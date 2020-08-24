package boilerplate.springboot.webwithajp.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Hello {

    private String name;
    private LocalDateTime time;
}
