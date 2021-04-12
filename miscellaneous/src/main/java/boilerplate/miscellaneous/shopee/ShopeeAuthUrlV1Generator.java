package boilerplate.miscellaneous.shopee;

import org.apache.commons.codec.digest.DigestUtils;

public class ShopeeAuthUrlV1Generator {

    public static void main(String[] args) {
        String baseUrl = "https://partner.test-stable.shopeemobile.com/api/v1/shop/auth_partner";
        String partnerId = "850750";
        String redirectUrl = "https://www.chowsangsang.com";
        String partnerKey = "partnerKey";
        String token = DigestUtils.sha256Hex(partnerKey + redirectUrl);

        String authUrl = String.format("%s?id=%s&redirect=%s&token=%s", baseUrl, partnerId, redirectUrl, token);
        System.out.println(authUrl);
    }
}
