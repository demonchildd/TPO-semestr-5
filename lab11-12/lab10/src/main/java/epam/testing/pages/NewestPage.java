package epam.testing.pages;

import epam.testing.models.product.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static epam.testing.utils.Logger.*;

import java.util.ArrayList;
import java.util.List;

public class NewestPage extends Page {
  @FindBy(css = "#arrFilter_P1_MIN")
  private WebElement minPriceInput;

  @FindBy(css = "#arrFilter_P1_MAX")
  private WebElement maxPriceInput;
  @FindBy(xpath = "//*[@id=\"modef\"]")
  private WebElement SearchButton;
  @FindBy(xpath = "/html/body/main/div[1]/div[5]/div/div[2]/div[2]/div[2]/div")
  private WebElement sortSelection;

  public NewestPage(WebDriver driver) {
    super(driver, "https://newton.by/gps-navigatory/");
  }



  public void setMinPrice(String minPrice) {
    minPriceInput.clear();
    minPriceInput.sendKeys(minPrice);

    log("Min price set");
  }

  public void setMaxPrice(String maxPrice) {
    maxPriceInput.clear();
    maxPriceInput.sendKeys(maxPrice);

    log("Max price set");
  }
  public void Search() {
    SearchButton.click();
  }



  public void clickOnSortOptions() {
    sortSelection.click();
    WebElement option = driver.findElement(By.xpath("/html/body/main/div[1]/div[5]/div/div[2]/div[2]/div[2]/div/div/div/a[1]"));
    option.click();

    log("Sort option clicked");
  }
}
