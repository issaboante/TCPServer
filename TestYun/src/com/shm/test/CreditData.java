package com.shm.test;

import java.util.Calendar;
import java.util.Random;

public class CreditData {
	public static String getCode(double random){
		String code="\"creditData\":{\"headerInfo\":{\"reportSN\":"+getRandomString(15)+",\"reportCreateTime\":\"20070502\"},"
				+ "\"overdueInfoSum\":{\"debtCount\":"+getRandomString(1)+",\"dispositionCount\":"+getRandomString(1)+"},"
				+ "\"shareAndDebtpInfo\":{\"loanInfo\":{\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(5)+",\"balance\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(3)+",\"financeCorpCount\":"+getRandomString(1)+"},"
				+ "\"loancardInfo\":{\"financeOrgCount\":"+getRandomString(1)+",\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(6)+",\"usedCreditLimit\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(4)+"}},"
				+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+getRandomString(1)+",\"lastMonths\":\"200503\""
				+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+(int)(random*1)+",\"lastMonths\":200503}],"
				+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"usedCreditLimitAmount\":null,\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+getRandomString(1)+",\"lastMonths\":200503"
				+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+(int)(random*1)+",\"lastMonths\":200503}],"
				+ "\"guaranteeInfoList\":[{\"class5State\":\"一级\"}, {\"class5State\":\"一级\"}],"
				+ "\"forceExecutionInfoList\":[{\"registerDate\":\"200803\"}, {\"registerDate\":\"200503\"}],"
				+ "\"adminPunishList\":[{\"beginDate\":\"200504\"}, {\"beginDate\":\"200504\"}],"
				+ "\"creditAndLoanRecordList\":[{\"queryDate\":\"20050402\", \"querier\":\"SYSTEM}\",\"queryReason\":\"贷款审批}\"}, {"
				+ "\"queryDate\":\"20050402\", \"querier\":\"SYSTEM}\",\"queryReason\":\"信用卡审批\"}]}";
													
				
		return code;
	}
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();  
	    
	 } 
//	public static String randomDateBetweenMinAndMax(){  
//	       Calendar calendar = Calendar.getInstance();  
//	       //注意月份要减去1  
//	       calendar.set(2000,11,31);  
//	       calendar.getTime().getTime();  
//	       //根据需求，这里要将时分秒设置为0  
//	       calendar.set(Calendar.HOUR_OF_DAY, 0);  
//	       calendar.set(Calendar.MINUTE, 0);  
//	       calendar.set(Calendar.SECOND,0);  
//	       long min = calendar.getTime().getTime();;  
//	       calendar.set(2017,11,31);  
//	       calendar.set(Calendar.HOUR_OF_DAY,0);  
//	       calendar.set(Calendar.MINUTE,0);  
//	       calendar.set(Calendar.SECOND,0);  
//	       calendar.getTime().getTime();  
//	       long max = calendar.getTime().getTime();  
//	       //得到大于等于min小于max的double值  
//	       double randomDate = Math.random()*(max-min)+min;  
//	       //将double值舍入为整数，转化成long类型  
//	       calendar.setTimeInMillis(Math.round(randomDate));  
//	       return calendar.getTime().toString();  
//	   }  
	
public static String creditjson="\"creditData\":{"+
"\"headerInfo\": {"+
	"\"reportSN\": \"4561321511515899\","+
	"\"reportCreateTime\":\"20070205\""+
"},"+
"\"overdueInfoSum\":{"+
	"\"debtCount\": \"2\","+
	"\"dispositionCount\": \"3\""+
"},"+
"\"shareAndDebtpInfo\": {"+
	"\"loanInfo\": {"+
		"\"accountCount\": \"3\","+
		"\"creditLimit\": \"40000\","+
		"\"balance\": \"4000\","+
		"\"latest6MonthUsedAvgAmount\": \"800\","+
		"\"financeCorpCount\": \"3\""+
	"},"+
	"\"loancardInfo\": {"+
		"\"financeOrgCount\": \"1\","+
		"\"accountCount\": \"3\","+
		"\"creditLimit\": \"563000\","+
		"\"usedCreditLimit\": \"6000\","+
		"\"latest6MonthUsedAvgAmount\": \"6000\""+
	"}"+
"},"+
"\"loaninfolist\": ["+
	"{"+
		"\"account\": \"2154512645154\","+
		"\"state\": \"呆账\","+
		"\"creditLimitAmount\": \"22200\","+
		"\"openDate\": \"200503\","+
		"\"paymentCyc\": \"10\","+
		"\"type\": \"01\","+
		"\"actualPaymentAmount\": \"2000\","+
		"\"balance\": \"60000\","+
		"\"scheduledPaymentAmount\": \"1000\","+
		"\"stateEndDate\": \"200601\","+
		"\"recentPayDate\": \"\","+
		"\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\","+
		"\"beginMonth\": \"200201\","+
		"\"endMonth\": \"200503\","+
		"\"month\": \"5\","+
		"\"lastMonths\": \"200501\""+
	"}, {"+
		"\"account\": \"2154512645154\","+
		"\"state\": \"呆账\","+
		"\"creditLimitAmount\": \"22200\","+
		"\"openDate\": \"200503\","+
		"\"paymentCyc\": \"10\","+
		"\"type\": \"01\","+
		"\"actualPaymentAmount\": \"2000\","+
		"\"balance\": \"60000\","+
		"\"scheduledPaymentAmount\": \"1000\","+
		"\"stateEndDate\": \"200601\","+
		"\"recentPayDate\": \"\","+
		"\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\","+
		"\"beginMonth\": \"200201\","+
		"\"endMonth\": \"200503\","+
		"\"month\": \"5\","+
		"\"lastMonths\": \"200501\""+
	"}"+
"],"+
"\"loanCardInfoList\": ["+
	"{"+
		"\"account\": \"2154512645154\","+
		"\"state\": \"呆账\","+
		"\"creditLimitAmount\": \"22200\","+
		"\"openDate\": \"200503\","+
		"\"actualPaymentAmount\": \"2000\","+
		"\"usedCreditLimitAmount\": \"\","+
		"\"scheduledPaymentAmount\": \"1000\","+
		"\"stateEndDate\": \"200601\","+
		"\"recentPayDate\": \"\","+
		"\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\","+
		"\"beginMonth\": \"200201\","+
		"\"endMonth\": \"200503\","+
		"\"month\": \"5\","+
		"\"lastMonths\": \"200501\""+
	"}, {"+
		"\"account\": \"2154512645154\","+
		"\"state\": \"呆账\","+
		"\"creditLimitAmount\": \"22200\","+
		"\"openDate\": \"200503\","+
		"\"actualPaymentAmount\": \"2000\","+
		"\"usedCreditLimitAmount\": \"\","+
		"\"scheduledPaymentAmount\": \"1000\","+
		"\"stateEndDate\": \"200601\","+
		"\"recentPayDate\": \"\","+
		"\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\","+
		"\"beginMonth\": \"200201\","+
		"\"endMonth\": \"200503\","+
		"\"month\": \"5\","+
		"\"lastMonths\": \"200501\""+
	"}"+
"],"+
"\"guaranteeInfoList\": ["+
	"{"+
		"\"class5State\": \"一级\""+
	"}, {"+
		"\"class5State\": \"一级\""+
	"}"+
"],"+
"\"forceExecutionInfoList\": ["+
	"{"+
		"\"registerDate\": \"200806\""+
	"}, {"+
		"\"registerDate\": \"200506\""+
	"}"+
"],"+
"\"adminPunishList\": ["+
	"{"+
		"\"beginDate\": \"201209\""+
	"}, {"+
		"\"beginDate\": \"201202\""+
	"}"+
"],"+
"\"creditAndLoanRecordList\": ["+
	"{"+
		"\"queryDate\": \"20000201\","+
		"\"querier\": \"SYSTEM\","+
		"\"queryReason\": \"贷款审批\""+
	"}, {"+
		"\"queryDate\": \"20000201\","+
		"\"querier\": \"SYSTEM\","+
		"\"queryReason\": \"信用卡审批\""+
	"}"+
"]"+
"}";

	public static void main(String[] args) {
    	try {
			System.out.println(getCode(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
