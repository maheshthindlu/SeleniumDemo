package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basetest.BaseTest;

public class NopCommerceHomePage extends BaseTest {

	
	//Creating constructor for the above class
	public NopCommerceHomePage(WebDriver driver){		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Webelement for Electronics	
	@FindBy(xpath="//ul[@class='top-menu notmobile']/li[2]/a")
	WebElement Electronics;
	public WebElement Electronicslink(){
	return Electronics;
	}
	
	//Webelement for Cellphones	
	@FindBy(xpath="//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a")
	WebElement Cellphones;
	public WebElement Cellphoneslink(){
	return Cellphones;
	}
	

	public void mouseoverclick(){
  Actions a=new Actions(driver);
  a.moveToElement(Electronics).build().perform();
  
	}

	
}
