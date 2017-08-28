package net.scai.fitp.esb.socketpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPoolHandler implements Runnable {

	private Socket socket;
	private static List<Socket> pool = new LinkedList<Socket>();
	
	//连接后的操作
	public void handleConnection () {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = in.readLine();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(line));
			String value = null;
			while ((value = bufferedReader.readLine()) != null) {
				out.println(value);
			}
			bufferedReader.close();
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//将Socket连接放入池中并唤醒wait()方法
	public static void processRequest (Socket socket) {
		synchronized (pool) {
			pool.add(pool.size(), socket);
			pool.notifyAll();
		}
	}
	
	//从池中取出Socket并进行连接
	@Override
	public void run() {
		while (true) {
			synchronized (pool) {
				while (pool.isEmpty()) {
					try {
						pool.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				socket = pool.remove(0);
			}
			handleConnection();
		}
	}

}
