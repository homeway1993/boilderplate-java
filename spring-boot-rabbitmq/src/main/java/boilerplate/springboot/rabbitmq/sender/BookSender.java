package boilerplate.springboot.rabbitmq.sender;

import boilerplate.springboot.rabbitmq.pojo.Book;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Book book) {
        rabbitTemplate.convertAndSend("boilerplate.rabbit.book", book);
    }
}
