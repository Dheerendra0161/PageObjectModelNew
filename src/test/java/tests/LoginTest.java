package tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;

	@Test
	public void login() throws Throwable {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		try {
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("LapTop\n Mobile");

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\test-output\\Screenshot.png"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	@Test
	public void reverseNo() {
		String s = "Dheerendra";
		int b = s.length();

		try {
			for (int i = 9; i <= b; i--) {
				System.out.print(s.charAt(i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public static void main(String[] args) {
		String input = "Dheerendra Vishwakarma";
		String reversed = reverseString(input);
		System.out.println("Original String: " + input);
		System.out.println("Reversed String: " + reversed);
	}

	public static String reverseString(String input) {
		char[] charArray = input.toCharArray();
		int start = 0;
		int end = input.length() - 1;
		while (start < end) {
			// Swap characters at start and end positions
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		return new String(charArray);
	}

	@Test
	public void JavaScriptExecutorExample() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		// 1. Scrolling down the page
		driver.get("https://www.sarkariresult.com/2023/uppsc-ro-aro-oct23/");
		org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

//		// 2. Clicking hidden elements
//		WebElement hiddenElement = driver.findElement(By.id("hiddenElement"));
//		js.executeScript("arguments[0].click();", hiddenElement);

		// 3. Handling JavaScript alerts
		js.executeScript("alert('This is a JavaScript alert');");
		driver.switchTo().alert().accept();

		// 4. Handling JavaScript prompts
//		js.executeScript("prompt('Please enter your name:');");
//		String inputText = driver.switchTo().alert().getText();
//		driver.switchTo().alert().sendKeys("John Doe");
//		driver.switchTo().alert().accept();

		// 5. Capturing and analyzing network traffic (outside of Selenium)
		// Capturing network traffic typically involves using browser developer tools or
		// network analysis tools and is not directly done in Selenium.

	}
	
	

}