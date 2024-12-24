
# Automated Testing Framework

## **Overview**
This project is an automated testing framework designed for both API and UI testing using modern tools and best practices. The framework is built with:

- **API Testing**: REST Assured
- **UI Testing**: Playwright
- **Logging**: Log4j
- **Configuration Management**: Centralized with `config.properties`
- **TestNG**: For test execution and management
- **Lombok**: For reducing boilerplate code

The framework adheres to principles like **SOLID**, **DRY**, and **KISS**, ensuring maintainability, scalability, and readability.

---

## **Technologies Used**

- **Java 11+**
- **Playwright**: UI testing framework for cross-browser automation
- **REST Assured**: For API testing
- **TestNG**: Test execution and reporting
- **Log4j**: Centralized logging
- **Maven**: Build and dependency management
- **Lombok**: Simplifies Java class structure

---

## **Getting Started**

### Prerequisites

1. **Java 11+**: Ensure Java is installed and `JAVA_HOME` is set.
2. **Maven**: Install Maven for dependency management.
3. **Playwright**: Ensure dependencies are installed by running the following command:

   ```bash
   mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
   ```

---

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```

---

## **Configuration**

### Configuration File
The `config.properties` file located in `src/main/resources` contains configurable values such as URLs, API keys, and other settings.

**Example:**
```properties
example.url=https://example.com
api.base.url=https://jsonplaceholder.typicode.com
```

### Log4j Configuration
Logging is configured in `src/main/resources/log4j2.xml`.

---

## **Running Tests**

### Run All Tests
Execute the following command to run all tests:
```bash
mvn clean test
```

### Run Specific Test Suite
Specify the `testng.xml` file:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## **Features**

### 1. API Testing
- **GET Request Test**: Verify the response status code and content of `https://jsonplaceholder.typicode.com/posts/1`.
- **POST Request Test**: Validate resource creation with a `POST` request to `https://jsonplaceholder.typicode.com/posts`.

### 2. UI Testing
- Open `https://example.com` and validate the page title is "Example Domain".
- Uses Playwright for fast and reliable browser automation.

### 3. Logging
- Centralized logging for all interactions (API and UI) using Log4j.
- Logs are saved in `logs/test.log` and also printed to the console.

---

## **Examples**

### Example API Test
```java
@Test
public void testGetPostById() {
    ApiResponse response = ApiClient.get("/posts/{id}", Map.of("id", 1));
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertNotNull(response.jsonPath().getString("title"));
}
```

### Example UI Test
```java
@Test
public void testExamplePageTitle() {
    ExamplePage examplePage = ExamplePage.create(page);
    examplePage.open();
    Assert.assertEquals(examplePage.getTitle(), "Example Domain");
}
```

---

## **Future Enhancements**
- Add support for parallel execution.
- Integrate Allure for enhanced reporting.
- Expand UI test coverage with more complex scenarios.
- Add API mocking for isolated testing.

---

## **Troubleshooting**

### Common Issues

1. **File Not Found**:
   Ensure `config.properties` is present in `src/main/resources` and copied to `target/classes` during the build.

2. **Playwright Dependency Issues**:
   Run the following command to ensure dependencies are installed:
   ```bash
   mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
   ```

3. **Logs Not Generated**:
   Check if the `logs` directory exists. If not, create it manually or adjust the `log4j2.xml` configuration.

---

## **Contributing**

1. Fork the repository.
2. Create a new branch for your feature/bug fix.
3. Commit your changes and push them to the branch.
4. Submit a pull request.

---
