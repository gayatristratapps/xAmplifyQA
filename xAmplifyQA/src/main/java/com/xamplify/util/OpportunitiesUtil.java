package com.xamplify.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.xamplify.automation.Instance;

public class OpportunitiesUtil {

	static WebDriver driver = Instance.getInstance();

	public static void getMouserOverElement(By locator) {
	    WebElement element = driver.findElement(locator);
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element).perform();
	}
	
	
	
	
	
	
	
}
