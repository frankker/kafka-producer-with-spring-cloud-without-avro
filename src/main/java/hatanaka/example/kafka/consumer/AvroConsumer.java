package hatanaka.example.kafka.consumer;

import hatanaka.example.kafka.dto.AlertDto;
import hatanaka.example.kafka.dto.AssetDto;
import hatanaka.example.kafka.producer.KafkaProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.stereotype.Service;

@Service
public class AvroConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(AvroConsumer.class);

//  @StreamListener(Processor.INPUT)
//  public void consumeAsset2(AssetDto assetDto) {
//    try {
//      LOGGER.info("Let's process employee details: {}", assetDto);
//    } catch (Exception ex) {
//      LOGGER.error(ex.getMessage());
//    }
//  }

//  @StreamListener(KafkaProcessor.ASSET_IN)
//  public void consumeAsset2(AssetDto assetDto) {
//    try {
//      LOGGER.info("Let's process employee details: {}", assetDto);
//    } catch (Exception ex) {
//      LOGGER.error(ex.getMessage());
//    }
//  }

}
