package boilerplate.springboot.web.service;

/**
 * Get message text from <b>resources/messages.properties</b>.
 */
public interface MessageService {

    String getMessage(String key, Object... objects);
}
