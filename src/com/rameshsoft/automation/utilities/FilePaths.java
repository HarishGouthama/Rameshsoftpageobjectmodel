package com.rameshsoft.automation.utilities;

import com.rameshsoft.automation.base.BaseTest;

public interface FilePaths {
	
	String txtPath  = BaseTest.getPath() + "\\job.txt";
	String orPath   = BaseTest.getPath() + "\\src\\com\\rameshsoft\\automation\\objectrepository\\or_gmail.properties";
	String confPath = BaseTest.getPath() + "\\config.properties";
	String jsonPath = BaseTest.getPath() + "\\or.json";
	String excelPath = BaseTest.getPath() + "\\TestData.xls";
	
	
}
