package boilerplate.springboot.multiplemongodb.repository.primary;

import boilerplate.springboot.multiplemongodb.entity.primary.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String>, PersonRepositoryCustom {
}
