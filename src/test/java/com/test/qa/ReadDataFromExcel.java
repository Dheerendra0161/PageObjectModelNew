package com.test.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataFromExcel {

	@DataProvider(name = "ExcelTestData")
	public static Object[][] readExcel(String sheetName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\testData\\DataProvider.xlsx";
		FileInputStream fileInputStream = new FileInputStream(new File(filePath));
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount - 1][colCount];

		// Start reading from the second row
		for (int r = 1; r < rowCount; r++) {
			Row row = sheet.getRow(r);
			for (int c = 0; c < colCount; c++) {
				Cell cell = row.getCell(c);
				// Handle different cell types
				switch (cell.getCellType()) {
				case STRING:
					data[r - 1][c] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[r - 1][c] = cell.getNumericCellValue();
					break;
				case BOOLEAN:
					data[r - 1][c] = cell.getBooleanCellValue();
					break;
				default:
					data[r - 1][c] = null;
				}
			}
		}

		// Close the workbook and input stream
		workbook.close();
		fileInputStream.close();

		return data;
	}

	@Test(dataProvider = "ExcelTestData")
	public void loginTestData(String userID, String password, String name) {
		System.out.println(userID + ":" + password + ":" + name);
	}

	
	
	public static void main(String[] args) {

		try {
			Object[][] excelData = readExcel("Login");

			// Display the data
			for (Object[] row : excelData) {
				for (Object cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
