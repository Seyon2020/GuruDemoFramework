package com.gurudemo.utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gurudemo.base.BaseUI;
/**
 * ExcelHandling reads the given sheet of the testdataexcel file and
 * return the data as two-dimensional String array
 * */
public class ExcelHandling extends BaseUI{
	
public String[][] userdatafromexcel(String sheetname){
	try {
	
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+getFileName("testdataexcel"));
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet(sheetname);
	int rowcount=sheet.getPhysicalNumberOfRows();
	Row row=sheet.getRow(0);
	int colcount=row.getPhysicalNumberOfCells();
	String[][] userdata=new String[rowcount][colcount];
	DataFormatter dform=new DataFormatter();
	for(int i=0;i<rowcount;i++) {
		for(int j=0;j<colcount;j++) {
			userdata[i][j]=dform.formatCellValue(sheet.getRow(i).getCell(j));
		}
	}
	workbook.close();
	return userdata;
	}
	catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	
}

}
