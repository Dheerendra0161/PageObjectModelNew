package com.test.qa;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import UtilsFile.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElement extends Base {
	WebDriver driver;

	public FindElement() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {
		//driver = LaunchingWebBrowser(prop.getProperty("browser"));
	}

	public void tearDown() {
		driver.quit();
	}

	@Test
	public void findElements() {
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='nav-progressive-contents'][@id='nav-xshop']//a"));
		elements.get(0).click();
		//IndexOutOfBoundsException: Index 0 out of bounds for length 0 (if xpath is incorrect)
		
		
		
		
		
//		for (WebElement elem : elements) {
//			if (elem.getText().length() != 0) {
//				System.out.println(elem.getText());
//				
//				Actions action = new Actions(driver);
		// action.keyDown(Keys.CONTROL).click(elem).perform();
		// action.keyDown(Keys.CONTROL).click(elem).keyUp(Keys.CONTROL).perform();
	}

	@Test
	public void findElement() {
		//driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestseller']")).click();
		// NoSuchElementException(if xpath is incorrect)
		
	
		
		
	}
	@Test
	public void findElements1() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		
		driver.get("https://demoqa.com/radio-button");
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='element-list collapse show']//ul//li"));
		for(int i=0;i<element.size();i++) {
		
		//System.out.println(element.get(i));   //OutPut:[[FirefoxDriver: firefox on WINDOWS (fe72dc6c-d17a-4961-b0ba-3035de3e49e9)] -> xpath: //div[@class='element-list collapse show']//ul//li]

		//System.out.println(element.get(i).getAttribute("id"));  //OutPut:item-1
		System.out.println();
		if(element.get(i).getAttribute("id").equalsIgnoreCase("item-0")) {
			element.get(i).click();
		}
	
	
	}

}
	
}
