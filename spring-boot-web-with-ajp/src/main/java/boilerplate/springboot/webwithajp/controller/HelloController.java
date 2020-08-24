package boilerplate.springboot.webwithajp.controller;

import boilerplate.springboot.webwithajp.pojo.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    Hello getHello(@PathVariable String name) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setTime(LocalDateTime.now());
        return hello;
    }
}
