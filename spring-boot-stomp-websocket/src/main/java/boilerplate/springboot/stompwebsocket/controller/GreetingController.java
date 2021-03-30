package boilerplate.springboot.stompwebsocket.controller;

import boilerplate.springboot.stompwebsocket.pojo.Greeting;
import boilerplate.springboot.stompwebsocket.pojo.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.concurrent.TimeUnit;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    Greeting greeting(HelloMessage message) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
