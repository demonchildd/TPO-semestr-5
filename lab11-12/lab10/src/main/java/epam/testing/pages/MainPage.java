package epam.testing.pages;

import epam.testing.models.product.IProduct;
import epam.testing.utils.factories.ProductFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static epam.testing.utils.Logger.*;

public class MainPage extends Page {
  @FindBy(xpath = "//*[@id=\"title-search-input\"]")
  private WebElement searchInput;

  @FindBy(xpath = "//*[@id=\"search\"]/form/button")
  private WebElement searchButton;

  public MainPage(WebDriver driver) {
    super(driver, "https://newton.by/");
  }

  public void search() {
    IProduct product = ProductFactory.createInstance();
    searchInput.sendKeys(product.getName());
    searchButton.click();
    log("Search button clicked with text '" + product.getName() + "'");
  }
}
