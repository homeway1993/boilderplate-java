package boilerplate.springboot.modelmapper.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class ModelMapperConfig {

    @Autowired(required = false)
    private final List<PropertyMap<?, ?>> propertyMaps = new ArrayList<>();

    @Autowired(required = false)
    private final List<Converter<?, ?>> converters = new ArrayList<>();

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        for (PropertyMap<?, ?> propertyMap : propertyMaps) {
            log.info("Adding propertyMap: {}", propertyMap.getClass().getName());
            modelMapper.addMappings(propertyMap);
        }

        for (Converter<?, ?> converter : converters) {
            log.info("Adding converters: {}", converter.getClass().getName());
            modelMapper.addConverter(converter);
        }

        return modelMapper;
    }
}