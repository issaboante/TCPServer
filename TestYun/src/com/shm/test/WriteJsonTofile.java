package com.shm.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteJsonTofile {
	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			String BHJson=GetFourDataPass.zhuanxiangfenqiSecondCunChuPass(Math.random());
			method1(BHJson);
		}
	}
	
	public static void method1(String json) {
		FileWriter fw = null;
		try {
			// 如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f = new File("C:/Users/ming/Desktop/dd.txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(json);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
