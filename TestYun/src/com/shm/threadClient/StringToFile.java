package com.shm.threadClient;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.junit.Test;

public class StringToFile {
	public static void main(String[] args) {
		WriteStringToFile("D:\\error.txt");
	}
	
	public static void WriteStringToFile(String filePath) {
	    try {
	         FileWriter fw = new FileWriter(filePath, true);
	         BufferedWriter bw = new BufferedWriter(fw);
	         bw.write("abc\r\n");// 往已有的文件上添加字符串
	         bw.append("在已有的基础上添加字符串");
	         bw.close();
	         fw.close();
	     } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	     }
	 }
}
