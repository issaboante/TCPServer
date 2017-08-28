package com.sino.morethread.simple;

import com.alibaba.fastjson.JSONObject;
import com.shm.test.HttpPost;

public class SimpleTask {  
	  
    private int id; 
    private String code;
      
    public SimpleTask(int id,String code) {  
        this.id = id;
        this.code=code;
    }  
      
    public void start(){  
		String finalScore = null;
		long starttime=System.currentTimeMillis();
		try {
			finalScore = HttpPost.getFinalScore(code);
			System.out.println(Thread.currentThread().getName()+":"+"编号:"+id+" 输入的数据："+code+" 得分: "+finalScore);
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
