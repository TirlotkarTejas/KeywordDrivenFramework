package com.keywordframework.basetest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

	protected final Logger logger = LogManager.getLogger(this.getClass());
	
//    static {
//        Configurator.initialize(null, "src/test/resources/log4j2.xml");
//    }

	
	 protected static WebDriver driver;
	 
	 @BeforeClass
	    public void setUp() {
	        System.out.println("Initializing Test Execution...");
	        logger.info("This is loggggger");
	        // Initialize WebDriver, ConfigReader, or any required setup
	        // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //Manual downloaded chromedriver required
//	        WebDriverManager.chromedriver().setup();
//	        driver = new ChromeDriver();
//	        driver.manage().window().maximize();
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }
	 
	 public static WebDriver getDriver() {
	        return driver; // Getter method to access driver
	    }

	    @AfterClass
	    public void tearDown() {
	        System.out.println("Closing Test Execution...");
	        // Cleanup or close WebDriver
	        //driver.quit();
	    }
	
}
