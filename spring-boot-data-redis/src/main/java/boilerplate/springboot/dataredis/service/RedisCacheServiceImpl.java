package boilerplate.springboot.dataredis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    @Override
    @Cacheable("hello")
    public String hello() {
        System.out.println("hello !!");
        return null;
    }
}
