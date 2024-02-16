package com.test.qa;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.toolsqa.pages.SoftWareHomePage;
import com.toolsqa.pages.SoftWareTesting_TutorialsPage;

import UtilsFile.Base;

public class SoftWareTesting_Tutorials extends Base {
	WebDriver driver;
	SoftWareTesting_TutorialsPage stp;

	public SoftWareTesting_Tutorials() throws IOException {
		super();
	}

	@BeforeMethod
	public void browser() {
		driver = LaunchingWebBrowser(prop.getProperty("browser"));
		SoftWareHomePage SHP = new SoftWareHomePage(driver);
		stp = SHP.ClickOnSoftware();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void SoftWareTesting() {
		stp.SoftWareTestingInside();

	}

	@Test
	public void ManualTesting_Text() {
		stp.ManualTesting();
	}
	
	@Test
	public void BugReadingTest() {
		stp.BugAndDefectOption();
	}

}
