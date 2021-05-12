package boilerplate.springboot.feignclient;

import boilerplate.springboot.feignclient.client.DaoduClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FeignClientApplicationRunner implements ApplicationRunner {

    @Autowired
    private DaoduClient daoduClient;

    @Override
    public void run(ApplicationArguments args) {
        String path = "08-26-2012-%e7%99%bd%e8%b3%a3%e4%ba%862%e5%8d%833%e7%99%be%e8%90%ac%e5%8f%b0%e6%99%ba%e6%85%a7%e5%9e%8b%e6%89%8b%e6%a9%9f-%e4%b8%89%e6%98%9f%e5%88%a4%e8%b3%a0%e9%80%be%e5%8f%b0%e5%b9%a3300%e5%84%84";
        String s = daoduClient.get(path);
        System.out.println(s);
    }
}
