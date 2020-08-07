package boilerplate.springboot.mongodb.repository;

import boilerplate.springboot.mongodb.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonReactiveRepository extends ReactiveMongoRepository<Person, String> {
}
