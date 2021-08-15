package hatanaka.example.kafka.producer;

import hatanaka.example.kafka.consumer.UserSink2;
import hatanaka.example.kafka.dto.AlertDto;
import hatanaka.example.kafka.dto.AssetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
//@EnableIntegration
public class KafkaProducerProcessor {

  @Autowired
  private UserSink2 processor;

  public void produceAssetMessage(AssetDto assetDto2) {
    /*AssetDto assetDto = new AssetDto();
    assetDto.setId(assetDto2.getId());
    assetDto.setName(assetDto2.getName());
    Message<AssetDto> message = MessageBuilder
        .withPayload(assetDto)
        .setHeader(KafkaHeaders.MESSAGE_KEY, assetDto.getId())
        .build();*/
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

    // creating employee details
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
