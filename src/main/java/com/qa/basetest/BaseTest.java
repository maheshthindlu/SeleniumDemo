/*
 This is the Base Class
 Basic Functionality:
 					Launch Browser
 					Extent Report
 					Screen Shots
 					Tear Down
 
 Creation Date : 07/01/2020
 @Version 2.2
 @author Sumana and Team
*/

package com.qa.basetest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.qa.Resource.DataRead;
import com.qa.Resource.ReadExcel;
import com.qa.Utility.PropertyLoader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public static WebDriver driver;
	static String absolutepath = System.getProperty("user.dir");
	static String driverPath = absolutepath+"\\Drivers\\";
	
	static String filePath = absolutepath+"\\Failedscreenshots";
	ExtentReports extent;
	//helps to generate the logs in test report.
	ExtentTest test;
	static ExtentReports report;
	ITestResult result;

	@BeforeClass
	// This method is used to launch browser
	public void BrowserIntialisation() {
		PropertyLoader proploader = new PropertyLoader();
		String browsertype=proploader.getBrowsertype();
		String baseurl=proploader.getBaseURL();
	
		try {
			switch (browsertype) {
			case "chrome":
				System.out.println("Launching google chrome with new profile..");
				System.setProperty("webdriver.chrome.driver", driverPath+ "chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.out.println("Launching Firefox browser..");
				System.setProperty("webdriver.gecko.driver", driverPath+ "geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "InternetExplorer":
				System.out.println("Launching InternetExplorer browser..");
				System.setProperty("webdriver.ie.driver", driverPath+ "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("browser : " + browsertype
						+ " is invalid, Launching Firefox as browser of choice..");
				System.setProperty("webdriver.gecko.driver", driverPath+ "geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}

		catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
			Assert.assertFalse(true, "Browser Not Found");
		}
		driver.manage().window().maximize();
		driver.get(baseurl);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


/*	@AfterClass
	// This method is used to close the browsers
	public void tearDown() {

		report.endTest(test);
		report.flush();
		driver.quit();
	}*/

	// It will execute after every test execution 
	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException{

		// Here will compare if test is failing then only it will enter into if condition and takes the screenshot
		if(ITestResult.FAILURE==result.getStatus()){
			try {

				test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver, result)) +result.getName()+" - Test Failed");

			}
			catch (Exception e){	
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName()+" - Test Passed");
		}
	}

	// This method will capture the screenshot
	public static String capture(WebDriver driver, ITestResult result) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(filePath +"/"+result.getName()+"_"+System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}			

	// This method will generate extent report
	@BeforeTest()
	public void startReport() {
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/testReport"+".html");
		test = report.startTest("Extent Report");
		report.addSystemInfo("OS", "Windows10");
	}

	@DataProvider(name = "LoginDataXLS")
	public Object[][] ReadExcelXLS() throws Exception{
		
		String absolutepath=System.getProperty("user.dir");
		String fileName=absolutepath+"\\ExportExcel\\WriteData.xlsx";
		String sheetname="WriteExcelDemo";

	ReadExcel excel = new ReadExcel();
	Object[][] testObjArray = excel.getExcelData(fileName,sheetname);
	System.out.println(testObjArray);
	return testObjArray;

	}
	
	@DataProvider(name = "LoginDataXLSX")
    public Object[][] ReadExcelXLSX() throws Exception{
   	 
   	 String absolutepath=System.getProperty("user.dir");
   		String fileName=absolutepath+"\\ExportExcel\\WriteData.xlsx";
   		String sheetname="WriteExcelDemo";

   		ReadExcel excel = new ReadExcel();
	Object[][] testObjArray = excel.getExcelData(fileName,sheetname);
	System.out.println(testObjArray);
	return testObjArray;

	}	



}