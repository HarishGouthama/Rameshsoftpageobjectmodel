package com.rameshsoft.automation.appln.businessscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseTest;
import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;

public class FpTest extends BaseTest{
	
	
	@Test
	public void FpTest() throws IOException, FrameworkException {
		//getDriver().get("https://www.flipkart.com");
		getDriver().get(PojoReader.getConfPrObj().getValue("fp_url"));
		getExtentTest().log(LogStatus.PASS,"URL is entered as: "+PojoReader.getConfPrObj().getValue("fp_url"));
		
		/*FileInputStream fipConf = new FileInputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\config.properties");
		Properties prConf = new Properties();
		prConf.load(fipConf);
		String url = prConf.getProperty("fp_url");		
		getDriver().get(url);*/
	}
	
}
