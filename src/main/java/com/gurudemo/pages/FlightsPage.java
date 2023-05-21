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
 * FlightsPage contains FlightsPage specific locators and methods for interacting with the Flights page
 * */
public class FlightsPage extends BaseUI{
	public ExtentTest logger;
	public WebDriver driver;
	By flightspage=getLocator("flights_xpath");
	By type=getLocator("type_xpath");
	By roundtrip=getLocator("roundtrip_xpath");
	By oneway=getLocator("oneway_xpath");
	By passengers=getLocator("passengers_xpath");
	By passoption=getLocator("passengersoptions_xpath");
	By departingfrom=getLocator("departingfrom_name");
	By departoption=getLocator("departingoptions_xpath");
	By onmonth=getLocator("onmonth_name");
	By onmonthoption=getLocator("onmonthoptions_xpath");
	By ondayoption=getLocator("ondayoptions_xpath");
	By onday=getLocator("onday_name");
	By arrivinginoption=getLocator("arrivinginoptions_xpath");
	By arrivingin=getLocator("arrivingin_name");
	By tomonthoption=getLocator("tomonthoptions_xpath");
	By tomonth=getLocator("tomonth_name");
	By todayoption=getLocator("todayoptions_xpath");
	By today=getLocator("today_name");
	By servclass=getLocator("class_name");
	By economy=getLocator("economy_xpath");
	By business=getLocator("business_xpath");
	By first=getLocator("first_xpath");
	By airlineoption=getLocator("airlineoption_xpath");
	By airline=getLocator("airline_name");
	By continuebutton=getLocator("continue_xpath");
	List<By> flightsdetails=new ArrayList<>();
	{
		flightsdetails.add(type);
		flightsdetails.add(passengers);
		flightsdetails.add(departingfrom);
		flightsdetails.add(onmonth);
		flightsdetails.add(onday);
		flightsdetails.add(arrivingin);
		flightsdetails.add(tomonth);
		flightsdetails.add(today);
		flightsdetails.add(servclass);
		flightsdetails.add(airline);
	}
	public FlightsPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}
	public void flightsPage() {
		driver.findElement(flightspage).click();
		logger.log(Status.INFO,"Flights Page is clicked");
	}
	public boolean check_successful_flightdetails() {
		if(driver.getCurrentUrl().equalsIgnoreCase(getProperty("flightsnextURL")))
			return true;
		else 
			return false;
	}
	public void enteruserinput(String[] details) {
		for(int i=0;i<flightsdetails.size();i++) {
			if(i==0||i==8) {
				radioClick(flightsdetails.get(i),Integer.parseInt(details[i]));
			}
			else
			dropDownSelect(flightsdetails.get(i), details[i]);
		}
		logger.log(Status.INFO,"Input data is passed to the Flights Page");
	}
	public void clickTypeRadio() {
		scrolldown();
		clickOn_radio_All_options(type);
		logger.log(Status.INFO,"All Type Radio options are clicked");
	}
	public void selectAllPassengersCount(){
		automate_dropDownList(passengers,passoption);
		logger.log(Status.INFO, "All Passengers Count options are selected");
	}
		public void selectAllDepartingFrom(){
		automate_dropDownList(departingfrom,departoption);	
		logger.log(Status.INFO, "All Departing From options are selected");
	}
	public void selectAllOnMonth(){
		automate_dropDownList(onmonth,onmonthoption);
		logger.log(Status.INFO, "All OnMonth options are selected");
	}
	public void selectAllOnDay(){
		automate_dropDownList(onday,ondayoption);	
		logger.log(Status.INFO, "All OnDay options are selected");
	}
	public void selectAllArrivingIn(){
		automate_dropDownList(arrivingin,arrivinginoption);	
		logger.log(Status.INFO, "All Arriving options are selected");
	}
	public void selectAllToMonth(){
		automate_dropDownList(tomonth,tomonthoption);
		logger.log(Status.INFO, "All Returning To Month options are selected");
	}
	public void selectAllToDay(){
		automate_dropDownList(today,todayoption);	
		logger.log(Status.INFO, "All Returning To Day options are selected");
	}
	public void selectAllAirline(){
		automate_dropDownList(airline,airlineoption);
		logger.log(Status.INFO, "All Airline options are selected");
	}
	public void selectPassengerCount(String selectvalue) {
		dropDownSelect(passengers, selectvalue);
		logger.log(Status.INFO, "Passengers count is Selected");
	}
	public void selectDeparting(String selectvalue) {
		dropDownSelect(departingfrom, selectvalue);
		logger.log(Status.INFO, "Departing Place is Selected");
	}
	public void selectOnMonth(String selectvalue) {
		dropDownSelect(onmonth, selectvalue);
		logger.log(Status.INFO, "Departing On month is Selected");
	}
	public void selectOnDay(String selectvalue) {
		dropDownSelect(onday, selectvalue);
		logger.log(Status.INFO, "Departing On day is Selected");
	}
	public void selectArivingIn(String selectvalue) {
		dropDownSelect(arrivingin, selectvalue);
		logger.log(Status.INFO, "Arriving place is Selected");
	}
	public void selectreturningmonth(String selectvalue) {
		dropDownSelect(tomonth, selectvalue);
		logger.log(Status.INFO, "Return To Month is Selected");
	}
	public void selectreturningday(String selectvalue) {
		dropDownSelect(today, selectvalue);
		logger.log(Status.INFO, "Return To Day is Selected");
	}
	public void selectairline(String selectvalue) {
		dropDownSelect(airline, selectvalue);
		logger.log(Status.INFO, "Airline Preference is Selected");
	}
	public void clickContinueButton() {
		clickOn(continuebutton, Duration.ofSeconds(30));
		logger.log(Status.INFO,"Continue Button is clicked");
	}
	public void clickClassRadio() {
		clickOn_radio_All_options(servclass);
		logger.log(Status.INFO,"All Class Radio options are clicked");
	}
	public void flight_screenshot() {
		String dest=screenshot("flightss");
		logger.addScreenCaptureFromPath(dest).log(Status.INFO, "Screenshot of flight details for the data passed is saved and sent to the report ");
	}
	public void closeAdSignin() {
		closeAd("flightsadURL");
		logger.log(Status.INFO, "Flights Page Ad is closed ");
	}
}
