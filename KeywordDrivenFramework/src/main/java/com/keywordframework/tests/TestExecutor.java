package com.keywordframework.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.keywordframework.basetest.BaseTest;
import com.keywordframework.config.ConfigReader;
import com.keywordframework.keywords.WebKeywords;
import com.keywordframework.utilities.ExcelReader;



public class TestExecutor extends BaseTest{
	
//    private static final Logger logger = LogManager.getLogger(TestExecutor.class);

	
@Test
public void LoginTest() {
	
	  String filePath = ConfigReader.getProperty("datafile");
	  List<List<String>> testSteps = ExcelReader.readExcel(filePath, "Sheet1");

	  WebKeywords actions = new WebKeywords();
	  
	  logger.info("Test execution started...");
	  
	  for (List<String> step : testSteps) {
	      String keyword = step.get(0);
	      String locator = step.size() > 1 ? step.get(1) : "";
	      String value = step.size() > 2 ? step.get(2) : "";

	      switch (keyword.toLowerCase()) {
//	          case "openbrowser":
//	              actions.openBrowser();
//	              System.out.println("Browser opened " + keyword);
//	              break;
	          case "navigateto":
	              actions.navigateTo(value);
	              break;
	          case "entertext":
	              actions.enterText(locator, value);
	              break;
	          case "click":
	              actions.click(locator);
	              System.out.println("Logged in: " + keyword);
	              break;
	          case "verifytext":
	              actions.verifyText(locator, value);
	              break;
	          case "closebrowser":
	              actions.closeBrowser();
	              System.out.println("Browser closed: " + keyword);
	              break;
	          default:
	              System.out.println("Invalid keyword: " + keyword);
	      }
	  }
	  logger.info("Test execution completed.");
}
	
	
//	==============================================Execution without Testng =====================================================
			
			
//	public static void main(String[] args) {
//        String filePath = "resources/test_data.xlsx";
//        List<List<String>> testSteps = ExcelReader.readExcel(filePath, "Sheet1");
//
//        WebKeywords actions = new WebKeywords();
//        
//        for (List<String> step : testSteps) {
//            String keyword = step.get(0);
//            String locator = step.size() > 1 ? step.get(1) : "";
//            String value = step.size() > 2 ? step.get(2) : "";
//
//            switch (keyword.toLowerCase()) {
//                case "openbrowser":
//                    actions.openBrowser();
//                    System.out.println("Browser opened " + keyword);
//                    break;
//                case "navigateto":
//                    actions.navigateTo(value);
//                    break;
//                case "entertext":
//                    actions.enterText(locator, value);
//                    break;
//                case "click":
//                    actions.click(locator);
//                    System.out.println("Logged in: " + keyword);
//                    break;
//                case "verifytext":
//                    actions.verifyText(locator, value);
//                    break;
//                case "closebrowser":
//                    actions.closeBrowser();
//                    System.out.println("Browser closed: " + keyword);
//                    break;
//                default:
//                    System.out.println("Invalid keyword: " + keyword);
//            }
//        }
//    }

}
