package net.scai.fitp.esb.socketpool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private String hostip;
	private int port;
	private BufferedReader in;
	private PrintWriter out;

	public Client(String hostip, int port) {
		this.hostip = hostip;
		this.port = port;
	}

	public void setUpConnection() {
		try {
			Socket client = new Socket(hostip, port);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));// 客户端输入流
			out = new PrintWriter(client.getOutputStream());// 客户端输出流
		} catch (UnknownHostException e) {
			System.out.println("找不到相应的主机！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("抛出相应的流异常信息");
			e.printStackTrace();
		}
	}

	/**
	 * 获取文件
	 * 
	 * @param fileName
	 *            ：文件名称
	 * @return String
	 */
	public String getFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		out.println(fileName);
		out.flush();
		String line = null;
		try {
			System.out.println("客户端连接成功！");
			while ((line = in.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			System.out.println("文件读入失败！");
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 断开连接
	 */
	public void tearDownConnection() {
		try {
			out.close();// 关闭输出流
			in.close();// 关闭输入流
		} catch (IOException e) {
			System.out.println("断开连接失败！");
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client("127.0.0.1", 9999);
		client.setUpConnection();
		String fileContent = client.getFile("D:\\hello.txt");
		System.out.println("文件内容为：" + "\n" + fileContent);
		client.tearDownConnection();
	}
}
