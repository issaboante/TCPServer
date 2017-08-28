package com.shm.queue;

import java.util.LinkedList;  
import java.util.List;

import com.shm.test.CreditData;
import com.shm.test.GetData;
import com.shm.test.GetFourData;
import com.shm.test.GetFourDataPass;  
  
public class TaskProducer {  
  
    public static List<Task> produce(int count) {  
        List<Task> tasks = new LinkedList<Task>();  
        //String BHJson="{\"serviceID\":\"170601\",\"customerInfo\":{\"customerID\":\"101010111\",\"password\":\"abcd\",\"requestTime\":\"201706121623\",\"refBusSerialNo\":\"01\"},\"ruleData\":{\"mainObject\":2,\"age\":10,\"nation\":1,\"customerFlag\":11},"+CreditData.creditjson+"}"; 
       // String BHJson=GetFourData.zhuanxiangfenqisecondwithyanshengshuju(Math.random());
        for(int i = 0; i < count; i ++) {  
        	//String BHJson=GetFourDataPass.zhuanxiangfenqiSecondCunChuSuiji(Math.random());
        	String BHJson=GetFourDataPass.zhuanxiangfenqiSecondCunChuPass2(Math.random());
        	//String BHJson=GetFourDataPass.zhuanxiangfenqiSecond(Math.random());
           // tasks.add(new Task(i + 1,GetData.getCode(Math.random())));  
            tasks.add(new Task(i + 1,BHJson)); 
        }  
          
        return tasks;  
    }  
      
}  
