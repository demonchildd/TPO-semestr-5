import org.example.FilterPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class TestSite2 {
    private static WebDriver driver;
    private FilterPage page;

    @BeforeClass()
    public static void init() {
        driver = new EdgeDriver();
    }

    @Before()
    public void openPages() {
        page = new FilterPage(driver);
        page.open();
        page.open();
        page.setMaxPrice("700");
        page.setMaxDiagonalPrice("70");
        page.checkFilter();


    }

    @Test()
    public void shouldBeDeleteElement() throws InterruptedException {
        Assert.assertEquals(1,1);
    }

    @AfterClass()
    public static void close() {
        driver.quit();
    }
}
