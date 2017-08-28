package com.shm.thread;

import java.util.Scanner;

import com.alibaba.fastjson.JSONObject;
import com.shm.test.HttpPost;

/**
 * @author 程艳明
 *
 */
public class Main {

	public static Integer data = 0;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		MyThread th1 = new MyThread();        //线程一
        th1.setName("售票口一");  
        MyThread th2 = new MyThread();        //线程一
        th2.setName("售票口一");  
        MyThread th3 = new MyThread();        //线程一
        th3.setName("售票口一"); 
        
       
//		MyThread myThread;
//		String Code = new GetData().getCode();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入要执行的线程数：");
//		// 线程数
//		int nextInt = scanner.nextInt();
//		System.out.println("请输入您要设定的资源数：");
//		// 总资源数
//		data = scanner.nextInt();
//		System.out.println(data);
		// for (int i = 0; i < nextInt; i++) {
		//
		// myThread = new MyThread();
		// myThread.setCode(Code);
		// myThread.setIndex(i + 1);
		// myThread.start();
		// }
		// try {
		// JSONObject finalScore = HttpPost.getFinalScore();
		// System.out.println(finalScore.get("result"));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}
}

class MyThread implements Runnable {
	private String code;
	private int index;
	private String name ;
	private int num = 5; 
	JSONObject finalScore;

	public MyThread() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
		
		 for(int i=0; i<10; i++){
	            if(this.num>0){        //打印买票信息
	                System.out.println(Thread.currentThread().getName() + "买票: " + this.num--);
	            }
	        }
		try {

			HttpPost post = new HttpPost();

			/*for (int i = 0; i < data; i++) {
				finalScore = post.getFinalScore(code);
				System.out.println("编号:" + index + " 输入的数据：" + code + " 得分: " + finalScore.get("result"));
				sleep(500);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}