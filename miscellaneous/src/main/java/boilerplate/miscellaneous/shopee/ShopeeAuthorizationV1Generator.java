package boilerplate.miscellaneous.shopee;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

public class ShopeeAuthorizationV1Generator {

    public static void main(String[] args) {
        String baseUrl = "https://partner.test-stable.shopeemobile.com";
        String path = "/api/v1/shop/get";
        String url = baseUrl + path;
        String partnerKey = "partnerKey";
        String requestBody = "{\"partner_id\":850750,\"shopid\":3031,\"timestamp\":1618197810}";

        String message = url + "|" + requestBody;
        String hmacHex = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, partnerKey).hmacHex(message);
        System.out.println(hmacHex);
    }
}
