package com.rameshsoft.automation.appln.businessscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseTest;
import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;

public class FbTest extends BaseTest{
	
		@Test
		public void FbTest() throws IOException, FrameworkException {
			
			getDriver().get(PojoReader.getConfPrObj().getValue("fb_url"));
			getExtentTest().log(LogStatus.PASS,"URL is entered as: "+PojoReader.getConfPrObj().getValue("fb_url"));
			
			
			/*getDriver().get("https://www.facebook.com");
			//getDriver().findElement(By.id("identifierID"));
			//un.clear();
			//un.SendKeys("rameshsoft.9177791456@gmail.com");
			
			FileInputStream fipConf = new FileInputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\config.properties");
			Properties prConf = new Properties();
			prConf.load(fipConf);
			String url = prConf.getProperty("fb_url");		
			getDriver().get(url);*/
			
			//WebElement nxt = getDriver().findElement(By.id("identifiernext456"));
			//nxt.click();
		}
}
