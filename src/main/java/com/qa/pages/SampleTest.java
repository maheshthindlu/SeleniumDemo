package com.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.Resource.ReadExcel;
import com.qa.basetest.BaseTest;
import org.apache.log4j.Logger;

public class SampleTest extends BaseTest {	

	Logger log = Logger.getLogger("devpinoyLogger");
	
	@FindBy(name="uid")

	WebElement user99GuruName;

	@FindBy(name="password")

	WebElement password99Guru;


	@FindBy(name="btnLogin")

	WebElement login;

	@FindBy(xpath="//a[@href='http://demo.guru99.com/insurance/v1/index.php']")

	WebElement clicklink;

	@FindBy(xpath="//a[@href='http://demo.guru99.com/insurancedex.php']")

	WebElement clicklink2;
	
	public SampleTest(){

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	//Set user name in textbox

	public void setUserName(String strUserName){

		user99GuruName.sendKeys(strUserName);     
	}

	//Set password in password textbox

	public void setPassword(String strPassword){

		password99Guru.sendKeys(strPassword);

	}

	//Click on login button

	public void clickLogin(){

		login.click();

	}  

	public void clickLink(){

		clicklink.click();

	}

	public void clickLink2(){

		clicklink2.click();

	}

	public void loginToGuru99(String strUserName,String strPasword){

		//Fill user name

		this.setUserName(strUserName);

		//Fill password

		this.setPassword(strPasword);

		//Click Login button

		this.clickLogin();           
	}		
	
	@DataProvider(name="getrowdata")
	public static ArrayList<String> dataReading(String userID) throws IOException
	{
		ReadExcel read=new ReadExcel();
		ArrayList<String> arr=read.getData(userID,System.getProperty("user.dir")+"\\ExportExcel\\WriteData.xlsx");
		System.out.println(arr);
		return arr;			
	}

}
