package com.shm.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class HttpClient {
	
	@Test
	public void testGet() throws Exception, Exception{
		//发起请求  GET方式
		String json = Request.Get("http://localhost:8081/RestWebServiceTest/services/test/risk/getJson/as")
			   .execute().returnContent().asString();
		System.out.println(json);
		JSONObject parseObject = JSONObject.parseObject(json);
		System.out.println(parseObject);
	}
	
	@Test
	public void testPOST() throws Exception{
		String json = "{\"userId\":\"1\",\"industry\":3,\"age\":1,\"sex\":0,\"education\":2}";
		HttpEntity entity = new StringEntity(json,Charset.forName("UTF-8"));
		Response execute = Request.Post("http://192.168.1.233:8080/rcc/ws/test/rest/getResult/eliteScore")
			   .setHeader("content-type", "application/json;charset=UTF-8")
			   .body(entity).execute();
		String asString = execute.returnContent().asString();
		System.out.println(asString);
	}
	
	@Test
	public void testRuGaoPOST() throws Exception{
		//String json = "{\"userId\":\"1\",\"industry\":3,\"age\":1,\"sex\":0,\"education\":2}";
		//String json = "{\"age\":28,\"marrital\":4,\"education\":4,\"job\":1,\"capacity\":2,\"workingLife\":2,\"area\":3,\"livingYears\":2,\"creditRecord\":2,\"personalCharacter\":3,\"courtQuery\":2,\"aveincome\":9500,\"householdAssets\":200000,\"population\":2,\"liabilities\":2,\"deposit\":55000,\"cardCooperation\":3,\"otherCooperation\":4}";
		String json = "{\"age\":18,\"marrital\":2,\"education\":4,\"job\":3,\"capacity\":1,\"workingLife\":1,\"area\":2,\"livingYears\":1,\"creditRecord\":4,\"personalCharacter\":4,\"courtQuery\":3,\"aveincome\":13000,\"householdAssets\":400000,\"population\":3,\"liabilities\":4,\"deposit\":20000,\"cardCooperation\":1,\"otherCooperation\":2}";  
		//String json = "{\"age\":65,\"marrital\":4,\"education\":1,\"job\":1,\"capacity\":3,\"workingLife\":4,\"area\":1,\"livingYears\":3,\"creditRecord\":3,\"personalCharacter\":2,\"courtQuery\":1,\"aveincome\":2000,\"householdAssets\":100000,\"population\":4,\"liabilities\":3,\"deposit\":200000,\"cardCooperation\":2,\"otherCooperation\":1}";
		//String json = "{\"age\":56,\"marrital\":3,\"education\":3,\"job\":2,\"capacity\":4,\"workingLife\":4,\"area\":3,\"livingYears\":3,\"creditRecord\":1,\"personalCharacter\":4,\"courtQuery\":3,\"aveincome\":40000,\"householdAssets\":1000000,\"population\":1,\"liabilities\":1,\"deposit\":500000,\"cardCooperation\":2,\"otherCooperation\":3}"; 
		//String json = "{\"age\":32,\"marrital\":1,\"education\":2,\"job\":2,\"capacity\":4,\"workingLife\":3,\"area\":4,\"livingYears\":2,\"creditRecord\":5,\"personalCharacter\":5,\"courtQuery\":4,\"aveincome\":40000,\"householdAssets\":300000,\"population\":5,\"liabilities\":5,\"deposit\":500000,\"cardCooperation\":3,\"otherCooperation\":4}";
		//String json = "{\"age\":50,\"marrital\":4,\"education\":4,\"job\":3,\"capacity\":4,\"workingLife\":4,\"area\":3,\"livingYears\":3,\"creditRecord\":4,\"personalCharacter\":4,\"courtQuery\":3,\"aveincome\":40000,\"householdAssets\":1000000,\"population\":4,\"liabilities\":4,\"deposit\":500001,\"cardCooperation\":3,\"otherCooperation\":10}";
		//String json = "{\"age\":20,\"marrital\":1,\"education\":1,\"job\":1,\"capacity\":1,\"workingLife\":1,\"area\":1,\"livingYears\":1,\"creditRecord\":1,\"personalCharacter\":1,\"courtQuery\":1,\"aveincome\":0,\"householdAssets\":0,\"population\":1,\"liabilities\":1,\"deposit\":0,\"cardCooperation\":1,\"otherCooperation\":0}";
		//String json = "{\"age\":43,\"marrital\":2,\"education\":3,\"job\":1,\"capacity\":4,\"workingLife\":2,\"area\":3,\"livingYears\":2,\"creditRecord\":2,\"personalCharacter\":2,\"courtQuery\":3,\"aveincome\":25000,\"householdAssets\":500000,\"population\":2,\"liabilities\":2,\"deposit\":300000,\"cardCooperation\":1,\"otherCooperation\":2}"; 
		HttpEntity entity = new StringEntity(json,Charset.forName("UTF-8"));
		Response execute = Request.Post("http://192.168.1.146:8080/rcc/ws/test/rest/getResult/eliteScore")
			   .setHeader("content-type", "application/json;charset=UTF-8")
			   .body(entity).execute();
		String asString = execute.returnContent().asString();
		System.out.println(asString);
	}
	
	@Test
	public void testBHTEMP() throws Exception{
		String urlrcc="http://192.168.1.233:8080/rcc/ws/test/rest/getResultTemp/specialScore";
		String json = "{\"customerFlag\":\"A\",\"sex\":2,\"registryAddress\":2,\"age\":45,\"marry\":3,\"education\":5,\"workTime\":5,\"residentType\":2,\"unitType\":2,\"outerBlacklist\":0,\"queryResult\":3,\"WORST_OVERDUE_NOW_PL\":0.0,\"WORST_OVERDUE_NOW_RC\":-9999995.0,\"FLAG_CURR_STATUS_TOTAL\":0.0,\"NO_6MOB_ACCT_TOTAL\":2.0,\"NO_QUERY_2_7M_CA\":0.0,\"NO_QUERY_3M_CA\":1.0,\"NO_2MOB_ACCT_TOTAL\":2.0,\"BAD_COUNT\":0,\"ACCOUNT_COUNT_PL\":2,\"FORCE_EXECUTION_IND\":0.0,\"ADMIN_PUNISHMENT_IND\":0.0,\"ACCOUNT_COUNT_RC\":6,\"FINANCE_ORG_COUNT_RC\":null,\"NO_DELQ_3M_TOTAL\":0.0,\"NO_DELQ_6M_TOTAL\":0.0,\"NO_DELQ_12M_TOTAL\":0.0,\"MAX_DELQ_12M_TOTAL\":0.0,\"NO_UTL80_RC\":-9999995.0,\"UNNORMAL_GUR_IND\":1.0,\"ruleDecision\":\"LA\",\"MAX_DELQ_24M_TOTAL\":0.0,\"LAST_6M_AVG_UTL_OPEN_RC\":0.45,\"MAX_MOB_TOTAL\":null,\"income\":10000,\"dailyBalance\":10000,\"carYear\":2,\"carEvaValue\":200000,\"MONTHPAYMENT_HOUSE_PL\":0.0,\"homeValue\":5000000,\"expectLines\":300000,\"REPORT_DT2\":\" .\",\"REPORT_DT\":\".-.-.\",\"BALANCE_RC\":3531,\"HOUSE_BALANCE_PL\":0.0,\"MONTHLY_SHOULDPAY_PL\":8811.0,\"REPORT_ID\":\"385512337669546\",\"special\":2}";
		HttpEntity entity = new StringEntity(json,Charset.forName("UTF-8"));
		Response execute = Request.Post(urlrcc)
			   .setHeader("content-type", "application/json;charset=UTF-8")
			   .body(entity).execute();
		String asString = execute.returnContent().asString();
		System.out.println(asString);
	}
	
	@Test
	public void testBHPrivate() throws Exception{
		//for (int i = 0; i < 10000; i++) {
		//String url="http://www.yintuanonline.com/sinointerface-0.1/services/decisionservice/BHPrivateTestDCM";
		//String url="http://www.yintuanonline.com/sinointerface/services/decisionservice/BHPrivateTestCunChu";
		//String url="http://localhost:8080/sinointerface/services/decisionservice/BHPrivateTestCunChu";
		//String url="http://103.199.228.3/sinointerface/services/decisionservice/BHPrivateTestCunChu";
		//String url="http://103.199.228.10:80/sinointerface/services/decisionservice/BHPrivateTestCunChu";
			//String url="http://www.yintuanonline.com/RestWebServiceTest-0.1/services/test/BHPrivateTest";
			//String url="http://localhost:8080/RestWebServiceTest/services/test/risk/BHPrivateTest";
			//String url="http://192.168.1.233:8080/rcc/ws/test/rest/getResult/saccess";
			//String BHJson=GetFourData.biaozhunfirst(Math.random());
			//String BHJson=GetFourData.biaozhunsecond(Math.random());
			//String BHJson=GetFourData.zhuanxiangfenqifirst(Math.random());
			//String BHJson=GetFourData.zhuanxiangfenqisecond(Math.random());
			//String BHJson=GetFourDataPass.biaozhunfirst();
			//String BHJson=GetFourDataPass.biaozhunsecond(Math.random());
			//String BHJson=GetFourDataPass.zhuanxiangfenqifirst();
			//String BHJson=GetFourDataPass.zhuanxiangfenqiSecondCunChuSuiji(Math.random());
			String BHJson=GetFourDataPass.zhuanxiangfenqiSecondCunChuPass(Math.random());
			//String BHJson=GetFourDataPass.zhuanxiangfenqiSecond(Math.random());
			//String BHJson=GetFourData.zhuanxiangfenqisecondwithyanshengshuju(Math.random());
		    //String BHJson=GetFourDataPass.zhuanxiangfenqiSecond(Math.random());
			System.out.println(BHJson);
			HttpEntity entity = new StringEntity(BHJson,Charset.forName("UTF-8"));
			long starttime=System.currentTimeMillis();
			String finalScore = HttpPost.getFinalScore(BHJson);
			long endtime=System.currentTimeMillis();
			System.out.println(finalScore);
			System.out.println("耗时："+(endtime-starttime)+"ms");
		}
	//}
	
}
