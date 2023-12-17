package com.test.qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import abstractcomponent.FetchElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementPresentOrNot {

	@Test
	public void FindElementPresentOrNotOnThePage() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.1mg.com/drugs/avil-25-tablet-69629?wpsrc=Google+Organic+Search");

		List<WebElement> f = FetchElement.findElements("xpath",
				"//div[@class='DrugIndex__index-wrapper___uQ3dq']//ul//li");
		// List<WebElement> f =
		// driver.findElements(By.xpath("//div[@class='DrugIndex__index-wrapper___uQ3dq']//ul//li"));
		for (WebElement elem : f) {
			if (elem.isDisplayed()) {
				System.out.println("Element is present on the Page" + ":" + elem.getText());
			} else {
				System.out.println("Element is not present" + ":" + elem.getText());
			}
		}
	}
}
