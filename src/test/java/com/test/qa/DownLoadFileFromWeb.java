package com.test.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class DownLoadFileFromWeb {

	public static void main(String[] args) {

		// Set the path where you want to download the file
		String downloadPath = System.getProperty("user.dir") + "l\\LocalFile\\Downloads";

		// Set Firefox preferences
		HashMap<String, Object> firefoxPrefs = new HashMap<>();
		firefoxPrefs.put("download.default_directory", downloadPath);

		// Set up FirefoxOptions
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("browserName", "firefox");
		options.setCapability("moz:firefoxOptions", firefoxPrefs);

		// Instantiate WebDriver with FirefoxOptions
		WebDriver driver = new FirefoxDriver(options);

		// Open the web page where the file download link is present
		driver.get("https://ncert.nic.in/textbook.php?legy1=1-8");
		WebElement element = driver.findElement(By.id("#download"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		driver.quit();
	}

}
