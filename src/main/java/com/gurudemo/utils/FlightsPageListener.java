package com.gurudemo.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.gurudemo.base.BaseUI;
/**
 * A simple FlightsPageListener which listen to all the test cases
 * of FlightsPage Test and logs all the status to the FlightsPageReport.
 * It attaches screenshot of failed test cases to the report. 
 * */
public class FlightsPageListener extends TestListenerAdapter{
public static ExtentReports extent;
public static ExtentTest logger;
public void onStart(ITestContext testContext) {
extent=ExtentReportManager.getReportInstance("FlightsPage");	
}
public void onTestStart(ITestResult result) {
logger=extent.createTest(result.getName());
BaseUI.logger=logger;
}

public void onTestSuccess(ITestResult result) {
logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
logger.log(Status.PASS, "Testcase Passed");
}
public void onTestFailure(ITestResult result) {
logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
logger.log(Status.FAIL, "Testcase Failed");
logger.addScreenCaptureFromPath(BaseUI.screenshot(result.getName()));
}
public void onTestSkipped(ITestResult result) {
logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
logger.log(Status.SKIP, "Testcase Skipped");
}
public void onFinish(ITestContext context) {
	extent.flush();
}
}
