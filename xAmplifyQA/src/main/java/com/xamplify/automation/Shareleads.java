package com.xamplify.automation;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import com.xamplify.util.XamplifyUtil;

public class Shareleads {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Shareleads.properties");
	final Logger logger = LogManager.getLogger(Shareleads.class);

	public void hoverOnShareLeads() throws InterruptedException {

		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "add_shareleads");
		// Step 1: Contact List Creation
		XamplifyUtil.sendTextWithTimestamp("contactListName", "AutoSlist");
	}

	public void manageHoverShareLeads() throws InterruptedException {

		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "manage_shareleads");

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

		// Step 9: Submit the sharelead
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_add"));
		Thread.sleep(1000);

		// Step 10:Save the list
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));

		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "OneatatimeCreation_Shareleads");

	}

	@Test(priority = 2, enabled = false)
	public void shareleadsUploadCSV() throws InterruptedException {
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

		// Step 6:Save the list
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));

		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));
		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "UploadCSVCreation_Shareleads");

	}

	@Test(priority = 3, enabled = true)
	public void shareleadsGridSearch() throws InterruptedException {
		Thread.sleep(2000);
	    // Step 1: Hover over Share Leads menu

		manageHoverShareLeads();
		Thread.sleep(2000);
	    // Step 2: Click on the Share Leads grid

		XamplifyUtil.callClickEvent(properties.getProperty("mshareleads_grid"));

	    // Step 3: Enter search text in the Search Bar

		XamplifyUtil.sendTextEvent(properties.getProperty("mshareleads_search"), "Auto");

		XamplifyUtil.sendKeyEvent(properties.getProperty("mshareleads_search"), Keys.ENTER);

	}

	@Test(priority = 4, enabled = true)
	public void shareleadsDropdown() throws InterruptedException {
		Thread.sleep(2000);

//Selecting multiple indices with a wait
		int[] indices = { 1, 2, 3, 6, 5, 4 };
		for (int index : indices) {
			XamplifyUtil.selectDropdownWithWait(driver, properties.getProperty("mshareleads_drpdwn"), index);
		}

		XamplifyUtil.sendTextEvent(properties.getProperty("mshareleads_search"), Keys.chord(Keys.CONTROL, "a"));
		XamplifyUtil.sendKeyEvent(properties.getProperty("mshareleads_search"), Keys.BACK_SPACE);

	}

	@Test(priority = 6, enabled = true)
	public void shareleadsManage() throws InterruptedException {
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_publishicon"));
		Thread.sleep(2000);

		XamplifyUtil.sendTextEvent(properties.getProperty("manageshare_publish_search"), "Partner");

		XamplifyUtil.sendKeyEvent(properties.getProperty("manageshare_publish_search"), Keys.ENTER);
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_expand"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_selectcheckbox"));

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_submit"));

		XamplifyUtil.takeScreenshot(driver, "Published_Shareleads");

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_submit_close"));
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_aftrpublish_preview"));

	}

}










