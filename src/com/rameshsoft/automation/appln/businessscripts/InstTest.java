package com.rameshsoft.automation.appln.businessscripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseTest;
import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;

public class InstTest extends BaseTest{
	
	@Test
	public void instTest() throws IOException, FrameworkException {
		
		getDriver().get(PojoReader.getConfPrObj().getValue("inst_url"));
		getExtentTest().log(LogStatus.PASS,"URL is entered as: "+PojoReader.getConfPrObj().getValue("inst_url"));
		
		
		/*FileInputStream fipConf = new FileInputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\config.properties");
		Properties prConf = new Properties();
		prConf.load(fipConf);
		String url = prConf.getProperty("inst_url");		
		getDriver().get(url);
		//getDriver().get("https://www.rameshsoft.com");
*/	}

}
