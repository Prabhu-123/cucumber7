package com.setup;

import java.util.Properties;
import com.utils.DriverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestSetup {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	
	@Before(order = 1)
	public void getConfigProperty()
	{
		System.out.println("config is initiated");
		configReader=new ConfigReader();
		prop=configReader.readConfig();
	}

	@Before(order = 2)
	public void launchBrowser() {
		System.out.println("browser will launch");
		String browserName = prop.getProperty("browser");
		driverFactory= new DriverFactory();
		driver= driverFactory.createBrowserInstance(browserName);
		System.out.println("browser is launched");
	}

	@After(order=0)
	public void teardown() {
		driver.quit();
	}

	@After(order=1)
	public void scenario_status(Scenario sc) {
		System.out.println(sc.getName() + " : " + sc.getStatus());
		if(sc.isFailed())
		{
			String ScreenshoName = sc.getName().replaceAll(" ","-");
			byte[] scrfilepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(scrfilepath, "img/png", ScreenshoName);
		}
	}

}
