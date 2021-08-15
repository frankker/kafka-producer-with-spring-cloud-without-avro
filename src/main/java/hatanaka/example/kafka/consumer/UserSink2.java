package hatanaka.example.kafka.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface UserSink2 {
//  static String ALERT_INPUT = "alert-input";
  static String ALERT_OUTPUT = "alert-output";

/*  @Input(ALERT_INPUT)
  SubscribableChannel processMessage();*/

  @Output(ALERT_OUTPUT)
  MessageChannel outEvent();
}
