package boilerplate.springboot.rabbitmq.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloReceiver {

    @RabbitListener(queues = "boilerplate.rabbit.hello")
    public void receive(String s) {
        log.info("Receiver a message: {}", s);
    }
}
