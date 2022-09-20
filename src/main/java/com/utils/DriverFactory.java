package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver createBrowserInstance(String browser)
	{
		System.out.println("Browser is "+ browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver.set(new FirefoxDriver());
		}
		
		else if(browser=="safari")
		{
		WebDriverManager.firefoxdriver().setup();
		driver.set(new SafariDriver());
		}
		
		else 
			System.out.println("Please pass the browser name properly");
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();	
	}
	
	public static synchronized WebDriver getDriver()
	{
		return driver.get();
	}
	
}
