package com.rameshsoft.automation.reports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsProg {
	public static void main(String[] args) {
		
		ExtentReports er = new ExtentReports("D:\\RameshSoft2directory\\Rameshsoft-PageObjectFramework\\Results\\Reports.html");
		
		Map<String, String> map = new HashMap<String , String>();
		map.put("username","Rameshsoft");
		map.put("suite","Regression");
		map.put("env","QA");
		map.put("username","Rameshsoft");
		er.addSystemInfo(map);
		
		//ExtentTest extentTest = er.startTest("Hardwork", "This Tc is about job");
		ExtentTest extentTest = er.startTest("Hardwork");
		
		extentTest.log(LogStatus.PASS, "Browser is opened");
		extentTest.log(LogStatus.PASS, "URL is entered as: https://www.gmail.com");
		extentTest.log(LogStatus.PASS, "Data typing action is done on username with testdata: rameshsoft.9177712456");
		extentTest.log(LogStatus.PASS, "Clicked on next button");
		extentTest.log(LogStatus.PASS, "Data typing action is done on password with testdata: 123456789");
		extentTest.log(LogStatus.PASS, "Clicked on signin button");
		
		er.endTest(extentTest);
		er.flush();
		er.close();

	}
}
