package com.gurudemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.gurudemo.base.BaseUI;
/**
 * SignInPage contains SignInPage specific locators and methods for interacting with the SignIn page
 * */
public class SignInPage extends BaseUI{
	public ExtentTest logger;
	public WebDriver driver;
	By username=getLocator("username_name");
	By password=getLocator("password_name");
	By submit=getLocator("submit_name");
	By signin=getLocator("signIn_linkText");
	By signoff=getLocator("signOff_linkText");
	By invaliduser=getLocator("invaliduser_xpath");
	By adframe=getLocator("adframe_xpath");
	public SignInPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}
	public boolean check_Login_success() {
		if(driver.getCurrentUrl().equalsIgnoreCase(getProperty("loginsuccessURL")))
			return true;
		else
			return false;
	}
	public void clickSignin() {
		clickOn(signin, Duration.ofSeconds(30));
		scrolldown();
		logger.log(Status.INFO, "SIGN-ON Link is Clicked");
	}
	public void enterusername(String user) {
		sendText(username, user);
		logger.log(Status.INFO, user+" is entered to Username Element");
	}
	public void enterpassword(String pass) {
		sendText(password, pass);
		logger.log(Status.INFO, pass+" is entered to Password Element");
	}
	public void clickSubmit() {
		clickOn(submit, Duration.ofSeconds(30));
		logger.log(Status.INFO, "SUBMIT Link is Clicked");
	}
	public void clickSignoff() {
		clickOn(signoff, Duration.ofSeconds(30));
		logger.log(Status.INFO, "SIGN-OFF Link is Clicked");
	}
	public void signin_screenshot() {
		String dest=screenshot("signinss");
		logger.addScreenCaptureFromPath(dest).log(Status.INFO,"Screenshot of successful SIGN-IN with is sent to the report");
	}
	public void signinfail_screenshot() {
		String dest=screenshot("signinssf");
		logger.addScreenCaptureFromPath(dest).log(Status.INFO,"Screenshot of unsuccessful SIGN-IN with is sent to the report");
	}
	public void closeAdSignin() {
		closeAd("signinadURL");
		logger.log(Status.INFO, "Sign in page Ad is closed ");
	}
}
