package com.test.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrapperClasses {

	ChromeDriver driver; 
	


	@BeforeMethod
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/");
	}
	

	@Test
	public void DataExtraction() {

		// Suppose you have a WebElement representing a numeric value
		WebElement numericElement = driver.findElement(By.xpath("//span[text()='123456789']"));
		String numericString = numericElement.getText(); // "123"

		// Using Integer wrapper class for conversion
		int numericValue = Integer.parseInt(numericString);

		// Perform numerical operations using the primitive data type
		int updatedValue = numericValue + 10;

		// Display the result
		System.out.println("Updated Value: " + updatedValue);

	}
	
	@Test
	public void HandlingNullValue() {
		
		// Suppose you have a WebElement that may or may not have a value
		WebElement nullableElement = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));

		// Using Integer wrapper class to handle null value
		String valueString = nullableElement.getText(); // "" or null
		Integer parsedValue = (valueString != null && !valueString.isEmpty()) ? Integer.parseInt(valueString) : null;

		// Perform actions based on the parsed value
		if (parsedValue != null) {
		    System.out.println("Parsed Value: " + parsedValue);
		} else {
		    System.out.println("Element has no value.");
		}

	}

}
