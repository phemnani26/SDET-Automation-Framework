# SDET Automation Framework

## Overview

This project is an end-to-end automation framework developed using Selenium WebDriver, REST Assured, Cucumber BDD, and TestNG.

The framework covers:

* UI Automation Testing
* API Automation Testing
* Logging and Reporting
* Retry Mechanism
* Screenshot Capture on Failure

---

## Technologies Used

* Java
* Selenium WebDriver
* REST Assured
* Cucumber BDD
* TestNG
* Maven
* Log4j2
* GitHub

---

## Framework Design

* Page Object Model (POM)
* BasePage Design Pattern
* DriverFactory
* ConfigReader
* WaitUtils
* Retry Analyzer
* Screenshot Utility

---

## OOP Concepts Implemented

### Encapsulation

* Private locators in page classes
* Access through public methods

### Inheritance

* HomePage, CareersPage and JobDetailsPage extend BasePage

### Abstraction

* Page methods hide Selenium implementation details

### Polymorphism

* Common page behavior through BasePage hierarchy

---

## UI Automation Coverage

* Chrome Browser Execution
* Explicit Waits
* Multiple Locator Strategies (ID, LinkText, XPath)
* LabCorp Job Search Validation
* Job Details Validation
* Apply Page Validation

---

## API Automation Coverage

### GET Request

Endpoint:

https://echo.free.beeceptor.com/sample-request?author=beeceptor

Validations:

* Status Code
* Path
* IP
* Headers

### POST Request

Validations:

* Customer Information
* Payment Information
* Product Information
* Status Code

---

## Additional Features

* Log4j2 Logging
* Retry Mechanism
* Screenshot Capture on Failure
* Externalized Configuration
* TestNG Integration

---

## Project Structure

src/main/java

* api
* factory
* pages
* util

src/test/java

* hooks
* runners
* stepdefinitions

src/test/resources

* config
* features

---

## Execution

Run the framework using:

testng.xml

or

mvn test
