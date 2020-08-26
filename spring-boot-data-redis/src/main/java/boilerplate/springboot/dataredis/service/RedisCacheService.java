package boilerplate.springboot.dataredis.service;

import boilerplate.springboot.dataredis.pojo.Person;

import java.util.List;

public interface RedisCacheService {

    String hello();

    List<Person> getPersonList(String name);
}
