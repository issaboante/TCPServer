package com.shm.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

import org.junit.Test;

public class gggg {

	@Test
	public void testt(){
		HashMap<String, Object> factMap = new HashMap<String, Object>();
		factMap.put("user_info", "8.4");
		String format = new DecimalFormat("0.00").format(Double.parseDouble((String) factMap.get("user_info"))*0.2);
		//double parseDouble = Double.valueOf(new DecimalFormat("0.00").format(Double.parseDouble((String)$p)*0.2));
		double parseDouble = Double.valueOf(new DecimalFormat("0.0").format(Double.parseDouble((String) factMap.get("user_info"))*0.2));
		System.out.println(parseDouble);
		BigDecimal big = new BigDecimal(Double.valueOf("8.4"));
		BigDecimal multiply = new BigDecimal(Double.valueOf("8.4")).multiply(new BigDecimal(Double.valueOf("0.2"))).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		//BigDecimal setScale = multiply.setScale(2,BigDecimal.ROUND_HALF_DOWN);
		//BigDecimal setScale2 = setScale.setScale(2);
		double a=0.9;
		double b=0.8;
		System.out.println(a+(0.7*10));
		System.out.println(multiply.doubleValue());
	}
	
	@Test
	public void testRandom(){
		for (int i = 0; i < 3; i++) {
			System.out.println((int)(Math.random()*10));
		}
	}
}
