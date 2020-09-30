package boilerplate.springboot.modelmapper.config.map;

import boilerplate.springboot.modelmapper.pojo.Person;
import boilerplate.springboot.modelmapper.pojo.Female;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WomanMap extends PropertyMap<Person, Female> {

    @Override
    protected void configure() {
        using(nul-> LocalDateTime.now()).map(destination.getCreatedDate());
    }
}
