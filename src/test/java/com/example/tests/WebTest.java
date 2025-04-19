package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertTrue;

public class WebTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(description = "Visit Google and fail the test on purpose")
    @Description("This test opens Google and fails intentionally to attach a screenshot")
    @Severity(SeverityLevel.CRITICAL)
    public void googleTestWithFailure() {
        driver.get("https://www.google.com");

        // Attach screenshot before failure
        Allure.addAttachment("Google Home Page", new ByteArrayInputStream(
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        assertTrue(false, "Intentional Failure to check Allure Screenshot");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}