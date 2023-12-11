package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    private final WebDriver driver;

    private WebElement linkToProductPage;
    private String href = "";

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProduct() throws InterruptedException {
        linkToProductPage = driver.findElement(By.xpath("//*[@id=\"bx_3367466560_153759_pict\"]"));

        String href = linkToProductPage.getAttribute("href");
        this.href = href;
        driver.get(href);
    }

    public String getHref() {
        return href;
    }
}
