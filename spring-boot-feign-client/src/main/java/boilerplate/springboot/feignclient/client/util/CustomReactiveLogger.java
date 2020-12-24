package boilerplate.springboot.feignclient.client.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.MethodMetadata;
import feign.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactivefeign.client.ReactiveHttpRequest;
import reactivefeign.client.ReactiveHttpResponse;
import reactivefeign.client.log.ReactiveLoggerListener;
import reactivefeign.utils.FeignUtils;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CustomReactiveLogger implements ReactiveLoggerListener<CustomReactiveLogger.LogContext> {

    private final Logger logger;

    /**
     * The constructor for setting logger class.
     *
     * @param clazz logger class
     */
    public CustomReactiveLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    @Override
    public LogContext requestStarted(ReactiveHttpRequest request, Target target, MethodMetadata methodMetadata) {
        LogContext logContext = new LogContext(methodMetadata);
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("[{}] ---> {} {} HTTP/1.1", logContext.methodTag, request.method(), request.uri());
            logHeaders(logContext.methodTag, request.headers());

            if (logRequestBody()) {
                ((Mono<Object>) request.body())
                        .doOnNext((body) -> {
                            this.logger.debug("[{}]", logContext.methodTag);
                            this.logger.debug("[{}] {}", logContext.methodTag, toJsonString(body));
                        })
                        .subscribe();
            }
            this.logger.debug("[{}] ---> END HTTP", logContext.methodTag);
        }
        return logContext;
    }

    @Override
    public boolean logRequestBody() {
        return true;
    }

    /**
     * This method will not be called when the request body is empty.
     */
    @Override
    public void bodySent(Object requestBody, LogContext logContext) {
    }

    @Override
    public void responseReceived(ReactiveHttpResponse response, LogContext logContext) {
        if (this.logger.isDebugEnabled()) {
            long elapsedTime = logContext.getElapsedTimeMillis();
            this.logger.debug("[{}] <--- HTTP/1.1 {} ({}ms)", logContext.methodTag, response.status(), elapsedTime);
            logHeaders(logContext.methodTag, response.headers());
        }
    }

    @Override
    public void errorReceived(Throwable throwable, LogContext logContext) {
    }

    @Override
    public boolean logResponseBody() {
        return true;
    }

    /**
     * This method will not be called when the response body is empty.
     */
    @Override
    public void bodyReceived(Object responseBody, LogContext logContext) {
        if (this.logger.isDebugEnabled() && logResponseBody()) {
            this.logger.debug("[{}]", logContext.methodTag);

            if (responseBody instanceof byte[]) {
                String responseBodyString = new String((byte[]) responseBody, StandardCharsets.UTF_8);
                this.logger.debug("[{}] {}", logContext.methodTag, responseBodyString);
            } else {
                this.logger.debug("[{}] {}", logContext.methodTag, toJsonString(responseBody));
            }

            this.logger.debug("[{}] <--- END HTTP", logContext.methodTag);
        }
    }

    private void logHeaders(String methodTag, Map<String, List<String>> headers) {
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            for (String headerValue : header.getValue()) {
                this.logger.debug("[{}] {}: {}", methodTag, header.getKey(), headerValue);
            }
        }
    }

    private Object toJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return object;
        }
    }

    public static class LogContext {
        private final String methodTag;
        private final long startTime;

        public LogContext(MethodMetadata methodMetadata) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            this.methodTag = String.format("%s@%s", FeignUtils.methodTag(methodMetadata), uid);
            this.startTime = System.currentTimeMillis();
        }

        public long getElapsedTimeMillis() {
            return System.currentTimeMillis() - this.startTime;
        }
    }
}