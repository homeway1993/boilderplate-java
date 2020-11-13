package boilerplate.springboot.oauth2server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("security.oauth2")
@Data
public class OAuth2ClientProperties {

    private Map<String, Client> clients;

    @Data
    public static class Client {
        private String clientId;
        private String clientSecret;
        private Integer accessTokenValiditySeconds;
        private String[] authorizedGrantTypes;
        private String[] scope;
    }
}
