# Testing-Platform
selenium-java-automation/
│

├── src/

│   └── main/

│       └── java/

│           └── com/

│               └── automation/

│                   └── tests/

│                       ├── BaseTest.java

│                       ├── LoginTest.java

│                       └── SearchTest.java

├── pom.xml

└── README.md

mvn test

mvn -Dtest=LoginTest test

package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void testLogin() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the login page
        driver.get("https://example.com/login");
        
        // Find login form elements and interact with them
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginButton")).click();
        
        // Assert that the login was successful
        Assert.assertTrue(driver.getTitle().contains("Welcome"));

        // Close the browser
        driver.quit();
    }
}

This project is licensed under the MIT License - see the LICENSE file for details.
