package abstractcomponent;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class List {
	WebDriver driver;
	WebElement[] elements;
//	 List interface for maintaining the ordered collection. A List can contain the null and duplicate values. The methods of the List are based on the index, so all the operations like insert, delete, update, and search is based on the index.
	
	public void list() {
		ArrayList<String> empName = new ArrayList<String>();
		empName.add("DK");
		empName.add("VK");
		empName.add("DK");
		empName.add("CK");
		empName.add("MK");

		for (String name : empName) {
			System.out.println("EmpName:" + name);
		}
		// assesing by index
		for (int i = 0; i < empName.size(); i++) {
			System.out.println("empName: " + i + ":" + empName.get(i));
		}

	}

	
	public void set() {
		Set<String> cityName = new HashSet<String>();
		cityName.add("New Delhi");
		cityName.add("New Delhi");
		cityName.add("Bangaluru");
		cityName.add("Chennai");
		cityName.add("Mumbai");
		cityName.add("Chandigarh");

		for (String city : cityName) {
			System.out.println("CityName:" + city);
		}

		// use of iteration to get or Access the value
		Iterator<String> iterator = cityName.iterator();

		while (iterator.hasNext()) {
			String city = iterator.next();
			System.out.println(city);
		}

		// *[contains(text(),'TestLink')]

	}

	public List() {

		driver = new FirefoxDriver();
		driver.get("https://www.tutorialspoint.com/testlink/testlink_import_data.htm");
		java.util.List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'TestLink')]"));

		
	}

	public WebDriver handling_WebElement(WebDriver driver) {

		for (WebElement a : elements) {
			String b = a.getText();
			System.out.println(a.getSize());
			System.out.println(b);

		}
		return driver;

	}

	public WebDriver excelfile_Write(WebDriver driver) throws IOException {

		// Create a new Excel workbook and sheet
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("WebElementsData");

		int rowNum = 0;

		
		for (WebElement element : elements) {
			// Extract data from the web element (e.g., element.getText())
			String data = element.getText();

			// Create a new row in the Excel sheet
			Row row = sheet.createRow(rowNum++);

			// Create a cell in the row and set its value
			Cell cell = row.createCell(0);
			cell.setCellValue(data);
		}

		// Save the workbook to a file
		FileOutputStream outputStream = new FileOutputStream(new File("output.xlsx"));
		workbook.write(outputStream);
		outputStream.close();
		return driver;

	}
	

}
