package boilerplate.springboot.multiplemongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "boilerplate.springboot.multiplemongodb.repository.secondary",
        mongoTemplateRef = MultipleMongodbConfig.SECONDARY_TEMPLATE
)
public class SecondaryMongoRepositoryConfig {
}
