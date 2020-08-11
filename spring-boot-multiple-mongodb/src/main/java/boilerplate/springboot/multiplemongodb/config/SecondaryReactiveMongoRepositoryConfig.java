package boilerplate.springboot.multiplemongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(
        basePackages = "boilerplate.springboot.multiplemongodb.repository.secondary.reactive",
        reactiveMongoTemplateRef = MultipleMongodbConfig.SECONDARY_REACTIVE_TEMPLATE
)
public class SecondaryReactiveMongoRepositoryConfig {
}
