package boilerplate.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String key, Object... objects) {
        return messageSource.getMessage(key, objects, Locale.ROOT);
    }
}
