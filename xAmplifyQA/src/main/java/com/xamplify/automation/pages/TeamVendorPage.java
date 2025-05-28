package com.xamplify.automation.pages;

import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Properties;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import com.xamplify.util.TeamVendorUtil;

public class TeamVendorPage {
	WebDriver driver;
	Properties properties;

	public TeamVendorPage(WebDriver driver, Properties properties) {
		this.driver = driver;
		this.properties = properties;
	}

	public void hoverTeam() throws InterruptedException {
		TeamVendorUtil.clickElementWithWait(driver, properties.getProperty("hoveronTeam"), 50);
		Thread.sleep(2000);
	}

	public void addTeammember() throws InterruptedException {
		// Add the Team member by clicking on "Add" button

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_add_button"));
		Thread.sleep(5000);

		// Given the first name, Lastname and Emaild
		TeamVendorUtil.sendTextEvent(properties.getProperty("clickon_firstname_field"), "CMR_FN");
		Thread.sleep(1000);
		TeamVendorUtil.sendTextEvent(properties.getProperty("clickon_lastname_field"), "LN");
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_emailid_field"));
		Thread.sleep(1000);

		WebElement emailTextBx = driver.findElement(By.xpath(properties.getProperty("clickon_emailid_field")));

		// using this, it generates the random email id's
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailTextBx.sendKeys("mouni" + randomInt + "@gmail.com");
		Thread.sleep(3000);

		// Selecting the Team member group
		WebElement TM_grpdropdown = driver.findElement(By.xpath(properties.getProperty("clickon_TMGroup")));
		TM_grpdropdown.click();
		Thread.sleep(1000);

		TeamVendorUtil.selectDropdownByValue(properties.getProperty("clickon_TMGroup"), "2: 7180");
		TeamVendorUtil.selectDropdownByValue(properties.getProperty("clickon_TMGroup"), "1: 7179");
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_view_available_modules"));
		Thread.sleep(2000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_close_available_modules"));
		Thread.sleep(1000);

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_saveTM"));
		Thread.sleep(3000);
	}

	@Test(priority = 3, enabled = false)

	public void inviteTeammember() throws InterruptedException, AWTException {

		// Inviting the Team members by clicking Invite team members button
		Thread.sleep(5000);
		WebElement invite_tm = driver.findElement(By.xpath(properties.getProperty("clickon_invite_tm_button")));
		invite_tm.click();
		Thread.sleep(1000);

		WebElement emailfield = driver.findElement(By.xpath(properties.getProperty("clickon_email_field_invite_tm")));
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailfield.sendKeys("cmrinvite" + randomInt + "@gmail.com");
		Thread.sleep(1000);

		// TeamVendorUtil.excelDownload();
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_send"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_close"));
		Thread.sleep(1000);

		// Invite Team member Analytics
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invite_tm_analytics"));
		Thread.sleep(1000);

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_dropdown"));
		Thread.sleep(1000);

		TeamVendorUtil.selectDropdownByValue(properties.getProperty("clickon_invitetm_dropdown"), "1: Object");
		Thread.sleep(1000);

		TeamVendorUtil.selectDropdownByValue(properties.getProperty("clickon_invitetm_dropdown"), "2: Object");
		Thread.sleep(1000);

		TeamVendorUtil.selectDropdownByValue(properties.getProperty("clickon_invitetm_dropdown"), "3: Object");
		Thread.sleep(1000);

		TeamVendorUtil.sendTextEvent(properties.getProperty("clickon_invitetm_Search"), "gmail.com");

		Thread.sleep(1000);

		// Search functionality
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_Search_icon"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_Search_clear"));
		Thread.sleep(1000);

		// Applying filter by giving the date and team member conditions
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_filter"));
		Thread.sleep(1000);
		WebElement invite_tm1 = driver.findElement(By.xpath(properties.getProperty("clickon_invitedby_filter")));
		invite_tm1.sendKeys("automation.vendor2024@gmail.com");
		invite_tm1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_selectdate_field"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("select_from_date"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_todate_field"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("select_to_date"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_apply_button"));
		Thread.sleep(1000);

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_refreshtm")); // refresh button

		// Export the Team members

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_exportexcel"));
		Thread.sleep(1000);
		// TeamVendorUtil.excelDownload();

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_filter"));
		Thread.sleep(1000);

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetm_filter_close"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_invitetab"));
		Thread.sleep(2000);

		// click on Navigation Breadcrumb
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_team_breadcrumb"));
		Thread.sleep(1000);

	}

	public void genearteCSV() throws InterruptedException {

		Thread.sleep(2000);

		// Define file path and data
		String filePath = "teammemberupload.csv";
		String[][] data = { { "Email Id", "First Name", "Last Name" }, { "cmrtest@gmail.com", "mouni", "ch" },
				// {"cmrtest1@gmail.com", "mouni", "ch"},

		};

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (String[] row : data) {
				writer.write(String.join(",", row));
				writer.newLine();
			}
			System.out.println("CSV file generated successfully!");
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test(priority = 5, enabled = true)
	public void testFileUpload() throws InterruptedException {
		// Generate the CSV file first
		genearteCSV(); // Call the method to generate the CSV
		Thread.sleep(5000);

		// Find the file input element
		WebElement uploadcsvfile = driver.findElement(By.xpath(properties.getProperty("clickon_uploadcsv_button"))); // Change
																														// ID
																														// if
																														// needed

		// Get the absolute path of the generated CSV file
		String filePath = new File("teammemberupload.csv").getAbsolutePath();

		// Upload the file by sending the file path to the file input element
		uploadcsvfile.sendKeys(filePath);
		Thread.sleep(3000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_upload_csv_tmg"));
		Thread.sleep(2000);

		TeamVendorUtil.selectDropdownByText(properties.getProperty("clickon_upload_csv_tmg"), "Sales Account Manager");
		Thread.sleep(1000);

		// click on save button to save the Team members
		WebElement submitButton = driver.findElement(By.xpath(properties.getProperty("clickon_Save_csv"))); // Change ID
																											// if needed
		submitButton.click();

		System.out.println("File uploaded successfully!");
	}

	public void searchTeamMember() throws InterruptedException {
		// Search functionality
		Thread.sleep(2000);
		TeamVendorUtil.sendTextEvent(properties.getProperty("clickon_Search_tm"), "cmrtest@gmail.com");
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_Searchicon_tm"));
		Thread.sleep(1000);

	}

	public void deleteSearchedMember() throws InterruptedException {

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_upload_delete"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_yes_delete"));
		Thread.sleep(3000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_refreshtm")); // Refresh
		Thread.sleep(2000);
	}

	public void exportTeamMembers() throws InterruptedException {
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_tm_exportexcel"));
		Thread.sleep(2000);
	}

	public void filterByEmailAndDate(String email) throws InterruptedException {
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_filtertm"));
		Thread.sleep(1000);

		WebElement emailInput = driver.findElement(By.xpath(properties.getProperty("clickon_select_tm_filter")));
		emailInput.sendKeys(email);
		emailInput.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_selectdate_field"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("select_from_date"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_todate_field"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("select_to_date"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_apply_button"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_filtertm"));
		Thread.sleep(1000);

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_clear_filter"));
		Thread.sleep(3000);
	}

	public void PreviewTeamMember() throws InterruptedException {

		JavascriptExecutor js1 = (JavascriptExecutor) driver; // Scroller
		js1.executeScript("window.scrollTo(document.body.scrollHeight,300)");
		Thread.sleep(4000);
		// preview of Team member Group
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_preview_group"));
		Thread.sleep(2000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_close_available_modules"));
		Thread.sleep(1000);

	}

	public void editTeammember(String newFirstName) throws InterruptedException {
		WebElement editBtn = driver.findElement(By.xpath(properties.getProperty("clickon_edit_icontm")));
		editBtn.click();
		Thread.sleep(2000);
		WebElement fnameInput = driver.findElement(By.xpath(properties.getProperty("clickon_firstname_field")));
		fnameInput.clear();
		fnameInput.sendKeys(newFirstName);
		Thread.sleep(2000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_tm_update"));
		Thread.sleep(1000);
		TeamVendorUtil.takeScreenshot(driver, "Update_team member");
		Thread.sleep(2000);
	}

	public void resendEmailNotification() throws InterruptedException {

		JavascriptExecutor js2 = (JavascriptExecutor) driver; // Scroller
		js2.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		Thread.sleep(2000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_resendtheemail_notification_icon"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_yes_save"));
		Thread.sleep(1000);
		TeamVendorUtil.takeScreenshot(driver, "Invitation sent");
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_admins"));

//		WebElement admin= driver.findElement(By.xpath(properties.getProperty("clickon_admins")));
//		admin.click();
		Thread.sleep(3000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_adminpopup_close"));
		Thread.sleep(1000);

		// clicking on total partners under Team members

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_total_partners_tm"));
		Thread.sleep(1000);

		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_total_partners_popupclose"));
		Thread.sleep(1000);
	}

	public void deleteTeammember() throws InterruptedException {
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_tm_delete"));
		Thread.sleep(1000);
		TeamVendorUtil.callClickEvent(properties.getProperty("clickon_yes_delete"));
		Thread.sleep(3000);
	}
}
