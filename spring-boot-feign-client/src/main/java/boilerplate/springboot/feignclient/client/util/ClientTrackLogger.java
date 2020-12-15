package boilerplate.springboot.feignclient.client.util;

import boilerplate.springboot.feignclient.config.ClientTrackDataHolder;
import feign.Response;
import feign.slf4j.Slf4jLogger;

import java.io.IOException;

public class ClientTrackLogger extends Slf4jLogger {

    /**
     * constructor for setting logger class.
     *
     * @param clazz logger class
     */
    public ClientTrackLogger(Class<?> clazz) {
        super(clazz);
    }

    /**
     * override this method for get tracking data.
     */
    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime)
            throws IOException {
        String url = response.request().url();
        ClientTrackDataHolder.addData(configKey, url, elapsedTime);
        return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
    }
}
