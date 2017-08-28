package net.scai.fitp.esb.server;

import java.net.Socket;
import java.util.concurrent.Callable;

public class DataTask implements Callable<Void> {

	private Socket connection;
	
	public DataTask(Socket connection) {
		this.setConnection(connection);
	}
	
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Socket getConnection() {
		return connection;
	}

	public void setConnection(Socket connection) {
		this.connection = connection;
	}

}
