package com.shm.test;

import java.nio.charset.Charset;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class HttpPost {
	//static String url="http://192.168.1.50/RestWebServiceTest-0.1/services/test/risk/getJsonPost";
	//static String url="http://localhost:8443/RestWebServiceTest/services/test/risk/getJsonPost";
	//static String url="https://localhost:8443/RestWebServiceTest/services/test/risk/getJsonPost";
	//static String url="http://www.yintuanonline.cn:8080/RestWebServiceTest-0.1/services/test/risk/BHprivate/eliteScore";
	//static String url="http://www.yintuanonline.com/RestWebServiceTest-0.1/services/test/BHPrivateTest";
	//static String url="http://192.168.1.233:8080/rcc/ws/test/rest/getResult/saccess";
	//static String url="http://www.yintuanonline.com/sinointerface-0.1/services/decisionservice/BHPrivateTestCunChu";
	//static String url="http://www.yintuanonline.com/sinointerface/services/decisionservice/BHPrivateTestCunChu";
	//static String url="http://www.yintuanonline.com/sinointerface/services/decisionservice/BHPrivateTestDCM";
	//static String url="http://localhost:8080/sinointerface/services/decisionservice/BHPrivateTestCunChu";
	static String url="http://103.199.228.9:8280/services/RESTAPI";
	//static String url="http://103.199.228.3/sinointerface/services/decisionservice/BHPrivateTestCunChu";
	//public static String url="http://localhost:8081/rcc/ws/test/getBHResult/saccess";
	//public static String url="http://localhost:8081/rcc/ws/test/getBHResult/test";
	//public static String url="http://103.199.228.3/rcc/ws/test/getBHResult/test";
	//public static String url="http://103.199.228.3/rcc/ws/test/getBHResult/saccess";
	
	public static String getFinalScore(String code) throws Exception, Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		org.apache.http.client.methods.HttpPost httpPost=new org.apache.http.client.methods.HttpPost(url);
		String jsonResult = null;
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10*60*1000).setConnectTimeout(10*60*1000).build();
	    httpPost.setConfig(requestConfig);
		try {
			if (null != code) {
				StringEntity entity = new StringEntity(code, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				httpPost.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(httpPost);
			//请求发送成功，并得到响应
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				try {
					//读取服务器返回过来的json字符串数据 
					jsonResult = EntityUtils.toString(result.getEntity(), "utf-8");
				} catch (Exception e) {
					throw new Exception(e.toString());
				}
			}else{
				throw new RuntimeException("请求出错"+result.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			throw new Exception(e.toString()+"gghhjjj");
		}finally {
			httpPost.releaseConnection();
		}
		return jsonResult;
	}
	
	public static String getFinalScore1(String code) throws Exception{
		String resultStr = "";
		try {
//			URL url = new URL("http://103.199.228.10:80/sinointerface/services"
//					+ "/decisionservice/BHPrivateTestCunChu");
			
			URL url = new URL("http://localhost:8081/rcc/ws/test/getBHResult/saccess");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//设置post提交  
			connection.setRequestMethod("POST");  
	        //设置超时时间  
			connection.setConnectTimeout(30000);  
	        connection.setReadTimeout(100000);  

	        connection.setDoInput(true);  
	        connection.setDoOutput(true);  

	        //把请求正文通过OutputStream发出去  
	        OutputStream os = connection.getOutputStream();  
	        os.write(code.getBytes());  
	        os.flush();  
			
	        //判断响应码  200 代表成功  
	        if(connection.getResponseCode()==200){  
	            //由HttpURLConnection拿到输入流  
	            InputStream in=connection.getInputStream();  
	            StringBuffer sb=new StringBuffer();  
	            //根据输入流做一些IO操作  
	            byte [] buff =new byte[1024];  
	            int len=-1;  
	            while((len=in.read(buff))!=-1){  
	                sb.append(new String(buff,0,len,"utf-8"));  
	            }  

	            in.close();  
	            os.close();  
	            connection.disconnect(); 
	            resultStr = sb.toString();
	        }else{
	        	throw new RuntimeException("请求出错"+connection.getResponseCode());
	        }
		} catch (Exception e) {
			throw new RuntimeException(e.toString());
		}
		return resultStr;
	}
}
