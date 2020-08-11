package boilerplate.springboot.multiplemongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "boilerplate.springboot.multiplemongodb.repository.primary",
        mongoTemplateRef = MultipleMongodbConfig.PRIMARY_TEMPLATE
)
public class PrimaryMongoRepositoryConfig {
}
