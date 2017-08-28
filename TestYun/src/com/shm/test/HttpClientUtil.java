package com.shm.test;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;  
import org.apache.http.conn.ssl.SSLContextBuilder;  
import org.apache.http.conn.ssl.TrustStrategy;  
import org.apache.http.conn.ssl.X509HostnameVerifier;  
import org.apache.http.entity.StringEntity;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;  
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;  
  
import javax.net.ssl.SSLContext;  
import javax.net.ssl.SSLException;  
import javax.net.ssl.SSLSession;  
import javax.net.ssl.SSLSocket;  
import java.io.IOException;  
import java.io.InputStream;  
import java.nio.charset.Charset;  
import java.security.GeneralSecurityException;  
import java.security.cert.CertificateException;  
import java.security.cert.X509Certificate;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  

public class HttpClientUtil {
	
	/** 
     * 发送 SSL POST 请求（HTTPS），JSON形式 
     * @param apiUrl API接口URL 
     * @param json JSON对象 
     * @return 
     */  
//    public static String doPostSSL(String apiUrl, Object json) {  
//        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();  
//        HttpPost httpPost = new HttpPost(apiUrl);  
//        CloseableHttpResponse response = null;  
//        String httpStr = null;  
//  
//        try {  
//            httpPost.setConfig(requestConfig);  
//            StringEntity stringEntity = new StringEntity(json.toString(),"UTF-8");//解决中文乱码问题  
//            stringEntity.setContentEncoding("UTF-8");  
//            stringEntity.setContentType("application/json");  
//            httpPost.setEntity(stringEntity);  
//            response = httpClient.execute(httpPost);  
//            int statusCode = response.getStatusLine().getStatusCode();  
//            if (statusCode != HttpStatus.SC_OK) {  
//                return null;  
//            }  
//            HttpEntity entity = response.getEntity();  
//            if (entity == null) {  
//                return null;  
//            }  
//            httpStr = EntityUtils.toString(entity, "utf-8");  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            if (response != null) {  
//                try {  
//                    EntityUtils.consume(response.getEntity());  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return httpStr;  
//    }  
	 /** 
     * 创建SSL安全连接 
     * 
     * @return 
     */  
    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {  
        SSLConnectionSocketFactory sslsf = null;  
        try {  
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {  
  
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
                    return true;  
                }  
            }).build();  
            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {  
  
                @Override  
                public boolean verify(String arg0, SSLSession arg1) {  
                    return true;  
                }  
  
                @Override  
                public void verify(String host, SSLSocket ssl) throws IOException {  
                }  
  
                @Override  
                public void verify(String host, X509Certificate cert) throws SSLException {  
                }  
  
                @Override  
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {  
                }  
            });  
        } catch (GeneralSecurityException e) {  
            e.printStackTrace();  
        }  
        return sslsf;  
    }  
}
