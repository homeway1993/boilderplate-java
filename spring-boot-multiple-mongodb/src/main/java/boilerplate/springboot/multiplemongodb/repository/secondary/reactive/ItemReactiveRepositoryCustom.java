package boilerplate.springboot.multiplemongodb.repository.secondary.reactive;

import boilerplate.springboot.multiplemongodb.entity.secondary.Item;
import reactor.core.publisher.Mono;

public interface ItemReactiveRepositoryCustom {

    Mono<Item> findFirst();
}
