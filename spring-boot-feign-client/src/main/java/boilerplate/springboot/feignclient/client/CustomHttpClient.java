package boilerplate.springboot.feignclient.client;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;

@Configuration
class CustomHttpClient {

    @Value("${proxy.host:@null}")
    private String proxyHost;

    @Value("${proxy.port:}")
    private Integer proxyPort;

    @Value("${feign.httpclient.disableSslValidation:false}")
    private boolean disableSslValidation;

    @Autowired
    private FeignClientProperties feignClientProperties;

    /**
     * Use Apache HttpClient to supported the PATCH method and setting the proxy.
     */
    public Client client() {
        // use feign client default configuration
        FeignClientProperties.FeignClientConfiguration defaultConfig = feignClientProperties.getConfig().get("default");
        RequestConfig.Builder configBuilder = RequestConfig.custom()
                .setSocketTimeout(defaultConfig.getReadTimeout())
                .setConnectTimeout(defaultConfig.getConnectTimeout());

        // setting proxy
        if (proxyHost != null && proxyPort != null) {
            configBuilder.setProxy(new HttpHost(proxyHost, proxyPort));
        }

        // create HTTP client
        HttpClientBuilder httpClientBuilder = HttpClients.custom()
                .setDefaultRequestConfig(configBuilder.build());

        if (disableSslValidation) {
            try {
                SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(TrustAllStrategy.INSTANCE).build();
                httpClientBuilder.setSSLContext(sslContext)
                        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new ApacheHttpClient(httpClientBuilder.build());
    }
}
