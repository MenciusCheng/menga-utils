package com.menga.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by Marvel on 18/08/17.
 */
public class HttpDemo {

    public static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

    public static void main(String args[]) {
        try {
//            CloseableHttpClient hp = createSSLClientDefault();
            CloseableHttpClient hp = HttpClients.createDefault();
            HttpGet hg = new HttpGet("https://www.isuwang.com/signit/webhook.html");
//            HttpGet hg = new HttpGet("http://signit.oa.isuwang.com/signit/webhook.html");
            hg.setHeader("User-Agent","firefox");
//            HttpPost hg = new HttpPost("http://www.isuwang.com/signit/webhook.html");
//            HttpGet hg = new HttpGet("http://open.isuwang.com/");


            CloseableHttpResponse response = null;
            response = hp.execute(hg);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "utf-8");
            System.out.println(content);
            hp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
