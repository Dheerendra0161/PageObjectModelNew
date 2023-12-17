package com.test.qa;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesHandle {
	public static void main(String[] args) {
		
		// Set the path to the ChromeDriver executable
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://testng.org/doc/documentation-main.html");

		// Add a new cookie
		Cookie newCookie = new Cookie("cookieName", "cookieValue");
		driver.manage().addCookie(newCookie);

		// Get all cookies
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie cookie : allCookies) {
			System.out.println("Cookie Name: " + cookie.getName());
			System.out.println("Cookie Value: " + cookie.getValue());
			System.out.println("Domain: " + cookie.getDomain());
			System.out.println("Path: " + cookie.getPath());
			System.out.println("Expiry: " + cookie.getExpiry());
			System.out.println("Secure: " + cookie.isSecure());
			System.out.println("=================================");
		}

		// Delete a cookie by name
		driver.manage().deleteCookieNamed("cookieName");

		// Delete all cookies
		driver.manage().deleteAllCookies();
		System.out.println();
		
	}
}











