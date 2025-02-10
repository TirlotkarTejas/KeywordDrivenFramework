package com.keywordframework.keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.keywordframework.basetest.BaseTest;
import com.keywordframework.utilities.ReportManager;

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
        System.out.println("Extent report before logPass");
        ReportManager.logPass("Opened browser");
        System.out.println("Extent report after logPass");
    }

    public void navigateTo(String url) {
        driver.get(url);
        ReportManager.logPass("Navigated to " + url);
    }

    public void enterText(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
        ReportManager.logPass("Entered text: " + value);
    }

    public void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
        ReportManager.logPass("Clicked on element");
    }

    public void verifyText(String locator, String expectedText) {
        WebElement element = driver.findElement(By.xpath(locator));
        assert element.getText().equals(expectedText) : "Text verification failed!";
        ReportManager.logPass("Verified text: " + expectedText);
    }

    public void closeBrowser() {
        driver.quit();
        ReportManager.logPass("Closed browser");
    }

}
