package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class TestCases {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.daraz.pk/");
    }

    @Test
    public void testSearchAndFilter() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchForItem("electronics");
        System.out.println("Successfully searched for 'electronics'.");
        Thread.sleep(5000); // Wait for 5 seconds

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.selectBrand("Xiaomi");
        System.out.println("Successfully selected brand 'Xiaomi'.");
        Thread.sleep(5000); // Wait for 5 seconds

        resultsPage.setPriceRange("500", "5000");
        System.out.println("Successfully set price range from 500 to 5000.");
        Thread.sleep(5000); // Wait for 5 seconds

        int productCount = resultsPage.getProductCount();
        if (productCount > 0) {
            System.out.println("Test Passed: Product count is greater than 0. Count: " + productCount);
        } else {
            System.out.println("Test Failed: Product count is 0.");
        }
        Thread.sleep(5000); // Wait for 5 seconds

        resultsPage.clickFirstProduct();
        System.out.println("Successfully clicked on the first product.");
        Thread.sleep(5000); // Wait for 5 seconds

        boolean freeShipping = resultsPage.isFreeShippingAvailable();
        if (freeShipping) {
            System.out.println("Test Passed: Free shipping is available.");
        } else {
            System.out.println("Test Failed: Free shipping is not available.");
        }
        Thread.sleep(5000); // Wait for 5 seconds
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
