package com.rameshsoft.automation.supporters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.rameshsoft.automation.customisedexceptions.FrameworkException;

public class ExcelReader {

		private String filePath;
		private FileInputStream fileInputStream;
		private Workbook workbook;
		private Sheet sheet;
		private Row row;
		private Cell cell;
		private String value;
		
		public ExcelReader(String filePath) throws EncryptedDocumentException, IOException
		{
			this.filePath = filePath;
			this.fileInputStream = new FileInputStream(filePath);
			workbook = WorkbookFactory.create(fileInputStream);
		}
		
		public Sheet getSheetObj(String how , String howValue) throws FrameworkException{
			if(workbook!=null) {
				if(how.equalsIgnoreCase("sheetname")) {
					sheet = workbook.getSheet(howValue);
				}
				else if(how.equalsIgnoreCase("index")) {
					int indx = Integer.parseInt(howValue);
					sheet = workbook.getSheetAt(indx);
				}
			}
			else {
				FrameworkException exception = new FrameworkException("Workbook is pointing to null");
				throw exception;
			}
			return sheet;
		}
		
		
		
		public String getCellData(String how, String howValue , int rowNum , int cellNum) throws FrameworkException {
			sheet = getSheetObj(how, howValue);
					if(sheet!=null) {
						row = sheet.getRow(rowNum);
						if(row != null) {
							cell = row.getCell(cellNum);
							if(cell != null) {
								if(cell.getCellType() == CellType.STRING) {
									value = cell.getStringCellValue();
								}
								else if(cell.getCellType() == CellType.BOOLEAN) {
									value = cell.getBooleanCellValue() + "";
								}
								else if(cell.getCellType() == CellType.NUMERIC) {
									value = cell.getNumericCellValue() + "";
							}
						}
					
					else {
						FrameworkException exception = new FrameworkException("Row is pointing to null");
						throw exception;
					}
					}
					else {
						FrameworkException exception = new FrameworkException("Sheet is pointing to null");
						throw exception;
		}
						
					
		}
					return value;
		}
		
		public List<String>  getRowData(String how , String howValue , int rowNum) throws FrameworkException {
			List<String> rowData = new ArrayList<String>();
				sheet = getSheetObj(how, howValue);
				if(sheet != null) {
					row = sheet.getRow(rowNum);
					if(row != null) {
						for(int i = 0 ; i <= row.getLastCellNum() ; i++)
						{
							row.getCell(i);
							if(cell != null) {
								if(cell.getCellType() == CellType.STRING) {
									value = cell.getStringCellValue();
									rowData.add(value);
								}
								else if(cell.getCellType() == CellType.BOOLEAN) {
									value = cell.getBooleanCellValue() + "";
									rowData.add(value);
								}
								else if(cell.getCellType() == CellType.NUMERIC) {
									value = cell.getNumericCellValue() + "";
									rowData.add(value);
							}
						}
						}
					}
					else {
						FrameworkException exception = new FrameworkException("Row is pointing to null");
						throw exception;
					}
				}
				else {
					FrameworkException exception = new FrameworkException("Sheet is pointing to null");
					throw exception;
				}
				return rowData;
		}
		
		public List<String> getSheetData(String how , String howValue) throws FrameworkException {
			List<String> SheetData = new ArrayList<String>();
			getSheetObj(how, howValue);
			for(int i = 0 ; i <= sheet.getLastRowNum() ; i++)
			{
				row = sheet.getRow(i);
				for(int j = 0 ; j < row.getLastCellNum() ; j++) {
					cell = row.getCell(j);
					if(cell != null) {
						if(cell.getCellType() == CellType.STRING) {
							value = cell.getStringCellValue();
							SheetData.add(value);
						}
						else if(cell.getCellType() == CellType.BOOLEAN) {
							value = cell.getBooleanCellValue() + "";
							SheetData.add(value);
						}
						else if(cell.getCellType() == CellType.NUMERIC) {
							value = cell.getNumericCellValue() + "";
							SheetData.add(value);
					}
				}

			}
				
			}
			return SheetData;
		}
		
		public Set<String> getUniqueSheetData(String how , String howValue) throws FrameworkException
		{
			List<String> sheetData = getSheetData(how, howValue);
			Set<String> set = new HashSet<String>(sheetData);
			return set;
			
		}	
		
	}
