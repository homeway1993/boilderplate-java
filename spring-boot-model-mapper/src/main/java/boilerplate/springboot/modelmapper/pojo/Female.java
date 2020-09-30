package boilerplate.springboot.modelmapper.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Female {

    private String name;
    private LocalDateTime createdDate;
}
