package com.keywordframework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

private static Properties properties;
    
    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//        // Example usage
//        System.out.println("Browser: " + getProperty("browser"));
//    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
	
}
