package com.test.qa;

import org.apache.poi.ss.usermodel.*;

public class ExcelReadingUsingOverriding {

	// Method to read data from Excel by sheet name
	public void readExcelData(String filePath, String sheetName) {
		// Logic to read data from Excel by sheet name
		// ...
		System.out.println("Reading data from Excel sheet: " + sheetName);
	}

	// OverLoading OOPs.

	// Method to read data from Excel by sheet index
	public void readExcelData(String filePath, int sheetIndex) {
		// Logic to read data from Excel by sheet index
		// ...
		System.out.println("Reading data from Excel sheet at index: " + sheetIndex);
	}

	public static void main(String[] args) {
		ExcelReadingUsingOverriding excelReader = new ExcelReadingUsingOverriding();

		// Reading data from Excel by sheet name
		excelReader.readExcelData("path/to/excelFile.xlsx", "Sheet1");

		// Reading data from Excel by sheet index
		excelReader.readExcelData("path/to/excelFile.xlsx", 0);
	}
}
