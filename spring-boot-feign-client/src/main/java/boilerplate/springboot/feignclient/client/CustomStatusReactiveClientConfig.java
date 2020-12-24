package boilerplate.springboot.feignclient.client;

import boilerplate.springboot.feignclient.client.util.CustomReactiveLogger;
import org.springframework.context.annotation.Bean;
import reactivefeign.ReactiveOptions;
import reactivefeign.client.log.ReactiveLoggerListener;
import reactivefeign.webclient.WebReactiveOptions;

public class CustomStatusReactiveClientConfig {

    @Bean
    public ReactiveOptions builder(){
        return new WebReactiveOptions.Builder()
                .setReadTimeoutMillis(10000)
                .setConnectTimeoutMillis(10000)
                .build();
    }

    @Bean
    public ReactiveLoggerListener<?> reactiveLoggerListener(){
        return new CustomReactiveLogger(CustomStatusReactiveClient.class);
    }
}
