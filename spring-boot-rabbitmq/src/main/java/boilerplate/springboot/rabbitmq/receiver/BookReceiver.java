package boilerplate.springboot.rabbitmq.receiver;

import boilerplate.springboot.rabbitmq.pojo.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BookReceiver {

    @RabbitListener(queues = "boilerplate.rabbit.book")
    public void receive(Book book) {
        log.info("Receiver a book message: {}", book);
    }
}
