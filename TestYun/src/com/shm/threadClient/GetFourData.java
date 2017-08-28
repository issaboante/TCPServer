package com.shm.threadClient;

import java.util.Random;


public class GetFourData {
	
	public static String biaozhunfirst(double random){
		return "{\"serviceID\":\"speaccess\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},"
				+"\"ruleData\":{\"mainObject\":"+(int)(random*3)+",\"age\":"+(int)(random*100)+",\"nation\":"+(int)(random*2)+",\"workAddress\":"+(int)(random*2)+",\"forbidJob\":"+(int)(random*2)+",\"innerBlacklist\":"+(int)(random*2)+",\"identityCardOrgan\":"+(int)(random*2)+","
				+"\"registryAddress\":"+(int)(random*2)+",\"customerFlag\":\""+getString((int)(random*3))+"\",\"loan\":"+(int)(random*2)+",\"creditCard\":"+(int)(random*2)+",\"overdue\":"+(int)(random*3000)+",\"LOAN_MAX_12M\":"+(int)(random*3)+","
				+"\"CC_MAX_12M\":"+(int)(random*3)+",\"LOAN_SUM_12M\":"+(int)(random*10)+",\"CC_SUM_12M\":"+(int)(random*10)+",\"loanRefuse\":"+(int)(random*2)+",\"creditRefuse\":"+(int)(random*2)+",\"education\":"+(int)(random*2)+",\"limitJob\":"+(int)(random*2)+"}}";
	}
	
	public static String biaozhunsecond(double random){
		return "{\"serviceID\":\"gradeScore\",\"customerInfo\":"
			    +"{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":"
				+"{\"customerFlag\":\""+getString((int)(random*3))+"\",\"sex\":2,\"registryAddress\":2,\"age\":"+(int)(random*100)+",\"marry\":"+(int)(random*4)+",\"education\":"+(int)(random*8)+",\"workTime\":"+(int)(random*10)+",\"residentType\":"+(int)(random*3)+","
				+"\"unitType\":"+(int)(random*3)+",\"outerBlacklist\":"+(int)(random*2)+",\"queryResult\":"+(int)(random*5)+",\"ruleDecision\":\"LA\",\"homeValue\":"+((int)(random*10))*1000000+","
				+"\"expectLines\":"+((int)(random*10))*100000+",\"maxLines\":"+((int)(random*3))*1000000+",\"income\":"+(int)(random*10000)+",\"dailyBalance\":"+(int)(random*10000)+",\"carYear\":"+(int)(random*10)+",\"carEvaValue\":"+(int)(random*1000000)+"},\"creditData\":"
						+"{\"headerInfo\":{\"reportSN\":\""+getRandomString(15)+"\",\"reportCreateTime\":\"20070515\"},"
						+ "\"overdueInfoSum\":{\"debtCount\":"+getRandomString(1)+",\"dispositionCount\":"+getRandomString(1)+"},"
						+ "\"shareAndDebtpInfo\":{\"loanInfo\":{\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(5)+",\"balance\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(3)+",\"financeCorpCount\":"+getRandomString(1)+"},"
						+ "\"loancardInfo\":{\"financeOrgCount\":"+getRandomString(1)+",\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(6)+",\"usedCreditLimit\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(4)+"}},"
						+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+getRandomString(1)+",\"lastMonths\":\"200503\""
						+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+(int)(random*1)+",\"lastMonths\":200503}],"
						+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"usedCreditLimitAmount\":null,\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+getRandomString(1)+",\"lastMonths\":200503"
						+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+(int)(random*1)+",\"lastMonths\":200503}],"
						+ "\"guaranteeInfoList\":[{\"class5State\":\"�?��\"}, {\"class5State\":\"�?��\"}],"
						+ "\"forceExecutionInfoList\":[{\"registerDate\":\"200803\"}, {\"registerDate\":\"200503\"}],"
						+ "\"adminPunishList\":[{\"beginDate\":\"200504\"}, {\"beginDate\":\"200504\"}],"
						+ "\"creditAndLoanRecordList\":[{\"queryDate\":\"20050402\", \"querier\":\"SYSTEM}\",\"queryReason\":\"贷款审批}\"}, {"
						+ "\"queryDate\":\"20050402\", \"querier\":\"SYSTEM}\",\"queryReason\":\"信用卡审批\"}]}}";
	}
	
	public static String zhuanxiangfenqifirst(double random){
		return "{\"serviceID\":\"speaccess\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},"
				+"\"ruleData\":{\"special\":"+(int)(random*10)+",\"homeAddress\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*2)+",\"workAddress\":"+(int)(random*2)+",\"marry\":"+(int)(random*2)+",\"forbidJob\":"+(int)(random*2)+",\"cashInstalment\":"+(int)(random*2)+",\"balance\":"+(int)(random*2)+",\"specialStage\":"+(int)(random*2)+","
				+"\"education\":"+(int)(random*10)+",\"customerFlag\":\""+getString((int)(random*3))+"\",\"fullTime\":"+(int)(random*2)+",\"publicCredit\":"+(int)(random*2)+",\"wealthCustomers\":"+(int)(random*2)+",\"wealthCustomersTime\":"+(int)(random*2)+",\"WC_3M_balance\":"+(int)(random*2000)+",\"housingMortgage\":"+(int)(random*2)+",\"hm_pay\":"+(int)(random*20)+",\"AF_capture_12M\":"+(int)(random*2)+","
				+"\"payPut\":"+(int)(random*1000)+",\"innerBlacklist\":"+(int)(random*2)+",\"workLife\":"+(int)(random*10)+",\"workTime\":"+(int)(random*10)+",\"homeIncome\":"+(int)(random*10)+",\"income\":"+(int)(random*10)+",\"limitJob\":1"+(int)(random*2)+",\"loan\":"+(int)(random*10)+",\"overdue\":"+(int)(random*1000)+",\"creditCard\":"+(int)(random*10)+",\"LOAN_MAX_12M\":"+(int)(random*11)+",\"CC_MAX_12M\":"+(int)(random*2)+",\"LOAN_SUM_12M\":"+(int)(random*10)+",\"CC_SUM_12M\":"+(int)(random*10)+",\"loanRefuse\":"+(int)(random*2)+",\"creditRefuse\":"+(int)(random*2)+"}}";
	}
	
	public static String zhuanxiangfenqisecond(double random){
		return "{\"serviceID\":\"specialScore\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},\"ruleData\":"
				+"{\"outerBlacklist\":"+(int)(random*2)+",\"queryResult\":3,\"special\":"+(int)(random*5)+",\"aveMonPay\":"+(int)(random*6000)+",\"income\":"+(int)(random*20000)+",\"ruleDecision\":\"R\",\"sex\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*3)+",\"age\":"+(int)(random*100)+",\"marry\":"+(int)(random*2)+",\"education\":"+(int)(random*6)+",\"workTime\":"+(int)(random*4)+","
				+"\"customerFlag\":\""+getString((int)(random*3))+"\",\"haohanType\":\"gold\",\"annualDailyWealth\":"+(int)(random*1000)+",\"dailyBalance\":"+(int)(random*500)+",\"expectLines\":"+(int)(random*600000)+",\"homeValue\":"+(int)(random*10000000)+","
				+"\"fullInvoice\":"+(int)(random*10000000)+",\"carYear\":"+(int)(random*20)+",\"rankType\":"+(int)(random*3)+",\"LQADWB_12M\":"+(int)(random*10)+",\"residentType\":"+(int)(random*5)+",\"unitType\":"+(int)(random*5)+"},\"creditData\":"
				+"{\"headerInfo\":{\"reportSN\":\""+getRandomString(15)+"\",\"reportCreateTime\":\"20080502\"},"
				+ "\"overdueInfoSum\":{\"debtCount\":"+getRandomString(1)+",\"dispositionCount\":"+getRandomString(1)+"},"
				+ "\"shareAndDebtpInfo\":{\"loanInfo\":{\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(5)+",\"balance\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(3)+",\"financeCorpCount\":"+getRandomString(1)+"},"
				+ "\"loancardInfo\":{\"financeOrgCount\":"+getRandomString(1)+",\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(6)+",\"usedCreditLimit\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(4)+"}},"
				+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200706\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200404,\"endMonth\":200805,\"month\":"+getRandomString(1)+",\"lastMonths\":\"200805\""
				+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200707\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+(int)(random*1)+",\"lastMonths\":200804}],"
				+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200707\",\"paymentCyc\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"usedCreditLimitAmount\":null,\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200505,\"endMonth\":200803,\"month\":"+getRandomString(1)+",\"lastMonths\":200804"
				+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200707\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200607,\"endMonth\":200907,\"month\":"+(int)(random*1)+",\"lastMonths\":200908}],"
				+ "\"guaranteeInfoList\":[{\"class5State\":\"�?��\"}, {\"class5State\":\"�?��\"}],"
				+ "\"forceExecutionInfoList\":[{\"registerDate\":\"200711\"}, {\"registerDate\":\"200511\"}],"
				+ "\"adminPunishList\":[{\"beginDate\":\"200726\"}, {\"beginDate\":\"200726\"}],"
				+ "\"creditAndLoanRecordList\":[{\"queryDate\":\"20070409\", \"querier\":\"SYSTEM}\",\"queryReason\":\"贷款审批}\"}, {"
				+ "\"queryDate\":\"20070409\", \"querier\":\"SYSTEM}\",\"queryReason\":\"信用卡审批\"}]}}";
	}
	
	public static String getCode(double random){
		String code1="{\"serviceID\":\"speaccess\",\"customerInfo\":{\"customerID\":\"02201\",\"password\":\"666666\",\"requestTime\":\"201706141434\",\"refBusSerialNo\":\"01\"},"
				+"\"ruleData\":{\"special\":"+(int)(random*10)+",\"homeAddress\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*2)+",\"registryAddress\":"+(int)(random*2)+",\"workAddress\":"+(int)(random*2)+",\"marry\":"+(int)(random*2)+",\"forbidJob\":"+(int)(random*2)+",\"cashInstalment\":"+(int)(random*2)+",\"balance\":"+(int)(random*2)+",\"specialStage\":"+(int)(random*2)+","
				+"\"education\":"+(int)(random*10)+",\"customerFlag\":\""+getString((int)(random*3))+"\",\"fullTime\":"+(int)(random*2)+",\"publicCredit\":"+(int)(random*2)+",\"wealthCustomers\":"+(int)(random*2)+",\"wealthCustomersTime\":"+(int)(random*2)+",\"WC_3M_balance\":"+(int)(random*2000)+",\"housingMortgage\":"+(int)(random*2)+",\"hm_pay\":"+(int)(random*20)+",\"AF_capture_12M\":"+(int)(random*2)+","
				+"\"payPut\":"+(int)(random*1000)+",\"innerBlacklist\":"+(int)(random*2)+",\"workLife\":"+(int)(random*10)+",\"workTime\":"+(int)(random*10)+",\"homeIncome\":"+(int)(random*10)+",\"income\":"+(int)(random*10)+",\"limitJob\":1"+(int)(random*2)+",\"loan\":"+(int)(random*10)+",\"overdue\":"+(int)(random*1000)+",\"creditCard\":"+(int)(random*10)+",\"LOAN_MAX_12M\":"+(int)(random*11)+",\"CC_MAX_12M\":"+(int)(random*2)+",\"LOAN_SUM_12M\":"+(int)(random*10)+",\"CC_SUM_12M\":"+(int)(random*10)+",\"loanRefuse\":"+(int)(random*2)+",\"creditRefuse\":"+(int)(random*2)+"},"
				+"\"creditData\":"
				+"{\"headerInfo\":{\"reportSN\":\""+getRandomString(15)+"\",\"reportCreateTime\":\"20070502\"},"
				+ "\"overdueInfoSum\":{\"debtCount\":"+getRandomString(1)+",\"dispositionCount\":"+getRandomString(1)+"},"
				+ "\"shareAndDebtpInfo\":{\"loanInfo\":{\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(5)+",\"balance\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(3)+",\"financeCorpCount\":"+getRandomString(1)+"},"
				+ "\"loancardInfo\":{\"financeOrgCount\":"+getRandomString(1)+",\"accountCount\":"+getRandomString(1)+",\"creditLimit\":"+getRandomString(6)+",\"usedCreditLimit\":"+getRandomString(4)+",\"latest6MonthUsedAvgAmount\":"+getRandomString(4)+"}},"
				+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"2005065\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+getRandomString(1)+",\"lastMonths\":\"200503\""
				+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200506\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200605\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+(int)(random*1)+",\"lastMonths\":200503}],"
				+ "\"loaninfolist\":[{\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200506\",\"paymentCyc\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"usedCreditLimitAmount\":null,\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+getRandomString(1)+",\"lastMonths\":200503"
				+ "}, {\"account\":"+getRandomString(13)+",\"state\":\"呆账\",\"creditLimitAmount\":"+getRandomString(5)+",\"openDate\":\"200505\",\"paymentCyc\":"+getRandomString(2)+",\"type\":"+getRandomString(2)+",\"actualPaymentAmount\":"+getRandomString(4)+",\"balance\":"+getRandomString(5)+",\"scheduledPaymentAmount\":"+getRandomString(4)+",\"stateEndDate\":\"200506\",\"recentPayDate\":null,\"latest24State\":\"NNNNNNNNNNNNNNNNNNNNNNNN\",\"beginMonth\":200202,\"endMonth\":200503,\"month\":"+(int)(random*1)+",\"lastMonths\":200503}],"
				+ "\"guaranteeInfoList\":[{\"class5State\":\"�?��\"}, {\"class5State\":\"�?��\"}],"
				+ "\"forceExecutionInfoList\":[{\"registerDate\":\"200503\"}, {\"registerDate\":\"200503\"}],"
				+ "\"adminPunishList\":[{\"beginDate\":\"200512\"}, {\"beginDate\":\"200512\"}],"
				+ "\"creditAndLoanRecordList\":[{\"queryDate\":\"20050407\", \"querier\":\"SYSTEM}\",\"queryReason\":\"贷款审批}\"}, {"
				+ "\"queryDate\":\"20050407\", \"querier\":\"SYSTEM}\",\"queryReason\":\"信用卡审批\"}]}}";
												
				
		return code1;
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
	public static String getString(int random){
		String[] arg={"A","B","C","D"};
		return arg[random];
	}
	public static String getRandomString2(int length) { //length表示生成字符串的长度
	    String base = "01";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();  
	    
	 } 


	
	
}
