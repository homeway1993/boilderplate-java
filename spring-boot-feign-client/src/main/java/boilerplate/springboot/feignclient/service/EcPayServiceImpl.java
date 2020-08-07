package boilerplate.springboot.feignclient.service;

import boilerplate.springboot.feignclient.client.EcPayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EcPayServiceImpl implements EcPayService {

    @Autowired
    private EcPayClient ecPayClient;

    @Override
    public void createTrade() {
        String trade = ecPayClient.createTrade(new HashMap<>());
        System.out.println(trade);
    }
}
