package hatanaka.example.kafka.controller;

import hatanaka.example.kafka.dto.AlertDto;
import hatanaka.example.kafka.dto.AssetDto;
import hatanaka.example.kafka.producer.KafkaProducerProcessor;
import hatanaka.example.kafka.producer.KafkaRecordProducer;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MainController {

  private final KafkaRecordProducer kafkaRecordProducer;
  private final KafkaProducerProcessor kafkaProducerProcessor;

  public MainController(KafkaRecordProducer kafkaRecordProducer, KafkaProducerProcessor kafkaProducerProcessor) {
    this.kafkaRecordProducer = kafkaRecordProducer;
    this.kafkaProducerProcessor = kafkaProducerProcessor;
  }

  /*@PutMapping("/createAlert")
  public void createMessage(@RequestBody() AlertDto alertDto) throws InterruptedException {
    System.out.println("Sending alertDto " + alertDto);
    kafkaRecordProducer.send(alertDto);
    System.out.println("alertDto sent " + alertDto);
  }*/

  @PutMapping("/createAsset")
  public void createMessage(@RequestBody() AssetDto assetDto) throws InterruptedException {
    System.out.println("Sending assetDto " + assetDto.getId());
    kafkaProducerProcessor.produceAssetMessage(assetDto);
    System.out.println("assetDto sent " + assetDto.getId());
  }

  @PutMapping("/createAlert")
  public void createMessage(@RequestBody() AlertDto alertDto) throws InterruptedException {
    System.out.println("Sending alertDto " + alertDto.getId());
    kafkaProducerProcessor.produceAlertDetails(
        alertDto.getId(), alertDto.getTopic(), alertDto.getName());
    System.out.println("alertDto sent " + alertDto.getId());
  }
}
