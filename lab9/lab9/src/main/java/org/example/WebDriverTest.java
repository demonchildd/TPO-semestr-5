package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://newton.by");

        By searchInputSelector = By.xpath("//*[@id=\"title-search-input\"]");
        By searchButtonSelector = By.xpath("//*[@id=\"search\"]/form/button");

        WebElement searchInput = driver.findElement(searchInputSelector);
        WebElement searchButton = driver.findElement(searchButtonSelector);

        searchInput.click();
        searchInput.sendKeys("чехол для телефона");
        searchButton.click();

        Thread.sleep(5000);
        By linkToProductPageSelector = By.xpath("//*[@id=\"bx_3367466560_153759_pict\"]");
        WebElement linkToProductPage = driver.findElement(linkToProductPageSelector);
        Thread.sleep(5000);

        String href = linkToProductPage.getAttribute("href");
        driver.get(href);
        Thread.sleep(2000);

        driver.quit();
    }
}