package com.test.qa;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotUsingFirefoxOnly {

	
	@Test
	public void firefox() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver=new FirefoxDriver();
		
		driver.get("https://www.naukri.com/mnjuser/recommendedjobs");
		File file=  driver.getScreenshotAs(OutputType.FILE);
		File file1=new File("C:\\Users\\DHEERENDRA\\eclipse-workspace\\PageObjectModel\\target\\src.png");
		//Here no need to type cast because  getScreenshotas method is written inside the FireFox ,Chromedriver  class
		//We need to typecast only if we have to use the WebDriver Interface method.
		FileUtils.copyFile(file, file1);
		
	}
}


