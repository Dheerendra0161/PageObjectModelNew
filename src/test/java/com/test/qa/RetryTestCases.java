package com.test.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetryTestCases {
	WebDriver driver;
	@Test(retryAnalyzer =com.test.qa.Retry.class )
	public void test1() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.get("https://www.drishtiias.com/");
		System.out.println(driver.getTitle());//Drishti IAS Coaching in Delhi, Best UPSC Website For IAS Test Series & Study Material
		System.out.println(driver.getCurrentUrl());//https://www.drishtiias.com/
		WebElement a = driver.findElement(By.xpath("//a[@href='https://www.drishtiias.com/prelims-test-series'][text()='English']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.drishtiias.com/prelims-test-series'][text()='English']")));
		a.click();
		
		boolean d = driver.findElement(By.xpath("//a[@href='https://www.drishtiias.com/prelims-test-series'][text()='English']")).isDisplayed();
		System.out.println(d);//True     (isDisplyed method is used to check the element is present in DOM or not)
	 
	System.out.println(driver.findElement(By.xpath("//a[@href='https://www.drishtiias.com/prelims-test-series'][text()='English']")).getCssValue("font-weight")
	);//700
	driver.quit();
	
	}
	
	
	public void Retry() {
		
	}
}
