package com.shm.queue;

import java.util.LinkedList;  
import java.util.List;
import java.util.Observable;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;  
  
public class UseQueue {  
  
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入要执行的线程数：");
		// 线程数
		int nextInt = scanner.nextInt();
		System.out.println("请输入您要设定的资源数：");
		// 总资源数
		int conut = scanner.nextInt();
        List<Task> tasks = TaskProducer.produce(conut);  
        handleTasks(tasks, nextInt);  
        System.out.println("结束");  
    }  
      
    public static void handleTasks(List<Task> tasks, int threadCount) {  
        Queue<Task> taskQueue = new ConcurrentLinkedQueue<Task>();  
        taskQueue.addAll(tasks);  
          
        List<Thread> threadHolder = new LinkedList<Thread>();  
        for(int i = 0; i < threadCount; i ++) {  
            Thread thread = new Thread(new TaskHandler(taskQueue));  
            threadHolder.add(thread);  
            thread.start();  
        }  
          
        waitToFinish(threadHolder);  
    }  
      
    public static void waitToFinish(List<Thread> threadHolder) {  
        while(true) {  
            boolean allFinished = true;  
            for(Thread thread : threadHolder) {  
                allFinished = allFinished && !thread.isAlive();  
            }  
              
            if(allFinished) {  
                break;  
            }  
        }  
    }  
      
    public static class TaskHandler implements Runnable {  
          
        private final Queue<Task> tasks;  
          
        public TaskHandler(Queue<Task> tasks) {  
            this.tasks = tasks;  
        }  
          
        public void run() {  
            while(!tasks.isEmpty()) {  
                Task task = tasks.poll();  
                if(task != null) {  
						task.start();
                }  
            }  
        }  
          
    }  
      
}  