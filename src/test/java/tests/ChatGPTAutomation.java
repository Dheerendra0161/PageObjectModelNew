package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import UtilsFile.ExplicitWait;
import UtilsFile.JavaScriptExecutorUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChatGPTAutomation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.chatgpt.com");

		
		Actions actions= new Actions(driver);
		ExplicitWait eWait = new ExplicitWait(driver);
		WebElement login = driver.findElement(By.xpath("//div[contains(text(),'Log in')]"));
		eWait.waitForElementToBeClickable(login);
		actions.doubleClick(login);
//		JavaScriptExecutorUtils js=new JavaScriptExecutorUtils(driver);
//		js.clickElement(login);

		
		
		
		
		
		
		
		
		
//		WebElement checkBox = driver
//				.findElement(By.xpath("//span[@class='ctp-label'] | //span[text()='Verify you are human']"));
//		eWait.waitForElementToBeClickable(checkBox);
//		js.clickElement(checkBox);

//		WebElement emailField = driver.findElement(By.xpath("//input[@class='input cc4a74ec1 cdb740a77']"));
//		eWait.waitForElementToBeClickable(emailField);
//		emailField.sendKeys("dheeruvish1608@gmail.com");
//
//		WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continue']"));
//		eWait.waitForElementToBeClickable(continueButton);
//		continueButton.click();
//
//		WebElement passWordField = driver.findElement(By.xpath("//input[@id='password']"));
//		eWait.waitForElementToBeClickable(passWordField);
//		passWordField.sendKeys("Marikpur@1");
//
//		WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
//		searchInput.sendKeys("What is Webdriver?");
//
//		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
//		searchButton.click();
//		WebElement searchResult = driver.findElement(By.xpath("//div[@class='search-results']"));
//		String searchResponse = searchResult.getText();
//		String expectedResponse = "WebDriver is a tool for automating web application testing.";
//		if (searchResponse.contains(expectedResponse)) {
//			System.out.println("Test passed: Found the correct response.");
//		} else {
//			System.out.println("Test failed: Incorrect response.");
//		}

		//driver.quit();
	}


}
