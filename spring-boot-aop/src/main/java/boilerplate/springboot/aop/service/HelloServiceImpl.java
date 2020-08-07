package boilerplate.springboot.aop.service;

import boilerplate.springboot.aop.annotation.Notify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Notify("world")
    @Override
    public String getHelloString(String name) {
        String helloString = "hello " + name + " !";
        log.info(helloString);
        return helloString;
    }
}
