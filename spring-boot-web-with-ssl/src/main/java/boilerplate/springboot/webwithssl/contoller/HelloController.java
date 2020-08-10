package boilerplate.springboot.webwithssl.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String getHello() {
        return "hello world!";
    }
}
