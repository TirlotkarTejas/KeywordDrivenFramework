package com.keywordframework.keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.keywordframework.basetest.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebKeywords extends BaseTest{
	
	private WebDriver driver;
	 //We are getting driver from BaseTest class
	 // Constructor to initialize driver
    public WebKeywords() {
        this.driver = BaseTest.getDriver();
    }

	
//	WebDriver driver;
    public void openBrowser() {
       // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //Manual downloaded chromedriver required
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void enterText(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void verifyText(String locator, String expectedText) {
        WebElement element = driver.findElement(By.xpath(locator));
        assert element.getText().equals(expectedText) : "Text verification failed!";
    }

    public void closeBrowser() {
        driver.quit();
    }

}
