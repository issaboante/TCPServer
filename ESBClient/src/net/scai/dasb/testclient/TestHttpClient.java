package net.scai.dasb.testclient;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestHttpClient {

	public static int THREAD_COUNT;
	public static int LOOPNUMBER;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("请输入线程数：");
		THREAD_COUNT = in.nextInt();
		System.out.println("请输入循环数");
		LOOPNUMBER = in.nextInt();
		in.close();
		
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		
		for (int i = 0; i < 1000; i++) {
			Runnable task = new HttpConnectionRunnable();
			pool.submit(task);
		}
	}

}
