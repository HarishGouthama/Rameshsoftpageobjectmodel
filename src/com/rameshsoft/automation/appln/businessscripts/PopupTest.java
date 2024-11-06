package com.rameshsoft.automation.appln.businessscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.ActionEngine;
import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.PojoReader;

public class PopupTest extends ActionEngine{

	@Test
	public void alertsTest() throws FrameworkException, IOException {
		enterUrl(PojoReader.getConfPrObj().getValue("popup_url"));
		getDriver().findElement(By.id("1")).click();
		
		/*Runtime runtime = Runtime.getRuntime();
		
		runtime.exec("D:\\RameshSoft2directory\\Rameshsoft-PageObjectFramework\\Popups\\pop.exe");*/
		
		Runtime.getRuntime().exec("D:\\RameshSoft2directory\\Rameshsoft-PageObjectFramework\\Popups\\pop.exe");
	}
	
}
