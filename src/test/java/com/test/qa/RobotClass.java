package com.test.qa;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotClass {

	@Test
	public static void TakeScreenshot() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		try {
			// Create a Robot object
			Robot robot = new Robot();

			// Capture the entire screen
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenCapture = robot.createScreenCapture(screenRect);

			// Save the captured screenshot to a file
			File outputFile = new File(System.getProperty("user.dir") + "\\RobotClass\\screenshot.png");
			ImageIO.write(screenCapture, "png", outputFile);

			System.out.println("Screenshot captured and saved to: " + outputFile.getAbsolutePath());
		} catch (AWTException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void MouseMovementRobot() {
		// Setup WebDriver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

		// Simulate mouse movement using Robot class
		try {
			// Wait for the browser to load
			Thread.sleep(3000);

			// Create a Robot object
			Robot robot = new Robot();

			// Simulate moving the mouse to a specific screen position
			int targetX = 500; // Adjust these coordinates based on your screen resolution
			int targetY = 500;
			robot.mouseMove(targetX, targetY);
			System.out.println("Moving mouse to X: " + targetX + ", Y: " + targetY);

			// Simulate a mouse click (left button)
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Close the WebDriver
			driver.quit();
		}
	}

	
	


}
