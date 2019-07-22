package com.shitu.cloud.service.util.http;

import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 工具类Http请求
 */
public class HttpUtil {

    private static PoolingHttpClientConnectionManager connectionManager;
    private static HttpRequestRetryHandler retryHandler;
    private static CloseableHttpClient httpClient;
    private static final Object lock = new Object();

    static {
        connectionManager = new PoolingHttpClientConnectionManager(5, TimeUnit.SECONDS);
        connectionManager.setMaxTotal(50);
        connectionManager.setDefaultMaxPerRoute(100);
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setCharset(Charset.forName("UTF-8"))
                .build();
        connectionManager.setDefaultConnectionConfig(connectionConfig);

        retryHandler = (e, tryCount, httpContext) -> {
            System.out.println("进入重试逻辑");
            if (tryCount >= 3) {
                System.out.println("超过三次重试");
                return false;
            }

            if (e instanceof NoHttpResponseException) {
                System.out.println("NoHttpResponseException====》开始重试");
                return true;
            }

            if (e instanceof InterruptedIOException) {
                return false;
            }

            if (e instanceof UnknownHostException) {
                return false;
            }

            HttpClientContext context = HttpClientContext.adapt(httpContext);
            HttpRequest request = context.getRequest();
            return !(request instanceof HttpEntityEnclosingRequest);
        };
    }

    public static CloseableHttpClient getHttpClient() throws Exception {
        if (httpClient == null) {
            synchronized (lock) {
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }}, null);
                httpClient = HttpClients.custom()
                        .setRetryHandler(retryHandler)
                        .setConnectionManager(connectionManager)
                        .setDefaultRequestConfig(RequestConfig.copy(RequestConfig.DEFAULT)
                                .setConnectTimeout(15000)
                                .setSocketTimeout(15000)
                                .build())
                        .setSSLContext(sslContext)
                        .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER))
                        .build();
            }
        }

        return httpClient;
    }

    public static void get(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        getHttpClient().execute(httpGet, response -> {
            String resp = EntityUtils.toString(response.getEntity());
            EntityUtils.consume(response.getEntity());
            return resp;
        });
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(1000);
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            es.submit(() -> {
                c.countDown();
                try {
                    get("https://www.jd.com/?cu=true&utm_source=cps.youmai.com&utm_medium=tuiguang&utm_campaign=t_1000049399_87264872&utm_term=7103fa540ceb49fdaf1cd188f8b259da");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}

