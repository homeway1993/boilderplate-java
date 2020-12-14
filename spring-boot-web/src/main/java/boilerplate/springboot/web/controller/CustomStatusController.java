package boilerplate.springboot.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class CustomStatusController {

    @GetMapping("/{statusCode}")
    ResponseEntity<Void> getStatusCode(@PathVariable Integer statusCode){
        return ResponseEntity.status(statusCode)
                .build();
    }
}
