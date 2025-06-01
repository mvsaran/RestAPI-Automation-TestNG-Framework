# RestAPI-Automation-TestNG-Framework

A robust and scalable **REST API Automation Testing Framework** built with Java, TestNG, Maven, and Rest Assured. This framework supports **data-driven testing** using Excel, integrates detailed reporting via **ExtentReports**, and includes **logging with Log4j2** and **properties-driven configuration** for maximum maintainability.

## 🔧 Tech Stack & Tools

- Java 21 (compatible with earlier versions if configured)
- Maven (build & dependency management)
- TestNG (test runner & assertions)
- Rest Assured (REST API testing)
- Apache POI (Excel-based data-driven testing)
- ExtentReports (HTML test reporting)
- Log4j2 (logging)
- Git & GitHub (version control)
- Excel (test data management)
- Properties file (configurable endpoints)

---

## 📁 Project Structure

PetStoreAutomation/
│
├── src/
│ ├── test/java/
│ │ └── api/
│ │ ├── endpoints/ # REST endpoints & routes
│ │ ├── payload/ # POJOs for request/response bodies
│ │ ├── test/ # TestNG test classes
│ │ └── utilities/ # Excel utils, data providers
│ └── test/resources/ # log4j2.xml, properties
│
├── testData/ # Excel data files
├── reports/ # ExtentReports output
├── testng.xml # TestNG suite configuration
├── pom.xml # Maven dependencies & build config
└── README.md # Project documentation


---

## ✅ Features

- 🔁 **Data-Driven Tests** from Excel using Apache POI
- 💡 **Centralized Endpoint Configuration** with `.properties` file
- 📋 **Structured TestNG Suites** (`testng.xml`)
- 📊 **HTML Reports** using ExtentReports
- 🔐 **Robust Logging** with Log4j2
- 📦 **Modular Design** using Page Object Model (POM) structure
- 🧪 Easy **test management and execution** via Maven CLI

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/mvsaran/RestAPI-Automation-TestNG-Framework.git
cd RestAPI-Automation-TestNG-Framework
