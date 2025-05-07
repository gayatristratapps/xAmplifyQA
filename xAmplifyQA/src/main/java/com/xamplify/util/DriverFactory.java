package com.xamplify.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.xamplify.automation.PropertiesFile;

import java.util.Properties;

public class DriverFactory {

    public static WebDriver getDriver() {
    	// This is just an abstraction, WebDriverManager is handling the setup.
        return com.xamplify.automation.Instance.getInstance();
    }
}
