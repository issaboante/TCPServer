package com.shm.test;

import com.alibaba.fastjson.JSONObject;

public class MyThread extends Thread {
	private String code;
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void run() {
		try {
			HttpPost post=new HttpPost();
			//JSONObject finalScore = post.getFinalScore(code);
			String finalScore=post.getFinalScore(code);
			System.out.println("编号:"+index+" 输入的数据："+code+" 得分: "+finalScore);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
