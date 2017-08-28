package net.scai.fitp.esb.client;

import java.util.Map;

import org.json.JSONObject;

public class JSONTest {

	public static void main(String[] args) {

		String text = "{\"name\":\"zhou\",\"age\":\"12\",\"gender\":\"man\"}";
		
		JSONObject data = new JSONObject(text);
		Map map = data.toMap();
		System.out.println(map.toString());
	}

}
