package com.xamplify.automation;

import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Contacts {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Contacts.properties");
	final Logger logger = LogManager.getLogger(Contacts.class);

	@Test(priority = 1, enabled = true)

	public void con_oneatatime() throws InterruptedException, SQLException {

		Thread.sleep(5000);

		WebDriverWait wait_con = new WebDriverWait(driver, 50);

		// Wait till the element is not visible
		WebElement con1 = wait_con.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hovercontacts"))));// hover
																													// on
																													// contacts

		con1.click();
		Actions actions = new Actions(driver);
		WebElement contacts = driver.findElement(By.xpath(properties.getProperty("hovercontacts")));
		actions.moveToElement(contacts).build().perform();

		WebDriverWait wait_acon = new WebDriverWait(driver, 60);

		// Wait till the element is not visible
		WebElement acon1 = wait_acon
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Addcontacts"))));
		acon1.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("con_oneatatimelist"))).click(); // one at a time click
		Thread.sleep(5000);

		WebElement emailText = driver.findElement(By.xpath(properties.getProperty("con_oat_emailfield")));

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailText.sendKeys("gayatri" + randomInt + "@gmail.com");
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("con_legalbasis"))).click();
		Thread.sleep(2000);

		
		
		WebElement con_legal = driver.findElement(By.xpath(properties.getProperty("con_legalbasis")));
		con_legal.sendKeys("Legitimate interest - existing customer");// enter data for legal basis field
		con_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		con_legal.sendKeys("Legitimate interest - prospect/lead");// enter data for legal basis field
		con_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("con_mobileno"))).sendKeys("9490925098");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(properties.getProperty("con_addbutton"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("con_oat_listfield"))).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(properties.getProperty("con_oat_listname"))).sendKeys("Autocon_1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("con_accept"))).click();
		Thread.sleep(2000);
		
		
		

	}
}