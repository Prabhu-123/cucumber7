package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utils.*;

public class SueduHomePage {
	
	ElementActions elementactions=new ElementActions();
	
	private WebDriver driver;
	
	private String genericDropDownss= "//select[@title='value']";
	
	private String genericFields= "//input[@title='value']";
	
	@FindBy(xpath="//button[contains(text(),'Agree & get program details')]")
	private WebElement getProgramDetailsBtn;
	
	private String header= "//a[contains(text(),'value')]";
	
	private By btmrfiForm =By.xpath("//div[@class='rfi-form']");
	
	
	private By headerLogo =By.xpath("//div[@class='glyph fs1']");
	
	
	public SueduHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void navigateToStrayer() {
		driver.get(Constants.SUEDUURL);
	}
	
	public void selectDegree(String Degvalue,String degree)
	{
		WebElement degreeDropdown = driver.findElement(By.xpath(genericDropDownss.replace("value",degree)));
		Select sel = new Select(degreeDropdown);
		sel.selectByVisibleText(Degvalue);
	}

	public void FillFields(String fieldvalue,String fieldTitle)
	{
		WebElement field = driver.findElement(By.xpath(genericFields.replace("value",fieldTitle)));
		field.sendKeys(fieldvalue);
	}
	
	public boolean VerifyHeaderMenu(String HeaderValue)
	{
		WebElement HeaderMenu = driver.findElement(By.xpath(header.replace("value",HeaderValue)));
		return HeaderMenu.isDisplayed();
	}
	
	public boolean VerifybtmRFIForm()
	{
		elementactions.waitforelementtobeVisible(btmrfiForm,20);
		return driver.findElement(btmrfiForm).isDisplayed();
	}
	
	public boolean VerifyHeadrLogo()
	{
		elementactions.waitforelementtobeVisible(headerLogo,20);
		return driver.findElement(headerLogo).isDisplayed();
	}
}
