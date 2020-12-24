package boilerplate.springboot.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/status")
public class CustomStatusController {

    @GetMapping("/{statusCode}")
    ResponseEntity<String> getStatusCode(@PathVariable Integer statusCode) throws InterruptedException {
        return ResponseEntity.status(statusCode)
                .body(statusCode.toString());
    }

    @PostMapping
    Object post(@RequestBody Object object) {
        return object;
    }
}
