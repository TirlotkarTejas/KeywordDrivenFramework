package com.keywordframework.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestExecutor3 {
    public static void main(String[] args) {
        System.out.println("Checking Log4j configuration...");

        Logger logger = LogManager.getLogger(TestExecutor.class);
        logger.info("If this message appears, Log4j is working!");

        System.out.println("Test complete.");
    }
}
