package epam.testing.pages;

import epam.testing.models.product.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static epam.testing.utils.Logger.*;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.toDouble;


import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends Page {


  @FindAll({@FindBy(css = "body > main > div:nth-child(1) > div.r.cat > div.rbl > div.catalog_list_block.r > div:nth-child(1) > a")})
  private List<WebElement> products;

  @FindAll({@FindBy(css = "body > main > div:nth-child(1) > div.row > div > div.rbl > div.catalog_list_block.r > div:nth-child(1)")})
  private List<WebElement> NewestProducts;



  public ProductsPage(WebDriver driver) {
    super(driver, null);
  }

  public void clickOnFirst () {
    String href = products.get(0).getAttribute("href");
    driver.get(href);

    log("Clicked on first product");
  }


  public List<Product> getProducts() {
    List<Product> prods = new ArrayList<>();
    List<WebElement> productsNames = driver.findElements(org.openqa.selenium.By.cssSelector(".catalog_item .catalog_item_title"));
    List<WebElement> productsPrices = driver.findElements(org.openqa.selenium.By.cssSelector(".catalog_item .price"));

    String price, name;
    int k = 0;
    for (int i = 0; i < productsNames.size(); i++) {

      name = productsNames.get(i).getText();
      price = productsPrices.get(k).getText();
      if (price.contains(","))
        price = productsPrices.get(++k).getText();
      k++;
      String lastTwoDigits = price.substring(price.length() - 2);

      int remainingDigits = Integer.parseInt(price.substring(0, price.length() - 2));

      double result = remainingDigits + Double.parseDouble(lastTwoDigits) / 100.0;
      if(name.equals("")) continue;
      prods.add(new Product(name, result));
    }

    log("Products got");

    return prods;
  }
}
