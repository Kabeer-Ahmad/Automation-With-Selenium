package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    By brandsPanel = By.xpath("//*[@id='root']/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div[1]"); // XPath for brands panel
    By brandCheckbox = By.className("ant-checkbox"); // Class name for checkboxes
    By minPrice = By.xpath("//*[@id='root']/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/input[1]"); // XPath for min price input
    By maxPrice = By.xpath("//*[@id='root']/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/input[2]"); // XPath for max price input
    By priceFilterButton = By.xpath("//*[@id='root']/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/button"); // XPath for apply button
    By productArea = By.xpath("//*[@id='root']/div/div[3]/div/div/div[1]/div[2]"); // XPath for product area
    By productItem = By.xpath("//*[@id='root']/div/div[3]/div/div/div[1]/div[2]/div[1]/div"); // XPath for product item
    By productLink = By.xpath("//*[@id='id-a-link']"); // XPath for product with href
    By productCountText = By.xpath("//*[@id='root']/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div"); // XPath for product count text

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBrand(String brandName) {
        WebElement brandsPanelElement = driver.findElement(brandsPanel);
        List<WebElement> checkboxes = brandsPanelElement.findElements(brandCheckbox);
        for (WebElement checkbox : checkboxes) {
            WebElement label = checkbox.findElement(By.xpath("following-sibling::span[1]"));
            if (label.getText().contains(brandName)) {
                checkbox.click();
                break;
            }
        }
    }

    public void setPriceRange(String min, String max) {
        driver.findElement(minPrice).sendKeys(min);
        driver.findElement(maxPrice).sendKeys(max);
        driver.findElement(priceFilterButton).click();
    }

    public int getProductCount() {
        String countText = driver.findElement(productCountText).getText();
        return extractProductCount(countText);
    }

    private int extractProductCount(String text) {
        // Extract the number from the text
        String count = text.split(" ")[0].replace(",", ""); // Assuming the format is "439,069 items found for "electronics""
        return Integer.parseInt(count);
    }

    public void clickFirstProduct() {
        List<WebElement> productList = driver.findElements(productItem);
        if (!productList.isEmpty()) {
            productList.get(0).findElement(productLink).click();
        } else {
            System.out.println("No products found to click on.");
        }
    }

    public boolean isFreeShippingAvailable() {
        return driver.getPageSource().contains("Free Shipping");
    }
}
