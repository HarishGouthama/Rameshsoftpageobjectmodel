package com.rameshsoft.automation.appln.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rameshsoft.automation.base.ActionEngine;

public class GmailHomePage extends ActionEngine {
	
	static
	{
		PageFactory.initElements(getDriver(), GmailHomePage.class);
	}
	
	@FindBy(id = "identifierId")
	private static WebElement userName;
	
	@FindBy(id = "identifierNext")
	private static WebElement nxt;
	
	@FindBy(xpath = "//button[text() = 'Forgot email?']")
    private static WebElement frgtEmail;
	
	@FindBy(xpath = "//span[text() = 'Create account']")
    private static WebElement createAcc;
	
	public static void enterUserName(String unData) {
		DTA(userName , unData , "username");
	}
	
	public static void clickNxtBtn() {
		clickElement(nxt, "next");
	}
	
	public static void clickFrgtEmailBtn() {
		clickElement(frgtEmail, "Forgot email");
	}
	
	public static void clickCreateAccBtn() {
		clickElement(createAcc, "Create account");
	}
}
