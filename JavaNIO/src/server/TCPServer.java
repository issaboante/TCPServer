package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TCPServer {
	//缓冲区大小
	private static final int BUFFERSIZE = 8*1024;
	//超时时间
	private static final int TIMEOUT = 3000;
	//本地监听端口
	private static final int LISTENPORT = 1978;
	
	public static void main(String[] args) throws IOException {
		//创建选择器
		Selector selector = Selector.open();
		//打开服务端监听通道
		ServerSocketChannel listenerChannel = ServerSocketChannel.open();
		//绑定端口
		listenerChannel.socket().bind(new InetSocketAddress(LISTENPORT));
		//设置为非阻塞模式
		listenerChannel.configureBlocking(false);
		//注册选择器和监听的事件类型
		listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
		//SelectionKey处理接口
		TCPProtocol protocol = new TCPProtocolImpl(BUFFERSIZE);
		//无限循环，持续监听
		while (true) {
			//选择器的select方法表示按照注册的监听事件有几个通道就绪
			int keys = selector.select(TIMEOUT);
			//没有通道就绪时的处理
			if (keys == 0) {
				System.out.println("独自等待.");
				continue;
			}
			//有通道就绪时调用该方法返回就绪通道的SelectionKey集合
			Set<SelectionKey> set = selector.selectedKeys();
			//遍历集合，进行处理
			Iterator<SelectionKey> keyIter = set.iterator();
			
			while (keyIter.hasNext()) {
				SelectionKey key = keyIter.next();
				
				try {
					if (key.isAcceptable()) {
						System.out.println("acceptable");
						//该方法在内部，会将interest由OP_ACCEPT改为OP_READ
						//如果不执行下面的语句，则会一直是accept状态（初始时设置为了accept），无法进入后面的两个if语句
						protocol.handleAccept(key);
					}
					if (key.isReadable()) {
						System.out.println("readable");
						//从通道读入数据
						protocol.handleRead(key);
					}
					if (key.isValid() && key.isWritable()) {
						//向通道写入数据
						protocol.handleWrite(key);
					}
				} catch (Exception e) {
					//出现异常就从集合中移除此通道
					keyIter.remove();
					continue;
				}
				//每处理完一个通道就要从集合中移除一个，否则下次集合中还会出现此通道
				keyIter.remove();
			}
		}
	}
}
