package boilerplate.springboot.multiplemongodb.repository.primary;

import boilerplate.springboot.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.springboot.multiplemongodb.entity.primary.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.PRIMARY_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @Override
    public Person findFirst() {
        return mongoTemplate.findOne(new Query(), Person.class);
    }
}
