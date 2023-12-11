package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FilterPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"arrFilter_92865_MAX\"]")
    private WebElement maxDiagonalElement;

    @FindBy(xpath = "//*[@id=\"modef\"]")
    private WebElement filterButton;

    @FindBy(xpath = "//*[@id=\"arrFilter_P1_MAX\"]")
    private WebElement maxPriceElement;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://newton.by/televizory/");
    }

    public void setMaxDiagonalPrice(String maxPrice) {
        maxPriceElement.clear();
        maxPriceElement.sendKeys(maxPrice);
    }

    public void setMaxPrice(String maxPrice) {
        maxPriceElement.clear();
        maxPriceElement.sendKeys(maxPrice);
    }

    public void checkFilter() {
        filterButton.click();
    }

}
