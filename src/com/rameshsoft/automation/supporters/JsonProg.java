package com.rameshsoft.automation.supporters;

/*//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/

import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsonProg {
	public static void main(String[] args) throws IOException, ParseException, JSONException, InterruptedException {
		
		JSONParser parser = new JSONParser();
		
		FileReader fr = new FileReader("D:\\RameshSoft2directory\\Rameshsoft-PageObjectFramework\\or.json");
		
		Object object = parser.parse(fr);
		
		JSONObject jsonObject = (JSONObject) object;
		
		//Object obj1 = jsonObject.get("name");
		String str1 = (String) jsonObject.get("name");		
		System.out.println(str1);
		
		String str2 = (String) jsonObject.get("Subject");		
		System.out.println(str2);
		
		String unId = (String) jsonObject.get("un_id");		
		System.out.println(unId);
		
		String nxtId = (String) jsonObject.get("nxt_id");		
		System.out.println(nxtId);
		
		String str4 = (String) jsonObject.get("pwd_name");		
		System.out.println(str4);
			
				
		System.setProperty("webdriver.chrome.driver", "D:\\RameshSoft2directory\\Rameshsoft-PageObjectFramework\\Drivers\\chromedriver.exe");
			
		WebDriver driver = new ChromeDriver();				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();				
		driver.get("https://www.gmail.com");
				
		//identify the element
		WebElement un = driver.findElement(By.id("identifierId"));
				
		//2. Perform the action
		un.clear();
		un.sendKeys("rameshsoft.9177791456@gmail.com");
		
		WebElement nxt = driver.findElement(By.id(nxtId));
		nxt.click();
				
		Thread.sleep(5000);
		
		driver.close();
				
				
				
				   


	
	}          
}
