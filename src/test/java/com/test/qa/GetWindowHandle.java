package com.test.qa;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetWindowHandle {

	@Test
	public static void setOfWebElement() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.drishtiias.com/");
		driver.findElement(By.xpath("//a[@href='https://www.drishtiias.com/prelims-test-series'][text()='English']"))
				.click();
		
		Set<String> windowHandle = driver.getWindowHandles();
		Iterator<String> iterator = windowHandle.iterator();
		String parantWindow = iterator.next();
		String childtWindow = iterator.next();
		System.out.println("parantWindow:"+parantWindow);
		System.out.println("childtWindow:"+childtWindow);
		driver.switchTo().window(childtWindow);
		
		
//		WebElement element = driver.findElement(By.xpath("//span[text()='Current Affairs']"));
//		Actions action = new Actions(driver);
//		action.moveToElement(element).perform();
//		action.moveToElement(driver.findElement(By.xpath("//a[text()='Mains Special']"))).perform();
//		action.click(driver.findElement(By.xpath("//a[@href='https://www.drishtiias.com/mains-marathon-2023']")));
		
	}
	
	@Test
	public void Youtube() {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://www.youtube.com/");
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
	
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys("@maashanticrack7897");
	driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
	//driver.findElement(By.xpath("(//yt-formatted-string[text()='MAA SHANTI CRACK'])[1]")).click();
	driver.findElement(By.xpath("//span[text()='@maashanticrack7897']")).click();
	
	driver.findElement(By.xpath("//div[@class='yt-tab-shape-wiz__tab yt-tab-shape-wiz__tab--tab-selected'][text()='Videos']")).click();
	
	//driver.findElement(By.xpath("//a[@title='student #विद्यार्थी# जीवन nind Kam time me pura kare']")).click();
    
	WebElement elementToControlClick = 	driver.findElement(By.xpath("//a[@title='student #विद्यार्थी# जीवन nind Kam time me pura kare']"));
    Actions actions = new Actions(driver);
    for (int i =0;i<5;i++) {
    actions.keyDown(org.openqa.selenium.Keys.CONTROL)  // Press the control key
           .click(elementToControlClick)               // Perform the click action
           .keyUp(org.openqa.selenium.Keys.CONTROL)    // Release the control key
           .perform();
    }
	
	}
	
	
	


	

}
