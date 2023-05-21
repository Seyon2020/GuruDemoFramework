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
 * HomePage contains HomePage specific locators and methods for interacting with the Home page
 * */
public class HomePage extends BaseUI {
	public ExtentTest logger;
	public WebDriver driver;
	By username=getLocator("username_name");
	By password=getLocator("password_name");
	By submit=getLocator("submit_name");
	By signin=getLocator("signIn_linkText");
	By signoff=getLocator("signOff_linkText");
	By register=getLocator("register_linkText");
	By support=getLocator("support_linkText");
	By contact=getLocator("contact_linkText");
	By flights=getLocator("flights_xpath");
	By hotels=getLocator("hotels_linkText");
	By carrentals=getLocator("carRentals_linkText");
	By cruises=getLocator("cruises_linkText");
	By destinations=getLocator("destinations_linkText");
	By vacations=getLocator("vacations_linkText");
	By index=getLocator("index_xpath");
	By home=getLocator("home_xpath");
	By invaliduser=getLocator("invaliduser_xpath");
	List<By> linkslist=new ArrayList<>();

	public HomePage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}
	public void createlinkslist() {
		linkslist.add(signin);
		linkslist.add(register);
		linkslist.add(support);
		linkslist.add(contact);
		linkslist.add(home);
		linkslist.add(flights);
		linkslist.add(hotels);
		linkslist.add(carrentals);
		linkslist.add(cruises);
		linkslist.add(destinations);
		linkslist.add(vacations);
		}
	public void clickLinksList() {
		createlinkslist();
		for (By link : linkslist) {
			clickOn(link,Duration.ofSeconds(30));
			if(checkforad())closeAd("homeadURL");
			logger.log(Status.INFO, link+" is clicked");
		}
	}
	public boolean check_Login_success() {
		if(driver.getCurrentUrl().equalsIgnoreCase(getProperty("loginsuccessURL")))
			return true;
		else
			return false;
	}
public void closeAdSignin() {
	closeAd("signinadURL");
	logger.log(Status.INFO, "Home page Ad is closed ");
}
public void hpsigninfail_screenshot() {
	String dest=screenshot("hpsigninssf");
	logger.addScreenCaptureFromPath(dest).log(Status.INFO,"Screenshot of unsuccessful SIGN-IN with is sent to the report");
}
public void hpsignin_screenshot() {
	String dest=screenshot("hpsigninss");
	logger.addScreenCaptureFromPath(dest).log(Status.INFO, "Screenshot of successful SIGN-IN is sent to the report");
}
public boolean checkHome() {
	return isElementClickable(home,Duration.ofSeconds(10));
}
public boolean checkSignin() {
	return isElementClickable(signin,Duration.ofSeconds(10));
}
public boolean checkRegister() {
	return isElementClickable(register,Duration.ofSeconds(10));
}
public boolean checkSupport() {
	return isElementClickable(support,Duration.ofSeconds(10));
}
public boolean checkFlights() {
	return isElementClickable(flights,Duration.ofSeconds(10));
}
public boolean checkHotels() {
	return isElementClickable(hotels,Duration.ofSeconds(10));
}
public boolean checkCarrentals() {
	return isElementClickable(carrentals,Duration.ofSeconds(10));
}
public boolean checkCruises() {
	return isElementClickable(cruises,Duration.ofSeconds(10));
}
public boolean checkDestinations() {
	return isElementClickable(destinations,Duration.ofSeconds(10));
}
public boolean checkVacations() {
	return isElementClickable(vacations,Duration.ofSeconds(10));
}
public boolean checkContact() {
	return isElementClickable(contact,Duration.ofSeconds(10));
}
public void clickHome() {
	clickOn(home,Duration.ofSeconds(30));
	logger.log(Status.INFO, "Home Page Link is clicked");
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
public void clickSignin() {
	clickOn(signin, Duration.ofSeconds(30));
	logger.log(Status.INFO, "SIGN-ON Link is Clicked");
}
public void clickSignoff() {
	clickOn(signoff, Duration.ofSeconds(30));
	logger.log(Status.INFO, "SIGN-OFF Link is Clicked");
}
public void clickRegister() {
	clickOn(register, Duration.ofSeconds(30));
	logger.log(Status.INFO, "REGISTER Link is Clicked");
}
public void clickSupport() {
	clickOn(support, Duration.ofSeconds(30));
	logger.log(Status.INFO, "SUPPORT Link is Clicked");
}
public void clickFlights() {
	clickOn(flights, Duration.ofSeconds(30));
	logger.log(Status.INFO, "FLIGHTS Link is Clicked");
}
public void clickHotels() {
	clickOn(hotels, Duration.ofSeconds(30));
	logger.log(Status.INFO, "HOTELS Link is Clicked");
}
public void clickCarrentals() {
	clickOn(carrentals, Duration.ofSeconds(30));
	logger.log(Status.INFO, "CARRENTALS Link is Clicked");
}
public void clickCruises() {
	clickOn(cruises, Duration.ofSeconds(30));
	logger.log(Status.INFO, "CRUISES Link is Clicked");
}
public void clickDestinations() {
	clickOn(destinations, Duration.ofSeconds(30));
	logger.log(Status.INFO, "DESTINATIONS Link is Clicked");
}
public void clickVacations() {
	clickOn(vacations, Duration.ofSeconds(30));
	logger.log(Status.INFO, "VACATIONS Link is Clicked");
}
public void clickContact() {
	clickOn(contact, Duration.ofSeconds(30));
	logger.log(Status.INFO, "VACATIONS Link is Clicked");
}
}
