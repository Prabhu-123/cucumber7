package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
			
			
	public WebElement waitforelementtobeVisible(By ele ,long time)
	{
		WebElement element;
		element = new WebDriverWait(DriverFactory.getDriver(),time).until(ExpectedConditions.visibilityOfElementLocated(ele));
		return element;
	  
	}
	
	
}
