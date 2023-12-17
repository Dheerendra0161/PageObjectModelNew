package com.test.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageFactoryAnnotaions {

	    // @FindBy: Used to locate a single web element
	    @FindBy(id = "singleElement")
	    private WebElement singleElement;

	    
	    
	    
	    // @FindBys: Used to locate a list of web elements. All criteria must be met.
	    @FindBys({
	            @FindBy(className = "listElementClass"),
	            @FindBy(tagName = "li")
	    })
	    private List<WebElement> listOfElements;

	    
	    
	    
	    
	    // @FindAll: Used to locate a list of web elements. Any criteria must be met.
	    @FindAll({
	            @FindBy(xpath = "//div[@class='anyCriteria1']"),
	            @FindBy(css = "div.anyCriteria2")
	    })
	    private List<WebElement> anyCriteriaElements;
	    
	    
	    

	    public PageFactoryAnnotaions(WebDriver driver) {
	        // Initialize elements using PageFactory
	        PageFactory.initElements(driver, this);
	    }

	    // Methods to interact with elements go here
	    public void clickSingleElement() {
	        singleElement.click();
	    }

	    public int getListOfElementsCount() {
	        return listOfElements.size();
	    }

	    public int getAnyCriteriaElementsCount() {
	        return anyCriteriaElements.size();
	    }
	}


