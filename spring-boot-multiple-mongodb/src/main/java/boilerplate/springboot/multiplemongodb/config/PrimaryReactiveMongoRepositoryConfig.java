package boilerplate.springboot.multiplemongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(
        basePackages = "boilerplate.springboot.multiplemongodb.repository.primary.reactive",
        reactiveMongoTemplateRef = MultipleMongodbConfig.PRIMARY_REACTIVE_TEMPLATE
)
public class PrimaryReactiveMongoRepositoryConfig {
}
