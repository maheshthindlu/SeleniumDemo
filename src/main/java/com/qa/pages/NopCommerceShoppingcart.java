package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.basetest.BaseTest;

public class NopCommerceShoppingcart extends BaseTest {

	
	//Creating constructor for the above class
	public NopCommerceShoppingcart(WebDriver driver){		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

		
	//Webelement for Pagetitle	
	@FindBy(xpath="//div[@class='page-title']/h1")
	WebElement Pagetitle;
	public WebElement Pagetitletext(){
	return Pagetitle;
	}
	
	//Webelement for Sub-total	
	@FindBy(xpath="//table[@class='cart-total']/tbody/tr[1]/td/label")
	WebElement subtotal;
	public WebElement subtotalheading(){
	return subtotal;
	}
	
	//Webelement for jewelquantity
	@FindBy(xpath="//div[@class='table-wrapper']/table/tbody/tr[3]/td[6]/input")
	WebElement quantity;
	public WebElement quantityentered(){
	return quantity;
	}
	
	//Webelement for Update shopping cart button
	@FindBy(xpath="//input[@value='Update shopping cart']")
	WebElement update;
	public WebElement updatebutton(){
	return update;
	}
		
	//Webelement for checkbox
	@FindBy(xpath="//input[@id='termsofservice']")
	WebElement checkbox;
	public WebElement checkbox(){
	return checkbox;
	}

	
	//Webelement for checkout button
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkout;
	public WebElement checkoutbutton(){
	return checkout;
	}
	
	
	
	
	
	
}
