import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class PurchaseOrderTest {

    WebDriver driver;

    @Test
    public void createPurchaseOrder() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accenture-sandbox.coupacloud.com/user/home");
    }
}
