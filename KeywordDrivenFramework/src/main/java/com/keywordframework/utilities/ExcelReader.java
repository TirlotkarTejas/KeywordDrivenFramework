package com.keywordframework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelReader {
	
	 public static List<List<String>> readExcel(String filePath, String sheetName) {
	        List<List<String>> data = new ArrayList<>();
	        try {
	            FileInputStream file = new FileInputStream(new File(filePath));
	            Workbook workbook = WorkbookFactory.create(file);
	            Sheet sheet = workbook.getSheet(sheetName);
	            
	            boolean skipHeader = true;
	            
	            for (Row row : sheet) {
	            	
	            	if (skipHeader) { 
	                    skipHeader = false; // Skip first row and continue
	                    continue;
	                }
	            	
	                List<String> rowData = new ArrayList<>();
	                for (Cell cell : row) {
	                    rowData.add(cell.toString());
	                }
	                data.add(rowData);
	            }
	            workbook.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return data;
	    }

}

