package net.scai.fitp.esb.socketpool;

import java.io.IOException;
import java.net.Socket;

public class SocketPool {
	
	private SocketPoolStructure[] socket;
	private int poolsize;
	
	public SocketPool (int poolsize) {
		super();
		this.poolsize = poolsize;
	}
	
	public void createSocketPool () {
		String ip = "192.168.1.240";
		int port = 6063;
		socket = new SocketPoolStructure[poolsize];
		for (int i = 0; i < poolsize; i++) {
			socket[i] = new SocketPoolStructure();
			socket[i].index = i;
			socket[i].isFree = true;
			try {
				socket[i].socket = new Socket(ip, port);
			} catch (IOException e) {
				System.err.println(e);
				e.printStackTrace();
			}
		}
	}
	
	public synchronized SocketPoolStructure getFreeSocket() {
		for (int i = 0; i < poolsize; i++) {
			if (socket[i].isFree) {
				socket[i].isFree = false;
				return socket[i];
			}
		}
		return null;
	}
}
