package com.shm.threadClient;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyThread implements Runnable{
	
	private final List<Task> tasks; 
	private FileWriter fileWriter;
    
    public MyThread(List<Task> tasks,FileWriter fileWriter) {  
        this.tasks = tasks;  
        this.fileWriter = fileWriter;
    }  
    
    public void run() {  
    	
    	BufferedWriter bw;
		try {
			bw = new BufferedWriter(fileWriter);
			for (Task task : tasks) {
	    		if(task != null) {  
					String result = task.start();
					bw.append(result);
	    		}  
	    	}
			bw.close();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
    
}
