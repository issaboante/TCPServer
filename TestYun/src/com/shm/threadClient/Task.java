package com.shm.threadClient;

import com.shm.test.HttpPost;

public class Task {  
	
    private int id; 
    private String code;
      
    public Task(int id,String code) {  
        this.id = id;
        this.code=code;
    }  
      
    public String start(){  
		long startTime=System.currentTimeMillis();
		
		try {
			String finalScore = HttpPost.getFinalScore(code);
			System.out.println(Thread.currentThread().getName()+":"+"任务编号"+id
					+" 输入的数据："+code+" 得分: ");
			
			//防止返回结果为空，来进行做一次判断
			if(finalScore != null){
				System.out.println("返回结果为："+Thread.currentThread().getName()+":"+"编号:"+id+finalScore.toString());
			}else{
				System.out.println("返回结果为空");
			}
			
			System.out.println(Thread.currentThread().getName()+":"+"编号:"+id
					+"程序耗时:"+(System.currentTimeMillis()-startTime)+"ms");
			
			return "线程名："+Thread.currentThread().getName()+":"+"编号:"+id+
					"结果为"+finalScore.toString()+"\r\n";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "线程名："+Thread.currentThread().getName()+":"+"编号:"+id+
					"所抛异常："+e.toString()+"\r\n";
		}
    }  
      
}  
