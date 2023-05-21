package com.gurudemo.base;
import com.gurudemo.utils.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.gurudemo.utils.FileIO;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * BaseUI contains Basic User Interactions methods, browser selection method and navigate to URL method 
 * which are all common for all the Webpages. 
 * */
public class BaseUI{
public static WebDriver driver;
public static Properties prop;
public static String browser_choice;
public static String TimeStamp=DateUtils.getTimeStamp();
public static String Date=DateUtils.getDate();
public static ExtentReports report;
public static ExtentTest logger;
public static WebElement drop;
public static int[] options;
public static List<String> adlocators=new ArrayList<>();
{
	adlocators.add("dismiss1_xpath");
	adlocators.add("dismiss2_xpath");
	adlocators.add("dismiss3_xpath");
	adlocators.add("dismiss4_xpath");
	adlocators.add("dismiss5_xpath");
	adlocators.add("dismiss6_xpath");
	adlocators.add("aria_xpath");
	adlocators.add("close1_xpath");
	adlocators.add("close2_xpath");
	adlocators.add("close3_xpath");
	adlocators.add("close4_xpath");
	adlocators.add("close5_xpath");
	adlocators.add("close6_xpath");
}
public BaseUI() {
	prop=FileIO.initProperties();
}

/*****Invoke Browser****/

public static WebDriver invokeBrowser() {
	browser_choice=prop.getProperty("browserName");
	System.out.println(browser_choice);
	try {
		if(browser_choice.equalsIgnoreCase("chrome")) {
			driver=BrowserSetup.getChromeDriver();
		}else if(browser_choice.equalsIgnoreCase("firefox")) {
			driver=BrowserSetup.getFireFoxDriver();}
		else if(browser_choice.equalsIgnoreCase("edge")) {
			driver=BrowserSetup.getEdgeDriver();}
		else {
			throw new Exception("Invalid broswer name provided in property file");
		}
		}
		catch(Exception e) {
		System.out.println(e.getMessage());	
		}
	return driver;
	}
/*****Navigate To Website URL****/
public static void navigateToUrl(String websiteURL) {
	try {
	driver.get(prop.getProperty(websiteURL));
	}catch(Exception e) {
		e.printStackTrace();
	}
}
/*****Is Element Present****/
public static boolean isElementPresent(By locator,Duration timeout) {
	try {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	catch(Exception e) {
		return false;
	}
}
/*****Is Element Enabled****/
public static boolean isElementEnabled(By locator,Duration timeout) {
	try {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		return driver.findElement(locator).isEnabled();
	}
	catch(Exception e) {
		return false;
	}
}
/*****Is Element Clickable****/
public static boolean isElementClickable(By locator,Duration timeout) {
	try {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(locator));
		return true;
	}
	catch(Exception e) {
		return false;
	}
}
/*****get property from congig file******/
public static String getProperty(String propertyName) {
	return prop.getProperty(propertyName);
}
/*****Take Screenshot and return destination of the image*****/
public static String screenshot(String name)  {
	TakesScreenshot tsrc=(TakesScreenshot)driver;
	return FileIO.getscreenshot(prop.getProperty(name), tsrc);
}
/*****Scroll Down to the bottom of the page*****/
public static void scrolldown() {
	Robot robot;
	try {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	} catch (AWTException e) {
		e.printStackTrace();
	}
	
}
/*****Select a particular option from drop down list*****/
public static void dropDownSelect(By locator,String visibleText) {
try {
		
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
		drop=driver.findElement(locator);
		drop.click();
		Select drpDown= new Select(drop);
		drpDown.selectByVisibleText(visibleText);
	}
catch(Exception e) {
	e.printStackTrace();
}
}
/****Click the particular radio button option*****/
public static void radioClick(By locator,int option) {
try {
		
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
		(driver.findElements(locator)).get(option).click();
	}
catch(Exception e) {
	e.printStackTrace();
}
}
/*****Send Text****/
public static void sendText(By locator,String text) {
	try {
		
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
/*****Click on****/
public static void clickOn(By locator,Duration timeout) {
	try {
		
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
		}catch(Exception e) {
		e.printStackTrace();
	}
}
/****Automatically click on all radio options one by one*****/
public static void clickOn_radio_All_options(By locator) {
try {
	
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
		int options_size=driver.findElements(locator).size();
		for(int option=0;option<options_size;option++) {
		(driver.findElements(locator)).get(option).click();
		}
	}
catch(Exception e) {
	e.printStackTrace();
}
}
/****Automatically click on all options of drop down list one by one*****/
public static void automate_dropDownList(By clicklocator,By locator) {
	try {
	new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
	
	List<WebElement> droplist=driver.findElements(locator);
	for (WebElement element: droplist) {
		drop=driver.findElement(clicklocator);
		drop.click();
		Select drpDown= new Select(drop);
		drpDown.selectByVisibleText(element.getText());
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
}

/****Get Filename from Configuration file****/
public static String getFileName(String excel) {
	return prop.getProperty(excel);
}
/*****Check whether advertisement page is opened******/
public static boolean checkforad() {
	boolean result=false;
	try {
		if(driver.getCurrentUrl().contains("#google_vignette"))
			result=true;
		else result=false;
		return result;
	} catch (Exception e) {
		e.printStackTrace();
		return result;
	}
}
/****Close the advertisement****/
public static void closeAd(String surl) {
	try {
		String url=prop.getProperty(surl);
		String substr=prop.getProperty("adurlsubstring");
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(substr));
		driver.navigate().to(url);
		clickOn(getLocator("dismiss1_xpath"),Duration.ofSeconds(10));
		driver.navigate().to(substring(url));
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
/*****Get Locator Method****/
public static By getLocator(String locatorKey) {
	
	if(locatorKey.endsWith("_id")) {
		//System.out.println("id"+prop.getProperty(locatorKey));
		return By.id(prop.getProperty(locatorKey));
		
	}
	if(locatorKey.endsWith("_name")) {
		//System.out.println("name "+prop.getProperty(locatorKey));
		return By.name(prop.getProperty(locatorKey));
	}
	if(locatorKey.endsWith("_className")) {
		return By.className(prop.getProperty(locatorKey));
	}
	if(locatorKey.endsWith("_xpath")) {
		//System.out.println("xpath "+prop.getProperty(locatorKey));
		return By.xpath(prop.getProperty(locatorKey));
	}
	if(locatorKey.endsWith("_css")) {
		return By.cssSelector(prop.getProperty(locatorKey));
	}
	if(locatorKey.endsWith("_linkText")) {
		return By.linkText(prop.getProperty(locatorKey));
	}
	if(locatorKey.endsWith("_partialLinkText")) {
		return By.partialLinkText(prop.getProperty(locatorKey));
	}
	if(locatorKey.endsWith("_tagName")) {
		return By.tagName(prop.getProperty(locatorKey));
	}
	return null;
}
public static String substring(String mainstring) {
	String substring=prop.getProperty("adurlsubstring");
	int index=mainstring.indexOf(substring);
	String newstring=mainstring.substring(0, index);
	return newstring;
}
}