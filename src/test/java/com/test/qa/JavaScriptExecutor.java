package com.test.qa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

	public static void main(String[] args) {

		WebDriver driver = null;
		
		
		
		
		//Scrolling the Page
		// 1.Scroll to the bottom of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// 2.Scroll to the top of the page
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, 0);");

		// 3.Scroll down by 500 pixels
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0, 500);");

		
		// 4.Scroll horizontally by 200 pixels
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(200, 0);");

		// 5.Scroll to a specific element
		WebElement element = driver.findElement(By.id("elementId"));
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
		
		
		//Handling the Alert
		// 1.Example: Accept an alert
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js.executeScript("window.alert('This is an alert');");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		String alertText = alert.getText();
		
		// 2.Enter text in a prompt
		js.executeScript("prompt('Enter your name:');");
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("John Doe");
		promptAlert.accept();

		// 3.Handling confirmation pop-up
		js.executeScript("confirm('Do you want to proceed?');");
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.accept(); // or confirmAlert.dismiss();

		
		
		
		// Example: Highlight an element by changing its background color
		WebElement element2 = driver.findElement(By.id("exampleId"));
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = 'yellow'", element);

		
		
		
		
		// Click on  hidden element
        WebElement hiddenElement = driver.findElement(By.id("hiddenElementId"));
        JavascriptExecutor js7 = (JavascriptExecutor) driver;
        js7.executeScript("arguments[0].click();", hiddenElement);
        
        
        
        
        
        //Use JavascriptExecutor to Enabling and disabling the element
        WebElement buttonElement = driver.findElement(By.id("buttonId"));

        //1.To disable the button
        JavascriptExecutor js8 = (JavascriptExecutor) driver;
        js8.executeScript("arguments[0].disabled = true;", buttonElement);

        // 2.To enable the button
        js8.executeScript("arguments[0].disabled = false;", buttonElement);


	}

}
