package cm.shm.https;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.junit.Test;

public class MyX509Test {
    public static void main(String[] args) {
        try {
             goHttpsGET("http://103.199.228.9:8280/services/RESTAPI");
        	//goHttps("https://localhost:8443/rcc/ws/test/rest/getResult/eliteScore");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testhttpsGet(){
    	 try {
             goHttpsGET("http://103.199.228.9:8280/services/RESTAPI");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testHttpsPost(){
    	 try {
    		 goHttpsPOST("http://103.199.228.9:8280/services/RESTAPI");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void goHttpsPOST(String url)throws Exception{
    	String json = "{\"serialNumber\":\"99999\",\"idNumber\":\"11111\","
    			+ "\"phoneNumber\":\"0086-111111111\",\"name\":\"张三\",\"bankCardNumber\":\"22222\"}";
    	// 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = { new MyX509TrustManager() };
        SSLContext sslContext =SSLContext.getInstance("SSL","SunJSSE");
        sslContext.init(null, tm,new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        // 创建URL对象
        URL myURL = new URL(url);
        // 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
        HttpsURLConnection httpsConn= (HttpsURLConnection) myURL.openConnection();
        httpsConn.setSSLSocketFactory(ssf);
        httpsConn.setDoInput(true);
        httpsConn.setDoOutput(true);
        httpsConn.setUseCaches(false);
        
        httpsConn.setRequestMethod("POST");
        OutputStream outputStream = httpsConn.getOutputStream();    
        // 注意编码格式，防止中文乱码     
        outputStream.write(json.getBytes("UTF-8"));    
        outputStream.close();    
        // 取得该连接的输入流，以读取响应内容
        InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream(),"UTF-8");
        // 读取服务器的响应内容并显示
        int respInt = insr.read();
        while (respInt != -1) {
            System.out.print((char) respInt);
            respInt = insr.read();
        }
        insr.close();
    }
    
    public static void goHttpsGET(String url)throws Exception{
    	// 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = { new MyX509TrustManager() };
        SSLContext sslContext =SSLContext.getInstance("SSL","SunJSSE");
        sslContext.init(null, tm,new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        // 创建URL对象
        URL myURL = new URL(url);
        // 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
        HttpsURLConnection httpsConn= (HttpsURLConnection) myURL.openConnection();
        httpsConn.setSSLSocketFactory(ssf);
        // 取得该连接的输入流，以读取响应内容
        InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream(),"UTF-8");
        // 读取服务器的响应内容并显示
        int respInt = insr.read();
        while (respInt != -1) {
            System.out.print((char) respInt);
            respInt = insr.read();
        }
    }
}
