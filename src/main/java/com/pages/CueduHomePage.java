package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.Constants;
import com.utils.ElementActions;

public class CueduHomePage {
	
	ElementActions elementactions=new ElementActions();
	private WebDriver driver;
	
	private By HeaderLogo = By.xpath("//a[@title='Capella University']");
	
	private String HeaderFields= "//a[@title='value']";
	
	private By Financing = By.xpath("//a[@title='Financing']");
	
	private By Grants = By.xpath("//a[@title='Grants']");
	
	
	public CueduHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void navigateTocapella() {
		driver.get(Constants.CUEDUURL);
	}
	

	public boolean VerifyHeaderMenu(String HeaderValue)
	{
		WebElement HeaderMenu = driver.findElement(By.xpath(HeaderFields.replace("value",HeaderValue)));
		return HeaderMenu.isDisplayed();
	}
	
	public boolean VerifyHeadrLogo()
	{
		WebElement elem = elementactions.waitforelementtobeVisible(HeaderLogo,20);
		return elem.isDisplayed();
	}
	
	public void clickOnFinancingLink() {
		driver.findElement(Financing).click();
	}
	
	public void clickOnGrantsLink() {
		driver.findElement(Grants).click();
	}
	
	public String validatePagetitle()
	{
		String Page_title=driver.getTitle();
		return Page_title;
	}
}
