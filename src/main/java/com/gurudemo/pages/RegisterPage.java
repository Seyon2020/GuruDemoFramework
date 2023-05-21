package com.gurudemo.pages;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.gurudemo.base.BaseUI;
/**
 * RegisterPage contains RegisterPage specific locators and methods for interacting with the Register page
 * */
public class RegisterPage extends BaseUI{
	public ExtentTest logger;
	public WebDriver driver;
	By register=getLocator("register_linkText");
	By firstname=getLocator("firstName_name");
	By lastname=getLocator("lastName_name");
	By phonename=getLocator("phone_name");
	By emailid=getLocator("email_id");
	By address=getLocator("address_name");
	By city=getLocator("city_name");
	By state=getLocator("state_name");
	By postalcode=getLocator("postalCode_name");
	By country=getLocator("country_name");
	By username=getLocator("userName_id");
	By password=getLocator("password_name");
	By confirmpassword=getLocator("confirmPassword_name");
	By registersubmit=getLocator("register_submit_name");
	By registersignin=getLocator("register_signin_linkText");
	List<By> registration_info_list=new ArrayList<>();
	{
		registration_info_list.add(firstname);
		registration_info_list.add(lastname);
		registration_info_list.add(phonename);
		registration_info_list.add(emailid);
		registration_info_list.add(address);
		registration_info_list.add(city);
		registration_info_list.add(state);
		registration_info_list.add(postalcode);
		registration_info_list.add(country);
		registration_info_list.add(username);
		registration_info_list.add(password);
		registration_info_list.add(confirmpassword);
	}
	
	public RegisterPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}
	public void clickRegister() {
		clickOn(register, Duration.ofSeconds(10));
		logger.log(Status.INFO, "REGISTER Link is Clicked");
	}
	public void reg_screenshot() {
		String dest=screenshot("regss");
		logger.addScreenCaptureFromPath(dest).log(Status.INFO, "Screenshot of successful Registration is sent to the report ");
	}
	public void regf_screenshot() {
		String dest=screenshot("regssf");
		logger.addScreenCaptureFromPath(dest).log(Status.INFO, "Screenshot of unsuccessful Registration is sent to the report ");
	}
	public boolean check_successful_registration() {
		if(driver.getCurrentUrl().equalsIgnoreCase(getProperty("registration_successURL")))
			return true;
		else 
			return false;
	}
	public void enterRegistrationdetails(String[] details) {
		scrolldown();
		for(int i=0;i<registration_info_list.size();i++) {
			if(i==8) {
				dropDownSelect(country, details[i]);
			}
			else {
			sendText(registration_info_list.get(i),details[i]);
			}
			logger.log(Status.INFO, "Registration Information text is passsed");
		}
	}
	public void entercontactdetails(String[] contactinfo) {
		for(int i=0;i<4;i++) {
			sendText(registration_info_list.get(i),contactinfo[i]);
			logger.log(Status.INFO, "Contact Information text is passsed");
		}
	}
	public void entermailingdetails(String[] mailinginfo) {
		for(int i=4,j=0;i<9;i++,j++) {
			if(i!=8) {
			sendText(registration_info_list.get(i),mailinginfo[j]);
			}
			else {
			dropDownSelect(registration_info_list.get(i), mailinginfo[j]);
			}
			logger.log(Status.INFO, "Mailing Information text is passsed");
			
		}
		
		logger.log(Status.INFO, "Mailing Information drop down is selected");
	}
	public void enteruserdetails(String[] userinfo) {
		for(int i=9,j=0;i<12;i++,j++) {
			sendText(registration_info_list.get(i),userinfo[j]);
			logger.log(Status.INFO, "User details text is passed");
		}
	}
	public void clickSubmit() {
		clickOn(registersubmit, Duration.ofSeconds(30));
		logger.log(Status.INFO, "SUBMIT Link in Register page is Clicked");
	}
	
}

