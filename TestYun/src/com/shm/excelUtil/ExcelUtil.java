package com.shm.excelUtil;

import java.awt.Label;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.shm.info.OuterData;
import com.shm.info.SignatureData;

import jxl.Workbook;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 创建excel
 * 
 * @author ming
 *
 */
public class ExcelUtil {
	
	static String[] sheets={"征信数据","外部数据"};
	static String[] className={"SignatureData","OuterData"};
	
	public static void main(String[] args) {
		try {
			// signature.xls为要新建的文件名
			WritableWorkbook book = Workbook.createWorkbook(new File("E:/评分数据准备.xls"));
			WritableFont writableFont = new WritableFont(WritableFont.createFont("宋体"), 11, WritableFont.NO_BOLD,
					false);
			WritableCellFormat writableCellFormat = new WritableCellFormat(writableFont);
			writableCellFormat.setWrap(true);
			// 生成名为的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("征信数据", 0);
			WritableSheet sheet1 = book.createSheet("外部数据", 1);
			// 写入标题
			for (int i = 0; i < SignatureData.title.length; i++) {
				sheet.addCell(new jxl.write.Label(i, 0, SignatureData.title[i], writableCellFormat));
				// 写入数据
				for (int j = 1; j <= 100; j++) {
					if (i == 0) {
						sheet.addCell(new jxl.write.Label(0, j, String.valueOf(j), writableCellFormat));
					} else {
						sheet.addCell(new jxl.write.Label(i, j, String.valueOf(SignatureData.getBox(Math.random())[i]),
								writableCellFormat));
					}
				}
			}
			
			for (int i = 0; i < OuterData.title.length; i++) {
				sheet1.addCell(new jxl.write.Label(i, 0, OuterData.title[i], writableCellFormat));
				// 写入数据
				for (int j = 1; j <= 100; j++) {
					if (i == 0) {
						sheet1.addCell(new jxl.write.Label(0, j, String.valueOf(j), writableCellFormat));
					} else {
						sheet1.addCell(new jxl.write.Label(i, j, String.valueOf(OuterData.getBox(Math.random())[i]),
								writableCellFormat));
					}
				}
			}

			// 写入数据
			book.write();
			// 关闭文件
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
