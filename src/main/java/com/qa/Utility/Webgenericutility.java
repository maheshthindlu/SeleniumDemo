package com.qa.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.basetest.BaseTest;

/**
 * @author Silampur Girish 
 * @date   06-01-2020
 * @version 1.o
 */
public class Webgenericutility extends BaseTest {
	static WebDriver driver;
	
	/**
	 * @author Silampur Girish
	 * Method to clickOn element 
	 * custom clickOn method: click on element on the basis of some
	 * ExpectedConditions to avoid StaleElementReferenceException
	 * @param element driver timeout 
	 */
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {		
		try {
			/*new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));*/
			waitExpectedConditions(element,timeout);
			element.click();
		} catch (Exception e) {
			System.out.println("some exception got occurred while cliking the webelement : " + element);
			System.out.println(e.getMessage());

		}
	}

	/**
	 * @author Silampur Girish
	 * Method to sendKey Value
	 * custom sendKeyValue method: enter value in element on the basis of some
	 * ExpectedConditions to avoid StaleElementReferenceException
	 * @param element driver timeout value	 
	 */
	public static void sendKeyValue(WebDriver driver, WebElement element, int timeout, String value) {
		try {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while sending the text to the webelement : " + element);
			System.out.println(e.getMessage());
		} 
	}	

	/**
	 * @author Silampur Girish
	 * Method to select dropdown by text
	 * @param element
	 * @param text
	 */
	public static void selectDropdownByText(WebElement element, String text,int timeout)
	{
		try {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(element));
			Select select = new Select(element);
			select.selectByVisibleText(text);			
		} catch (Exception e) {
			System.out.println("some exception got occurred while selecting  the dropdown  by text : " + element);
			System.out.println(e.getMessage());
		}
		
			
	}

	/**
	 * @author Silampur Girish
	 * Method to select dropdown by Value
	 * @param element
	 * @param text  timeout
	 */
	public static void selectDropdownByValue(WebElement element, String text,int timeout)
	{
		try {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(element));
			Select select = new Select(element);
			select.selectByValue(text);			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("some exception got occurred while selecting  the dropdown by value : " + element);
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * @author Silampur Girish
	 * Method to select dropdown by index
	 * @param element
	 * @param num timeout
	 */
	public static void selectDropdownByIndex(WebElement element, int  num, int timeout)
	{
		try {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(element));
			Select select = new Select(element);
			select.selectByIndex(num);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("some exception got occurred while selecting  the dropdown by index : " + element);
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * @author Silampur Girish
	 * Method to get attribute value of the element
	 * @param element
	 * @param attribute
	 * @return String
	 */
	public static String getAttributeValue(WebElement element, String attribute,int timeout)
	{
		try {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(element));					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("some exception got occurred while selecting  the dropdown by index : " + element);
			System.out.println(e.getMessage());
		}
		return element.getAttribute(attribute);			
	}

	/**
	 * @author Silampur Girish
	 * Method to get SelectedText value of the dropdwon
	 * @param element	 
	 * @return String
	 */
	public static String getSelectedText(WebElement element,int timeout)
	{
		try {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(element)); 			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("some exception got occurred while geting the  SelectedText : " + element);
			System.out.println(e.getMessage());			
		}
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * @author Silampur Girish
	 * Method to get text of the element
	 * @param element
	 */

	public static String getText(WebElement element,int timeout)
	{
		try {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));			
		} catch (Exception e) {
			System.out.println("some exception got occurred while geting the text of webelement : " + element);
			System.out.println(e.getMessage());
		}

		return element.getText();
	}
	/**
	 * @author Uma Maheswari
	 * Method to Navigate url 
	 * @param url
	 */
	public static void NavigateToUrl(String url)
	{
		driver.navigate().to(url);
	}

	/**
	 * @author Lakshmi
	 * Method to take you back by one page on the browser’s history.
	 */ 
	public static void Navigateback()
	{
		driver.navigate().back();
	}
	/**
	 * @author Uma Maheswari
	 * Method to take you forward by one page on the browser’s history.
	 */ 

	public static void NavigateForward()
	{
		driver.navigate().forward();
	}

	/**
	 * @author Uma Maheswari
	 * Method to refresh the page
	 */ 

	public static void NavigateRefresh()
	{
		driver.navigate().refresh();
	}

	/**
	 * @author Uma Maheswari
	 * Method to get title of the application/page
	 * return String
	 */ 

	public static String getTitle()
	{
		return driver.getTitle();
	}
	
	//
		/**
	 * @author Mohini Sethumadhavan
	 * Method to select any element for boolean value
	 * @param boolean 
	 * @param value
	 */
	public boolean isElementSelected(WebElement element)
	{
		boolean value;
		value=element.isSelected();
		try{
			value=true;
			System.out.println("is Selected");
			
		}
		catch (Exception e)
		{
			System.out.println("not Selected");
			System.out.println(e.getMessage());
		}
		
		
		return value;

	}
	/**
	 * @author Mohini Sethumadhavan
	 * Method to display any element for boolean value
	 * @param WebElement 
	 * @param elementDisplay
	 */
	public boolean isElementDisplayed( WebElement element)
	{
		boolean value;
		value=element.isDisplayed();
		try{
			value=true;
			System.out.println("is Displayed");
			
		}
		catch (Exception e)
		{
			System.out.println("not Displayed");
			System.out.println(e.getMessage());
		}
		
		
		return value;

	}
	/**
	 * @author Mohini Sethumadhavan
	 * Method to enable any element for boolean value
	 * @param boolean 
	 * @param element
	 */
	public boolean isElementEnabled(WebElement element)
	{
		boolean value;
		value=element.isEnabled();
		try{
			value=true;
			System.out.println("is Enabled");
			
		}
		catch (Exception e)
		{
			System.out.println("not Enabled");
			System.out.println(e.getMessage());
		}
		
		
		return value;
	}
	/**
	 * @author Mohini Sethumadhavan
	 * Method to wait till page is loaded
	 * @param i 
	 * @param 
	 */
	public WebElement waitTillPageLoad(int i)
	{
		driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);
		return null;

	}
	/**
	 * @author Mohini Sethumadhavan
	 * Method to check if the given element is selected
	 * @param WebElement 
	 * @param waitExpectedException
	 */
	public static WebElement waitExpectedConditions(WebElement waitExpectedException, int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,seconds);

		wait.until(ExpectedConditions.elementToBeSelected(waitExpectedException));
		return waitExpectedException;
	}

	/**
	 * @author Mohini Sethumadhavan
	 * Method to check an element to be invisible
	 * @param WebElement 
	 * @param waitExpectedException
	 */

	public WebElement waitTillElementFound(WebElement ElementTobeFound,
			int seconds) 
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
		return ElementTobeFound;
	}
	/**
	 * @author Mohini Sethumadhavan
	 * Method to check whether the given frame is available to switch to.
	 * @param WebElement 
	 * @param waitExpectedException
	 */
	public WebElement waitframeToBeAvailableAndSwitchToIt(WebElement frameLocator,
			int seconds) 
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		return frameLocator;
	}
	/**
	 * @author Mohini Sethumadhavan
	 * Method to switch back to original page 
	 * @param   
	 * @param 
	 */

	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
		
	}
	/**
	 * @author Mohini Sethumadhavan
	 * Method to switch frame 
	 * @param   
	 * @param 
	 */	
	public void switchToFrame(WebElement iframeElement) {
		driver.switchTo().frame(iframeElement);
		
	}

	/**
	 * @author Silampur Girish 
	 * Method to wait for load
	 * @param driver
	 */
	public static void waitForLoad(long seconds) 
	{
		ExpectedCondition<Boolean> pageLoadCondition = new
	               ExpectedCondition<Boolean>() {
	                   public Boolean apply(WebDriver driver) {
	                       return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                   }
	               };
	               WebDriverWait wait = new WebDriverWait(driver, seconds);
	               wait.until(pageLoadCondition);
	    }
	
	/**
	 * @author Silampur Girish 
	 * Method is Element Exists
	 * @param element
	 */
	public static boolean isElementExists( WebElement element)
	{
		boolean present;
		try {
		   element.isDisplayed();
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		   //log.info("",e);
		}
		return present;
	}
	/**
	 * @author Silampur Girish 
	 * Scroll method
	 * @param 
	 * @return
	 */
	public static void scrollpage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 750);");
	}
	/**
	 * @author Sharoonroja G 
	 * Scroll to a particular element
	 * @param 
	 * @return
	 */
	public static void scrolltoElement(WebElement element) throws Exception {

		int x = element.getLocation().getX();
		int y = element.getLocation().getY();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		Thread.sleep(2000);
	}
	/**
	 * @author Sharoonroja G 
	 * Scroll to a particular element
	 * @param 
	 * @return
	 */
	public static void listOfElements(String xpath) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));

		List<String> arrayOptions = new ArrayList<String>();

		for (WebElement option : list) {
			arrayOptions.add(option.getText());
		}
		int listsize = arrayOptions.size();
		System.out.println("count of sections:-" + listsize);
		for (int i = 0; i < listsize; i++) {

			String text = arrayOptions.get(i);
			System.out.println(text);
		}

	}
	/**
	 * @author Bhavana CM 
	 * method to fetch title of current web Page
	 * @param 
	 * @return
	 */
	public String getBrowserInfo() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}
	/**
	 * @author Bhavana CM 
	 * method to fetch title of current web Page
	 * @param 
	 * @return
	 */
	
	@SuppressWarnings("unused")
	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	/**
	 * @author Bhavana CM 
	 * method to fetch title of current web Page
	 * @param 
	 * @return
	 */
	public void dragAndDrop(WebElement from,WebElement to){
		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
	}
}