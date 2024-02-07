package com.test.qa;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLink_UsingLogger {

	// private static final Logger logger =
	// LogManager.getLogger(FindBrokenLink_UsingLogger.class);

	public static void main(String[] args) throws IOException {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();	

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// Log info about completing the test
//		logger.info("FindBrokenLinks test completed.");
//
//		// Log a debug message
//		logger.debug("Additional debug information...");
//
//		// Log a fatal error (just for illustration, replace with actual fatal error
//		// scenario)
//		logger.fatal("A fatal error occurred!");

	}
}

























