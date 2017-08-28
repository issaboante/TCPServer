package com.shm.info;

public class OuterData {
	public static String title[] = { "用户id", "手机数据_在网时长(月份)", "手机数据_过去3个月的手机欠停次数", 
			"手机数据_月套餐金额", "过去3个月申请人在多个平台借款机构数"};
	
	//手机数据_在网时长(月份)
	public static int getphone_online_month(double random){
		int[] index = { (int) (random * 51), -100 };
		return index[(int) (Math.random() * 2)];
	}
	
	//手机数据_过去3个月的手机欠停次数
	public static int phone_arrears_3m_ci(double random){
		int[] index = { (int) (random * 11), -100 };
		return index[(int) (Math.random() * 2)];
	}
	
	//手机数据_月套餐金额
	public static int phone_amount_m(double random){
		int[] index = { (int) (random * 401), -100 };
		return index[(int) (Math.random() * 2)];
	}
	
	//过去3个月申请人在多个平台借款机构数
	public static int plate_loan_3m_ci(double random){
		int[] index = { (int) (random * 21), -100 };
		return index[(int) (Math.random() * 2)];
	}
	
	//数据
	public static int[] getBox(double random) {
		int[] box = {1,getphone_online_month(random), phone_arrears_3m_ci(random), phone_amount_m(random),
				plate_loan_3m_ci(random)};
		return box;
	}
}
