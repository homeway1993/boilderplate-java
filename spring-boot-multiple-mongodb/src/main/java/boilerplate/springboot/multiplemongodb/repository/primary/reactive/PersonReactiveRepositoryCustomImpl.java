package boilerplate.springboot.multiplemongodb.repository.primary.reactive;

import boilerplate.springboot.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.springboot.multiplemongodb.entity.primary.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Mono;

public class PersonReactiveRepositoryCustomImpl implements PersonReactiveRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.PRIMARY_REACTIVE_TEMPLATE)
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Person> findFirst() {
        return reactiveMongoTemplate.query(Person.class).first();
    }
}
