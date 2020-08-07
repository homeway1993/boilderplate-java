package boilerplate.springboot.web.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

@Async
public interface AsyncService {

    void count();

    Future<String> getFuture();
}
