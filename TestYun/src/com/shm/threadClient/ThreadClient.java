package com.shm.threadClient;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


import com.shm.test.GetFourDataPass;


public class ThreadClient {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入要执行的线程数:");
		// 线程数
		int threadNum = scanner.nextInt();
		System.out.println("请输入您要设定的资源数：");
		// 总资源数
		int TaskConut = scanner.nextInt();
        List<Task> tasks = produce(TaskConut);
        //handleTasks(tasks, nextInt);
        executeTasks(tasks,threadNum);
        //Thread thread = new Thread(new MyThread(tasks));
        //thread.start();
	}
	
	/**
	 * 将任务大致平均分配给每一个线程进行并发处理
	 * @param tasks
	 * @param ThreadNum
	 */
	private static void executeTasks(List<Task> tasks, int threadNum) {
		//每个线程应该处理的大致任务数
		int countPer = tasks.size() / threadNum;
		
		for(int i=0;i<threadNum;i++){	
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter("/usr/local/cloudplateformtestclient/thread"+i+".txt", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//将tasks按照每份的份额进行等分
			int startNum = i*countPer;
			int endNum = startNum+countPer;
			
			List<Task> taskList = tasks.subList(startNum, endNum); 
			//创建ThreadNum个线程，每个线程都有其对应的tasks，其实这里的队列是否为线程安全的已经不重要了
	        Thread thread = new Thread(new MyThread(taskList,fileWriter));
	        thread.start();
		}
	}
	
	/**
	 * 根据输入的task个数，生成List<Task>对象
	 * @param count
	 * @return
	 */
	public static List<Task> produce(int count) {  
        List<Task> tasks = new LinkedList<Task>();
        
        for(int i = 0; i < count; i ++) {  
        	String BHJson=GetFourDataPass.zhuanxiangfenqiSecondCunChuPass(Math.random());
        	//String BHJson = GetFourDataPass.zhuanxiangfenqiSecond(Math.random());
        	tasks.add(new Task(i + 1,BHJson)); 
        	// tasks.add(new Task(i + 1,GetData.getCode(Math.random())));  
        }  
        return tasks;  
    }  
	
	
}
