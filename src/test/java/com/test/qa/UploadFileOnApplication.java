package com.test.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileOnApplication {

	public static void main(String[] args) {

		
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://omayo.blogspot.com/");
		
	
	//Upload from local Machines
		//driver.findElement(By.id("uploadfile")).sendKeys("C:\\Users\\DHEERENDRA\\OneDrive\\Desktop\\Interview\\TestNG.docx");
	
	//From the project
	driver.findElement(By.id("uploadfile")).sendKeys(System.getProperty("user.dir")+"\\LocalFile\\Interview Que.docx");
	
	
	
		
	}

}
