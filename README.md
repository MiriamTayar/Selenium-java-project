# Selenium Java Automation Project – E-commerce Simulation

## Overview
This project automates an online shopping process on a real e-commerce website using **Java**, **Selenium WebDriver**, and **JUnit**.

It simulates user behavior including:
- Logging in
- Navigating product categories
- Adding items to the shopping cart
- Filling out a checkout form
- Completing a payment attempt

The project follows the **Page Object Model (POM)** design pattern for maintainability and readability.

---

## Technologies Used
- Java (OOP)
- Selenium WebDriver
- JUnit
- ExtentReports
- Maven (if added)
- ChromeDriver
- XPath / CSS Selectors
- JavaScriptExecutor

---

## Project Structure

```
Selenium-java-project/
├── src/
│   └── java/
│       ├── pages/
│       │   ├── HomePage.java
│       │   ├── ProductPage.java
│       │   ├── PaymentPage.java
│       │   └── SignInPage.java
│       └── tests/
│           └── SanityTest.java
├── index.html  (Extent Report)
└── README.md
```

---

## Features Tested

### Login Flow
- Enter username and password
- Validate login

### Homepage Navigation
- Navigate through kitchenware, accessories, and seasonal items
- Switch language to Hebrew
- Perform product search

### Product Page
- Select baby product category
- Choose size and color
- Add multiple items to the bag
- Check shopping cart

### Checkout & Payment
- Fill full checkout form
- Choose credit card payment
- Enter card details
- Validate error handling for invalid card

---

## Test Automation

The test runner (`SanityTest.java`) includes:
- `@BeforeClass`: Chrome setup, URL navigation
- `@Test`: Separate test cases per section
- `@AfterClass`: Teardown with `driver.quit()`

---

## Test Reports
Test results are generated with **ExtentReports** and saved as `index.html` in the project root.

---

## Author
Developed by Miriam Tayar
> A QA enthusiast combining code, logic, and design to build automated test flows with clarity and precision.

---

## Note
This project is for learning and testing purposes only. The payment form does not interact with real payment systems.
