package com.testcase;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.gurudemo.base.BaseUI;
import com.gurudemo.pages.RegisterPage;
import com.gurudemo.utils.FileIO;
@Listeners(com.gurudemo.utils.RegisterPageListener.class)
public class RegisterTest extends BaseUI{
	static WebDriver driver;
	String[][] contactdata;
	String[][] mailingdata;
	String[][] userdata;
	@BeforeClass
		public static void setup(){
			driver=invokeBrowser();
			navigateToUrl("registerURL");
			scrolldown();
		}
		@AfterClass
		public void teardown() {
			System.out.println("Closing the browser");
			driver.close();
		}
		@Test(priority=1,dataProvider="contactdata",groups="passingdata")
		public void entercontactdetails(String[] contactdetails){
			RegisterPage regpage=new RegisterPage(driver,logger);
			regpage.clickRegister();
			regpage.entercontactdetails(contactdetails);
			
		}
		@DataProvider(name="contactdata")
		public Object[][] contactdata(){
			contactdata=FileIO.datahandling("Sheet4");
			return contactdata;
		}
		@Test(priority=2,dataProvider="mailingdata",groups="passingdata")
		public void entermailingdetails(String[] mailingdetails){
			RegisterPage regpage=new RegisterPage(driver,logger);
			regpage.entermailingdetails(mailingdetails);
		}
		@DataProvider(name="mailingdata")
		public Object[][] mailingdata(){
			mailingdata=FileIO.datahandling("Sheet5");
			return mailingdata;
		}
	
		@Test(priority=3,dataProvider="userdata",groups="passingdata")
		public void enteruserdetails(String[] userdetails){
			RegisterPage regpage=new RegisterPage(driver,logger);
			regpage.enteruserdetails(userdetails);
			
		}
		@DataProvider(name="userdata")
		public Object[][] userdata() {
			userdata=FileIO.datahandling("Sheet6");
			return userdata;
		}
		@DataProvider(name="registrationdata")
		public Object[][] registrationdata() {
			userdata=FileIO.datahandling("Sheet3");
			return userdata;
		}
		@Test(priority=4,dataProvider="registrationdata",groups="submittingdata")
		public void registrationtest(String[] data) {
			RegisterPage regpage=new RegisterPage(driver,logger);
			regpage.clickRegister();
			regpage.enterRegistrationdetails(data);
			regpage.clickSubmit();
			assertTrue(regpage.check_successful_registration(),"Testing by Submitting valid data in Registartion Page");
			
		}
		
		@Test(priority=5)
		public void registrationtest_Null_Data() {
			RegisterPage regpage=new RegisterPage(driver,logger);
			regpage.clickRegister();
			String[] nulldata= {null,null,null,null,null,null,null,null,null,null,null,null};
			regpage.enterRegistrationdetails(nulldata);
			regpage.clickSubmit();
			assertFalse(regpage.check_successful_registration(),"Testing whether the regitstration datas accepts null values");
		}
		
}
