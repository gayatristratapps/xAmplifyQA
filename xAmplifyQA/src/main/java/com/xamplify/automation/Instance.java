package com.xamplify.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instance {

    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private Instance() {}

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("use-fake-ui-for-media-stream");
            options.addArguments("--start-maximized"); // Recommended for UI consistency
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitInstance() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
