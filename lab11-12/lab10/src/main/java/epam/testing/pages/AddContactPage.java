package epam.testing.pages;

import epam.testing.intefaces.ISubmite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactPage extends Page implements ISubmite {
  @FindBy(xpath = "/html/body/main/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div/div[2]/input")
  private WebElement city;
  @FindBy(xpath = "/html/body/main/div[1]/div[2]/div[2]/div/form/div[2]/div[2]/div/div[2]/input")
  private WebElement address;

  @FindBy(xpath = "/html/body/main/div[1]/div[2]/div[2]/div/form/div[1]/div[1]/div[1]/div[2]/input")
  private WebElement fio;
  @FindBy(xpath = "/html/body/main/div[1]/div[2]/div[2]/div/form/div[3]/div/div[2]/div[4]/input")
  private WebElement password;

  @FindBy(xpath = "/html/body/main/div[1]/div[2]/div[2]/div/form/div[3]/div/div[2]/div[2]/input")
  private WebElement newPassword;
  @FindBy(xpath = "/html/body/main/div[1]/div[2]/div[2]/div/form/div[5]/input")
  private WebElement submitButton;


  public AddContactPage(WebDriver driver) {
    super(driver, "https://newton.by/personal/");
  }

  public void addContact(String city, String address, String password) {
    this.city.clear();
    this.address.clear();
    this.password.clear();

    this.city.sendKeys(city);
    this.address.sendKeys(address);
    this.password.sendKeys(password);

  }

  public void submit() {
    submitButton.click();
  }

  public String getResult() {
    String str = driver.findElement(By.cssSelector("body > main > div:nth-child(1) > div.r > div.r-block > p")).getText();
    return str;
  }

  public void addFio(String fio, String password) {
    this.fio.clear();
    this.password.clear();

    this.fio.sendKeys(fio);
    this.password.sendKeys(password);

  }

  public void addNewPassword(String newPassword, String password) {
    this.newPassword.clear();
    this.password.clear();

    this.newPassword.sendKeys(newPassword);
    this.password.sendKeys(password);

  }
}
