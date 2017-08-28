package net.scai.fitp.esb.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.json.JSONObject;

public class TestClient {

	public static void main(String[] args) {
		
		final String HOSTNAME = "localhost";
		Socket socket = null;
		PrintWriter pw = null;
		try {
			socket = new Socket(HOSTNAME, 6062);
			socket.setSoTimeout(15000);

	        String text = "{\"idNumber\":\"13062619910412083X\",\"phoneNumber\":\"0086-15926464343\",\"name\":\"张赢\"}";

	        pw = new PrintWriter(socket.getOutputStream());
	        pw.print(text);
	        pw.flush();
	        socket.shutdownOutput();
	        
	        InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in, "utf-8");
			for (int c = reader.read(); c != -1; c = reader.read()) {
				time.append((char)c);
			}
			System.out.println(time);
	        
			System.out.println(text);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e2) {
					
				}
			}
		}
	}

}
