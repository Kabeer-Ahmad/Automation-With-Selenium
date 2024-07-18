# Automation-With-Selenium
Selenium project for automated testing of Daraz.pk website using Java and ChromeDriver.

This project is an automated testing framework for the Daraz.pk website using Selenium and Java. The tests include searching for products, filtering by brand and price range, and verifying if free shipping is available.

## Project Structure
Project1/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── pageObjects/
│ │ ├── HomePage.java
│ │ └── SearchResultsPage.java
│ └── test/
│ └── java/
│ └── testCases/
│ └── TestCases.java
├── pom.xml
└── README.md


### Description of Files

- **`src/main/java/pageObjects/HomePage.java`**: Page Object Model class for the home page.
- **`src/main/java/pageObjects/SearchResultsPage.java`**: Page Object Model class for the search results page.
- **`src/test/java/testCases/TestCases.java`**: Test case class containing the tests.
- **`pom.xml`**: Maven configuration file.
- **`README.md`**: Project documentation.

## Prerequisites

- Java Development Kit (JDK)
- Maven
- ChromeDriver
- A web browser (Google Chrome)

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/YOUR_USERNAME/Automation-With-Selenium.git

2. **Navigate to the project directory:**
   cd Project1

3. **Open the project in your IDE.**

4. **Update the path to ChromeDriver in src/test/java/testCases/TestCases.java:**
   System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");

5. **Run The TestCase**



