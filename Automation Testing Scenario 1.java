import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;a
import java.util.concurrent.TimeUnit;

class PurchaseOrderTest {
    public static void main(String[] args) {
        // Set the path for ChromeDriver (if necessary)
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accenture-sandbox.coupacloud.com/user/home");

        // Initialize Chrome browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");  // Maximize the browser window

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open the URL where the purchase order page is located
        login(driver);

        // Perform purchase order automation
           createPurchaseOrder(driver);



        // Close the browser after test completion
        driver.quit();
    }

    // Login method (modify according to your platform)
    public static void login(WebDriver driver) {
        // Wait until the login elements are visible
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Locate the username, password, and login button elements
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
        WebElement passwordField = driver.findElement(By.id("user_password"));
        WebElement loginButton = driver.findElement(By.id("login_button"));

        // Enter credentials and click the login button
        usernameField.sendKeys("jaskaran.w.singh@accenture.com");
        passwordField.sendKeys("Testing.coupa@0201");
        loginButton.click();

        System.out.println("Login successful!");
    }

    // Method to create the purchase order (automate the steps)
    public static void createPurchaseOrder(WebDriver driver)
    {
        driver.findElement(By.xpath("//a[text()='Requests']")).click();
        WebElement element = driver.findElement(By.xpath("(//img[@class='icon icon_button sprite-page_copy'])[1]"));
        element.click();
        WebElement addressField = driver.findElement(By.cssSelector("[data-deny-dialog-overlap='true']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addressField);
        js.executeScript("arguments[0].click();", addressField);

        WebElement chooseButton = driver.findElement(By.xpath("(//a[@class='rollover button'])[1]"));
        chooseButton.click();

        WebElement submitButton = driver.findElement(By.cssSelector("[data-disable-on-click='true']"));
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS); // Java 8+ approach
        js.executeScript("arguments[0].click();", submitButton);

        System.out.println("Purchase Order Confirmation: ");
    }


}
