# RestAssured API Tests for mock-microservices

This repository contains **API automation tests** for the **[mock-microservices]** (hosted at: [GitHub Repo Link](https://github.com/luvomgulwa/mock-microservices)).

---

## 📌 Overview
- Tests are written using **RestAssured** for HTTP requests.
- Test framework: **TestNG** .
- Validates endpoints of the Spring Boot app running at `http://localhost:8080`.

---

## 🛠️ Prerequisites
1. **Java 17+**
2. **Maven** (for dependency management).
3. **Clone the Spring Boot app** and run it locally (`http://localhost:8080`).
   git clone https://github.com/yourusername/your-springboot-repo.git
   Please see the springboot micro-services README.md for instructions on how to run the project

## 🚀 How to Run Tests
1. **Clone this repository**
   git clone https://github.com/luvomgulwa/mock-microservices.git
   cd micro-services

2. **Run tests with Maven**
   mvn clean test

## 🔧 Dependencies
- RestAssured (API testing)
- TestNG/JUnit (test framework)
- Lombok (optional, for reducing boilerplate)
- Maven Surefire Plugin (test execution)

Check pom.xml for details.

## 📊 Test Reports
After running tests, check:

- Allure reports: target/allure-results/
  Command for executing the report: `mvn io.qameta.allure:allure-maven:serve`
