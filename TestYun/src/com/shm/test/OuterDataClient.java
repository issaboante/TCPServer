package com.shm.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.StringEntity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class OuterDataClient {
	public static void main(String[] args) {
		String url="http://127.0.0.1:8080/irb-batch/ws/task/enableTaskScheduler";
		try {
			    //String outerData = getOuterData("C:/Users/Public/Nwt/cache/recv/winner/征信解析存储过程版本/报文.txt");
			String outerData = getOuterData("C:/Users/Public/Nwt/cache/recv/winner/征信解析存储过程版本/报文随机.txt");    
			HashMap parseObject = JSON.parseObject(outerData, HashMap.class);
			    ZHANGYINGClient(url,outerData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void BHClient(String name,String url,String BHJson){
		System.out.println("******************************************************************************************");
		System.out.println("*****                              "+name+"                                 ******");
		System.out.println("******************************************************************************************");
		try {
			//String BHJson=GetFourData.zhuanxiangfenqisecondwithyanshengshuju(Math.random());
			System.out.println("******************************传输数据******************************");
			System.out.println(BHJson);
			HttpEntity entity = new StringEntity(BHJson,Charset.forName("UTF-8"));
			long starttime=System.currentTimeMillis();
			Response execute = Request.Post(url)
				   .setHeader("content-type", "application/json;charset=UTF-8")
				   .body(entity).execute();
			String asString = execute.returnContent().asString();
			long endtime=System.currentTimeMillis();
			System.out.println("******************************返回数据******************************");
			System.out.println(asString);
			System.out.println(""+name+"耗时："+(endtime-starttime)+"ms");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ZHANGYINGClient(String url,String BHJson){
		System.out.println("******************************************************************************************");
		System.out.println("******************************************************************************************");
		try {
			//String BHJson=GetFourData.zhuanxiangfenqisecondwithyanshengshuju(Math.random());
			System.out.println("******************************传输数据******************************");
			System.out.println(BHJson);
			HttpEntity entity = new StringEntity(BHJson,Charset.forName("UTF-8"));
			long starttime=System.currentTimeMillis();
			Response execute = Request.Post(url)
				   .setHeader("content-type", "application/json;charset=UTF-8")
				   .body(entity).execute();
			String asString = execute.returnContent().asString();
			long endtime=System.currentTimeMillis();
			System.out.println("******************************返回数据******************************");
			System.out.println(asString);
			System.out.println("zhangying耗时："+(endtime-starttime)+"ms");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getOuterData(String path){
		InputStream inputStream = null;
		try {
			File file = new File(path);
			// String code = new FileCharsetDetector().guessFileEncoding(file);
			inputStream = new FileInputStream(file);
			String encoding = "gbk";
			String lineTxt = "";
			String lineTxtadd = "";
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				//isFile() 测试此抽象路径名表示的文件是否是一个标准文件，exists() 测试此抽象路径名表示的文件或目录是否存在
				InputStreamReader read = new InputStreamReader(inputStream, encoding);// 考虑到编码格式
				//读取字符
				BufferedReader bufferedReader = new BufferedReader(read);
				//bufferedReader.readLine() 每次只读一行 
				while ((lineTxt = bufferedReader.readLine()) != null) {
					lineTxtadd = lineTxtadd + lineTxt.trim();// trim() 去掉字符串首尾的空格
				}
				read.close();

			}else{
				System.out.println("文件不存在!");
			}
			return lineTxtadd;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (null != inputStream) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
