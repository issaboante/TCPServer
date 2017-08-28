package com.shm.queue;

import com.shm.test.HttpPost;

public class Task {  
	  
    private int id; 
    private String code;
      
    public Task(int id,String code) {  
        this.id = id;
        this.code=code;
    }  
      
    public void start(){  
		//JSONObject finalScore = null;
    	String finalScore = null;
		long starttime=System.currentTimeMillis();
		try {
			finalScore = HttpPost.getFinalScore(code);
			System.out.println(Thread.currentThread().getName()+":"+"编号:"+id+" 输入的数据："+code);
			System.out.println(Thread.currentThread().getName()+":"+"编号:"+id+" 输出的数据："+finalScore);
			System.out.println(Thread.currentThread().getName()+":"+"编号:"+id+"程序耗时:"+(System.currentTimeMillis()-starttime)+"ms");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// System.out.println(Thread.currentThread().getName() + ": start to handle task " + id);  
  
//       try {
//		Thread.sleep(100);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}  
    }  
      
}  
