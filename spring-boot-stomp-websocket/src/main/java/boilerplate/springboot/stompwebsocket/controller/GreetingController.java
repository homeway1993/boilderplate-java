package boilerplate.springboot.stompwebsocket.controller;

import boilerplate.springboot.stompwebsocket.pojo.Greeting;
import boilerplate.springboot.stompwebsocket.pojo.HelloMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    Greeting greeting(HelloMessage message) throws InterruptedException {
        log.info("receive message: " + message);
        TimeUnit.SECONDS.sleep(1);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
