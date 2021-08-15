package example.kafka.producer;

import example.kafka.dto.AlertDto;
import example.kafka.dto.AssetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(KafkaProcessor.class)
//@EnableIntegration
public class KafkaProducerProcessor {

  @Autowired
  private KafkaProcessor processor;

  public void produceAssetMessage(AssetDto assetDto2) {
    AlertDto alertDto = new AlertDto();
    alertDto.setId(3L);
    alertDto.setName("name");
    alertDto.setTopic("asset4");

    Message<AlertDto> message =
        MessageBuilder
            .withPayload(alertDto)
            .setHeader(KafkaHeaders.MESSAGE_KEY, 3L)
            .build();

    processor.outEvent().send(message);
  }

  public void produceAlertDetails(long alertId, String topic, String name) {
    AlertDto alertDto = new AlertDto();
    alertDto.setId(alertId);
    alertDto.setName(name);
    alertDto.setTopic(topic);

    Message<AlertDto> message =
        MessageBuilder
            .withPayload(alertDto)
            .setHeader(KafkaHeaders.MESSAGE_KEY, alertId)
            .build();

    processor.outEvent()
        .send(message);
  }
}
