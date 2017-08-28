package net.scai.fitp.esb.socketpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PoolMultiServer {
	
	private int maxConnect;
	private int listenerPort;
	private ServerSocket serverSocket;
	
	public PoolMultiServer (int maxConnect, int listenerPort) {
		this.maxConnect = maxConnect;
		this.listenerPort = listenerPort;
	}
	
	public void acceptConnection () {
		try {
			serverSocket = new ServerSocket(listenerPort, maxConnect);
			while (true) {
				Socket socket = serverSocket.accept();
				handleConnection(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void handleConnection (Socket socket) {
		ConnectionPoolHandler.processRequest(socket);
	}
	
	public void setUpHandlers () {
		for (int i = 0; i < maxConnect; i++) {
			ConnectionPoolHandler connectionPoolHandler = new ConnectionPoolHandler();
			new Thread(connectionPoolHandler, "处理器" + i).start();
		}
	}
	
	public static void main (String[] args) {
		PoolMultiServer poolMultiServer = new PoolMultiServer(5,9999);
		poolMultiServer.setUpHandlers();
		poolMultiServer.acceptConnection();
	}
	
	
}
