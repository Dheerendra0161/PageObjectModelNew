package UtilsFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public  Base() throws IOException {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\DHEERENDRA\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\propertiesFile\\propertiesFile.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public WebDriver LaunchingWebBrowser(String browser) {

		switch (prop.getProperty("browser")) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		case "edge": {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case "IEbrowser": {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		case "safari": {
			WebDriverManager.safaridriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		default:
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;

	}

	
}
