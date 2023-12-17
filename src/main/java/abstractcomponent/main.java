package abstractcomponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class main {
	WebDriver driver;

	public void run(WebDriver driver) throws IOException {

		this.driver = driver;
		List list = new List();

		list.excelfile_Write(driver);

	}

}
