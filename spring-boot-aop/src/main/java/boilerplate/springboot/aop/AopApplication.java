package boilerplate.springboot.aop;

import boilerplate.springboot.aop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Autowired
    private HelloService helloService;

    @Bean
    ApplicationRunner runner(){
        return args -> {
          helloService.getHelloString("aa");
        };
    }
}
