package com.toolsqa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SoftWareHomePage {
	
	WebDriver driver;

	@FindBy(id = "accept-cookie-policy")
	WebElement cookiesPolicyOption;
	@FindBy(xpath = "//span[@class='navbar__tutorial-menu--text']")
	WebElement tutorialsOption;
	
	@FindBy(xpath="//span[normalize-space()='QA Practices']")
	WebElement QApracticeOption;
	
	@FindBy(xpath="//ul[@class='active']//li[@class='active']")
	WebElement softwareTestingOption;
	
	
	public SoftWareHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public SoftWareTesting_TutorialsPage ClickOnSoftware() {
		Actions actions=new Actions(driver);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-cookie-policy")));
		actions.moveToElement(cookiesPolicyOption).click().build().perform();
		actions.moveToElement(tutorialsOption).click().build().perform();
		actions.moveToElement(QApracticeOption).click().perform();
		actions.moveToElement(softwareTestingOption).click().build().perform();
		return new SoftWareTesting_TutorialsPage(driver);
	}
	

}
