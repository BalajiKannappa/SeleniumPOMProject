package com.qa.automationPractice.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public static String TEST_SHEET_PATH = ".src\\main\\java\\com\\qa\\automationPractice\\testData\\MyAddress.xlsx";
	public static Workbook workbook;
	public static Sheet sheet;
	
	public void getTestData(String sheetName){
		
		try {
			FileInputStream fs  = new FileInputStream(TEST_SHEET_PATH);
			workbook = WorkbookFactory.create(fs);
			sheet = workbook.getSheet(sheetName);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
