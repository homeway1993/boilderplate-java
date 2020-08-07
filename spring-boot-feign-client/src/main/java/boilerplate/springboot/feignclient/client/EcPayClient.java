package boilerplate.springboot.feignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "ECPay", url = "${ec-pay.base-url}", configuration = EcPayClientConfig.class)
@RequestMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public interface EcPayClient {

    @PostMapping("/SP/CreateTrade")
    String createTrade(@RequestBody Map<String, ?> formData);

    @PostMapping("/Cashier/QueryTradeInfo/V5")
    String queryTrade(Map<String, ?> formData);
}
