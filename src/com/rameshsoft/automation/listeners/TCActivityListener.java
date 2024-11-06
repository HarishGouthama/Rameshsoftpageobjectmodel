package com.rameshsoft.automation.listeners;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rameshsoft.automation.utilities.ScrrenshotUtility;

public class TCActivityListener implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
			System.out.println("TC is completed ");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("TC is failed: " + result.getName());
		try {
			ScrrenshotUtility.takeScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("TC is skipped: " + result.getName());
		try {
			ScrrenshotUtility.takeScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TC is started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TC is success: " + result.getName());
		}
	
}
