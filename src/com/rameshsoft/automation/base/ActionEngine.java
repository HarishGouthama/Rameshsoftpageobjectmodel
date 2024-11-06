package com.rameshsoft.automation.base;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ActionEngine extends BaseTest{
	
	public static void enterUrl(String url) {
		try {
			getDriver().get( url);
			getExtentTest().log(LogStatus.PASS, "URL is entered as: "+url);			
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "URL is not entered as: " + url);
		}
	}
	
	public static void enterUrl(URL url) {
		try {
			getDriver().navigate().to(url);
			getExtentTest().log(LogStatus.PASS, "URL is entered as: " +url);
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "URL is not entered as: "+url);
		}
	}
	
	public static void navigateUrl(String url) {
		try {
			getDriver().navigate().to(url);
			getExtentTest().log(LogStatus.PASS, "URL is entered as: " +url);
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "URL is not entered as: "+url);
		}
	}

	
	
	public static void DTA(WebElement element , String testData , String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			element.clear();
			getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			element.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS, "Data typing action is done on element: "+elementName+" with testdata: "+testData);
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void DTAActions(WebElement element , String testData , String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			//element.clear();
			Actions actions = new Actions(getDriver());
			actions.sendKeys(element , testData).build().perform();
			getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			//element.sendKeys(testData);
			//getExtentTest().log(LogStatus.PASS, "Data typing action is done on element: "+elementName+" with testdata: "+testData);
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void DTAActions1(WebElement element , String testData , String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			//element.clear();
			Actions actions = new Actions(getDriver());
			actions.click(element).sendKeys(testData).build().perform();
			actions.sendKeys(element , testData).build().perform();
			//getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			//element.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS, "Data typing action is done on element: "+elementName+" with testdata: "+testData);
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void DTAByJs(WebElement element , String testData , String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			//element.clear();
			Actions actions = new Actions(getDriver());
			actions.click(element).sendKeys(testData).build().perform();
			actions.sendKeys(element , testData).build().perform();
			//getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			//element.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS, "Data typing action is done on element: "+elementName+" with testdata: "+testData);
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void clickElement(WebElement element ,  String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			//element.clear();
			/*Actions actions = new Actions(getDriver());
			actions.sendKeys(element , testData).build().perform();*/
			element.click();
			//getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			//element.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS, "click Data typing action is done on element: "+elementName );
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void clickElementByActions(WebElement element ,  String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			//element.clear();
			Actions actions = new Actions(getDriver());
			actions.click(element).build().perform();
			//getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			//element.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS, "click Data typing action is done on element: "+elementName );
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void clickElementByActionsENTER(WebElement element ,  String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			//element.clear();
			Actions actions = new Actions(getDriver());
			actions.sendKeys(element , Keys.ENTER).build().perform();
			//getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			//element.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS, "click Data typing action is done on element: "+elementName );
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void mouseHover(WebElement element ,  String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			//element.clear();
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).build().perform();
			//getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			//element.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS, "click Data typing action is done on element: "+elementName );
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void mouseHoverByJs(WebElement element ,  String elementName) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+elementName);
			//element.clear();
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).build().perform();
			//getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
			//element.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS, "click Data typing action is done on element: "+elementName );
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+elementName);
		}
	}
	
	public static void handleDropDowns(WebElement element , String ddName , String how , String howValue) {
		try {
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			getExtentTest().log(LogStatus.PASS, "Element is displayed: "+ddName);
			Select select = new Select(element);
			if(how.equalsIgnoreCase("value")) {
				select.selectByValue(howValue);
			}
			else if(how.equalsIgnoreCase("VisibleText")) {
				select.selectByVisibleText(howValue);
			}
			else if(how.equalsIgnoreCase("index")) {
				int indx = Integer.parseInt(howValue);
				select.selectByIndex(indx);
			}
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL, "Element is not displayed: "+ddName);
		}
	}
	
	
	public static void handleWindows() {
		try {
			String curWinName = getDriver().getWindowHandle();
			Set<String> windows = getDriver().getWindowHandles();
			if(windows.size() > 1) {
				for(String str : windows)
				{
					if(!curWinName.equalsIgnoreCase(str)) {
						getDriver().switchTo().window(str);
					}
				}
			}
			else {
				getExtentTest().log(LogStatus.PASS, "Only one window is available");
			}			
		}
		catch(Exception exception) {
			
		}
	}
	
	public static void handleWindows(int index) {
		try {
			
			Set<String> windows = getDriver().getWindowHandles();
			if(windows.size() > 1) {				
				List<String> listWin = new ArrayList<String>(windows);
				String str = listWin.get(index);
				getDriver().switchTo().window(str);
			}
			else {
				getExtentTest().log(LogStatus.PASS, "Only one window is available");
			}			
		}
		catch(Exception exception) {
			
		}
	}
	
	
	
	
}
