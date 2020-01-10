package com.qa.test;

import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.pages.NopCommerceCellphones;
import com.qa.pages.NopCommerceHomePage;
import com.qa.pages.NopCommerceJewellary;
import com.qa.pages.NopCommerceShoppingcart;
import com.qa.pages.NopCommerceSigninpage;

import junit.framework.Assert;

public class NopcommerceNanvigation extends BaseTest{

	@Test(priority=1)
	public void homepagenavigation() throws InterruptedException{
		//Creating object for Homepage
		NopCommerceHomePage NCHP=new NopCommerceHomePage(driver);
		NCHP.mouseoverclick();
		NCHP.Cellphoneslink().click();
	}
	
	@Test(priority=2)
	public void Addingcellstocart() throws InterruptedException{		
		//Creating object for Cellphones
		NopCommerceCellphones NCCP=new NopCommerceCellphones(driver);
		//Select Low price to high for mobiles
		NCCP.Dropdownprice();
		//Adding first mobile to shopping cart
		NCCP.Addtocartfirstlink().click();
		Thread.sleep(6000);
		//Adding second mobile to shopping cart
		NCCP.Addtocartsecondlink().click();
		//Click on Jewellary link
		NCCP.Jawellarylink().click();
	}
	
	@Test(priority=3)
	public void Addingjewellarytocart() throws InterruptedException{
		//Creating object for Jewellary
		NopCommerceJewellary NCJW=new NopCommerceJewellary(driver);
		//Select High price to Low price for Jewellaries
		NCJW.Dropdownpricejewel();
		//Adding jewel to Shopping cart
		NCJW.Addtocartfirstlink().click();	
		
		String confrmmsg=NCJW.confirmationmessage().getText();
		
		//Verifying confirmation message
		Assert.assertEquals("The product has been added to your shopping cart", confrmmsg);
		System.out.println(confrmmsg);
		Thread.sleep(4000);
		//Click on Add to cart button
		NCJW.mouseoverclickshoppingcart();
		NCJW.Addtocartbutton().click();
	}
	
	@Test(priority=4)
	public void Updateshoppingcart() throws InterruptedException{
	
		//Creating object for Shoppingcart page
		NopCommerceShoppingcart NCSC=new NopCommerceShoppingcart(driver);
		String heading = NCSC.Pagetitletext().getText();
		String subtotal=NCSC.subtotalheading().getText();
		Assert.assertEquals("Shopping cart", heading);
		Assert.assertEquals("Sub-Total:", subtotal);
		NCSC.quantityentered().clear();
		//updatig jewellary quantity as 3
		NCSC.quantityentered().sendKeys("3");			
		//Click on update shopping cart button
		NCSC.updatebutton().click();
		//Select checkbox
		NCSC.checkbox().click();
		//Click on Checkout button.
		NCSC.checkoutbutton().click();
	}
	
	@Test(priority=5)
	public void Signin() throws InterruptedException{
	
		//Creating object for Signin page
		NopCommerceSigninpage NCSI=new NopCommerceSigninpage(driver);
		String signinpagetitle=NCSI.signintitletext().getText();
		//Verifying Signin Page title
		Assert.assertEquals("Welcome, Please Sign In!", signinpagetitle);
		//Click on Checkout as a guest button
		NCSI.guestbutton().click();
		
		
	}
	

}


