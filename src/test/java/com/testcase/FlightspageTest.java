package com.testcase;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.gurudemo.base.BaseUI;
import com.gurudemo.pages.FlightsPage;
import com.gurudemo.utils.FileIO;
@Listeners(com.gurudemo.utils.FlightsPageListener.class)
public class FlightspageTest extends BaseUI {
	static WebDriver driver;
	String[][] flightsdata;
	@BeforeClass
	public static void setup(){
		driver=invokeBrowser();
		navigateToUrl("flightsURL");
		scrolldown();
	}
	@AfterClass
	public void teardown() {
		System.out.println("Closing the browser");
		driver.close();
	}
	
	@Test(priority=1, groups="elementcheck")
	public void clicktype() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.flightsPage();
		flightpage.clickTypeRadio();
	}
	@Test(priority=2,groups="elementcheck")
	public void selectpassengercount() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.selectAllPassengersCount();
	}
	@Test(priority=3,groups="elementcheck")
	public void selectdepartingfrom() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.selectAllDepartingFrom();
	}
	@Test(priority=4,groups="elementcheck")
	public void selectonMonth() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.selectAllOnMonth();
	}
	@Test(priority=5,groups="elementcheck")
	public void selectonDay() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.selectAllOnDay();
	}
	@Test(priority=6,groups="elementcheck")
	public void arrivingIn() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.selectAllArrivingIn();
	}
	@Test(priority=7,groups="elementcheck")
	public void selecttoMonth() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.selectAllToMonth();
	}
	@Test(priority=8,groups="elementcheck")
	public void selecttoDay() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.selectAllToDay();
	}
	@Test(priority=9,groups="elementcheck")
	public void selectairline() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.selectAllAirline();
	}
	@Test(priority=10,groups="elementcheck")
	public void clickClass() {
		FlightsPage flightpage=new FlightsPage(driver,logger);
		flightpage.clickClassRadio();
	}
	@DataProvider(name="flightsdata")
	public Object[][] flightsdata() {
		flightsdata=FileIO.datahandling("Sheet7");
		return flightsdata;
	}
	@Test(priority=11,dataProvider="flightsdata")
	public void flightdetailstest(String[] data) {
		FlightsPage flightpage=new FlightsPage(driver, logger);
		flightpage.flightsPage();
		if(checkforad())
		flightpage.closeAdSignin();
		flightpage.enteruserinput(data);
		flightpage.clickContinueButton();
		assertTrue(flightpage.check_successful_flightdetails(),"Testing by selecting valid data in flights details page");
		flightpage.flight_screenshot();
		
	}
	}

