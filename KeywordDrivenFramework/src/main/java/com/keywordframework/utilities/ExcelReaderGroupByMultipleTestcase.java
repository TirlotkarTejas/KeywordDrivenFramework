package com.keywordframework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderGroupByMultipleTestcase {
	
	public static Map<String, List<List<String>>> readExcel(String filePath, String sheetName) {
        Map<String, List<List<String>>> testCases = new LinkedHashMap<>();

        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(file)) {
            
            Sheet sheet = workbook.getSheet(sheetName);
            boolean skipHeader = true;

            for (Row row : sheet) {
                if (skipHeader) { // Skip header row
                    skipHeader = false;
                    continue;
                }

                List<String> rowData = new ArrayList<>();
                String testCaseID = row.getCell(0).toString(); // First column is TestCaseID

                for (int i = 1; i < row.getLastCellNum(); i++) { // Read remaining columns
                    rowData.add(row.getCell(i).toString());
                }

                testCases.computeIfAbsent(testCaseID, k -> new ArrayList<>()).add(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return testCases;
    }

}
