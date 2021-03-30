package boilerplate.springboot.stompwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");

        config.enableStompBrokerRelay("/topic")
//                .setRelayHost("crmuat02.chowsangsang.com")
                .setRelayHost("localhost")
                .setRelayPort(61613)
                .setVirtualHost("/")
                .setSystemLogin("guest")
                .setSystemPasscode("guest")
                .setSystemHeartbeatSendInterval(5000)
                .setSystemHeartbeatReceiveInterval(5000);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
