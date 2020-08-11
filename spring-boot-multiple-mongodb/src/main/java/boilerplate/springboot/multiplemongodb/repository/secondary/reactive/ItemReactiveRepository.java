package boilerplate.springboot.multiplemongodb.repository.secondary.reactive;

import boilerplate.springboot.multiplemongodb.entity.secondary.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ItemReactiveRepository extends ReactiveMongoRepository<Item, String>, ItemReactiveRepositoryCustom {
}
