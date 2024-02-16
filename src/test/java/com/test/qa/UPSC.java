package com.test.qa;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import UtilsFile.Base;

public class UPSC extends Base {

	WebDriver driver;

	public UPSC() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = LaunchingWebBrowser("firefox");
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void JavaScripExecuter() {

		WebElement w = driver.findElement(By.xpath("(//a[@style='text-decoration:none;'])[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", w);

		WebElement w1 = driver.findElement(By.xpath("//div//h2[text()='Recent updates on Drishti IAS']"));
		j.executeScript("arguments[0].setAttribute('style','background: purple; border: solid 2px red');", w1);
		TakeScreenShotEveryPage(driver, GenerateNewChangedValue());

		

			WebElement w2 = driver.findElement(By.xpath("(//div//a[text()='Optional Subjects'])[1]"));
			j.executeScript("arguments[0].scrollIntoView(true);", w2);
			w2.click();
			
			int maxRetries = 3;
			int retryCount = 0;

			while (retryCount < maxRetries) {
				try {
					WebElement element = driver.findElement(
							By.xpath("//a[text()='Philosophy' and @class='btn-red width-300 orange_theme_button']"));
					element.click();
					break; // If successful, break out of the loop
				} catch (NoSuchElementException e) {
					System.out.println("Element not found. Retrying..."+e.getMessage());
					retryCount++;
				}
//		TakeScreenShotEveryPage(driver, GenerateNewChangedValue());
//		
//		
//		WebElement seriesElement=driver.findElement(By.xpath("(//div[@class='slick-slide slick-current slick-active'])/a"));
//		Set<String>set=new HashSet<String>();
		}

	}

	public void TakeScreenShotEveryPage(WebDriver driver, String srnshot) {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				System.getProperty("user.dir") + "\\test-output\\Screenshot\\DrishtiIAS" + srnshot);
		try {
			org.openqa.selenium.io.FileHandler.copy(screenshotFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String GenerateNewChangedValue() {
		String ScreenShot = "ScreenShot";
		int Random = new Random().nextInt(100);
		return ScreenShot + Random + ".png";
	}
	
	
	

}
