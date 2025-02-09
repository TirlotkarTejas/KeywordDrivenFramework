package com.keywordframework.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.Test;

import com.keywordframework.basetest.BaseTest;
import com.keywordframework.config.ConfigReader;
import com.keywordframework.keywords.WebKeywords;
import com.keywordframework.utilities.ExcelReader;

public class TestExecutor2 extends BaseTest{
	
@Test
public void TestExecutorEngine2() throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IllegalAccessException   {
	
	  String filePath = ConfigReader.getProperty("datafile");
	  List<List<String>> testSteps = ExcelReader.readExcel(filePath, "Sheet2");

	  WebKeywords actions = new WebKeywords();

      Class<WebKeywords> actionClass = WebKeywords.class;
	  
	  logger.info("Test execution started...");
	  
	  for (List<String> step : testSteps) {
	      String keyword = step.get(0);
	      String locator = step.size() > 1 ? step.get(1) : "";
	      String value = step.size() > 2 ? step.get(2) : "";
	      
	      
	      logger.info(keyword + locator + value);
	      Method method;

          if (locator != null && !locator.isEmpty() && value != null && !value.isEmpty()) {

              method = actionClass.getMethod(keyword, String.class, String.class);

              method.invoke(actions, locator, value);
              
              logger.info("Method with locator and value");

          } else if (locator != null && !locator.isEmpty()) {

              method = actionClass.getMethod(keyword, String.class);

              method.invoke(actions, locator);
              
              logger.info("Method with locator");

          } else if (value != null && !value.isEmpty()) {
        	  
        	  method = actionClass.getMethod(keyword, String.class);

              method.invoke(actions, value);
              
              logger.info("Method with value");
              
          }else {

              method = actionClass.getMethod(keyword);

              method.invoke(actions);
              
              logger.info("Method with no parameters");

          }
          
          
//                                 ==============================================Using Switch Case ==================================================
          

//	      switch (keyword.toLowerCase()) {
////	          case "openbrowser":
////	              actions.openBrowser();
////	              System.out.println("Browser opened " + keyword);
////	              break;
//	          case "navigateto":
//	              actions.navigateTo(value);
//	              break;
//	          case "entertext":
//	              actions.enterText(locator, value);
//	              break;
//	          case "click":
//	              actions.click(locator);
//	              System.out.println("Logged in: " + keyword);
//	              break;
//	          case "verifytext":
//	              actions.verifyText(locator, value);
//	              break;
//	          case "closebrowser":
//	              actions.closeBrowser();
//	              System.out.println("Browser closed: " + keyword);
//	              break;
//	          default:
//	              System.out.println("Invalid keyword: " + keyword);
//	      }
	  }
	  logger.info("Test execution completed.");
  
}

}
