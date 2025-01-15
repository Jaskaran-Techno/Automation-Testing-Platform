public class PurchaseOrderAutomation {
    public static void main(String[] args) {
        // Set the path for ChromeDriver (if necessary)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize Chrome browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");  // Maximize the browser window
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Open the URL where the purchase order page is located
        driver.get("https://your-purchase-order-platform-url.com");

        // Add code to login (if required)
        login(driver);

        // Perform purchase order automation
        createPurchaseOrder(driver);

        // Close the browser after test completion
        driver.quit();
    }

    // Login method (modify according to your platform)
    public static void login(WebDriver driver) {
        // Find username and password fields, and log in
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("yourUsername");
        passwordField.sendKeys("yourPassword");
        loginButton.click();
        
        // Wait for login to complete, e.g., waiting for a landing page element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
    }

    // Method to create the purchase order (automate the steps)
    public static void createPurchaseOrder(WebDriver driver) {
        // Click on "Create Purchase Order" button
        WebElement createPOButton = driver.findElement(By.id("createPO"));
        createPOButton.click();

        // Wait for the form to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("poForm")));

        // Fill out purchase order details
        WebElement vendorField = driver.findElement(By.id("vendor"));
        WebElement itemField = driver.findElement(By.id("item"));
        WebElement quantityField = driver.findElement(By.id("quantity"));
        WebElement submitButton = driver.findElement(By.id("submitPO"));

        vendorField.sendKeys("VendorName");
        itemField.sendKeys("ItemName");
        quantityField.sendKeys("10");

        // Submit the purchase order
        submitButton.click();

        // Wait for confirmation page or message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("poConfirmation")));

        // Print confirmation message (optional)
        WebElement confirmationMessage = driver.findElement(By.id("poConfirmationMessage"));
        System.out.println("Purchase Order Confirmation: " + confirmationMessage.getText());
    }
}
