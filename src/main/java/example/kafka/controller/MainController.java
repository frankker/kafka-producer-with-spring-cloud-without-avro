package example.kafka.controller;

import example.kafka.dto.AssetDto;
import example.kafka.producer.KafkaProducerProcessor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MainController {

  private final KafkaProducerProcessor kafkaProducerProcessor;

  public MainController(KafkaProducerProcessor kafkaProducerProcessor) {
    this.kafkaProducerProcessor = kafkaProducerProcessor;
  }

  @PutMapping("/createAsset")
  public void createMessage(@RequestBody() AssetDto assetDto) {
    System.out.println("Sending assetDto " + assetDto.getId());
    kafkaProducerProcessor.produceAssetMessage(assetDto);
    System.out.println("assetDto sent " + assetDto.getId());
  }
}
