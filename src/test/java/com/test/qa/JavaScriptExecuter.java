package com.test.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecuter {
	@Test
	public static void javaSricptExecutor() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("https://vajiramandravi.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		// Scroll to the bottom of the page
		// 1.Scroll to the element using JavaScript
		WebElement elementToScroll=driver.findElement(By.xpath("//li[@class='react-multi-carousel-item react-multi-carousel-item--active ']//p[text()='PSIR Enrichment Programme 2024']"));
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
		// 2.Scroll to the bottom of the page using JavaScript
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		// 3.Scroll to the top of the page using JavaScript
		js.executeScript("window.scrollTo(0, 0);");

		
		//Handling Element Visibility or Clickability Issues: "Element is not clickable at point" or "Element click intercepted,
		WebElement element = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 pointer phone css-19co55i']"));
		js.executeScript("arguments[0].click;", element);
		

		
	}

}