package com.test.qa;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import UtilsFile.Base;

public class iframe extends Base {
	WebDriver driver;

	public iframe() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = LaunchingWebBrowser("firefox");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void iframeToHandleWindow() {

		// Using WebElement
		WebElement iframe = driver.findElement(By.id("ape_Gateway_desktop-ad-center-1_desktop_iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//a[@class='ad-link absolute z-20 top-0 left-0 right-0 bottom-0']")).click();
		driver.switchTo().defaultContent();

		// We Need to switch to main page before performing action on another iframe.

		// Using the ID
		driver.switchTo().frame("buttonframe");
		// Or using the Name instead
		driver.switchTo().frame("myframe");
		// Now we can click the button
		driver.findElement(By.tagName("button")).click();
		driver.switchTo().defaultContent();

		// By using The Indexes Switches to the second frame.
		driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		driver.switchTo().frame(2);

	}

}
