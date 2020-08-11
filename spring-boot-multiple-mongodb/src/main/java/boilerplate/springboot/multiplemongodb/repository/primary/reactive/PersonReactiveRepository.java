package boilerplate.springboot.multiplemongodb.repository.primary.reactive;

import boilerplate.springboot.multiplemongodb.entity.primary.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonReactiveRepository extends ReactiveMongoRepository<Person, String>,
        PersonReactiveRepositoryCustom {
}
