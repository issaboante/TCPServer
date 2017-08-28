package com.shm.info;

public class SignatureData {
	// 标题行
	public static String title[] = { "用户id", "过去24个月最大逾期期数(信贷)", "过去12个月总逾期次数(信贷)", "过去12个月中信贷审核查询次数", "总额度使用率(贷记卡)", "从未逾期贷记卡最大帐龄" };

	// 过去24个月最大逾期期数(信贷)
	public static int getMax_delq_24m_total(double random) {
		int[] max_delq_24m_total = { (int) (random * 11), -100 };
		return max_delq_24m_total[(int) (Math.random() * 2)];
	}

	// 过去12个月总逾期次数(信贷)
	public static int getNo_delq_12m_total(double random) {
		int[] no_delq_12m_total = { (int) (random * 11), -100 };
		return no_delq_12m_total[(int) (Math.random() * 2)];
	}

	// 过去12个月中信贷审核查询次数
	public static int getNo_query_12m_ca(double random) {
		int[] no_query_12m_ca = { (int) (random * 21), -100 };
		return no_query_12m_ca[(int) (Math.random() * 2)];
	}

	// 总额度使用率(贷记卡)
	public static int getNet_utl_rc(double random) {
		int[] net_utl_rc = { (int) (random * 101), -100 };
		return net_utl_rc[(int) (Math.random() * 2)];
	}

	// 从未逾期贷记卡最大帐龄
	public static int getMax_mob_rc_nodelq(double random) {
		int[] max_mob_rc_nodelq = { (int) (random * 101), -100 };
		return max_mob_rc_nodelq[(int) (Math.random() * 2)];
	}

	// 数据
	public static int[] getBox(double random) {
		int[] box = { 1, getMax_delq_24m_total(random), getNo_delq_12m_total(random), getNo_query_12m_ca(random),
				getNet_utl_rc(random), getNet_utl_rc(random), getMax_mob_rc_nodelq(random) };
		return box;
	}
}
