package com.gurudemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * BrowserSetup initializes the WebDriver with the specified BrowserOption.
 * It opens and maximizes the window.
 * */

public class BrowserSetup {
	public static WebDriver driver;
	public static WebDriver getChromeDriver() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications*");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}
	public static WebDriver getFireFoxDriver() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public static WebDriver getEdgeDriver() {
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
