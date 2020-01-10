package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.basetest.BaseTest;

public class NopCommerceSigninpage extends BaseTest {

	
	//Creating constructor for the above class
	public NopCommerceSigninpage(WebDriver driver){		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

		
	//Webelement for Pagetitle	
	@FindBy(xpath="//div[@class='page-title']/h1")
	WebElement signintitle;
	public WebElement signintitletext(){
	return signintitle;
	}
	
	
	//Webelement for Pagetitle	
	@FindBy(xpath="//input[@value='Checkout as Guest']")
	WebElement guest;
	public WebElement guestbutton(){
	return guest;
	}
	
	
	
	

	


	
	
	
	
	
}
