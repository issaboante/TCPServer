package com.shm.queue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import com.shm.test.GetFourDataPass;
import com.shm.test.HttpPost;

public class MyThreadClient {
	
	private static AtomicLong countRight = new AtomicLong(0);
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入要执行的线程数");
		// 线程数
		int nextInt = scanner.nextInt();
		System.out.println("请输入您要设定的资源数,请选择能除尽的数：");
		// 任务数
		int count = scanner.nextInt();
		createThread(nextInt, count);
    }  
	
	
	
	public static void createThread(int threadNum,int count){
		int countPer = count/threadNum;
		
		for(int i=0;i<threadNum;i++){
			FileWriter fileWriter = null;
			try {
				//fileWriter = new FileWriter("/usr/local/cloudplateformtestclient/thread"+i+".txt", true);
				fileWriter = new FileWriter("C:\\Users\\ming\\Desktop\\ceshi\\"+i+".txt", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			int startNum = i*countPer+1;
			Thread thread = new Thread(new MyThread(startNum, countPer,fileWriter));
			thread.start();
		}
	}
	
	
	
	

    public static class MyThread implements Runnable { 
    	private int startNum;
    	private int countPer;
    	private FileWriter fileWriter;
    	
        public MyThread(int startNum, int countPer,FileWriter fileWriter) {
			this.startNum = startNum;
			this.countPer = countPer;
			this.fileWriter = fileWriter;
		}

		public void run() { 
			try {
				BufferedWriter bw = new BufferedWriter(fileWriter);
				for(int i=startNum;i<startNum+countPer;i++){
				
					String BHJson=GetFourDataPass.zhuanxiangfenqiSecondCunChuPass(Math.random());
					//String BHJson=GetFourDataPass.biaozhunfirst(Math.random());
					//String BHJson=GetFourDataPass.testcode(Math.random());
					Task task = new Task(i, BHJson);
					String result = task.start();
					bw.append(result);
				}
				bw.close();
				fileWriter.close();				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}  
    }  
    
    public static class Task {  
  	  
        private int id; 
        private String code;
        
        
          
        public Task(int id,String code) {  
            this.id = id;
            this.code=code;
        }  
          
        public String start(){  
        	String finalScore = null;
    		
    		try {
    			long starttime=System.currentTimeMillis();
    			finalScore = HttpPost.getFinalScore(code);
    			long time = System.currentTimeMillis()-starttime;
    			System.out.println(Thread.currentThread().getName()+":"+"编号:"+id+" 输入的数据："+code);
    			System.out.println(Thread.currentThread().getName()+":"+"编号:"+id+" 输出的数据："+finalScore);
    			System.out.println(Thread.currentThread().getName()+":"+"编号:"
    			+id+"程序耗时为:"+time+"ms");
    			countRight.incrementAndGet();
    			return "线程名："+Thread.currentThread().getName()+":"+"编号:"+id+
    					"结果为"+finalScore.toString()+"\r\n"+"耗时："+time+"ms,"+"为第"+countRight+"个成功返回值"+"\r\n";
    		} catch (Exception e) {
    			e.printStackTrace();
    			return "线程名gghhjjj："+Thread.currentThread().getName()+":"+"编号:"+id+
    					"所抛异常："+e.toString()+"\r\n";
    		}
        }  
          
    }  
}