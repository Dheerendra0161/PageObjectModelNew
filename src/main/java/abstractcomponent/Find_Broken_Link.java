package abstractcomponent;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Find_Broken_Link {
	WebDriver driver;

	@Test
	public void brokenLink() {
		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		List<String> StoreBrokenLinksList = new ArrayList<>();

		for (int i = 0; i < links.size(); i++) {
			// Checking Each & Every Links
			
			//WebElement element = links.get(i);
			String url = links.get(i).getAttribute("href");

//	        for (WebElement link : links) {
//	            String url = link.getAttribute("href");

			try {
				URL linkUrl = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();
				httpURLConnection.connect();

				int responseCode = httpURLConnection.getResponseCode();
				if (responseCode != 200) {
					System.out.println("Broken link: " + url + " (Response Code: " + responseCode + ")");
					StoreBrokenLinksList.add(url);
				}
				httpURLConnection.disconnect();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		driver.quit();

		// Report the broken links or take further action as needed
	}
}
