package cm.shm.https;

import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Test;

public class HttpsClient {
	
	@Test
	public void HttpsGetTest(){
		try {
			 // 创建URL对象
	        URL myURL = new URL("https://localhost:8443/RestWebServiceTest-0.1/services/test/risk/ll");
	        // 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
	        HttpsURLConnection httpsConn = (HttpsURLConnection) myURL
	                .openConnection();
	        httpsConn.setRequestMethod("POST");
	        // 取得该连接的输入流，以读取响应内容
	        InputStreamReader insr = new InputStreamReader(httpsConn
	                .getInputStream());
	        // 读取服务器的响应内容并显示
	        int respInt = insr.read();
	        while (respInt != -1) {
	            System.out.print((char) respInt);
	            respInt = insr.read();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
