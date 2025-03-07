package com.xamplify.automation;

import java.util.Properties;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.xamplify.util.XamplifyUtil;

public class TeamPartner {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\TeamPartner.properties");
	final Logger logger = LogManager.getLogger(TeamPartner.class);

	@Test(priority = 1, enabled = true)
	public void hoverTeam() throws InterruptedException, AWTException, IOException {
		
		//Hover and click on Team module
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("hoveronTeam"), 50);
		Thread.sleep(5000);
		
	}

	@Test(priority = 2, enabled = true)
	public void addTeammember() throws InterruptedException, AWTException, IOException {

		// Add the Team member by clicking on "Add" button

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_add_button"));
		Thread.sleep(1000);

		// Given the first name, Lastname and Emaild
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_firstname_field"), "CMR_FN");
		Thread.sleep(1000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_lastname_field"), "LN");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_emailid_field"));
		Thread.sleep(1000);

		WebElement emailTextBx = driver.findElement(By.xpath(properties.getProperty("clickon_emailid_field")));

		// using this, it generates the random email id's
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailTextBx.sendKeys("mouni" + randomInt + "@gmail.com");
		Thread.sleep(6000);

		// Selecting the Team member group
		WebElement TM_grpdropdown = driver.findElement(By.xpath(properties.getProperty("clickon_TMGroup")));
		TM_grpdropdown.click();
		Thread.sleep(1000);

		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_TMGroup"), "Partner Account Manager");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_view_available_modules"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_close_available_modules"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_saveTM"));
		Thread.sleep(3000);
	}

	@Test(priority = 3, enabled = true)

	public void inviteTeammember() throws InterruptedException, AWTException {

		// Inviting the Team members by clicking Invite team members button

		WebElement invite_tm = driver.findElement(By.xpath(properties.getProperty("clickon_invite_tm_button")));
		invite_tm.click();
		Thread.sleep(1000);

		WebElement emailfield = driver.findElement(By.xpath(properties.getProperty("clickon_email_field_invite_tm")));
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailfield.sendKeys("cmrinvite" + randomInt + "@gmail.com");
		Thread.sleep(1000);

		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_send"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_close"));
		Thread.sleep(1000);

		// Invite Team member Analytics
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invite_tm_analytics"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_dropdown"));
		Thread.sleep(1000);

		XamplifyUtil.selectDropdownByValue(properties.getProperty("clickon_invitetm_dropdown"), "1: Object");
		Thread.sleep(1000);

		XamplifyUtil.selectDropdownByValue(properties.getProperty("clickon_invitetm_dropdown"), "2: Object");
		Thread.sleep(1000);

		XamplifyUtil.selectDropdownByValue(properties.getProperty("clickon_invitetm_dropdown"), "3: Object");
		Thread.sleep(1000);

		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_invitetm_Search"), "gmail.com");

		Thread.sleep(1000);

		// Search functionality
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_Search_icon"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_Search_clear"));
		Thread.sleep(1000);

		// Applying filter by giving the date and team member conditions
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_filter"));
		Thread.sleep(1000);

		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_invitedby_filter"),
				"partnerautomate@gmail.com");

		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectdate_field"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("select_from_date"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_todate_field"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("select_to_date"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_apply_button"));
		Thread.sleep(1000);

		 // refresh button
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_refreshtm"));

		// Export the Team members

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_exportexcel"));
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_filter"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_invitetm_filter_close"));
		Thread.sleep(1000);

		// click on Navigation Breadcrumb
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_team_breadcrumb"));
		Thread.sleep(1000);

	}

	@Test(priority = 4, enabled = true)
	public void generateCSV() throws InterruptedException {

		Thread.sleep(2000);

		// Define file path and data
		String filePath = "teammemberupload.csv";
		String[][] data = { { "Email Id", "First Name", "Last Name" }, { "autotest@gmail.com", "mouni", "ch" },
				// {"cmrtest1@gmail.com", "mouni", "ch"},

		};

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (String[] row : data) {
				writer.write(String.join(",", row));
				writer.newLine();
			}
			System.out.println("CSV file generated successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test(priority = 5, enabled = true)
	public void testFileUpload() throws InterruptedException {
		// Generate the CSV file first
		generateCSV(); // Call the method to generate the CSV

		// Find the file input element
		WebElement uploadcsvfile = driver.findElement(By.xpath(properties.getProperty("clickon_uploadcsv_button"))); 

		// Get the absolute path of the generated CSV file
		String filePath = new File("teammemberupload.csv").getAbsolutePath();

		// Upload the file by sending the file path to the file input element
		uploadcsvfile.sendKeys(filePath);
		Thread.sleep(3000);
		
		//Click and select the team member group
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_upload_csv_tmg"));
		Thread.sleep(2000);

		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_upload_csv_tmg"), "Partner Account Manager");
		Thread.sleep(1000);

		// click on save button to save the Team members
		WebElement submitButton = driver.findElement(By.xpath(properties.getProperty("clickon_Save_csv"))); 
		submitButton.click();

		System.out.println("File uploaded successfully!");

	}

	@Test(priority = 6, enabled = true)

	public void search_filter_export_TM() throws Throwable {
		Thread.sleep(6000);

		// Search functionality

		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_Search_tm"), "autotest@gmail.com");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_Searchicon_tm"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_upload_delete"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_yes_delete"));
		Thread.sleep(3000);

		// Refresh the Team member
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_refreshtm")); // Refresh

		// Export the Team members

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_tm_exportexcel"));
		Thread.sleep(1000);

		XamplifyUtil.excelDownload();
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_refreshtm"));

		// Applying the filter
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_filtertm"));
		Thread.sleep(1000);

		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_select_tm_filter"),
				"partnerautomate@gmail.com");

		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		Thread.sleep(1000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_select_vendor_filter"),
				"xAmplify");

		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectdate_field"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("select_from_date"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_todate_field"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("select_to_date"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_apply_button"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_filtertm"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_clear_filter"));
		Thread.sleep(3000);


	}

	@Test(priority = 7, enabled = true)
	public void actions_teammember() throws InterruptedException {

		JavascriptExecutor js1 = (JavascriptExecutor) driver; // Scroller
		js1.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		Thread.sleep(2000);
		//preview of Team member Group
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_preview_group"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_close_available_modules"));
		Thread.sleep(1000);

		// Edit the Team member details
		WebElement edit = driver.findElement(By.xpath(properties.getProperty("clickon_edit_icontm")));
		edit.click();

		Thread.sleep(1000);
		WebElement edit_field = driver.findElement(By.xpath(properties.getProperty("clickon_firstname_field")));
		edit_field.clear();
		Thread.sleep(1000);
		edit_field.sendKeys("mounika_tm");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_tm_update"));
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "Partner Team member Updated");
		Thread.sleep(1000);

		JavascriptExecutor js2 = (JavascriptExecutor) driver; // Scroller
		js2.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		Thread.sleep(2000);

		// Resend the email notification to Team member

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_resendtheemail_notification_icon"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_yes_save"));
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, " Partner Team memberInviatation sent");
		Thread.sleep(2000);

		// Delete the Team member
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_tm_delete"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_yes_delete"));
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "partner Teammember Deleted Successfully");

		// Clicking on Admins

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_admins"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_adminpopup_close"));
		Thread.sleep(1000);

		

	
	}

}

