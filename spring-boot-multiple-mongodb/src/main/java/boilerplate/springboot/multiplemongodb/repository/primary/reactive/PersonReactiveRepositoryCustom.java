package boilerplate.springboot.multiplemongodb.repository.primary.reactive;

import boilerplate.springboot.multiplemongodb.entity.primary.Person;
import reactor.core.publisher.Mono;

public interface PersonReactiveRepositoryCustom {

    Mono<Person> findFirst();
}
