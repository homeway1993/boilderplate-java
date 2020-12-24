package boilerplate.springboot.feignclient.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(
        name = "CustomStatusReactiveClient",
        url = "${status.base-url}",
        configuration = CustomStatusReactiveClientConfig.class)
public interface CustomStatusReactiveClient {

    @GetMapping("/{statusCode}")
    Mono<String> getStatusCode(@PathVariable Integer statusCode);
}
