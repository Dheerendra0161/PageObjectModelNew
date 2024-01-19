package com.test.qa;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataExcel {

	public static Object[][] readDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\testData\\TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum() + 1; // Add 1 to include the header row
		int totalColumns = sheet.getRow(0).getLastCellNum();

		DataFormatter formatter = new DataFormatter();
		Object[][] testData = new Object[totalRows - 1][totalColumns]; // Exclude the header row

		for (int i = 1; i < totalRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < totalColumns; j++) {
				testData[i - 1][j] = formatter.formatCellValue(row.getCell(j));
			}
		}

		workbook.close();
		return testData;
	}

	public static void main(String[] args) {
		try {
			Object[][] testData = readDataFromExcel("RegistrationTesData");

			// Displaying the read data (for demonstration purposes)
			for (Object[] row : testData) {
				for (Object cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println(); // Move to the next line for a new row
			}

		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
		}
	}
}
