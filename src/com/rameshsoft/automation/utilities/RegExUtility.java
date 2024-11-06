package com.rameshsoft.automation.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface RegExUtility {

	public static boolean isValidPhNum(String phNum)
	{
		
		boolean status = true;
		Pattern pattern = Pattern.compile("(0|[+]?91)?[6-9][0-9]{9}");
		
		Matcher matcher = pattern.matcher(phNum);
		
		if(matcher.find()&&matcher.group().equalsIgnoreCase(phNum)) {
			System.out.println("Valid phone number");
		}
		else
		{
			System.out.println("Invalid phone number");
			status = false;
		}
		return status;
		
		
		
	}
	
	public static boolean isValidEmail(String email)
	{
		
		boolean status = true;
		Pattern pattern = Pattern.compile("(0|[+]?91)?[6-9][0-9]{9}");
		
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.find()&&matcher.group().equalsIgnoreCase(email)) {
			System.out.println("Valid phone number");
		}
		else
		{
			System.out.println("Invalid phone number");
			status = false;
		}
		return status;
}

}