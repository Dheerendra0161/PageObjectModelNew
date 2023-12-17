package com.test.qa;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	@Test
	public void Brokenlinks() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://toolsqa.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement l : links) {
			String url = l.getAttribute("href");
			URL link = new URL(url);
			System.out.println(link);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println("This is a Broken Links:" + url + ":" + responseCode);
			} else {
				System.out.println("This is not a Broken Links:" + url + ":" + responseCode);
			}

		}

	}
}
