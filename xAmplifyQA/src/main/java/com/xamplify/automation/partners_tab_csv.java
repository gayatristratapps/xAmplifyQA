package com.xamplify.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;
//import com.opencsv.CSVWriter;

public class partners_tab_csv {
	private static final TimeUnit Seconds = null;
	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Partners.properties");
	final Logger logger = LogManager.getLogger(partners_tab_csv.class);

	@Test(priority = 7, enabled = true)
	public void onboarding_section() throws Throwable

	{
	
		
		Thread.sleep(8000);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("search1"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("search1"))).sendKeys("automated");
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("search1"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("search1"))).clear();
		Thread.sleep(2000);

				Select sortby = new Select(driver.findElement(By.xpath(properties.getProperty("sort"))));
		sortby.selectByVisibleText("Email(A-Z)");
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("entityinfo1"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("actionsin"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("saveasin"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("legall"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("legall"))).sendKeys("Legitimate interest - other");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("legall"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("nameofthelist"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("nameofthelist")))
				.sendKeys("harish" + System.currentTimeMillis() + "_");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("button12"))).click();
		Thread.sleep(2000);

	}

	

	@Test(priority = 8, enabled = false)
	public void onboard_icons() throws Throwable {
		Thread.sleep(8000);
		
		partners_onboard_comma onboard= new partners_onboard_comma();
		onboard.Signinprocess();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(properties.getProperty("resendemail"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("editpartner"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("companyid"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("companyid")))
				.sendKeys("newcompany name" + "_" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("updatepartner"))).click();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("deletepartneronboard"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("yesdeleteit"))).click();
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	
	Thread.sleep(20000);	
		driver.findElement(By.xpath(properties.getProperty("partneranalytics"))).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath(properties.getProperty("closeanalytics"))).click();
		Thread.sleep(5000);

	}

	@Test(priority = 9, enabled = true)
	public void Managepartners() throws Throwable

	{

		WebElement partners = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));// hover to partners
																									// module in left
																									// menu
		Actions actions = new Actions(driver);
		actions.moveToElement(partners).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("managepartner"))).click();

	}

	@Test(priority = 10, enabled = true)
	public void Managepartners_icons() throws Throwable

	{
		Thread.sleep(3000);
		Select sortby1 = new Select(driver.findElement(By.xpath(properties.getProperty("sortbymanagepartners"))));
		sortby1.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("searchmanage"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("searchmanage"))).sendKeys("Active");
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("searchmanage"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("copyandsave"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("copyandsavename"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("copyandsavename")))
				.sendKeys("automated list" + "_" + System.currentTimeMillis());
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("savenamechanges"))).click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath(properties.getProperty("downloadlist"))).click();
		driver.findElement(By.xpath(properties.getProperty("searchmanage"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("searchmanage"))).sendKeys("automated");
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("searchmanage"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("campain"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("entinfo"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("sharingcampaigns"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("closing"))).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("editlist"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("editinglist"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("cname"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("cname")))
				.sendKeys("cname" + " " + System.currentTimeMillis());

		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("phnumber"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("phnumber"))).sendKeys("123456789");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("updated"))).click();
		Thread.sleep(5000);
		Managepartners();
		Thread.sleep(5000);
		/*
		 * driver.findElement(By.xpath(properties.getProperty("searchmanage"))).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath(properties.getProperty("searchmanage"))).sendKeys
		 * ("active"); Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("searchmanage"))).sendKeys
		 * (Keys.ENTER); Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("share1"))).click();
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath(properties.getProperty("allcampains"))).click();
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("shareallcampaigns"))).
		 * click(); Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("close"))).click();
		 * Thread.sleep(3000);
		 */driver.findElement(By.xpath(properties.getProperty("searchmanage"))).clear();
		Thread.sleep(2000);
		//driver.findElement(By.xpath(properties.getProperty("searchmanage")))
		driver.findElement(By.xpath(properties.getProperty("searchmanage"))).sendKeys("active");
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchmanage"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("deletemanage"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("deletemanagelist"))).click();
		Thread.sleep(3000);
		// Use TakesScreenshot method to capture screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        // Path to the location to save screenshot
        FileUtils.copyFile(source, new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Resub_contact.png"));
        System.out.println("Screenshot is captured for resubscribed contact");
		
		
	}
	@Test(priority = 11, enabled = false)
	public void pagenation() throws Throwable

	{
		Thread.sleep(3000);
		partners_onboard_comma onboard= new partners_onboard_comma();
		onboard.Signinprocess();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 2000)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("pagenation2"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("pagenation_last"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("pagenation_first"))).click();

	}

}