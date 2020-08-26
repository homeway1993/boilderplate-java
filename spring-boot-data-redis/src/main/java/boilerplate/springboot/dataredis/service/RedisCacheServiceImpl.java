package boilerplate.springboot.dataredis.service;

import boilerplate.springboot.dataredis.pojo.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    @Override
    @Cacheable("hello")
    public String hello() {
        System.out.println("hello !!");
        return null;
    }

    @Override
    @Cacheable("person")
    public List<Person> getPersonList(String name) {
        System.out.println("call person list");

        Person person1 = new Person();
        person1.setName(name);
        person1.setAge(1);
        Person person2 = new Person();
        person2.setName(name);
        person2.setAge(2);

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        return list;
    }
}
