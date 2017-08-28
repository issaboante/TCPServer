package com.shm.test;

public class GetData {
	
	public static String getCode(double random){
		//String code="{\"userId\":\"220502199212031613\",\"industry\":"+(int)(random*6)+",\"age\":"+(int)(random*51)+",\"sex\":"+(int)(random*2)+",\"education\":"+((int)(random*5)+1)+"}";
		//String code="{\"userId\":\"220502199212031613\",\"industry\":1,\"age\":9,\"sex\":0,\"education\":1}";
		String code="[{\"key\":\"industry\",\"value\":"+(int)(random*6)+"},{\"key\":\"age\",\"value\":"+(int)(random*51)+"},"
				+ "{\"key\":\"sex\",\"value\":"+(int)(random*2)+"},"
				+ "{\"key\":\"education\",\"value\":"+((int)(random*5)+1)+"},{\"key\":\"user_id\",\"value\":\""+(1+(int)(random*100))+"\"}]";
		return code;
	}
}
