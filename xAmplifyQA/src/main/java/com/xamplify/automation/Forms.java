package com.xamplify.automation;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Forms {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\.metadata\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Forms.properties");
	final Logger logger = LogManager.getLogger(VideoCampaign.class);

	@Test(priority = 3, enabled = false)
	public void design() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("Designmodule"))).click();// clicking on Design Module
		logger.info("Clicked on Design Module");
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("DesignForms"))).click();
		Thread.sleep(5000);
	}

	@Test(priority = 4, enabled = false)
	public void designregularform() throws InterruptedException {

		driver.findElement(By.xpath(properties.getProperty("RegularForm"))).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Hoveringregularform")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("clickoncreatingregularform"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname")))
				.sendKeys("Regularnewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformcontinue"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savingregularform"))).click();
		Thread.sleep(5000);
		design();
	}

	@Test(priority = 5, enabled = false)
	public void designquizform() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("quizForm"))).click();
		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Hoveringquizform")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("clickoncreatingquizform"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("quizformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("quizformname")))
				.sendKeys("quiznewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("quizformcontinue"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savingquizform"))).click();
		Thread.sleep(5000);
		design();

	}

	@Test(priority = 6, enabled = false)
	public void designsurveyform() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("surveyForm"))).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Hoveringsurveyform")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("clickoncreatingsurveyform"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("surveyformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("surveyformname")))
				.sendKeys("surveynewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("surveyformcontinue"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savingsurveyform"))).click();

	}

	@Test(priority = 7, enabled = true)
	public void Manageforms() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("Designmodule"))).click();// clicking on Design Module
		logger.info("Clicked on Design Module");
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("Manageforms"))).click();

	}

	@Test(priority = 8, enabled = true)
	public void ManageformsEdit() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath(properties.getProperty("RegularForm"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("EditRegularForm"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("AddFields"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("singlelinetext"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("closeregaddfields"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Designbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("inputurl"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("inputurl"))).sendKeys("https://www.xamplify.co/");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("checkbox"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("submitaddedfields"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("submittoupdateregform"))).click();

	}

	@Test(priority = 9, enabled = true)
	public void Manageformsregsaveas() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("EditRegularForm"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("renameicon"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname")))
				.sendKeys("Regularnewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformcontinue"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("saveasregform"))).click();
		

	}
	
	@Test(priority = 10, enabled = true)
	public void Manageformsregicons() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("copyasregform"))).click();	
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname")))
				.sendKeys("Regularnewformcopy" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("copiedsave"))).click();
		
		
		
}
}