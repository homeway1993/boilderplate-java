package boilerplate.springboot.webwithajp.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AjpConfig {

    @Value("${tomcat.ajp.port:8009}")
    int ajpPort;

    @Value("${tomcat.ajp.enabled:true}")
    boolean tomcatAjpEnabled;

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        if (tomcatAjpEnabled) {
            Connector connector = new Connector("AJP/1.3");
            connector.setScheme("http");
            connector.setPort(ajpPort);
            connector.setSecure(false);
            tomcat.addAdditionalTomcatConnectors(connector);
        }
        return tomcat;
    }
}
