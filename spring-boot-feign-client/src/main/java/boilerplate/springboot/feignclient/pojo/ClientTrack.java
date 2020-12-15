package boilerplate.springboot.feignclient.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientTrack {
    private String configKey;
    private String url;
    private Long elapsedTime;
}
