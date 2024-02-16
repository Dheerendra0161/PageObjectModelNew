package UtilsFile;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtils {
	WebDriver driver;
	static JavascriptExecutor js;

	public JavaScriptExecutorUtils(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;

	}

	// Click on an element using JavaScriptExecutor
	public static void clickElement(WebElement element) {

		js.executeScript("arguments[0].click();", element);
	}

	// Scroll to the specified element using JavaScriptExecutor
	public static void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Execute JavaScript code
	public static void executeJavaScript(String script) {
		js.executeScript(script);
	}

	// Get the text of the page using JavaScriptExecutor
	public static String getPageText() {
		return (String) js.executeScript("return document.documentElement.innerText;");
	}

	// Highlight an element using JavaScriptExecutor
	public static void highlightElement(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
}
