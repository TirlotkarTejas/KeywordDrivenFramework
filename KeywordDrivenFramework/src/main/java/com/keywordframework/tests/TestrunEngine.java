package com.keywordframework.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.keywordframework.basetest.BaseTest;
import com.keywordframework.config.ConfigReader;
import com.keywordframework.keywords.WebKeywords;
import com.keywordframework.utilities.ExcelReaderGroupByMultipleTestcase;
import com.keywordframework.utilities.ReportManager;

public class TestrunEngine extends BaseTest{
	
	private static final Logger logger = LogManager.getLogger(TestExecutor.class);
	
	 @BeforeSuite
	    public void setupReport() {
	        ReportManager.initializeReport();
	        System.out.println("==========================================");
	        System.out.println("Extent report initiated");
	        System.out.println("==========================================");
	    }
	 
//	 @BeforeTest
//	    public void startTest() {
//	        ReportManager.startTest("Login Test");  // ✅ Start a test before logging
//	    }
	 
	 @BeforeMethod
	 public void startTest() {
	        ReportManager.startTest("Login Test");  // ✅ Start a test before logging
	    }

	    @AfterSuite
	    public void tearDownReport() {
	        ReportManager.finalizeReport();
	    }

    @DataProvider(name = "testCasesProvider")
    public Object[][] getTestCases() {
        // Read test cases from Excel
        String filePath = ConfigReader.getProperty("datafile");
        Map<String, List<List<String>>> testCases = ExcelReaderGroupByMultipleTestcase.readExcel(filePath, "Sheet1");

        // Convert test case map into a 2D array for DataProvider
        Object[][] data = new Object[testCases.size()][2];
        int index = 0;

        for (Map.Entry<String, List<List<String>>> entry : testCases.entrySet()) {
            data[index][0] = entry.getKey();  // TestCaseID
            data[index][1] = entry.getValue(); // List of test steps
            index++;
        }
        return data;
    }

    @Test(dataProvider = "testCasesProvider")
    public void executeTest(String testCaseID, List<List<String>> testSteps) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IllegalAccessException {
        logger.info("Executing Test Case: " + testCaseID);
        executeTestSteps(testSteps);
        logger.info("Completed Test Case: " + testCaseID);
    }

    private void executeTestSteps(List<List<String>> testSteps) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IllegalAccessException{
    	WebKeywords actions = new WebKeywords();
  	  Class<WebKeywords> actionClass = WebKeywords.class;

        for (List<String> step : testSteps) {
            String keyword = step.get(0);
            String locator = step.size() > 1 ? step.get(1) : "";
            String value = step.size() > 2 ? step.get(2) : "";
            
            logger.info(keyword + locator + value);
  	      
  	      Method method;

            if (locator != null && !locator.isEmpty() && value != null && !value.isEmpty()) {

                method = actionClass.getMethod(keyword, String.class, String.class);

                method.invoke(actions, locator, value);

            } else if (locator != null && !locator.isEmpty()) {

                method = actionClass.getMethod(keyword, String.class);

                method.invoke(actions, locator);

            } else if (value != null && !value.isEmpty()) {
          	  
          	  method = actionClass.getMethod(keyword, String.class);

                method.invoke(actions, value);  
            }else {

                method = actionClass.getMethod(keyword);

                method.invoke(actions);
            }
            
            
        }
    }

}
