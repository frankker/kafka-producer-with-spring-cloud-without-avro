package example.kafka.producer;

import example.kafka.dto.AlertDto;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaRecordProducer {
  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaRecordProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(AlertDto alertDto) throws InterruptedException {
    String topic = "reflectoring5";
    final long key = alertDto.getId();
    String data = alertDto.getName();
    List<Header> headers = new ArrayList<>();
    headers.add(
        new RecordHeader(
            "X-Custom-Header", "Sending Custom Header with Spring Kafka 2222222222".getBytes()));

    ProducerRecord<String, String> record =
        new ProducerRecord(topic, 0, "adsf", "test", headers);
    MessageFormat.format("sending message='{0}' to topic='{1}'", data, topic);

    kafkaTemplate.send(record);
  }
}
