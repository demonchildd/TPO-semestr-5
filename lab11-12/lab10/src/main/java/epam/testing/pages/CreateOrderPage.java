package epam.testing.pages;

import epam.testing.models.order.IOrder;
import epam.testing.utils.factories.OrderFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static epam.testing.utils.Logger.log;

public class CreateOrderPage extends Page {
  int count = 0;
  @FindBy(xpath = "//*[@id=\"basket-item-quantity-622076\"]")
  private WebElement countElementInCart;

  @FindBy(xpath = "//*[@id=\"basket-item-622076\"]/td[2]/div/span[1]")
  private WebElement Delete;

  @FindBy(xpath = "//*[@id=\"basket-item-622076\"]/td[2]/div/span[2]")
  private WebElement Insert;
  public CreateOrderPage(WebDriver driver) {
    super(driver, null);
  }
  public CreateOrderPage(WebDriver driver, String baseUrl) {
    super(driver, baseUrl);
  }
  @SneakyThrows
  public boolean createOrder() {
    IOrder order = OrderFactory.createInstance();


    WebElement confirmLink = driver.findElement(By.xpath("//*[@id=\"basket-root\"]/div[2]/div[2]/div/div/div[4]/button"));
    confirmLink.click();
    // if url is https://superlama.by/index.php?route=checkout/success then order is created
    log("Take on my own input clicked");

    return driver.getCurrentUrl().equals("https://newton.by/personal/order/make/");
  }

  public int getCountElementInCart() {
    int count = Integer.parseInt(countElementInCart.getAttribute("value"));

    return count;

  }

  public void DeleteFromBasket() {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", Delete);



  }

  public void InsertIntoBasket() {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", Insert);



  }
}
