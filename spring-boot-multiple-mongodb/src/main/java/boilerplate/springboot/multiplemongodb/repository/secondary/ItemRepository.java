package boilerplate.springboot.multiplemongodb.repository.secondary;

import boilerplate.springboot.multiplemongodb.entity.secondary.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String>, ItemRepositoryCustom {
}
