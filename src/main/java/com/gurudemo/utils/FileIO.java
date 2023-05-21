package com.gurudemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.gurudemo.base.BaseUI;

public class FileIO extends BaseUI{
public static String Screenshot_file_destination;
public static Properties prop;
public static Properties properties;
/************Get properties File*************/
public static Properties initProperties() {
	if(prop==null) {
	prop=new Properties();
	try {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\objectrepository\\config.properties");
		prop.load(file);
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
	}
	return prop;
}
/*****Takes Screenshot and returns the destination of the image*****/
public static String getscreenshot(String name,TakesScreenshot tsrc) {
	try {
		String repname=name+BaseUI.Date+".jpg";
		File source = tsrc.getScreenshotAs(OutputType.FILE);
		Screenshot_file_destination= System.getProperty("user.dir") + "/Screenshots/"+repname;
		File finalDestination = new File(Screenshot_file_destination);
		FileUtils.copyFile(source, finalDestination);
		return Screenshot_file_destination;
	 
	}
		catch(Exception e) {
			e.printStackTrace();
			return null;
			
		}
}
/******Writes the data on config file*******/
public static void writeProperties(StringBuilder key,StringBuilder value,StringBuilder comments) {
	if(properties==null) {
try {
	properties=new Properties();
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\objectrepository\\config1.properties");
	properties.load(file);
	FileOutputStream fileos=new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\objectrepository\\config1.properties");
	properties.setProperty(key.toString(), value.toString());
	properties.store(fileos,comments.toString());
	}catch(Exception e) {
		e.printStackTrace();
	
}}
}
/*****Gets data from excel******/
public static String[][] datahandling(String sheetname){
	try {
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+getFileName("testdataexcel"));
	XSSFWorkbook workbook =new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet(sheetname);
	int rowcount=sheet.getPhysicalNumberOfRows();
	Row row=sheet.getRow(0);
	int colcount=row.getPhysicalNumberOfCells();
	String testdata[][]=new String [rowcount][colcount];
	DataFormatter formatter=new DataFormatter();
	for (int i = 0; i < rowcount; i++) {
		for(int j=0;j<colcount;j++) {
			testdata[i][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
		}
	}
	workbook.close();
	return testdata;
	}
	catch(Exception e) {
		e.printStackTrace();
		return null;
	}
}
}
