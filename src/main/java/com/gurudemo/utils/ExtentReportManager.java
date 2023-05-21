package com.gurudemo.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gurudemo.base.*;
/**
*ExtentReportManager creates a ExtentReport and ExtentSparkReporter objects.
*Initialize and create a html report, attach it to the report and 
*return the report instance.
 * */
public class ExtentReportManager extends BaseUI{
	public static ExtentReports report;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports getReportInstance(String name) {
		String repName=name+"TestReport"+BaseUI.TimeStamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/TestOutput/"+repName);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("DemoGuru Mercury Tours Report");
		htmlReporter.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		return report;
	}
}
