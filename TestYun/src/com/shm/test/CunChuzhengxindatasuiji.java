package com.shm.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class CunChuzhengxindatasuiji {
	
	public static String getRandomMessage(){
		//生成当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");//设置日期格式
		String currentData = sdf.format(new Date());
		//System.out.println(currentData);// new Date()为获取当前系统时间
		
		return "{\"headerInfo\": {\"reportSN\": \""+getRandomNum(7)+"\",\"reportCreateTime\":\""+currentData+"\"},\"overdueInfoSum\":"
				+ "{\"debtCount\": \""+getRandomNum(1)+"\",\"dispositionCount\":\""+getRandomNum(1)+"\"},\"shareAndDebtpInfo\": {\"loanInfo\": {\"accountCount\":\""
				+ ""+getRandomNum(1)+"\",\"creditLimit\": \""+getRandomNum(4)+"\",\"balance\": \""+getRandomNum(4)+"\",\"latest6MonthUsedAvgAmount\": \""+getRandomNum(4)+"\",\"financeCorpCount\":\""
				+ ""+getRandomNum(1)+"\"},\"loancardInfo\": {\"financeOrgCount\": \""+getRandomNum(1)+"\",\"accountCount\": \""+getRandomNum(1)+"\",\"creditLimit\": \""+getRandomNum(6)+"\","
				+ "\"usedCreditLimit\": \""+getRandomNum(4)+"\",\"latest6MonthUsedAvgAmount\": \""+getRandomNum(4)+"\"}},\"loaninfolist\": [{\"account\": \""+getRandomNum(13)+"\","
				+ "\"state\": \"呆账\",\"creditLimitAmount\": \""+getRandomNum(5)+"\",\"openDate\": \""+getRandomDateDay()+"\",\"paymentCyc\": \""+getRandomNum(2)+"\",\"type\": \""+getRandomNum(2)+"\","
				+ "\"actualPaymentAmount\": \""+getRandomNum(4)+"\",\"balance\": \""+getRandomNum(5)+"\",\"scheduledPaymentAmount\": \""+getRandomNum(4)+"\",\"stateEndDate\": \""+getRandomDateDay()+"\","
				+ "\"recentPayDate\":null,\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\": \""+getRandomDate()+"\",\"endMonth\": \""+getRandomEndDate()+"\","
				+ "\"month\":\""+getRandomDate()+"\",\"amount\": \""+getRandomNum(4)+"\",\"currOverdueCyc\": \""+getRandomNum(1)+"\",\"currOverdueAmount\": \""+getRandomNum(4)+"\",\"lastMonths\": \""+getRandomNum(1)+"\"}, {"
				+ "\"account\": \""+getRandomNum(13)+"\",\"state\": \"呆账\",\"creditLimitAmount\": \""+getRandomNum(5)+"\",\"openDate\": \""+getRandomDateDay()+"\",\"paymentCyc\":\""
				+ " "+getRandomNum(2)+"\",\"type\": \""+getRandomNum(2)+"\",\"actualPaymentAmount\": \""+getRandomNum(4)+"\",\"balance\": \""+getRandomNum(5)+"\",\"scheduledPaymentAmount\": \""+getRandomNum(4)+"\","
				+ "\"stateEndDate\": \""+getRandomDateDay()+"\",\"recentPayDate\":null,\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\": \""+getRandomDate()+"\","
				+ "\"endMonth\": \""+getRandomEndDate()+"\",\"month\":\""+getRandomDate()+"\",\"amount\": \""+getRandomNum(4)+"\",\"currOverdueCyc\": \""+getRandomNum(1)+"\",\"currOverdueAmount\": \""+getRandomNum(4)+"\","
				+ "\"lastMonths\": \""+getRandomNum(1)+"\"}],\"loanCardInfoList\": [{\"account\": \""+getRandomNum(13)+"\",\"state\": \"呆账\",\"creditLimitAmount\": \""+getRandomNum(5)+"\","
				+ "\"openDate\": \""+getRandomDateDay()+"\",\"actualPaymentAmount\": \""+getRandomNum(4)+"\",\"usedCreditLimitAmount\":"+getRandomNum(5)+",\"scheduledPaymentAmount\": \""+getRandomNum(4)+"\","
				+ "\"stateEndDate\": \""+getRandomDateDay()+"\",\"recentPayDate\":null,\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\": \""+getRandomDate()+"\","
				+ "\"endMonth\": \""+getRandomEndDate()+"\",\"month\": \""+getRandomDate()+"\",\"amount\": \""+getRandomNum(4)+"\",\"currOverdueCyc\": \""+getRandomNum(1)+"\",\"currOverdueAmount\": \""+getRandomNum(4)+"\","
				+ "\"lastMonths\": \""+getRandomNum(1)+"\"}, {\"account\": \""+getRandomNum(13)+"\",\"state\": \"呆账\",\"creditLimitAmount\": \""+getRandomNum(5)+"\",\"openDate\": \""+getRandomDateDay()+"\","
				+ "\"actualPaymentAmount\": \""+getRandomNum(4)+"\",\"usedCreditLimitAmount\":"+getRandomNum(5)+",\"scheduledPaymentAmount\": \""+getRandomNum(4)+"\",\"stateEndDate\": \""+getRandomDateDay()+"\","
				+ "\"recentPayDate\":null,\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\": \""+getRandomDate()+"\",\"endMonth\": \""+getRandomEndDate()+"\",\"month\":\""
				+ " "+getRandomDate()+"\",\"amount\": \""+getRandomNum(4)+"\",\"currOverdueCyc\":\""+getRandomNum(1)+"\",\"currOverdueAmount\": \""+getRandomNum(4)+"\",\"lastMonths\": \""+getRandomNum(1)+"\"}],\"guaranteeInfoList\":"
				+ " [{\"class5State\": \"一级\"}, {\"class5State\": \"一级\"}],\"forceExecutionInfoList\": [{\"registerDate\": \""+getRandomDateDay()+"\"}, {\"registerDate\""
				+ ": \""+getRandomDateDay()+"\"}],\"adminPunishList\": [{\"beginDate\": \""+getRandomDateDay()+"\"}, {\"beginDate\": \""+getRandomDateDay()+"\"}],\"creditAndLoanRecordList\": "
				+ "[{\"queryDate\": \""+getRandomDateDay()+"\",\"querier\": \"SYSTEM\",\"queryReason\": \"贷款审批\"}, {\"queryDate\": \""+getRandomDateDay()+"\",\"querier\": \"SYSTEM\","
				+ "\"queryReason\": \"信用卡审批\"}]}";
	}
	
	public static String getPassedMessage(){
		//生成当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");//设置日期格式
		String currentData = sdf.format(new Date());
		//System.out.println(currentData);// new Date()为获取当前系统时间
		
		return "{\"headerInfo\": {\"reportSN\": \""+getRandomNum(7)+"\",\"reportCreateTime\":\""+currentData+"\"},\"overdueInfoSum\":"
				+ "{\"debtCount\": \"0\",\"dispositionCount\":\"0\"},\"shareAndDebtpInfo\": {\"loanInfo\": {\"accountCount\":\""
				+ ""+getRandomNum(1)+"\",\"creditLimit\": \""+getRandomNum(4)+"\",\"balance\": \""+getRandomNum(4)+"\",\"latest6MonthUsedAvgAmount\": \""+getRandomNum(4)+"\",\"financeCorpCount\":\""
				+ ""+getRandomNum(1)+"\"},\"loancardInfo\": {\"financeOrgCount\": \""+getRandomNum(1)+"\",\"accountCount\": \""+getRandomNum(1)+"\",\"creditLimit\": \""+getRandomNum(6)+"\","
				+ "\"usedCreditLimit\": \""+getRandomNum(4)+"\",\"latest6MonthUsedAvgAmount\": \""+getRandomNum(4)+"\"}},\"loaninfolist\": [{\"account\": \""+getRandomNum(13)+"\","
				+ "\"state\": \"非呆账\",\"creditLimitAmount\": \""+getRandomNum(5)+"\",\"openDate\": \""+getRandomDateDay()+"\",\"paymentCyc\": \""+getRandomNum(2)+"\",\"type\": \"01\","
				+ "\"actualPaymentAmount\": \""+getRandomNum(4)+"\",\"balance\": \""+getRandomNum(5)+"\",\"scheduledPaymentAmount\": \""+getRandomNum(4)+"\",\"stateEndDate\": \""+getRandomDateDay()+"\","
				+ "\"recentPayDate\":null,\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\": \""+getRandomDate()+"\",\"endMonth\": \""+getRandomEndDate()+"\","
				+ "\"month\":\""+getRandomDate()+"\",\"amount\": \""+getRandomNum(4)+"\",\"currOverdueCyc\": \"0\",\"currOverdueAmount\": \"0\",\"lastMonths\": \""+getRandomNum(1)+"\"}, {"
				+ "\"account\": \""+getRandomNum(13)+"\",\"state\": \"非呆账\",\"creditLimitAmount\": \""+getRandomNum(5)+"\",\"openDate\": \""+getRandomDateDay()+"\",\"paymentCyc\":\""
				+ " "+getRandomNum(2)+"\",\"type\": \""+getRandomNum(2)+"\",\"actualPaymentAmount\": \""+getRandomNum(4)+"\",\"balance\": \""+getRandomNum(5)+"\",\"scheduledPaymentAmount\": \""+getRandomNum(4)+"\","
				+ "\"stateEndDate\": \""+getRandomDateDay()+"\",\"recentPayDate\":null,\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\": \""+getRandomDate()+"\","
				+ "\"endMonth\": \""+getRandomEndDate()+"\",\"month\":\""+getRandomDate()+"\",\"amount\": \""+getRandomNum(4)+"\",\"currOverdueCyc\": \"0\",\"currOverdueAmount\": \"0\","
				+ "\"lastMonths\": \""+getRandomNum(1)+"\"}],\"loanCardInfoList\": [{\"account\": \""+getRandomNum(13)+"\",\"state\": \"非呆账\",\"creditLimitAmount\": \""+getRandomNum(5)+"\","
				+ "\"openDate\": \""+getRandomDateDay()+"\",\"actualPaymentAmount\": \""+getRandomNum(4)+"\",\"usedCreditLimitAmount\":"+getRandomNum(5)+",\"scheduledPaymentAmount\": \""+getRandomNum(4)+"\","
				+ "\"stateEndDate\": \""+getRandomDateDay()+"\",\"recentPayDate\":null,\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\": \""+getRandomDate()+"\","
				+ "\"endMonth\": \""+getRandomEndDate()+"\",\"month\": \""+getRandomDate()+"\",\"amount\": \""+getRandomNum(4)+"\",\"currOverdueCyc\": \"0\",\"currOverdueAmount\": \"0\","
				+ "\"lastMonths\": \""+getRandomNum(1)+"\"}, {\"account\": \""+getRandomNum(13)+"\",\"state\": \"非呆账\",\"creditLimitAmount\": \""+getRandomNum(5)+"\",\"openDate\": \""+getRandomDateDay()+"\","
				+ "\"actualPaymentAmount\": \""+getRandomNum(4)+"\",\"usedCreditLimitAmount\":"+getRandomNum(5)+",\"scheduledPaymentAmount\": \""+getRandomNum(4)+"\",\"stateEndDate\": \""+getRandomDateDay()+"\","
				+ "\"recentPayDate\":null,\"latest24State\": \"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\": \""+getRandomDate()+"\",\"endMonth\": \""+getRandomEndDate()+"\",\"month\":\""
				+ " "+getRandomDate()+"\",\"amount\": \""+getRandomNum(4)+"\",\"currOverdueCyc\":\"0\",\"currOverdueAmount\": \"0\",\"lastMonths\": \""+getRandomNum(1)+"\"}],\"guaranteeInfoList\":"
				+ " [{\"class5State\": \"一级\"}, {\"class5State\": \"一级\"}],\"forceExecutionInfoList\":null,\"adminPunishList\":null,\"creditAndLoanRecordList\": "
				+ "[{\"queryDate\": \""+getRandomDateDay()+"\",\"querier\": \"SYSTEM\",\"queryReason\": \"贷款审批\"}, {\"queryDate\": \""+getRandomDateDay()+"\",\"querier\": \"SYSTEM\","
				+ "\"queryReason\": \"信用卡审批\"}]}";
	}
	
	
	/**
	 * 根据传入的参数，获取到对应位数的随机数
	 * @param i
	 * @return
	 */
	public static String getRandomNum(int i){
		
		if(i==1){
			int randomInt1 = (int)(Math.random()*10);
			return ""+randomInt1;
		}else if (i==2) {
			int randomInt2 = (int)(Math.random()*90+10);
			return ""+randomInt2;
		}else if (i==4) {
			int randomInt4 = (int)(Math.random()*9000+1000);
			return ""+randomInt4;
		}else if (i==5) {
			int randomInt5 = (int)(Math.random()*90000+10000);
			return ""+randomInt5;
		}else if (i==6) {
			int randomInt6 = (int)(Math.random()*900000+100000);
			return ""+randomInt6;
		}else if (i==7) {
			int randomInt7 = (int)(Math.random()*9000000+1000000);
			return ""+randomInt7;
		}else if (i==13){
			long randomInt13 = (long)(Math.random()*Long.parseLong("9000000000000")
					+Long.parseLong("1000000000000"));
			return ""+randomInt13;
		}
		return null;
	}
	
	/**
	 * 按照2005.02的格式随机生成年月
	 * @return
	 */
	public static String getRandomDate(){
		StringBuffer sb = new StringBuffer();
		sb.append("20"+getRandomMonth()+"."+getRandomMonth());
		return sb.toString();
	}
	
	/**
	 * 按照2005.02的格式随机生成end月份
	 * @return
	 */
	public static String getRandomEndDate(){
		StringBuffer sb = new StringBuffer();
		sb.append("2013"+"."+getRandomMonth());
		return sb.toString();
	}
	
	/**
	 * 按照2005.02.01的格式随机生成准确到日的日期
	 * @return
	 */
	public static String getRandomDateDay(){
		StringBuffer sb = new StringBuffer();
		sb.append("20"+getRandomMonth()+"."+getRandomMonth()+"."+getRandomDay());
		return sb.toString();
	}
	
	/**
	 * 生成随机的月数01-12
	 * @return
	 */
	public static String getRandomMonth(){
		int randomInt2 = (int)(Math.random()*12)+1;
		if(randomInt2<10){
			return "0"+randomInt2;
		}else {
			return ""+randomInt2;
		}
	}
	
	/**
	 * 生成随机的日数01-29
	 * @return
	 */
	public static String getRandomDay(){
		int randomInt2 = (int)(Math.random()*28)+1;
		if(randomInt2<10){
			return "0"+randomInt2;
		}else {
			return ""+randomInt2;
		}
	}
	
	//这个是之前人写的方法，有缺陷，没有0的存在，需要改进但是也是一种方法
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
	
/*	public static String createJson(){
		String str = OuterDataClient.getOuterData("C:\\Users\\Administrator.SC-201701111934\\Desktop\\报文1.txt");
		str.replaceAll("\"", "\\\"");
		System.out.println(str);
		return str;
	}*/
}
