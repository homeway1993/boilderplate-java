package boilerplate.springboot.mongodb.repository;

import boilerplate.springboot.mongodb.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
