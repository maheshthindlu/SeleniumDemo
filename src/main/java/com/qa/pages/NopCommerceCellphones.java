package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.basetest.BaseTest;

public class NopCommerceCellphones extends BaseTest {

	
	//Creating constructor for the above class
	public NopCommerceCellphones(WebDriver driver){		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	
	//Webelement for LowtoHigh	
	@FindBy(xpath="//select[@id='products-orderby']")
	WebElement Lowtohigh;
	public WebElement Lowtohighlink(){
	return Lowtohigh;
	}

	public void Dropdownprice(){
    Select s=new Select(Lowtohigh);
    s.selectByVisibleText("Price: Low to High");  
	}

	
	//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/input[1]
	
	
	//Webelement for 1stAddtoCart button	
	@FindBy(xpath="//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/input[1]")
	WebElement Addtocartfirst;
	public WebElement Addtocartfirstlink(){
	return Addtocartfirst;
	}
	
	//Webelement for 2ndAddtoCart button	
	@FindBy(xpath="//div[@class='item-grid']/div[2]/div/div[2]/div[3]/div[2]/input[1]")
	WebElement Addtocartsecond;
	public WebElement Addtocartsecondlink(){
	return Addtocartsecond;
	}
	
	//Webelement for Jawellary button	
	@FindBy(xpath="//ul[@class='top-menu notmobile']/li[6]/a")
	WebElement Jawellary;
	public WebElement Jawellarylink(){
	return Jawellary;
	}
	
}
