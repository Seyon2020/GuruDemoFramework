package com.testcase;

import static org.testng.Assert.assertFalse;
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
import com.gurudemo.pages.SignInPage;
import com.gurudemo.utils.FileIO;

@Listeners(com.gurudemo.utils.SignInPageListener.class)
public class SignInPageTest extends BaseUI{
	WebDriver driver;
	String[][] testdata;
	@BeforeClass
	public  void setup(){
		driver=invokeBrowser();
		navigateToUrl("signinURL");
	}
	@AfterClass
	public void teardown() {
		System.out.println("Closing the browser");
		driver.close();
	}
	@Test(priority=1,dataProvider="testdata")
	public void logintest_ValidData(String user,String pass){
		SignInPage signinpage=new SignInPage(driver,logger);
		signinpage.clickSignin();
		signinpage.enterusername(user);
		signinpage.enterpassword(pass);
		signinpage.clickSubmit();
		if(signinpage.check_Login_success()) {
		signinpage.signin_screenshot();
		signinpage.clickSignoff();
		if(checkforad())
		signinpage.closeAdSignin();
		}
		else {
			signinpage.signinfail_screenshot();
			signinpage.clickSignin();
		}
		
	}

	@Test(priority=2,dataProvider="testdata",groups="nulldatatest")
	public void logintest_NullDataForUserName(String login[]){
		SignInPage signinpage=new SignInPage(driver,logger);
		
		signinpage.clickSignin();
		if(checkforad())
			signinpage.closeAdSignin();
		signinpage.enterusername(null);
		signinpage.enterpassword(login[1]);
		signinpage.clickSubmit();
		SoftAssert softassert=new SoftAssert();
		softassert.assertFalse(signinpage.check_Login_success(), "Testing_if_the_Null_value_for_Password_in_SigninPage_will_be_ACCEPETED");
		if(signinpage.check_Login_success()) {
			signinpage.clickSignoff();
			if(checkforad())
			signinpage.closeAdSignin();
		}
		softassert.assertAll();
		
		
	}
	
	@Test(priority=3,groups="nulldatatest",dataProvider="testdata")
	public void logintest_NullDataForPassword(String login[]){
		SignInPage signinpage=new SignInPage(driver,logger);
		signinpage.clickSignin();
		if(checkforad())
			signinpage.closeAdSignin();
		signinpage.enterusername(login[0]);
		signinpage.enterpassword(null);
		signinpage.clickSubmit();
		SoftAssert softassert=new SoftAssert();
		softassert.assertFalse(signinpage.check_Login_success(), "Testing_if_the_Null_value_for_Password_in_SigninPage_will_be_ACCEPETED");
		if(signinpage.check_Login_success()) {
			signinpage.clickSignoff();
			if(checkforad())
			signinpage.closeAdSignin();
		}
		softassert.assertAll();
	}
	@Test(priority=4,groups="nulldatatest")
	public void logintest_NullDataForUserNameAndPassword(){
		SignInPage signinpage=new SignInPage(driver,logger);
		signinpage.clickSignin();
		if(checkforad())
			signinpage.closeAdSignin();
		signinpage.enterusername(null);
		signinpage.enterpassword(null);
		signinpage.clickSubmit();
		assertFalse(signinpage.check_Login_success(), "Testing_if_the_Null_values_for_Username&Password_in_SigninPage_will_be_ACCEPETED");
	}
	
	@DataProvider(name="testdata")
	public Object[][] testdata(){
		testdata=FileIO.datahandling("Sheet1");
		return testdata;
	}
	
}
