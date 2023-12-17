package com.test.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelBrowserTest {

	private WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		// Other setup steps, if any
	}

	@Test
	public void testExample() {
		// Your test logic goes here
		driver.get("https://www.selenium.dev/documentation/");
		WebElement element = driver.findElement(By.xpath("//ul[@class='navbar-nav mr-4 mb-2 mb-lg-0 ps-4 ps-lg-2']//span[text()='Documentation']"));
		String actualText = element.getText();
		String expectedText = "The Selenium Browser Automation Project | Selenium";
		Assert.assertEquals(actualText, expectedText, "Page title doesn't match");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			//driver.quit();
		}
	}
}


/*
 *    <test name="ChromeTest">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="com.test.qa.ParallelBrowserTest"/>
        </classes>
    </test>
    <test name="FirefoxTest">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="com.test.qa.ParallelBrowserTest"/>
        </classes>
    </test>
    <test name="IETest">
        <parameter name="browser" value="ie"/>
        <classes>
            <class name="com.test.qa.ParallelBrowserTest"/>
        </classes>
    </test>
 */









