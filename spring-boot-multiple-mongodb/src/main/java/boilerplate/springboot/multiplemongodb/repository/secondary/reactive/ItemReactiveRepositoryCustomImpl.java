package boilerplate.springboot.multiplemongodb.repository.secondary.reactive;

import boilerplate.springboot.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.springboot.multiplemongodb.entity.secondary.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Mono;

public class ItemReactiveRepositoryCustomImpl implements ItemReactiveRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.SECONDARY_REACTIVE_TEMPLATE)
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Item> findFirst() {
        return reactiveMongoTemplate.query(Item.class).first();
    }
}
