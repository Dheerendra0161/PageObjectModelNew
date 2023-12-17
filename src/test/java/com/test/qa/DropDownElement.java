package com.test.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownElement {
	@Test
	public void DropDown() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.makemytrip.com/flights/?gclid=CjwKCAiAu9yqBhBmEiwAHTx5p5ez2Ux9BRF-2w8imb-gLTwei_lV1mDk864x5AAZB8yd7ntJK6rQZRoCmYsQAvD_BwE&cmp=SEM|D|DF|G|Brand|Brand-BrandExact_DT|B_M_Makemytrip_Search_Exact|RSA|673383350836&s_kwcid=AL!1631!3!673383350836!e!!g!!mmt&ef_id=CjwKCAiAu9yqBhBmEiwAHTx5p5ez2Ux9BRF-2w8imb-gLTwei_lV1mDk864x5AAZB8yd7ntJK6rQZRoCmYsQAvD_BwE:G:s&gad_source=1");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']"));
	}
}



