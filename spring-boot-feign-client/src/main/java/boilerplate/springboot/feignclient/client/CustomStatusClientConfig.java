package boilerplate.springboot.feignclient.client;

import feign.FeignException;
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
}
