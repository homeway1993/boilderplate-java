package boilerplate.springboot.stompwebsocket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("stomp")
public class StompProperties {

    private boolean enable;
    private String relayHost;
    private Integer relayPort;
    private String username;
    private String passcode;
    private String virtualHost;
}
