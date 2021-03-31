package boilerplate.springboot.stompwebsocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private StompProperties stompProperties;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");

        if (stompProperties.isEnable()) {
            config.enableStompBrokerRelay("/topic")
                    .setRelayHost(stompProperties.getRelayHost())
                    .setRelayPort(stompProperties.getRelayPort())
                    .setVirtualHost(stompProperties.getVirtualHost())
                    .setSystemLogin(stompProperties.getUsername())
                    .setSystemPasscode(stompProperties.getPasscode())
                    .setSystemHeartbeatSendInterval(5000)
                    .setSystemHeartbeatReceiveInterval(5000);
        } else {
            config.enableSimpleBroker("/topic");
        }
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
