package com.test.qa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoockisForLogin {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

        driver.findElement(By.xpath("//input[@id='input-email']"))
              .sendKeys("dheeruvish1608@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']"))
              .sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Specify the file path
        String filePath = System.getProperty("user.dir") + "\\Cookies\\Cookies.properties";
        File file = new File(filePath);
        
        try {
            file.createNewFile(); // Create the file
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter bufferW = new BufferedWriter(fileWrite);

            Set<Cookie> cookiesCK = driver.manage().getCookies();

            for (Cookie ck : cookiesCK) {
                bufferW.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
                            + ck.getExpiry() + ";" + ck.isSecure());
                bufferW.newLine();
            }

            bufferW.close();
            fileWrite.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }

    }
}
