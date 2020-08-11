package boilerplate.springboot.multiplemongodb.repository.secondary;

import boilerplate.springboot.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.springboot.multiplemongodb.entity.secondary.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.SECONDARY_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @Override
    public Item findFirst() {
        return mongoTemplate.findOne(new Query(), Item.class);
    }
}
