package com.rameshsoft.automation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.DriverPaths;
import com.rameshsoft.automation.utilities.ScrrenshotUtility;
import com.rameshsoft.automation.reports.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import bsh.classpath.BshClassPath.GeneratedClassSource;
import lombok.Getter;


public class BaseTest {
	
	@Getter private static WebDriver driver;
	@Getter private static String path;
	@Getter private static String tcName;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
	public static ExtentTest getExtentTest()
	{
		return extentTest;
	}
	
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(@Optional("chrome") String browser){
		
		path = System.getProperty("user.dir");
		
		if(browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", path +  "\\Drivers\\IEDriverServer.exe");
			System.setProperty(DriverPaths.chromeKey, DriverPaths.chromeValue);
			driver = new ChromeDriver();
			init();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty(DriverPaths.ieKey, DriverPaths.ieValue);
			driver = new InternetExplorerDriver();
			init();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty(DriverPaths.edgeKey, DriverPaths.edgeValue);
			driver = new EdgeDriver();
			init();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(DriverPaths.firefoxKey , DriverPaths.firefoxValue);
			driver = new FirefoxDriver();
			
		}
	}
	
	private void init() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15 ,  TimeUnit.SECONDS);
	}
	
	@AfterSuite
	private void closeBrowser() throws FrameworkException {
		if(driver!=null) {
			driver.close();
		}
		else {
			//Throw exception
			FrameworkException exception = new FrameworkException("Driver is pointing yo null");
			System.out.println("Driver is pointing to null");
			throw exception;
		}
	}
	
	@BeforeTest
	public void initReports() {
		 	extentReports = new ExtentReports(path + "\\Results\\Reports.html");
		 	Map<String, String> map = new HashMap<String , String>();
			map.put("username","Rameshsoft");
			map.put("suite","Regression");
			map.put("env","QA");
			map.put("username","Rameshsoft");
			extentReports.addSystemInfo(map);
	}
	
	@AfterTest
	public void generateReports() throws FrameworkException {
		if(extentReports!=null) {
			extentReports.close();
		}
		else
		{
			FrameworkException exception = new FrameworkException("ExtentsReports is pointing to null");
			throw exception;
		}
	}
	
	@BeforeMethod
	public void beforeTCExecution(Method method) {
		tcName = method.getName();
		System.out.println("Current execution TC is:  " + tcName);
		extentTest = extentReports.startTest(tcName);
		extentTest.log(LogStatus.PASS, "Current execution Tc is: "+tcName);
	}
	
	@AfterMethod
	public void afterTCExecution(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("TC is passed " + result.getName());
			extentTest.log(LogStatus.PASS, "TC is passed "+result.getName());
		}
			else if(result.getStatus() == ITestResult.FAILURE) {
				System.out.println("TC is Failed: " + result.getName());
				extentTest.log(LogStatus.FAIL, "TC is failed "+result.getName());
				extentTest.log(LogStatus.FAIL, result.getThrowable().toString());
				String imagePath = ScrrenshotUtility.takeScreenshot();
				extentTest.addScreenCapture(imagePath);
			}
			else if(result.getStatus() == ITestResult.SKIP) {
				System.out.println("TC is skipped: " + result.getName());
				extentTest.log(LogStatus.SKIP, "TC is skipped "+result.getName());
				extentTest.log(LogStatus.SKIP, result.getThrowable().toString());
				String imagePath = ScrrenshotUtility.takeScreenshot();
				extentTest.addScreenCapture(imagePath);
		}
		extentReports.endTest(extentTest);
		extentReports.flush();
	}
	
	/*public static String getPath() {
		return path;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static String getTcName() {
		return tcName;
	}*/
	//thread.close();
}
