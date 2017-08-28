package com.shm.threadClient;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
	
	public static FileWriter fileWriter;
	
	private MyFileWriter(){
		try {
			fileWriter =new FileWriter("D:\\error.txt", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private static MyFileWriter instance = new MyFileWriter();  
    
    public static MyFileWriter getInstance(){  
        return instance;  
    }  
 

}
