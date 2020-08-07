package boilerplate.springboot.aop.service;

import boilerplate.springboot.aop.annotation.Notify;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Notify("world")
    @Override
    public String getHelloString(String name) {
        String str = "hello " + name + " !";
        System.out.println("================");
        System.out.println(str);
        System.out.println("================");
        return str;
    }
}
