package server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPProtocolImpl implements TCPProtocol {

	private int bufferSize = 8*1024;
	
	public TCPProtocolImpl(int bufferSize) {
		super();
		this.bufferSize = bufferSize;
	}

	@Override
	public void handleAccept(SelectionKey key) throws IOException {//值传递，但传递的是引用，指向同一个内存地址，所以可以改变key的内容
		//accept方法获得与客户端通信的信道通道，之后设置监听read事件
		SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
		clientChannel.configureBlocking(false);
		//通道绑定缓冲区
		clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
	}

	@Override
	public void handleRead(SelectionKey key) throws IOException {
		//获得与客户端通信的信道
		SocketChannel clientChannel = (SocketChannel) key.channel();
		//得到SelectionKey附加的对象，此处是与通道绑定的缓冲区
		ByteBuffer buffer = (ByteBuffer) key.attachment();
		//清空缓冲区
		buffer.clear();
		//读取通道数据并返回读取的字节数
		long bytesRead = clientChannel.read(buffer);
		
		if (bytesRead == -1) {
			//没有读取到内容的情况
			clientChannel.close();
		} else {
			//将缓冲区准备为数据读取状态
			buffer.flip();
			//将字节转化为为UTF-16的字符串
			String receivedString = Charset.forName("UTF-16").newDecoder().decode(buffer).toString();
			
			System.out.println("接收到来自" + clientChannel.socket().getRemoteSocketAddress() + "的信息：" + receivedString);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			String f = format.format(new Date());
			//准备发送的文本
			String sendString = "你好，客户端.@" + f + ",已经收到你的信息：" + receivedString;
			//将字节数组包装到缓冲区中
			buffer = ByteBuffer.wrap(sendString.getBytes("UTF-16"));
			//将信息写入缓冲区
			clientChannel.write(buffer);
			
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		}
	}

	@Override
	public void handleWrite(SelectionKey key) {
		// TODO Auto-generated method stub

	}

}
