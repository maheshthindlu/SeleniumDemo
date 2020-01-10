package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.basetest.BaseTest;

public class NopCommerceJewellary extends BaseTest {

	
	//Creating constructor for the above class
	public NopCommerceJewellary(WebDriver driver){		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	
	//Webelement for LowtoHigh	
	@FindBy(xpath="//select[@id='products-orderby']")
	WebElement hightolow;
	public WebElement hightolowlink(){
	return hightolow;
	}

	public void Dropdownpricejewel(){
    Select sj=new Select(hightolow);
    sj.selectByVisibleText("Price: High to Low");  
	}

		
	
	//Webelement for 1stAddtoCart button	
	@FindBy(xpath="//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/input[1]")
	WebElement Addtocartfirst;
	public WebElement Addtocartfirstlink(){
	return Addtocartfirst;
	}

	
	//Webelement for Confirmationmessage	
	@FindBy(xpath="//div[@class='bar-notification-container']/div/p")
	WebElement confirmation;
	public WebElement confirmationmessage(){
	return confirmation;
	}
    
	//
	//Webelement for Confirmationmessage	
	@FindBy(xpath="//span[@class='cart-label']")
	WebElement shoppingcart;
	public WebElement shoppingcartlabel(){
	return shoppingcart;
	}
	
	//Creating actions for mouseovering on shopping cart
	public void mouseoverclickshoppingcart(){
		  Actions sc=new Actions(driver);
		  sc.moveToElement(shoppingcart).build().perform();	  
		  
			}
	
	//Webelement for Add to Cart button	
	@FindBy(xpath="//input[@value='Go to cart']")
	WebElement Addtocart;
	public WebElement Addtocartbutton(){
	return Addtocart;
	}
	
	
	
	
}
