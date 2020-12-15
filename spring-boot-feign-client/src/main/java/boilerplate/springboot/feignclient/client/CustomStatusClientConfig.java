package boilerplate.springboot.feignclient.client;

import boilerplate.springboot.feignclient.client.util.ClientTrackLogger;
import feign.FeignException;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomStatusClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return (s, response) -> {
            if (response.status() == 502) {
                throw new AssertionError("custom error");
            }
            return FeignException.errorStatus(s, response);
        };
    }

    @Bean
    public Logger logger() {
        return new ClientTrackLogger(CustomStatusClient.class);
    }
}
