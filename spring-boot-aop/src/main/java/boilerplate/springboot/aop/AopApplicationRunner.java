package boilerplate.springboot.aop;

import boilerplate.springboot.aop.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AopApplicationRunner implements ApplicationRunner {

    @Autowired
    private HelloService helloService;

    @Override
    public void run(ApplicationArguments args) {
        String helloString = helloService.getHelloString("aa");
        log.info("get the return string: " + helloString);
    }
}
