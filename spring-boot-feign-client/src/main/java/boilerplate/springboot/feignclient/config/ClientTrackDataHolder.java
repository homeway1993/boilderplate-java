package boilerplate.springboot.feignclient.config;

import boilerplate.springboot.feignclient.pojo.ClientTrack;

import java.util.ArrayList;
import java.util.List;

public class ClientTrackDataHolder {

    private static final InheritableThreadLocal<List<ClientTrack>> THREAD_LOCAL;

    static {
        THREAD_LOCAL = new InheritableThreadLocal<List<ClientTrack>>() {
            protected List<ClientTrack> initialValue() {
                return new ArrayList<>();
            }
        };
    }

    public static void addData(String configKey, String url, Long elapsedTime) {
        THREAD_LOCAL.get().add(new ClientTrack(configKey, url, elapsedTime));
    }

    public static List<ClientTrack> getData() {
        return THREAD_LOCAL.get();
    }
}
