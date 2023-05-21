package com.testcase;
import com.gurudemo.pages.*;
import com.gurudemo.utils.FileIO;

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
import org.testng.asserts.SoftAssert;

import com.gurudemo.base.BaseUI;
@Listeners(com.gurudemo.utils.HomePageListenerUtils.class)
public class HomepageTest extends BaseUI{

	static WebDriver driver;
	String[][] testdata;
	@BeforeClass
	public static void setup(){
		driver=invokeBrowser();
		navigateToUrl("websiteURL");
	}
	@AfterClass
	public void teardown() {
		System.out.println("Closing the browser");
		driver.close();
	}
	@Test(priority=3,dataProvider="testdata")
	public void logintest(String user,String pass){
		HomePage homepage=new HomePage(driver,logger);
		homepage.clickHome();
		if(checkforad())
			homepage.closeAdSignin();
		homepage.enterusername(user);
		homepage.enterpassword(pass);
		homepage.clickSubmit();
		if(homepage.check_Login_success()) {
			homepage.hpsignin_screenshot();
			homepage.clickSignoff();
			if(checkforad())
			homepage.closeAdSignin();
			}
			else {
				homepage.hpsigninfail_screenshot();
				homepage.clickHome();
			}}
	@DataProvider(name="testdata")
	public Object[][] testdata() {
		testdata=FileIO.datahandling("Sheet1");
		return testdata;
	}
	@DataProvider(name="testdata1")
	public Object[][] testdata1() {
		testdata=FileIO.datahandling("Sheet8");
		return testdata;
	}
	@Test(priority = 2)
	public void clicklinkstest() {
		HomePage homepage=new HomePage(driver,logger);
		homepage.clickLinksList();
		
	}
	@Test(priority = 1)
	public void linkisClickable() {
		HomePage homepage=new HomePage(driver,logger);
		assertTrue(homepage.checkHome(),"Home Page Link to be Clickable");
		assertTrue(homepage.checkRegister(),"Register Page Linkt to be Clickable");
		assertTrue(homepage.checkSignin(),"SignOn Page Link to be Clickable");
		assertTrue(homepage.checkSupport(),"Support Page Link to be Clickable");
		assertTrue(homepage.checkContact(),"Contact Page Link to be Clickable");
		assertTrue(homepage.checkFlights(),	"Flights Page Link to be Clickable");
		assertTrue(homepage.checkDestinations(),"Destinations Page Link to be Clickable");
		assertTrue(homepage.checkCarrentals(),"CarRentals Page Link to be Clickable");
		assertTrue(homepage.checkCruises(),"Cruises Page Link to be Clickable");
		assertTrue(homepage.checkVacations(),"Vacations Page Link to be Clickable");
	}
	@Test(priority=4,dataProvider="testdata")
	public void logintest_NullDataForUserName(String login[]){
		HomePage homepage=new HomePage(driver,logger);
		homepage.enterusername(null);
		homepage.enterpassword(login[1]);
		homepage.clickSubmit();
		SoftAssert softassert=new SoftAssert();
		softassert.assertFalse(homepage.check_Login_success(), "Testing_if_the_Null_value_for_Password_in_HomePage_will_be_ACCEPETED");
		if(homepage.check_Login_success()) {
			homepage.clickSignoff();
			if(checkforad())
			homepage.closeAdSignin();
		}
		softassert.assertAll();
	}
	
	@Test(priority=5,dataProvider="testdata")
	public void logintest_NullDataForPassword(String login[]){
		HomePage homepage=new HomePage(driver,logger);
		homepage.enterusername(login[0]);
		homepage.enterpassword(null);
		homepage.clickSubmit();
		SoftAssert softassert=new SoftAssert();
		softassert.assertFalse(homepage.check_Login_success(), "Testing_if_the_Null_value_for_Password_in_HomePage_will_be_ACCEPETED");
		if(homepage.check_Login_success()) {
			homepage.clickSignoff();
			if(checkforad())
			homepage.closeAdSignin();
		}
		softassert.assertAll();

		
	}
	@Test(priority=6)
	public void logintest_NullDataForUserName_and_Password(){
		HomePage homepage=new HomePage(driver,logger);
		homepage.enterusername(null);
		homepage.enterpassword(null);
		homepage.clickSubmit();
		assertFalse(homepage.check_Login_success(),"Testing whether username and password in Home Page accepts null values");
	}
	
	
}
