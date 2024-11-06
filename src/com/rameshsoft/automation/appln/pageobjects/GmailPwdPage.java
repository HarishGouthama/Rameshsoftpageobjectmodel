package com.rameshsoft.automation.appln.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rameshsoft.automation.base.ActionEngine;

public class GmailPwdPage extends ActionEngine{
	
	static
	{
		PageFactory.initElements(getDriver(), GmailHomePage.class);
	}
	
	@FindBy(name = "password")
	private static WebElement password;
	
	@FindBy(id = "passwordNext")
	private static WebElement signIn;
	
	@FindBy(xpath = "//span[text() = 'Forgot password?']")
    private static WebElement frgtPwd;
	
	@FindBy(xpath = "//div[text() = 'Show password']")
    private static WebElement showPwd;
	
	public static void enterPwd(String pwdData) {
		DTA(password , pwdData , "password");
	}
	
	public static void clickSignInBtn() {
		clickElement(signIn, "signin");
	}
	
	public static void clickFrgtpwdBtn() {
		clickElement(frgtPwd, "Forgot password");
	}
	
	public static void clickShowPwdBtn() {
		clickElement(showPwd, "Show password");
	}

}
