package com.test.qa;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");

		List<WebElement> ele = driver.findElements(By.tagName("a"));
		for (WebElement links : ele) {
			String url = links.getAttribute("herf");

			URL linkURL = new URL(url);
			HttpURLConnection httpConnection = (HttpURLConnection) linkURL.openConnection();
			httpConnection.connect();

			int responseCode = httpConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println("BrokenLinks:" + url);
				List<String> link = new ArrayList<>();
				link.add(url);
			}
			httpConnection.disconnect();
		}
		driver.close();

	}
}
