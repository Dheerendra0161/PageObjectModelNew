package com.test.qa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4J_Logging {
		
		//Log4j is a popular logging framework in Java that can be used to log messages at different levels (info, debug, error, etc.) during the execution of your Selenium scripts. 
		//Step 1: Add Log4j Dependency
		//Step 2: Create a Log4j Configuration File
		
		
		    private static final Logger logger = LogManager.getLogger(Log4J_Logging.class);

		    
		    public static void main(String[] args) {
		        // Set the path to the ChromeDriver executable
		       WebDriverManager.chromedriver().setup();

		        // Initialize ChromeDriver
		        WebDriver driver = new ChromeDriver();

		        try {
		            // Log an info message
		            logger.info("Starting the Selenium script");

		            // Open the web page
		            driver.get("https://demoqa.com/alertsWindows");
		            logger.info("Opened the web page");

		            // Perform actions on the web page
		            driver.findElement(By.xpath("//span[@class='ElementsElements']")).click();
		            logger.info("Clicked on a link");

		            // Perform additional steps...

		        } catch (Exception e) {
		            // Log an error message
		            logger.error("An error occurred: " + e.getMessage());

		        } finally {
		            // Close the browser
		            driver.quit();
		            logger.info("Closed the browser");

		            // Log a final info message
		            logger.info("Selenium script completed");
		        }
		    }
		}


