package abstractcomponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FetchElement {
	static public WebDriver driver;

	public static WebElement findElement(String Type, String ElementValue) {

		switch (Type) {

		case "xpath":
			return driver.findElement(By.xpath(ElementValue));
		case "cssSelector":
			return driver.findElement(By.cssSelector(ElementValue));
		case "id":
			return driver.findElement(By.id(ElementValue));
		case "linkText":
			return driver.findElement(By.linkText(ElementValue));
		case "tagName":
			return driver.findElement(By.tagName(ElementValue));
		case "className":
			return driver.findElement(By.className(ElementValue));

		default:
			return null;

		}
	}

	public static List<WebElement> findElements(String Type, String ElementValue) {

		switch (Type) {

		case "xpath":
			return driver.findElements(By.xpath(ElementValue));
		case "cssSelector":
			return driver.findElements(By.cssSelector(ElementValue));
		case "id":
			return driver.findElements(By.id(ElementValue));
		case "linkText":
			return driver.findElements(By.linkText(ElementValue));
		case "tagName":
			return driver.findElements(By.tagName(ElementValue));
		case "className":
			return driver.findElements(By.className(ElementValue));

		default:
			return null;

		}

	}
}
