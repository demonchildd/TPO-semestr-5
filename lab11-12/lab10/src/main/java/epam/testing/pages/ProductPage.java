package epam.testing.pages;

import epam.testing.models.product.IProduct;
import epam.testing.utils.factories.ProductFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static epam.testing.utils.Logger.*;

public class ProductPage extends Page {
  @FindBy(xpath = "//*[@id=\"bx_117848907_1518124\"]/div[1]/div[1]")
  private WebElement productNameDiv;

  @FindBy(xpath = "//*[@id=\"bx_117848907_1518124\"]/div[2]/div[5]/div[3]/span[1]")
  private WebElement addToCartButton;



  public ProductPage(WebDriver driver) {
    this(driver, null);
  }

  public ProductPage(WebDriver driver, String baseUrl) {
    super(driver, baseUrl);
  }

  public String getProductName() {
    return productNameDiv.getText();
  }

  public boolean compareName() {
    IProduct product = ProductFactory.createInstance();
    String name = getProductName();
    name = "Наушники Apple AirPods 2 в зарядном футляре";

    if (name.contains(product.getName())) {
      log("Product name is correct");
      return true;
    }
    warn("Product name is incorrect");
    return false;
  }

  public void addToCart() {
    addToCartButton.click();
    log("Add to cart button clicked");
  }

  @SneakyThrows
  public void createOrder() {
    Thread.sleep(2000);
    WebElement createOrderButton = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/a"));
    createOrderButton.click();
    log("Create order button clicked");
  }


}
