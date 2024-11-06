package com.rameshsoft.automation.testdata;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetProg1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fip = new FileInputStream("D:\\RameshSoft Automation Testing\\TestData.xls");
		
		Workbook workbook = WorkbookFactory.create(fip);
		
		Sheet sheet = workbook.getSheet("Gmail_Data");
		
		for(int i = 0 ; i <= sheet.getLastRowNum() ; i++)
		{
			
			Row row = sheet.getRow(i);
			
			for(int j = 0 ; j < row.getLastCellNum(); j++)
			{
				Cell cell = row.getCell(j);
				if(cell.getCellType() == CellType.STRING) {
					String cellValue = cell.getStringCellValue();
					System.out.println(cellValue);					
				}
				else if(cell.getCellType() == CellType.NUMERIC) {
					double d = cell.getNumericCellValue();
					System.out.println(d);
				}
				else if(cell.getCellType() == CellType.BOOLEAN) {
					boolean d = cell.getBooleanCellValue();
					System.out.println(d);
				}
				
			}
		}
		
	}
}
