import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ContractTest {
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
         createContracts(driver);

        // Close the browser after test completion
        // driver.quit();
    }
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
    public static void createContracts(WebDriver driver)
    {
        driver.findElement(By.xpath("//a[text()='Contracts']")).click();

        //Click on create button
        WebElement element = driver.findElement(By.xpath("//*[@id='index_contract_page']/button"));
        element.click();

        WebElement classification = driver.findElement(By.xpath("//*[@id='classification_value_3']"));
        classification.click();
        // Send keys (text you want to enter)
        classification.sendKeys("Buy-Side");
        // Optionally, press ENTER (if required to submit the form or trigger the action)
        classification.sendKeys(Keys.ENTER);

        WebElement contractType = driver.findElement(By.xpath("//*[@id='type_value_4']"));
        contractType.click();
        // Send keys (text you want to enter)
        contractType.sendKeys("Agreement");
        // Optionally, press ENTER (if required to submit the form or trigger the action)
        contractType.sendKeys(Keys.ENTER);

        WebElement contractName = driver.findElement(By.xpath("//*[@id='title_value_5']"));
        contractName.clear();
        contractName.sendKeys("abc16");

        WebElement contractFor = driver.findElement(By.xpath("//*[@id='contract_supplier_search']"));
        contractFor.click();
        // Send keys (text you want to enter)
        contractFor.sendKeys("AB");
        Actions actions = new Actions(driver);
        // Send the Down Arrow key and Enter key
        actions.moveToElement(contractFor)  // Move to the input field
                .sendKeys(Keys.ARROW_DOWN)    // Press ARROW_DOWN
                .sendKeys(Keys.ENTER)         // Press Enter
                .perform();

        WebElement submitContract = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[3]/button[1]"));
        submitContract.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Java 8+ approach
//
        WebElement startDate = driver.findElement(By.xpath("//*[@id='local_start_date_25']"));
        startDate.clear();
        // Set the date (format: mm/dd/yyyy)
        startDate.sendKeys("01/15/2025");  // Example date: January 15, 2025

        WebElement submit = driver.findElement(By.xpath("//*[@id='pageContentWrapper']/div[4]/div/div/div/div/button[1]"));
        submit.click();

        WebElement partName = driver.findElement(By.cssSelector("#legal_entity_489"));
        partName.click();
        //Send keys
        partName.sendKeys("Our");
        Actions actions1 = new Actions(driver);

        //Send the Down Arrow key and Enter key
        actions.moveToElement(partName)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement approval = driver.findElement(By.xpath("//*[@id='submit-for-approval-warning']/span[1]/a"));
        approval.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Java 8+ approach
//        contractFor.sendKeys(Keys.ARROW_DOWN);
//        contractFor.sendKeys(Keys.ENTER);


    }
}
