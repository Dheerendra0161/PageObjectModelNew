package com.test.qa;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DataProvider {
	
	//*********************************
	// if you need to pass different parameters for each invocation, you can use the
	// dataProvider attribute along with a data provider method.
	
	
	@org.testng.annotations.DataProvider(name = "testData")   //name =" must be method name"
	public Object[][] testData() {
		
		//return new Object[][] { { "DK", "123" }, { "VK", "132" }, { "SK", "321" } };
		
		
		Object[][] data= {{"Dheerendra",123},{"Vikas",321},{"Vivek",213}};
		return data;
				
	}

	@Test(dataProvider = "testData")
	public void runTestData(String name,int value) {
		System.out.println("Employee Name:"+name+","+" Employee value:"+value);
		

	}
	
	
	
	
	
	
	

	@Test(dataProvider = "provideData")
	public void Login(String username, String Password, String Name) {
		System.out.println(username + ":" + Password);

	}

	@org.testng.annotations.DataProvider(name="provideData")
	public Object[][] provideData() throws EncryptedDocumentException, IOException {

		Object[][] data = excelData("Login");
		return data;

	}

	public static Object[][] excelData(String sheetName) throws EncryptedDocumentException, IOException {
		final String pathExcel = System.getProperty("user.dir") + "\\src\\main\\java\\testData\\DataProvider.xlsx";
		Workbook workbook = WorkbookFactory.create(new File(pathExcel));
		Sheet sheet = workbook.getSheet(sheetName);

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

}

//for (int i = 1; i <= rows; i++) {
//LoginValue = sheet.getRow(i).getCell(1).toString().trim();
//Object[] rowData = new Object[columnCount];
//PasswordValue = sheet.getRow(i).getCell(2).toString().trim();
//System.out.println("Login: " + LoginValue + ", Password: " + PasswordValue);
//data.add(PasswordValue);
//}

