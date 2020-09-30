package boilerplate.springboot.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperApplicationRunner implements ApplicationRunner {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
