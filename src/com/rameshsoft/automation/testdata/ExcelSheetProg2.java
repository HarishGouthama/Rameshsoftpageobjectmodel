package com.rameshsoft.automation.testdata;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetProg2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fip = new FileInputStream("D:\\RameshSoft Automation Testing\\TestData.xls");
		
		Workbook workbook = WorkbookFactory.create(fip);
		
		Sheet sheet = workbook.getSheet("Gmail_Data");
		
		Row row0 = sheet.getRow(0);
		
		Cell cell03 = row0.createCell(3);
		
		cell03.setCellValue("hardwork");
		
		Row row1 = sheet.getRow(1);
		Cell cell12 = row1.createCell(2);
		cell12.setCellValue("Jobs");
		
		Row row4 = sheet.createRow(4);
		
		Cell cell40 = row4.createCell(0);
		
		cell40.setCellValue("practice");
		
		Cell cell41 = row4.createCell(1);
		cell41.setCellValue("jobs");
		
		FileOutputStream fop = new FileOutputStream("D:\\RameshSoft Automation Testing\\TestData.xls");
		
		workbook.write(fop);
		
		workbook.close();
		
	}
}
