# Keyword-Driven Automation Framework

## 📌 Overview
This project is a **Keyword-Driven Automation Framework** built using **Selenium WebDriver, TestNG, Extent Reports, and Apache POI** for test execution and reporting.

## 📁 Project Structure
```
KeywordDrivenFramework/
├── src/main/java
│   ├── com.keywordframework.baseset/BaseTest.java
│   ├── com.keywordframework.config/ConfigReader.java
│   ├── com.keywordframework.keywords/WebKeywords.java
│   ├── com.keywordframework.utilities/ExcelReader.java
│   ├── config/ConfigReader.java
│   ├── keywords/WebKeywords.java
│   ├── com.keywordframework.tests/TestExecutor.java
│
├── src/test/resources/
│   ├── test_data.xlsx
│   ├── config.properties
|   ├── log4j2.xml
│
├── reports/
│   ├── ExtentReport.html
│
├── pom.xml
├── testng.xml
└── README.md
```

## 🛠️ Setup Instructions

### 1️⃣ **Pre-requisites**
- Install **Java (JDK 8+)**
- Install **Maven**
- Download **Chromedriver** and place it in the `drivers/` folder

### 2️⃣ **Clone the Repository**
```sh
git clone https://github.com/TirlotkarTejas/KeywordDrivenFramework.git
cd KeywordDrivenFramework
```

### 3️⃣ **Install Dependencies**
```sh
mvn clean install
```

### 4️⃣ **Project Configuration**
- Update `config.properties` with the correct browser settings.
- Place your test cases in `testdata/TestCases.xlsx`.

## 🚀 Running Tests

### **Run from IDE (Eclipse/IntelliJ)**
- Open `TestExecutor.java` or `TestrunEngine.java`
- Run as **TestNG Test**

### **Run from Command Line**
```sh
mvn test
```

## 📊 Test Execution Reports
- Reports are generated in `reports/ExtentReport.html`

## 📚 Technologies Used
- **Java**
- **Selenium WebDriver**
- **Apache POI (Excel Handling)**
- **Extent Reports (Logging & Reporting)**
- **TestNG (Test Execution)**

## 👨‍💻 Author
[Tirlotkar Tejas](https://github.com/TirlotkarTejas)


