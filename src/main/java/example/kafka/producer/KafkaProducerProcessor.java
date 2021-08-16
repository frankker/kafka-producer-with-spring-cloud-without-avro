package example.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

  public void produceAssetMessage(AssetDto assetDto) {
    String assetDtoString = "";
    ObjectMapper mapper = new ObjectMapper();
    try {
      assetDtoString = mapper.writeValueAsString(assetDto);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    Message<String> message =
        MessageBuilder
            .withPayload(assetDtoString)
            .setHeader(KafkaHeaders.MESSAGE_KEY, assetDto.getId())
            .build();

    processor.assetEventSending().send(message);
  }
}
