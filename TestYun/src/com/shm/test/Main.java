package com.shm.test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要执行的线程数：");
		int nextInt = scanner.nextInt();
		for (int i = 0; i < nextInt; i++) {
			GetData getData = new GetData(); 
			MyThread myThread = new MyThread();
			myThread.setCode(getData.getCode(Math.random()));
			myThread.setIndex(i+1);
			myThread.start();
		}
//		try {
//			JSONObject finalScore = HttpPost.getFinalScore();
//			System.out.println(finalScore.get("result"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
