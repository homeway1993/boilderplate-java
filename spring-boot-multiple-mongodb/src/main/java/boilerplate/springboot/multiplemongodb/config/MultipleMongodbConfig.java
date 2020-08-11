package boilerplate.springboot.multiplemongodb.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@EnableConfigurationProperties(MultipleMongodbProperties.class)
public class MultipleMongodbConfig {

    public static final String PRIMARY_TEMPLATE = "primaryMongoTemplate";
    public static final String SECONDARY_TEMPLATE = "secondaryMongoTemplate";
    public static final String PRIMARY_REACTIVE_TEMPLATE = "primaryReactiveMongoTemplate";
    public static final String SECONDARY_REACTIVE_TEMPLATE = "secondaryReactiveMongoTemplate";

    @Autowired
    private MultipleMongodbProperties multipleMongodbProperties;

    @Autowired
    private MongoMappingContext mongoMappingContext;

    @Autowired
    private BeanFactory beanFactory;

    @Primary
    @Bean(name = PRIMARY_TEMPLATE)
    public MongoTemplate primaryMongoTemplate(@Qualifier("primaryFactory") MongoDbFactory mongoDbFactory) {
        MappingMongoConverter mappingMongoConverter = getMappingMongodbConverter();
        mappingMongoConverter.afterPropertiesSet();
        return new MongoTemplate(mongoDbFactory, mappingMongoConverter);
    }

    @Primary
    @Bean
    public MongoDbFactory primaryFactory() {
        MongoProperties properties = multipleMongodbProperties.getPrimary();
        return new SimpleMongoDbFactory(new MongoClientURI(properties.getUri()));
    }

    @Bean(name = SECONDARY_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate(@Qualifier("secondaryFactory") MongoDbFactory mongoDbFactory) {
        MappingMongoConverter mappingMongoConverter = getMappingMongodbConverter();
        mappingMongoConverter.afterPropertiesSet();
        return new MongoTemplate(mongoDbFactory, mappingMongoConverter);
    }

    @Bean
    public MongoDbFactory secondaryFactory() {
        MongoProperties properties = multipleMongodbProperties.getSecondary();
        return new SimpleMongoDbFactory(new MongoClientURI(properties.getUri()));
    }

    @Primary
    @Bean(name = PRIMARY_REACTIVE_TEMPLATE)
    public ReactiveMongoTemplate primaryMongoReactiveTemplate() {
        MappingMongoConverter mappingMongodbConverter = getMappingMongodbConverter();
        mappingMongodbConverter.afterPropertiesSet();
        return new ReactiveMongoTemplate(primaryReactiveFactory(), mappingMongodbConverter);
    }

    @Primary
    @Bean
    public ReactiveMongoDatabaseFactory primaryReactiveFactory() {
        MongoProperties properties = multipleMongodbProperties.getPrimary();
        return new SimpleReactiveMongoDatabaseFactory(new ConnectionString(properties.getUri()));
    }

    @Bean(name = SECONDARY_REACTIVE_TEMPLATE)
    public ReactiveMongoTemplate secondaryMongoReactiveTemplate() {
        MappingMongoConverter mappingMongodbConverter = getMappingMongodbConverter();
        mappingMongodbConverter.afterPropertiesSet();
        return new ReactiveMongoTemplate(secondaryReactiveFactory(), mappingMongodbConverter);
    }

    @Bean
    public ReactiveMongoDatabaseFactory secondaryReactiveFactory() {
        MongoProperties properties = multipleMongodbProperties.getSecondary();
        return new SimpleReactiveMongoDatabaseFactory(new ConnectionString(properties.getUri()));
    }

    /**
     * Spring mongodb template will safe field "_class" by default.
     * This method will return converter let mongodb template do not save field "_class".
     */
    private MappingMongoConverter getMappingMongodbConverter() {
        NoOpDbRefResolver dbRefResolver = NoOpDbRefResolver.INSTANCE;
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);

        try {
            mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
        } catch (NoSuchBeanDefinitionException ignore) {
            mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
            return mappingConverter;
        }

        // Don't save field "_class" to mongodb
        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null, mongoMappingContext));
        return mappingConverter;
    }
}
