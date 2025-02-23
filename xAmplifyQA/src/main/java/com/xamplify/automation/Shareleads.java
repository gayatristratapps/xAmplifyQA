package com.xamplify.automation;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import com.xamplify.util.XamplifyUtil;

public class Shareleads {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Shareleads.properties");
	final Logger logger = LogManager.getLogger(Shareleads.class);

	@Test
	public void testUploadCSV() throws InterruptedException {
	    // Step 1: Hover over the "Share Leads" section 

		hoverOnShareLeads();

	    // Step 2: Define test data for CSV file (each row corresponds to the headers)
		List<String[]> userData = Arrays.asList(
				new String[] { "Gayatri", "Doe", "ABC Corp", "Manager", "gayatri.doe@getnada.com", "123 Street",
						"New York", "NY", "10001", "USA", "1234567890" },
				new String[] { "lucky", "Smith", "XYZ Ltd", "Software Engineer", "lucky.smith@getnada.com",
						"456 Avenue", "San Francisco", "CA", "94105", "USA", "9876543210" });

	    // Step 3: Generate CSV dynamically and get the file path
		String filePath = XamplifyUtil.generateCSV(userData);

		
		
		
		Thread.sleep(4000);

		// Step 4:Locate file input and upload CSV
		WebElement uploadElement = driver.findElement(By.xpath(properties.getProperty("sh_csvclick")));
																									

		uploadElement.sendKeys(filePath);
		// Step 5: Legal Basis Selection

		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

	}

	public void hoverOnShareLeads() throws InterruptedException {

		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "add_shareleads");
		// Step 1: Contact List Creation
		XamplifyUtil.sendTextWithTimestamp("contactListName", "AutoSlist");
	}

	@Test(priority = 1, enabled = false)
	public void shareLeadsOneAtATime() throws InterruptedException {

		hoverOnShareLeads();

		logger.debug("Starting creating partner using One at a time");

		// Click on 'One at a Time' option
		XamplifyUtil.callClickEvent(properties.getProperty("sh_oneattime"));

		// Step 2: Enter Personal Details
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("sh_emailid"), "Gayatri_automate", "@getnada.com");
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_firstname"), "Gayatri");
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_lastname"), "autosharelead");

		// Step 3: Enter Company Details
		XamplifyUtil.getElementById("company").sendKeys("Gcompany");
		Thread.sleep(1000);

		// Step 4: Legal Basis Selection
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

		// Step 5: Job Details
		XamplifyUtil.getElementById("title").sendKeys("Software Engineer");

		// Step 6: Address Information
		XamplifyUtil.getElementById("address").sendKeys("Sri maaruthi homes");
		XamplifyUtil.getElementById("city").sendKeys("Hyderabad");
		XamplifyUtil.getElementById("state").sendKeys("Andhra pradesh");
		XamplifyUtil.getElementById("zip").sendKeys("534342");

		// Step 7: Scroll Inside Modal
		WebElement scrollableDiv = driver.findElement(By.xpath(properties.getProperty("sh_scroll")));
		XamplifyUtil.scrollInsideElement(scrollableDiv, 500);

		// Step 8: Mobile & Country Selection
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_mobileno"), "9490925009");
		XamplifyUtil.selectDropdownByText(properties.getProperty("sh_country"), "India");

		// Step 9: Submit Lead
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_add"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));

		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "Shareleads_oneatatimeCreation");

	}
}
