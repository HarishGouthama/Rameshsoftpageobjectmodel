package com.rameshsoft.automation.appln.businessscripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.reflect.Method;

import com.rameshsoft.automation.base.BaseTest;
import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.rameshsoft.automation.reports.*;

public class GmailTest extends BaseTest{
	ExtentReports extentReports; 
	ExtentTest extentTest;
	
	@Test
	public void gmailLoginTest() throws IOException, FrameworkException {
		String unData = "";
		//BaseTest.getDriver().get("https://www.gmail.com");
		
		/*FileInputStream fipConf = new FileInputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\config.properties");
		Properties prConf = new Properties();
		prConf.load(fipConf);
		String url = prConf.getProperty("qa_url");		
		getDriver().get(url);*/
		
		String url = PojoReader.getConfPrObj().getValue("qa_url");
		getDriver().get(url);
		
		getExtentTest().log(LogStatus.PASS,"URL is entered as: "+PojoReader.getConfPrObj().getValue("qa_url"));
		
		//getDriver().get(PojoReader.getConfPrObj().getValue("qa_url"));
		
		
		/*FileInputStream fip = new FileInputStream("D:\\RameshSoft Automation Testing\\TestData.xls");
		
		Workbook workbook = WorkbookFactory.create(fip);
		
		Sheet sheet = workbook.getSheet("Gmail_Data");
		
		Row row = sheet.getRow(0);
		
		Cell cell = row.getCell(0);
		
		if(cell.getCellType() == CellType.STRING) {
			unData = cell.getStringCellValue();
		}
		else if(cell.getCellType() == CellType.NUMERIC) {
			
		}
		else if(cell.getCellType() == CellType.BOOLEAN) {
			
			
		}*/
		
		/*FileInputStream fipOr = new FileInputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\objectrepository\\or_gmail.properties");
		Properties prOr = new Properties();
		prOr.load(fipOr);
		String unId 	= prOr.getProperty("un_id");
		String nxtId	= prOr.getProperty("nxt_id");*/
		
		
		
		unData = PojoReader.getExcelReader().getCellData("sheetname" , "Gmail_Data" , 0 , 0);
		
		String unId = PojoReader.getOrPrObj().getValue("un_id");
		String nxtId = PojoReader.getOrPrObj().getValue("nxt_id");
		WebElement un = getDriver().findElement(By.name("identifier"));
		//WebElement un = driver.findElement(By.name("identifier"));
		un.clear();
		getExtentTest().log(LogStatus.PASS, "Username is cleared");
		un.sendKeys(unData);
		getExtentTest().log(LogStatus.PASS, "DTA is done on Username with testdata: "+unData);
		
		
		
		WebElement nxt = getDriver().findElement(By.id(nxtId));
		nxt.click();
		getExtentTest().log(LogStatus.PASS, "click action is done on next element: ");

	}
}
