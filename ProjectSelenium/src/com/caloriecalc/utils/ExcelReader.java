package com.caloriecalc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Object[][] ReadExcelDataToObjArr(String filepath,String filename,String sheetname) throws IOException{
		//to open the file in an input format - read format 
		//FileInputStream
		//one for reading from xlsx files another for xls
		//xlsx -->XSSFWorkbook and xls --> HSSFWorkbook
		
		FileInputStream inputStream  = new FileInputStream(new File(filepath + "/" + filename));
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		//row count
		System.out.println("Row Count : " + sheet.getLastRowNum());
		int rowcount = sheet.getLastRowNum();
		//declaring a two dimensional array
		Object[][] obj = new Object[rowcount][1];
		Hashtable<String,String> record = null;
		//KeysRow 
		Row keyrow = sheet.getRow(0);
		for(int r =1;r <rowcount+1;r++) //rowcount does not include headerrow
		{
			record = new Hashtable<String,String>();
			Row datarow = sheet.getRow(r);			
			for(int c=0;c <datarow.getLastCellNum();c++){
				String key = keyrow.getCell(c).getStringCellValue();
				String val = datarow.getCell(c).getStringCellValue();
				record.put(key,val);
			}
			obj[r-1][0] = record;
		}
		return obj;
	}
	
	public static void ReadExcelData(String filepath,String filename,String sheetname) throws IOException{
		//to open the file in an input format - read format 
		//FileInputStream
		//one for reading from xlsx files another for xls
		//xlsx -->XSSFWorkbook and xls --> HSSFWorkbook
		
		FileInputStream inputStream  = new FileInputStream(new File(filepath + "/" + filename));
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		//row count
		System.out.println("Row Count : " + sheet.getLastRowNum());
		int rowcount = sheet.getLastRowNum();
		
		for(int r =0;r <rowcount+1;r++) //rowcount does not include headerrow
		{
			Row row = sheet.getRow(r);
			for(int c=0;c <row.getLastCellNum();c++){
				Cell cell = row.getCell(c);
				System.out.print(cell.getStringCellValue() + "\t");
			}
			System.out.println("");
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		String filepath= System.getProperty("user.dir")+"/src/com/caloriecalc/testdata";
		String filename="CalorieData.xlsx";
		String sheetname ="CalorieTestSet";
		//ExcelReader.ReadExcelDataToObjArr(filepath, filename, sheetname);
		ExcelReader.ReadExcelData(filepath, filename, sheetname);
	
	}

}
