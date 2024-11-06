package com.rameshsoft.automation.testdata;

//import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//import com.google.common.collect.Table.Cell;

public class ExcelSheetProg {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//FileInputStream fip = new FileInputStream(new File("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\testdata\\TestData.xls"));
		//FileInputStream fip = new FileInputStream("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\testdata\\TestData.xlsx");
		//Workbook workbook = WorkbookFactory.create(fip); 
		
		//File file = new File("C:\\Users\\MuleSoft\\OneDrive\\Desktop\\New folder\\Rameshsoft-PageObjectFramework\\src\\com\\rameshsoft\\automation\\testdata\\TestData.xlsx");
		//Workbook workbook = WorkbookFactory.create(file);
	
		FileInputStream fip = new FileInputStream("D:\\RameshSoft Automation Testing\\TestData.xls");
		Workbook workbook = WorkbookFactory.create(fip);
		
		int noofSheets = workbook.getNumberOfSheets();
		System.out.println("No of sheets are : " + noofSheets);
		
		Sheet sheet = workbook.getSheet("Gmail_Data");
		//Sheet sheet = workbook.getSheetAt(0);
		
		int indx = workbook.getSheetIndex("Gmail_indx");
		System.out.println("Gmail_Data index is: "+indx);
		
		String sheetName = workbook.getSheetName(0);
		System.out.println("0th index sheet name is: " + sheetName);
		
		int noofRows = sheet.getLastRowNum();
		System.out.println("No of rows are: " + noofRows);
		
		Row row0 = sheet.getRow(0);
		int row0CellCount = row0.getLastCellNum();
		System.out.println("0th row cell cont is: "+row0CellCount);
		
		Cell cell00 = row0.getCell(0);
		String cell00Value = cell00.getStringCellValue();
		System.out.println("0th row 0th cell data is: " + cell00Value);
		
		Cell cell01 = row0.getCell(1);
		String cell01Value = cell01.getStringCellValue();
		System.out.println("0th row 1st cell data is: " + cell01Value);
		
		Cell cell02 = row0.getCell(2);
		String cell02Value = cell02.getStringCellValue();
		System.out.println("0th row 2nd cell data is: "+cell02Value);
		
		Row row1 = sheet.getRow(1);
		int row1CellCount = row1.getLastCellNum();
		System.out.println("Row1 cell count is: "+row1CellCount);
		
		Cell cell10 = row1.getCell(0);
		String cell10Value = cell10.getStringCellValue();
		System.out.println("1st row 0th data is: "+cell10Value);
		
		Cell cell11 = row1.getCell(1);
		String cell11Value = cell11.getStringCellValue();
		System.out.println("1st row 1st cell data is: "+cell11Value);
		
		Row row2 = sheet.getRow(2);
		int row2CellCount = row2.getLastCellNum();
		System.out.println("Row2 cell count is: " + row2CellCount);
		
		Cell cell20 = row2.getCell(0);
		String cell20Value = cell20.getStringCellValue();
		System.out.println("2nd row 0th cell data is: "+cell20Value);
		
		Cell cell21 = row2.getCell(1);
		String cell21Value = cell21.getStringCellValue();
		System.out.println("2nd row 1st cell data is: "+cell21Value);
		
		
		
		/*Sheet sheet = (Sheet) workbook.getSheet("Gmail_Data");
		//Sheet sheet = workbook.getSheetAt(0);
		
		
		int indx = workbook.getSheetIndex("Gmail_Data");
		System.out.println("Gmail_Data index is : " +indx);
		
		String sheetName = workbook.getSheetName(0);
		System.out.println("0th index sheet name is : " + sheetName);
		
		int noofRows = ((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum();
		System.out.println("No of rows are: " +noofRows);
		
		Row row0 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0);
		int row0CellCount = row0.getLastCellNum();
		System.out.println("oth row cell cont is :" +row0CellCount);
		
		Cell cell00 = (Cell) row0.getCell(0);
		String cell00Value = ((org.apache.poi.ss.usermodel.Cell) cell00).getStringCellValue();
		System.out.println("0th row 0th cell data is: "+cell00Value);
		
		Cell cell01 = (Cell) row0.getCell(1);
		String cell01Value = ((org.apache.poi.ss.usermodel.Cell) cell01).getStringCellValue();
		System.out.println("0th row 1st cell data is : " +cell01Value);
		
		Cell cell02 = (Cell) row0.getCell(2);
		String cell02Value = ((org.apache.poi.ss.usermodel.Cell) cell02).getStringCellValue();
		System.out.println("0th  row 2nd cell data is: "+ cell02Value);
		
		Row row1 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(1);
		int row1CellCount = row1.getLastCellNum();
		System.out.println("Row1 cell count is: "+row1CellCount);
		
		Cell cell10 = (Cell) row1.getCell(0);
		String cell10Value = ((org.apache.poi.ss.usermodel.Cell) cell10).getStringCellValue();
		System.out.println("1st row 0th cell data is: " + cell10Value);
		
		Cell cell11 = (Cell) row1.getCell(1);
		String cell11Value = ((org.apache.poi.ss.usermodel.Cell) cell11).getStringCellValue();
		System.out.println("1st row 0th cell data is: " + cell11Value);
		
		Row row2 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(2);
		int row2CellCount = row2.getLastCellNum();
		System.out.println("Row2 cell count is: " + row2CellCount);
		
		Cell cell20 = (Cell) row2.getCell(0);
		String cell20Value = ((org.apache.poi.ss.usermodel.Cell) cell20).getStringCellValue();
		System.out.println("2 nd row 0th cell data is: "+ cell20Value);
		
		Cell cell21 = (Cell) row2.getCell(1);
		String cell21Value = ((org.apache.poi.ss.usermodel.Cell) cell21).getStringCellValue();
		System.out.println("2 nd row 1st cell data is: " + cell21Value);*/
		
	}
	
	
}
