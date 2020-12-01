package boilerplate.springboot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/time")
public class TimeController {

    @GetMapping("/currentTimeMill")
    String getCurrentTimeMill() {
        return String.valueOf(System.currentTimeMillis());
    }

    @GetMapping("/localDateTimeNow")
    String getLocalDateTimeNow() {
        return LocalDateTime.now().toString();
    }
}
