package com.test.qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleSDropDown {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/cart");
		// selectClass();

		WebElement countryElement = driver.findElement(By.id("input-country"));
		selectOption_From_DropDown_UsingLoop(countryElement, "India");

		WebElement stateElement = driver.findElement(By.id("input-zone"));
		selectOption_From_DropDown_UsingLoop(stateElement, "Delhi");

		driver.quit();
	}

	
	// You can just give the WebElement ele and Value you want to search.
	public static void selectOption_From_DropDown_UsingLoop(WebElement ele, String value) {
		
		Select select = new Select(ele);
		List<WebElement> allOption = select.getOptions();
		for (WebElement countryOption : allOption) {
			if (countryOption.getText().equals(value)) {
				countryOption.click();
				break;
			}
		}
	}

	public static void selectClass() {

		 WebElement countryElement=driver.findElement(By.id("Form_getForm_Country"));
		 Select select=new Select(countryElement);
		 select.selectByIndex(14);
		 select.selectByValue("India");
		 select.selectByVisibleText("India");
	}
}
