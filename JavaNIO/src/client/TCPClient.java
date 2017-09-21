package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TCPClient {
	//定义选择器
	private Selector selector;
	//定义与服务器通信的信道
	SocketChannel socketChannel;
	//服务器IP
	private String hostIp;
	//服务器服务端口
	private int hostListenningPort;
	
	public TCPClient(String hostIp, int hostListenningPort) throws IOException {
		super();
		this.hostIp = hostIp;
		this.hostListenningPort = hostListenningPort;
		//初始化
		initialize();
	}

	private void initialize() throws IOException {
		//建立通道并设置为非阻塞模式
		socketChannel = SocketChannel.open(new InetSocketAddress(hostIp, hostListenningPort));
		socketChannel.configureBlocking(false);
		//建立选择器并注册到通道
		selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_READ);
		//启动读取线程
		new TCPClientReadThread(selector);
	}
	//发送字符串到服务器
	public void sendMsg(String message) throws IOException {
		ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("UTF-16"));
		
		int r = socketChannel.write(writeBuffer);
		System.out.println("write return:" + r);
	}
	
	public static void main(String[] args) throws IOException {
		TCPClient client = new TCPClient("localhost", 1978);
		for (int i = 0; i < 10; i++) {
			client.sendMsg("NIO" + i);
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
