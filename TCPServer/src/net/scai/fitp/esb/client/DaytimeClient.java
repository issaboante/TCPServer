package net.scai.fitp.esb.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {
	
	public static void main(String[] args) {
		
		String hostname = "localhost";
		Socket socket = null;
		try {
			socket = new Socket(hostname, 6061);
			socket.setSoTimeout(15000);
			InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in, "utf-8");
			for (int c = reader.read(); c != -1; c = reader.read()) {
				time.append((char)c);
			}
			System.out.println(time);
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
