package boilerplate.springboot.feignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HelloClient", url = "${hello.base-url}", configuration = CustomStatusClientConfig.class)
public interface CustomStatusClient {

    @GetMapping("/{statusCode}")
    String getStatusCode(@PathVariable Integer statusCode);
}
