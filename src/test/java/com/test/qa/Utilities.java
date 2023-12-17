package com.test.qa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import abstractcomponent.main;

public class Utilities {

	public com.aventstack.extentreports.ExtentReports ExtentReports() {
		File Extentfile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\ExtentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Extentfile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Practice of Page Object Model");
		sparkReporter.config().setDocumentTitle("POM Reports");
		sparkReporter.config().setTimeStampFormat("DD/MM/YYYY hh/mm/ss");

		com.aventstack.extentreports.ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);

		System.getProperties().list(System.out); // To get all System Out
		extentReport.setSystemInfo("Application URL", "https://toolsqa.com/");
		extentReport.setSystemInfo("os.name", "Windows 10");
		extentReport.setSystemInfo("os.version", "10.0");
		extentReport.setSystemInfo("java.version", "20.0.1");
		extentReport.setSystemInfo("user.country", "India");

		return extentReport;
	}

	public void ScreenShot(WebDriver driver, String testName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir") + ":ScreenShot" + testName + ".png");
		try {
			FileUtils.copyFile(srcFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void GetTestDataFroEexcel(String sheetName) throws EncryptedDocumentException, IOException {
		final String xlsxfilePath = System.getProperty("user.dir") + "\\src\\main\\java\\testData\\PracticeExcel.xlsx";
		// DataFormatter dataformatter = new DataFormatter();
		Workbook workbook = WorkbookFactory.create(new File(xlsxfilePath));
		Sheet sheet1 = workbook.getSheet(sheetName);

		Iterator<Row> rowIterator = sheet1.rowIterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

			}

		}
		// System.out.println(row+cell);

		workbook.close();

	}

	public static Object[][] ReadExcelFile() throws IOException {
		final String xlsxfilePath = System.getProperty("user.dir") + "\\src\\main\\java\\testData\\PracticeExcel.xlsx";

		Workbook workbook = WorkbookFactory.create(new File(xlsxfilePath));
		Sheet sheet = workbook.getSheet("Login");

		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		workbook.close();
		return data;
	}

	public static void main(String[] args) {
		// Test data and test steps defined in a table
		String[][] testData = { { "OpenBrowser", "Chrome" }, { "NavigateTo", "https://example.com" },
				{ "EnterText", "UsernameField", "user1" }, { "EnterText", "PasswordField", "pass1" },
				{ "Click", "LoginButton" }, { "VerifyText", "WelcomeMessage", "Welcome, user1" } };

		for (int i = 0; i < testData.length; i++) {
			for (int j = 0; j < testData[i].length; j++) {
				System.out.print(testData[i][j] + " ");
			}
			System.out.println();
			
			//The size of the matrix is 6 rows by a variable number of columns.

			//Number of rows: 6 (Counted by the number of arrays enclosed in curly braces {}).

			//Number of columns: The number of columns is not fixed, and it varies for each row. The first row has 2 elements, the next three rows have 3 elements, and the last two rows have 3 elements.

			//If you want to find the maximum number of columns in any row, you can iterate through the rows and find the row with the maximum number of elements. In this case, the maximum number of columns is 3.

			//So, the size of the matrix is effectively 6x3, but it's important to note that each row can have a different number of columns.
		}
	}
}
