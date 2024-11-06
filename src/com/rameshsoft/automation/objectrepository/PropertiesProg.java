package com.rameshsoft.automation.objectrepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesProg {
	public static void main(String[] args) throws IOException {
		
//FileInputStream fip = new FileInputStream(new File("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\objectrepository\\or_gmail.properties"));
		
		FileInputStream fip = new FileInputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\objectrepository\\or_gmail.properties");
		
		Properties properties = new Properties();
		properties.load(fip);
		
		properties.setProperty("job", "practice");
		properties.setProperty("Hardwork", "job");
		properties.setProperty("java", "practice");
		properties.setProperty("sal", "hike");
		
		properties.store(new FileOutputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\objectrepository\\or_gmail.properties"), "File is saved successfully");
		
		//System.out.println(fip);
		
		
		
		/*un_id 		= identifierID
				un_xpath 	= //input[@id = ' identifierID']
				nxt_id 		= identifierNext
				nxt-xpath 	= //input[@id = 'identifierNext]
				pwd_name 	= password
				pwd_css 	= *[name  = 'password']
				pwd_xpath 	= //*[@name = 'password']
				signin_id 	= passwordNext
				signin_css	= *[id = 'passwordNext'];*/		
		
		/*//FileInputStream fip = new FileInputStream(new File("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\objectrepository\\or_gmail.properties"));
		
		FileInputStream fip = new FileInputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\objectrepository\\or_gmail.properties");
		
		Properties properties = new Properties();
		properties.load(fip);	
		
		
		String idVal = properties.getProperty("un_id");
		System.out.println(idVal);
		
		String unVal = properties.getProperty("un_xpath");
		System.out.println(unVal);
		
		String pwdVal = properties.getProperty("pwd_name");
		System.out.println(pwdVal);
		
		String signinVal = properties.getProperty("signin_id");
		System.out.println(signinVal);
		
		String signinVal1 = properties.getProperty("signin_id456","Job is must");
		System.out.println(signinVal1);
		
		
		String str1 = (String) properties.get("nxt_id");
		System.out.println(str1);
		
		String str2 = (String) properties.getOrDefault("nxt_id456" , "JOB");
		System.out.println(str2);
		
		Set keys = properties.keySet();
		System.out.println(keys);
		
		Set entries = properties.entrySet();
		System.out.println(entries);*/
		
		
	}
}
