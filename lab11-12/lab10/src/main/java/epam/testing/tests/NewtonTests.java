package epam.testing.tests;

import dev.failsafe.internal.util.Assert;
import epam.testing.models.product.Product;
import epam.testing.pages.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class NewtonTests {
  private final WebDriver driver = new EdgeDriver();

  @Test
  public void shouldBeSignedIn() {
    AuthPage authPage = new AuthPage(driver);
    authPage.signIn();
  }

  @Test
  public void shouldBeFounded() throws InterruptedException {
    MainPage mainPage = new MainPage(driver);
    mainPage.search();

    ProductsPage productsPage = new ProductsPage(driver);
    productsPage.clickOnFirst();

    ProductPage productPage = new ProductPage(driver);
    productPage.compareName();
    Assert.isTrue(productPage.compareName(), "Product name is incorrect");
  }

  @Test
  public void shouldBeNotOrdered() throws InterruptedException {
    AuthPage authPage = new AuthPage(driver);
    authPage.signIn();

    ProductPage productPage = new ProductPage(driver, "https://newton.by/naushniki-i-garnitury/apple_airpods_2_v_zaryadnom_futlyare/");
    Thread.sleep(4000);
    productPage.addToCart();
    Thread.sleep(4000);
    productPage.createOrder();

    CreateOrderPage createOrderPage = new CreateOrderPage(driver);
    Thread.sleep(4000);
    Assert.isTrue(createOrderPage.createOrder(), "Order is created");
  }

  @Test
  public void shouldBeDeletedFromCart() throws InterruptedException {

    AuthPage authPage = new AuthPage(driver);
    authPage.signIn();


    CreateOrderPage createOrderPage = new CreateOrderPage(driver, "https://newton.by/personal/cart/");
    int startCount, endCount;
    Thread.sleep(5000);
    startCount = createOrderPage.getCountElementInCart();

    createOrderPage.DeleteFromBasket();
    Thread.sleep(5000);
    endCount = createOrderPage.getCountElementInCart();

    Assert.isTrue((startCount - 1) == endCount, "Несоотвествие");
  }

  @SneakyThrows
  @Test
  public void shouldBeFiltered() {
    NewestPage newestPage = new NewestPage(driver);
    final Integer MAX_PRICE = 300;
    newestPage.setMaxPrice(MAX_PRICE.toString());
    Thread.sleep(6000);
    newestPage.Search();
    ProductsPage productsPage = new ProductsPage(driver);
    List<Product> prods = productsPage.getProducts();
    Assert.isTrue(prods.stream().filter(p -> p.getPrice() > MAX_PRICE).count() == 0, "Несоотвествие");
  }

  @Test
  public void shouldBeErrorInAddingContact() {
    AuthPage authPage = new AuthPage(driver);
    authPage.signIn();

    AddContactPage addContactPage = new AddContactPage(driver);
    addContactPage.addContact("aaa", "bbb", "anjelika11");

    addContactPage.submit();
    addContactPage.getResult();
    Assert.isTrue(addContactPage.getResult() .equals("Изменения сохранены"), "Успех");
  }

  @SneakyThrows
  @Test
  public void shouldBeSorted() {
    NewestPage newestPage = new NewestPage(driver);
    Thread.sleep(5000);
    newestPage.clickOnSortOptions();

    Thread.sleep(5000);
    ProductsPage productsPage = new ProductsPage(driver);
    List<Product> products = productsPage.getProducts();

    for (int i = 0; i < products.size() - 2; i++) {
      Assert.isTrue(products.get(i).getPrice() <= products.get(i + 1).getPrice(), "Несоотвествие");
    }
  }

  @Test
  public void shouldBeAddedToBasket() throws InterruptedException {
    AuthPage authPage = new AuthPage(driver);
    authPage.signIn();


    CreateOrderPage createOrderPage = new CreateOrderPage(driver, "https://newton.by/personal/cart/");
    int startCount, endCount;
    Thread.sleep(5000);
    startCount = createOrderPage.getCountElementInCart();

    createOrderPage.InsertIntoBasket();
    Thread.sleep(5000);
    endCount = createOrderPage.getCountElementInCart();

    Assert.isTrue((startCount + 1) == endCount, "Несоотвествие");
  }

  @Test
  public void shouldPersonalInformationBeAdded() {
    AuthPage authPage = new AuthPage(driver);
    authPage.signIn();

    AddContactPage addContactPage = new AddContactPage(driver);
    addContactPage.addFio("aaaasds","anjelika11");

    addContactPage.submit();
    addContactPage.getResult();
    Assert.isTrue(addContactPage.getResult() .equals("Изменения сохранены"), "Успех");
  }

  @Test
  public void shouldBeErrorInChangingOfPassword() throws InterruptedException {
    AuthPage authPage = new AuthPage(driver);
    authPage.signIn();

    AddContactPage addContactPage = new AddContactPage(driver);
    addContactPage.addNewPassword("anjelika11","");
    Thread.sleep(5000);
    addContactPage.submit();
    addContactPage.getResult();
    Assert.isTrue(addContactPage.getResult() .equals("Неверное подтверждение пароля."), "Успех");
  }
}

