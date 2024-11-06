package com.rameshsoft.automation.appln.businessscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.rameshsoft.automation.appln.pageobjects.GmailHomePage;
import com.rameshsoft.automation.appln.pageobjects.GmailPwdPage;
import com.rameshsoft.automation.base.ActionEngine;
import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.PojoReader;

public class GmailPomTest extends ActionEngine{
	
	@Test
	public void GmailPomTest() throws FrameworkException, IOException {
		ActionEngine.enterUrl(PojoReader.getConfPrObj().getValue("qa_url"));
		GmailHomePage.enterUserName(PojoReader.getExcelReader().getCellData("sheetname", "Gmail_Data", 0 , 0));
		GmailHomePage.clickNxtBtn();
		
		//GmailPwdPage.enterPwd(PojoReader.getExcelReader().getCellData("index", "0" , 0, 1));
		//GmailPwdPage.clickSignInBtn();
		
	}

}
