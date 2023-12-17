package com.toolsqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SoftWareTesting_TutorialsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//body/div[@class='container-fluid']/div[@class='article-body']/div[@class='row first-row']/div[@class='article-body__left-menu col-auto d-none d-xl-block']/div[@class='article-body__left-menu--wrapper']/ul/li[2]/div[1]/span[1]")
	WebElement SoftWareTestingOption;
	
	
	@FindBy(xpath="(//ul[@class=' active']//li//a[text()='Software Testing' and @title='Software Testing'])[1]")
	WebElement SoftWareTestingOptionInside;
	
	
	@FindBy(xpath="//ul[@class=' active']//a[@title='Manual Testing']")
	WebElement ManualTestingOption;
	
	@FindBy(xpath="//div[@class='toc--menu']//a[text()='Error, Mistake, Fault, Bug & Defect'] ")
	WebElement BugAndDefectOption;

	
	public SoftWareTesting_TutorialsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void SoftWareTestingInside() {
		SoftWareTestingOption.click();
		SoftWareTestingOptionInside.click();
		
	}
	
	public void ManualTesting() {
		SoftWareTestingOption.click();
		ManualTestingOption.click();
	}
	
	public void BugAndDefectOption() {
		SoftWareTestingOption.click();
		BugAndDefectOption.click();
	}

	
	
}
