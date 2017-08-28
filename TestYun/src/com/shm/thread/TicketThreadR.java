package com.shm.thread;

import java.util.Scanner;

import com.alibaba.fastjson.JSONObject;
import com.shm.test.GetData;
import com.shm.test.HttpPost;

public class TicketThreadR implements Runnable {

	public static Integer conut = 10;

	private String code;
	private int index;
	private String name;
	//JSONObject finalScore;
	String finalScore;
	HttpPost post = new HttpPost();
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Thread th;
		TicketThreadR ticketThread = new TicketThreadR();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要执行的线程数：");
		// 线程数
		int nextInt = scanner.nextInt();
		System.out.println("请输入您要设定的资源数：");
		// 总资源数
		conut = scanner.nextInt();
		System.out.println(conut);
		for (int i = 0; i < nextInt; i++) {
			ticketThread.setCode(GetData.getCode(Math.random()));
			ticketThread.setIndex(i + 1);
			th = new Thread(ticketThread);
			th.setName("线程-" + i);
			th.start();
		}

	}


	@Override
	public void run() {
		for (int i = 0; i < conut; i++) {

			// 使用同步代码块
			synchronized (this) {
				try {
					if (conut > 0) { // 打印买票信息
						conut--;
						finalScore = post.getFinalScore(code);
 						System.out.println("编号:" + Thread.currentThread().getName() + " 输入的数据：" + code + " 得分: "
								+ finalScore);
						//Thread.sleep(30); // 休息30毫秒
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}


}