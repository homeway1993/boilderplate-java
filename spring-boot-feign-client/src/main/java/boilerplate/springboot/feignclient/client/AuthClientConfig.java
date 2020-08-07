package boilerplate.springboot.feignclient.client;

import feign.*;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;

public class AuthClientConfig {

    @Value("${feign.client.config.AuthClient.retryPeriod:1000}")
    private long retryPeriod;

    @Value("${feign.client.config.AuthClient.retryMaxAttempts:3}")
    private int retryMaxAttempts;

    @Autowired
    private AuthTokenClient authTokenClient;

    private String authToken;

    /**
     * Setting the retry configuration.
     */
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(retryPeriod, retryPeriod, retryMaxAttempts);
    }

    /**
     * Evict cache and retry when receive the status 401.
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return (s, response) -> {
            if (response.status() == 401) {
                this.authToken = authTokenClient.getToken();
                throw new RetryableException(401, response.toString(), Request.HttpMethod.GET, null);
            }
            return FeignException.errorStatus(s, response);
        };
    }

    /**
     * Setting the authentication headers.
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // set empty header to remove previous header when retry.
            requestTemplate.header(HttpHeaders.AUTHORIZATION, new ArrayList<>());
            requestTemplate.header(HttpHeaders.AUTHORIZATION, this.authToken);
        };
    }
}
