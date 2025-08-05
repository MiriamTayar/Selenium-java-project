# 🛒 Selenium Java Automation Project – E-commerce Testing Suite

## 📌 Overview

This project automates the testing of an e-commerce website using **Java**, **Selenium WebDriver**, and **JUnit**.  
It simulates real user actions such as:

- Logging into a user account
- Browsing product categories (Baby, Accessories, Kitchenware, etc.)
- Adding products to the shopping cart
- Switching site language
- Filling out a checkout form
- Performing a mock payment (credit card flow)

The automation framework is built using the **Page Object Model (POM)** pattern to enhance reusability, maintainability, and clarity.

---

## 🧰 Technologies Used

- Java (OOP)
- Selenium WebDriver
- JUnit
- ExtentReports
- ChromeDriver
- XPath & CSS Selectors
- JavaScriptExecutor
- Maven (for dependencies and build)

---

## 📂 Project Structure

```
SeleniumJavaProject/
├── src/
│   └── test/
│       └── java/
│           ├── pages/
│           │   ├── HomePage.java
│           │   ├── ProductPage.java
│           │   ├── PaymentPage.java
│           │   └── SignInPage.java
│           ├── tests/
│           │   └── SanityTest.java
│           └── utilities/
│               ├── Constants.java
│               └── Methods.java
├── target/
├── pom.xml
├── config.xml
└── README.md

```

---

---

## ✅ Features Covered

### 🔐 Login Flow
- Navigate to "My Account"
- Input email and password
- (Optional) Submit login form

### 🏠 Home Page
- Navigate through categories (Kitchenware, Accessories, Spring Home)
- Change site language to Hebrew
- Search for a product via search bar

### 🍼 Product Page
- Navigate to Baby category
- Select product by color and size
- Add item(s) to shopping cart
- View and verify cart contents

### 💳 Payment Page
- Fill complete guest checkout form
- Select credit card as payment method
- Enter card details
- Validate error handling for incorrect card number

---

## 🧪 Test Automation

All tests are managed inside the `SanityTest.java` class and include:

- `@BeforeClass`: Sets up Chrome browser and navigates to homepage
- `@Test`: Contains separate test methods for login, home navigation, product flow, and checkout
- `@AfterClass`: Closes browser after tests are finished

---

## 📊 Reports

Test execution generates HTML reports using **ExtentReports**, saved to `index.html` at the project root.

---

## 🧠 Author

Developed by Miriam Tayar
> Combining technical skill and UI logic to build automated flows for real-world testing.

---

## 📎 Note

This project is for educational and QA practice purposes only. No actual payment is processed.
