package com.rameshsoft.automation.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;

import com.rameshsoft.automation.supporters.ExcelReader;
import com.rameshsoft.automation.supporters.JsonReader;
import com.rameshsoft.automation.supporters.PropertiesReader;
import com.rameshsoft.automation.supporters.TextReader;

public class PojoReader {
	
	public static PropertiesReader getOrPrObj() throws IOException {
		PropertiesReader pr = new PropertiesReader(FilePaths.orPath);
		return pr;
	}
	
	public static PropertiesReader getConfPrObj() throws IOException 
	{
		PropertiesReader prConf = new PropertiesReader(FilePaths.confPath);
		return prConf;
	}
	
	public static ExcelReader getExcelReader() throws EncryptedDocumentException, IOException
	{
		ExcelReader er = new ExcelReader(FilePaths.excelPath);
		return er;
		
	}
	
	public static TextReader getTextReader() throws IOException
	{
		TextReader textReader = new TextReader(FilePaths.txtPath);		
		return textReader;
		
	}
	
	public static JsonReader getJsonObj() throws FileNotFoundException, IOException, ParseException
	{
		JsonReader jsonReader = new JsonReader(FilePaths.jsonPath);
		return jsonReader;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
