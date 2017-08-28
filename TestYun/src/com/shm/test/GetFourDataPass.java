package com.shm.test;

import java.util.Random;

public class GetFourDataPass {
	
	public static String biaozhunfirst(double random){
		return "{\"serviceID\":\"saccess\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":{\"mainObject\":1,\"age\":"+(int)(18+random*65)+",\"nation\":1,\"workAddress\":1,\"forbidJob\":0,\"innerBlacklist\":0,\"identityCardOrgan\":1,\"registryAddress\":1,\"customerFlag\":"+"\""+getCustomerFlag((int)(random*5))+"\""+",\"loan\":"+(int)(random*5)+",\"creditCard\":1,\"overdue\":"+(int)(500+random*100000)+",\"LOAN_MAX_12M\":"+(int)(random*100)+",\"CC_MAX_12M\":"+(int)(random*500)+",\"LOAN_SUM_12M\":"+(int)(random*500)+",\"CC_SUM_12M\":"+(int)(random*100)+",\"loanRefuse\":"+(int)(random*5)+",\"creditRefuse\":"+(int)(random*5)+",\"education\":"+(int)(random*5)+",\"limitJob\":"+(int)(random*1)+"}}";
	}
	
	//测试单条规则数据
	public static String testcode(double random){
		return "{\"serviceID\":\"test\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":{\"score\":"+(int)(100+random*200)+"}}";
	}
	
	public static String biaozhunsecond(double random){
        return "{\"serviceID\":\"gradeScore\",\"customerInfo\":"
			    +"{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":{\"customerFlag\":\"A\",\"sex\":2,\"registryAddress\":2,\"age\":45,\"marry\":3,\"education\":5,\"workTime\":5,\"residentType\":2,\"unitType\":2,\"outerBlacklist\":0,\"queryResult\":3,\"ruleDecision\":\"LA\",\"homeValue\":5000000,\"expectLines\":300000,\"maxLines\":1000000,\"income\":10000,\"dailyBalance\":10000,\"carYear\":2,\"carEvaValue\":200000},\"creditData\":"
						+"{\"headerInfo\":{\"reportSN\":\""+getRandomString(15)+"\",\"reportCreateTime\":\"20070515\"},"
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
						+ "\"queryDate\":\"20050402\", \"querier\":\"SYSTEM}\",\"queryReason\":\"信用卡审批\"}]}}";
	}
	
	public static String zhuanxiangfenqifirst(){
		return "{\"serviceID\":\"speaccess\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":{\"special\":2,\"homeAddress\":1,\"registryAddress\":0,\"age\":30,\"workAddress\":1,\"marry\":1,\"forbidJob\":0,\"cashInstalment\":0,\"balance\":0,\"specialStage\":0,\"education\":5,\"customerFlag\":\"A\",\"fullTime\":1,\"publicCredit\":0,\"wealthCustomers\":1,\"wealthCustomersTime\":1,\"WC_3M_balance\":1000,\"housingMortgage\":1,\"hm_pay\":10,\"AF_capture_12M\":1,\"payPut\":500,\"innerBlacklist\":0,\"workLife\":2,\"workTime\":2,\"homeIncome\":2,\"income\":2,\"limitJob\":1,\"loan\":2,\"overdue\":600,\"creditCard\":2,\"LOAN_MAX_12M\":10,\"CC_MAX_12M\":2,\"LOAN_SUM_12M\":5,\"CC_SUM_12M\":6,\"loanRefuse\":1,\"creditRefuse\":0}}";
	}
	
	public static String zhuanxiangfenqiSecond(double random){
			return "{\"serviceID\":\"specialScore\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":"
					+"{\"outerBlacklist\":0,\"queryResult\":3,\"special\":"+(int)(random*5)+",\"aveMonPay\":"+(int)(random*6000)+",\"income\":"+(int)(random*20000)+",\"ruleDecision\":\"R\",\"sex\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*3)+",\"age\":"+(int)(random*100)+",\"marry\":"+(int)(random*2)+",\"education\":"+(int)(random*6)+",\"workTime\":"+(int)(random*4)+","
					+"\"customerFlag\":\""+getCustomerFlag((int)(random*5))+"\",\"haohanType\":\""+getHaoHanType((int)(random*3))+"\",\"annualDailyWealth\":"+(int)(random*1000)+",\"dailyBalance\":"+(int)(random*500)+",\"expectLines\":"+(int)(random*600000)+",\"homeValue\":"+(int)(random*10000000)+","
					+"\"fullInvoice\":"+(int)(random*10000000)+",\"carYear\":"+(int)(random*20)+",\"rankType\":"+(int)(random*3)+",\"LQADWB_12M\":"+(int)(random*10)+",\"residentType\":"+(int)(random*5)+",\"unitType\":"+(int)(random*5)+"},\"creditData\":"
					+"{\"headerInfo\":{\"reportSN\":\""+getRandomString(15)+"\",\"reportCreateTime\":\"20080502\"},"
					+ "\"overdueInfoSum\":{\"debtCount\":"+getRandomString(1)+",\"dispositionCount\":"+getRandomString(1)+"},"
					+ "\"shareAndDebtpInfo\":{\"loanInfo\":{\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(5)+",\"balance\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(3)+",\"financeCorpCount\":"+getRandomString(1)+"},"
					+ "\"loancardInfo\":{\"financeOrgCount\":"+getRandomString(1)+",\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(6)+",\"usedCreditLimit\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(4)+"}},"
					+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200706\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200404,\"endMonth\":200805,\"month\":\"200805\",\"lastMonths\":"+getRandomString(1)+""
					+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200707\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+(int)(random*1)+",\"lastMonths\":200804}],"
					+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200707\",\"paymentCyc\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"usedCreditLimitAmount\":null,\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200505,\"endMonth\":200803,\"month\":"+getRandomString(1)+",\"lastMonths\":200804"
					+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200707\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200607,\"endMonth\":200907,\"month\":"+(int)(random*1)+",\"lastMonths\":200908}],"
					+ "\"guaranteeInfoList\":[{\"class5State\":\"一级\"}, {\"class5State\":\"一级\"}],"
					+ "\"forceExecutionInfoList\":null,"
					+ "\"adminPunishList\":null,"
					+ "\"creditAndLoanRecordList\":[{\"queryDate\":\"20070409\", \"querier\":\"SYSTEM}\",\"queryReason\":\"贷款审批}\"}, {"
					+ "\"queryDate\":\"20070409\", \"querier\":\"SYSTEM}\",\"queryReason\":\"信用卡审批\"}]}}";
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
	
	public static String getCustomerFlag(int random){
		String[] arg={"A","B","C","D","Z211"};
		return arg[random];
	}
	
	public static String getHaoHanType(int random){
		String[] args={"diamond","platinum","gold"};
		return args[random];
	}
	
	public static String zhuanxiangfenqiSecondCunChuSuiji(double random){
		return "{\"serviceID\":\"specialScore\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":"
				+"{\"outerBlacklist\":0,\"queryResult\":3,\"special\":"+(int)(random*5)+",\"aveMonPay\":"+(int)(random*6000)+",\"income\":"+(int)(random*20000)+",\"ruleDecision\":\"R\",\"sex\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*3)+",\"age\":"+(int)(random*100)+",\"marry\":"+(int)(random*2)+",\"education\":"+(int)(random*6)+",\"workTime\":"+(int)(random*4)+","
				+"\"customerFlag\":\""+getCustomerFlag((int)(random*5))+"\",\"haohanType\":\""+getHaoHanType((int)(random*3))+"\",\"annualDailyWealth\":"+(int)(random*1000)+",\"dailyBalance\":"+(int)(random*500)+",\"expectLines\":"+(int)(random*600000)+",\"homeValue\":"+(int)(random*10000000)+","
				+"\"fullInvoice\":"+(int)(random*10000000)+",\"carYear\":"+(int)(random*20)+",\"rankType\":"+(int)(random*3)+",\"LQADWB_12M\":"+(int)(random*10)+",\"residentType\":"+(int)(random*5)+",\"unitType\":"+(int)(random*5)+"},\"creditData\":"
				//+OuterDataClient.getOuterData("D:/mine/Pro/Program Files(x86)/Nwt/recv/winner/征信解析存储过程版本/报文.txt")
				//+OuterDataClient.getOuterData("D:/mine/Pro/Program Files(x86)/Nwt/recv/winner/征信解析存储过程版本/报文随机.txt")
				+CunChuzhengxindatasuiji.getRandomMessage()
				+"}";
}
	
	public static String zhuanxiangfenqiSecondCunChuPass(double random){
		return "{\"serviceID\":\"specialScore\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":"
				+"{\"outerBlacklist\":0,\"queryResult\":3,\"special\":"+(int)(random*5)+",\"aveMonPay\":"+(int)(random*6000)+",\"income\":"+(int)(random*20000)+",\"ruleDecision\":\"R\",\"sex\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*3)+",\"age\":"+(int)(random*100)+",\"marry\":"+(int)(random*2)+",\"education\":"+(int)(random*4)+",\"workTime\":"+(int)(random*4)+","
				+"\"customerFlag\":\""+getCustomerFlag((int)(random*5))+"\",\"haohanType\":\""+getHaoHanType((int)(random*3))+"\",\"annualDailyWealth\":"+(int)(random*1000)+",\"dailyBalance\":"+(int)(random*500)+",\"expectLines\":"+(int)(random*600000)+",\"homeValue\":"+(int)(random*10000000)+","
				+"\"fullInvoice\":"+(int)(random*10000000)+",\"carYear\":"+(int)(random*20)+",\"rankType\":"+(int)(random*3)+",\"LQADWB_12M\":"+(int)(random*10)+",\"residentType\":"+(int)(random*5)+",\"unitType\":"+(int)(random*5)+"},\"creditData\":"
				//+OuterDataClient.getOuterData("D:/mine/Pro/Program Files(x86)/Nwt/recv/winner/征信解析存储过程版本/报文.txt")
				//+OuterDataClient.getOuterData("D:/mine/Pro/Program Files(x86)/Nwt/recv/winner/征信解析存储过程版本/报文随机.txt")
				+CunChuzhengxindatasuiji.getPassedMessage()
				+"}";
}
	public static String zhuanxiangfenqiSecondCunChuPass1(double random){
		return "{\"serviceID\":\"businessData\",\"ruleData\":"
				+"{\"outerBlacklist\":0,\"queryResult\":3,\"special\":"+(int)(random*5)+",\"aveMonPay\":"+(int)(random*6000)+",\"income\":"+(int)(random*20000)+",\"ruleDecision\":\"R\",\"sex\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*3)+",\"age\":\"19710402\",\"marry\":"+(int)(random*2)+",\"education\":\"专科\",\"workTime\":"+(int)(random*4)+","
				+"\"customerFlag\":\""+getCustomerFlag((int)(random*5))+"\",\"haohanType\":\""+getHaoHanType((int)(random*3))+"\",\"annualDailyWealth\":"+(int)(random*1000)+",\"dailyBalance\":"+(int)(random*500)+",\"expectLines\":"+(int)(random*600000)+",\"homeValue\":"+(int)(random*10000000)+","+"\"fullTime\":\"脱产\",\"CC_MAX_12M\": \"01E3456789ABC\",\"wealthCusTime\":\"2017/06/02\",\"threeMonthWealthAmtAvgRate1\":\"16.78%\","
				+"\"fullInvoice\":"+(int)(random*10000000)+",\"carYear\":"+(int)(random*20)+",\"rankType\":"+(int)(random*3)+",\"LQADWB_12M\":"+(int)(random*10)+",\"residentType\":"+(int)(random*5)+",\"unitType\":"+(int)(random*5)+"}}";
}
	public static String zhuanxiangfenqiSecondCunChuPass2(double random){
		return "{\"serialNumber\":\"99999\",\"idNumber\":\"11111\","
				+ "\"phoneNumber\":\"0086-111111111\",\"name\":\"张三\",\"bankCardNumber\":\"22222\"}";
}
}
