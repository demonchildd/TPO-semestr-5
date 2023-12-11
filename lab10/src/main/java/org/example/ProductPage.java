package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private final WebDriver driver;

    private WebElement product;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() throws InterruptedException {
        product = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/h1"));
        return product.getText();
    }
}
