package hatanaka.example.kafka.producer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface KafkaProcessor {
/*
  String ASSET_IN = "asset4"; // Topic where the new loans appear
  String ASSET_OUT = "asset4"; // Topic where the approved loans are sent
  String ALERT_IN = "alert4"; // Topic where the new loans appear
  String ALERT_OUT = "alert6"; // Topic where the approved loans are sent

  @Input(ASSET_IN)
  SubscribableChannel assetIn();

  @Output(ASSET_OUT)
  MessageChannel assetOut();

*//*  @Input(ALERT_IN)
  SubscribableChannel alertIn();*//*

  @Output(ALERT_OUT)
  MessageChannel alertOut();*/

}