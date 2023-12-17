package abstractcomponent;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {
	protected WebDriver driver;

	public Utilities(WebDriver driver) {

		this.driver = driver;
	}

	@Test
	public void Find_Broken_Link() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");

		List<WebElement> links = driver.findElements(By.linkText("a"));
		List<String> brokenLinks = new ArrayList<>();

		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);

			String url = element.getAttribute("href");

			try {
				URL linkURL = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection) linkURL.openConnection();
				httpURLConnection.connect();
				int responsecode = ((HttpURLConnection) httpURLConnection).getResponseCode();

				if (responsecode != 200) {
					System.out.println("BrokenLinks" + url + "(responseCode:" + responsecode + ")");
					brokenLinks.add(url);
				}
				((HttpURLConnection) httpURLConnection).disconnect();

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			driver.quit();

		}

	}

	@Test
	public void printingStringsToDifferentWords() {

		String s1 = "String,Maven,TestNg,jenkins";
		String[] lis = s1.split(",");
		for (String ls : lis) {
			System.out.println(ls);
		}

	}

	@Test
	public void StringBufferExample() {

		String str1 = "Hello ";
		String str2 = "Happy ";
		String str3 = "Holi";

		System.out.println(str1.concat(str2).concat(str3));

//	        StringBuffer stringBuffer = new StringBuffer("Hello");
//	        stringBuffer.append(", ISRO!");
//	        stringBuffer.insert(5, " I Am");
//	        stringBuffer.replace(0, 4, "Hi");
//	        stringBuffer.delete(2, 3);
//	        String result = stringBuffer.toString();
//	        System.out.println(result); // Output: "Hi, Java World!"
	}

	@Test
	public void StaleElementException() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://omayo.blogspot.com/");

		WebElement textBox = driver.findElement(By.id("ta1"));
		textBox.sendKeys("Hello I am Dheerendra");
		WebElement linksClick = driver.findElement(By.linkText("compendiumdev"));
		linksClick.click();
		driver.navigate().back();
		textBox = driver.findElement(By.id("ta1"));
		textBox.clear();
		driver.close();
	}

	@Test
	public void NoSuchElementException() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://omayo.blogspot.com/");
		try {
			WebElement Button = driver.findElement(By.id("but2xys"));
			boolean displayStatus = Button.isDisplayed();
			if (displayStatus) {
				System.out.println("Element is present on the web page");
			}
		} catch (java.util.NoSuchElementException e) {
			{
				System.out.println("Exception" + e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws Throwable {

		try {
			int i = 4 / 0;
		} catch (Throwable e) {
			e.printStackTrace();
			System.err.println("Cause : " + e.getCause());
		}
	}



}
