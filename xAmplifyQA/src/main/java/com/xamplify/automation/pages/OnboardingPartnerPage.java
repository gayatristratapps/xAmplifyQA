package com.xamplify.automation.pages;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.partners;
import com.xamplify.util.XamplifyUtil;
import com.xamplifycon.util.XamplifyUtil_contacts;

public class OnboardingPartnerPage {
	static WebDriver driver = Instance.getInstance();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	static Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\partners.properties");
	final static Logger logger = LogManager.getLogger(partners.class);
	static String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";
	static String getMailId = "";
	static String uniquecompany = "";
	
// Generative CSV with data
		public static String CreateCSVFile() {
			getMailId = "user" + System.currentTimeMillis() + "@gmail.com";
			uniquecompany = "company" + System.nanoTime();
			List<String[]> partnerUserData = Arrays.asList(
					new String[] {
							"AutomationUser", "Test", "uACCOUNT NAME", "uACCOUNT OWNER", "uACCOUNT SUB TYPE",
							"cm1" + uniquecompany, "uCOMPANY DOMAIN", "uJOBTITLE", "us1" + getMailId, "", "uVERTICAL,uREGION",
							"uTERRITORY", "uTYPE","uCATEGORY", "uKondapur", "uHyderabad", "uTelangana", "534350", "India", "2125554567" },
					new String[] { "AutomationUser", "Test", "uACCOUNT NAME", "uACCOUNT OWNER", "uACCOUNT SUB TYPE",
							"cm2" + uniquecompany, "COMPANY DOMAIN", "JOBTITLE", "us2" + getMailId, "", "VERTICAL,REGION",
							"uTERRITORY", "uTYPE","uCATEGORY", "uKondapur", "uHyderabad", "uTelangana", "534350", "India", "+919999088099" });
			// Step 3: Generate CSV dynamically and get the file path
			String filePath = XamplifyUtil.generatePartnerCSV(partnerUserData);
			return filePath;
		}
	
// onboarding partner form
		public static void onboardpartnerForm() throws InterruptedException {
			Thread.sleep(2000);
			getMailId = "user" + System.currentTimeMillis() + "@gmail.com";
			uniquecompany = "company" + System.nanoTime();
			XamplifyUtil.sendTextEvent(properties.getProperty("emailid_1"), getMailId);
			XamplifyUtil.sendTextEvent(properties.getProperty("companyname"), uniquecompany);
			XamplifyUtil.sendTextEvent(properties.getProperty("firstname"), "firstname");
			XamplifyUtil.sendTextEvent(properties.getProperty("lastname"), "lastname");
			XamplifyUtil.sendTextEvent(properties.getProperty("jobtitle"), "jobtitle");
			XamplifyUtil.sendTextEvent(properties.getProperty("address"), "address");
			XamplifyUtil.sendTextEvent(properties.getProperty("city"), "city");
			XamplifyUtil.sendTextEvent(properties.getProperty("state"), "state");
			XamplifyUtil.sendTextEvent(properties.getProperty("zipcode"), "123456");
			XamplifyUtil.sendTextEvent(properties.getProperty("vertical"), "vertical");
			XamplifyUtil.sendTextEvent(properties.getProperty("Region"), "Region");
			XamplifyUtil.sendTextEvent(properties.getProperty("category"), "category");
			XamplifyUtil.sendTextEvent(properties.getProperty("Partnertype"), "Partnertype");  
			XamplifyUtil.callClickEvent(properties.getProperty("CountryCode"));
			XamplifyUtil.sendTextEvent(properties.getProperty("CountryCodeSearch"), "+91");
			XamplifyUtil.callClickEvent(properties.getProperty("selectCountryCode"));

			XamplifyUtil.sendmobileTextEvent("phoneNumber", "9908899088", driver, properties);
			XamplifyUtil.sendTextEvent(properties.getProperty("legall"), "Legitimate interest - prospect/lead");
			XamplifyUtil.sendKeyEvent(properties.getProperty("legall"), Keys.ENTER);
			Thread.sleep(4000);
		}

// Update partner form
		public static void updatepartnerForm() throws InterruptedException {
			Thread.sleep(2000);
			//driver.findElement(By.xpath(properties.getProperty("firstname"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("firstname"), "firstname7");
			//driver.findElement(By.xpath(properties.getProperty("lastname"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("lastname"), "lastname7");
			//driver.findElement(By.xpath(properties.getProperty("jobtitle"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("jobtitle"), "jobtitle7");
			//driver.findElement(By.xpath(properties.getProperty("address"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("address"), "address7");
			//driver.findElement(By.xpath(properties.getProperty("city"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("city"), "city7");
			//driver.findElement(By.xpath(properties.getProperty("state"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("state"), "state7");
			//driver.findElement(By.xpath(properties.getProperty("zipcode"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("zipcode"), "1234567");
			//driver.findElement(By.xpath(properties.getProperty("vertical"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("vertical"), "vertical7");
			//driver.findElement(By.xpath(properties.getProperty("Region"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("Region"), "Region7");
			//driver.findElement(By.xpath(properties.getProperty("category"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("category"), "category7");
			//driver.findElement(By.xpath(properties.getProperty("Partnertype"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("Partnertype"), "Partnertype7");
			
			XamplifyUtil.callClickEvent(properties.getProperty("CountryCode"));
			XamplifyUtil.sendTextEvent(properties.getProperty("CountryCodeSearch"), "+91");
			XamplifyUtil.callClickEvent(properties.getProperty("selectCountryCode"));
			
			XamplifyUtil.sendmobileTextEvent("phoneNumber", "9908899088", driver, properties);

			Thread.sleep(2000);
		}

// Hover on Partner module and open Onboarding partner
		public static void HoverPartners_OnboardingPartner( ) throws InterruptedException {
			Thread.sleep(2000);
			WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hoverpartner"))));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0);");
			XamplifyUtil.hoverAndClick(driver, properties, "hoverpartner", "Onboarding");			
		} 

// Onboarding partner through upload a csv file
		public static void OnboardParnerThroughUploadCSV() throws InterruptedException {
			Thread.sleep(5000);
			String filePath = CreateCSVFile();
	// Step:Locate file input and upload CSV
			WebElement uploadElement = driver.findElement(By.xpath(properties.getProperty("uploadcsv1")));
			uploadElement.sendKeys(filePath);
	// Step: Select Legal Basis Selection  
			Thread.sleep(5000);
			String legalBasisXPath = properties.getProperty("legall");
			XamplifyUtil.sendTextEvent(properties.getProperty("legall"), "Legitimate interest - prospect/lead");
			XamplifyUtil.sendKeyEvent(properties.getProperty("legall"), Keys.ENTER);
			Thread.sleep(5000);
	// Step: Click on save button and accept t&c then continue to upload
			XamplifyUtil.callClickEvent(properties.getProperty("csvparnersave"));
			Thread.sleep(3000);
			WebElement acceptTandC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("acceptT&C"))));
			acceptTandC.click();
			Thread.sleep(3000);
			WebElement pcontinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("pContinue"))));
			pcontinue.click();
			Thread.sleep(3000);
			XamplifyUtil.takeScreenshot(driver, "Upload CSV");
			Thread.sleep(2000);
			// autoResponseMessage("Your Partner(s) have been saved successfully");
			// Step 7 : verify Csv upload success message validation
			/*
			 * WebElement sucess_msg =
			 * driver.findElement(By.xpath(properties.getProperty("con_existname"))); String
			 * expected_msg = "Your Partner(s) have been saved successfully"; String
			 * Actual_msg = sucess_msg.getText(); Assert.assertEquals(Actual_msg,
			 * expected_msg);
			 */
			}

// Onboarding partner through One At a Time
		public static void OnboardPartnerOneAtaTime() throws InterruptedException {
			Thread.sleep(9000);
			XamplifyUtil.callClickEvent(properties.getProperty("oneatatime"));
			Thread.sleep(5000);
			onboardpartnerForm();
			// Step 3: Click on proceed button and accept t&c then continue to upload
			XamplifyUtil.callClickEvent(properties.getProperty("oneatatimeproceed"));
			WebElement acceptTandC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("acceptT&C"))));
			Thread.sleep(3000);
			acceptTandC.click();
			Thread.sleep(3000);
			WebElement pcontinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("pContinue"))));
			pcontinue.click();
			Thread.sleep(3000);
			XamplifyUtil.takeScreenshot(driver, "OneataTime");
		}

// Edit the partner and update the partner details
		public static void partnerEdit() throws InterruptedException {
			Thread.sleep(4000);
			HoverPartners_OnboardingPartner();
			Thread.sleep(5000);
			XamplifyUtil.callClickEvent(properties.getProperty("editpartner"));
			Thread.sleep(4000);
			updatepartnerForm();
			Thread.sleep(3000);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("updatepartner2"))));
			element.click();
			// XamplifyUtil.callClickEvent(properties.getProperty("updatepartner2"));
			Thread.sleep(3000);
			XamplifyUtil.takeScreenshot(driver, "updatePartner");
		}
		
		
// search partner and verify search result contain search word
		public static void searchAndVerifyPartner() throws InterruptedException {
			Thread.sleep(3000);
			// Step 1: Perform search
			String searchKeyword = getMailId;			
			Thread.sleep(6000);
			XamplifyUtil.sendTextEvent(properties.getProperty("searchh"), searchKeyword);
			Thread.sleep(2000);
			XamplifyUtil.sendKeyEvent(properties.getProperty("searchh"), Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Email Id:']/..")));
			// Step 2: Verify search results
			// Find all records that contain the email ID using XPath
			List<WebElement> emailRecords = driver.findElements(By.xpath("//b[text()='Email Id:']/.."));
			// Verify that each of the email records contains the search keyword
			for (WebElement record : emailRecords) {
				String emailText = record.getText();
				//System.out.println("Search record : " + emailText + " = searchkeyword : " + searchKeyword);
				// Assert that the email text contains the search keyword
				Assert.assertTrue(emailText.contains(searchKeyword), "Search keyword does not match with the record: " + emailText);
			}
			Thread.sleep(2000);
		}

// Export partners excel report
		public static void exportToExcel() throws InterruptedException {
			//searchAndVerifyPartner();
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("action"));
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("downloadingpartners"));
			Thread.sleep(2000);
			XamplifyUtil.takeScreenshot(driver, "exportToExcel");
		}

//Export partner email report
		public static void exportToEmail() throws InterruptedException {
			Thread.sleep(3000);
			searchAndVerifyPartner();
			Thread.sleep(5000);
			XamplifyUtil.callClickEvent(properties.getProperty("exportToMail"));
			Thread.sleep(4000);
			XamplifyUtil.takeScreenshot(driver, "exportToemail");
		}

//Create Partner group
		public static void createGroup() throws InterruptedException {
			//searchAndVerifyPartner();
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("checkbox1"));
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("action"));
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("newGroup"));
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("nameofthelist"))).clear();
			XamplifyUtil.sendTextEvent(properties.getProperty("nameofthelist"), "NewGroup" + System.currentTimeMillis());
			Thread.sleep(4000);
			XamplifyUtil.sendTextEvent(properties.getProperty("legalInGroup"), "Legitimate interest - prospect/lead");
			Thread.sleep(2000);
			XamplifyUtil.sendKeyEvent(properties.getProperty("legalInGroup"), Keys.ENTER);
			Thread.sleep(2000);
			WebElement saveButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("saveNewGroup"))));
			saveButton.click();
			Thread.sleep(2000);
			XamplifyUtil.takeScreenshot(driver, "newgroup");
		}

//Add partners to existing Group
		public static void addToGroup() throws InterruptedException {
			searchAndVerifyPartner();
			Thread.sleep(5000);
			XamplifyUtil.callClickEvent(properties.getProperty("checkbox1"));
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("action"));
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("addToGroup"));
			Thread.sleep(15000);
			XamplifyUtil.callClickEvent(properties.getProperty("groupcheckbox"));
			Thread.sleep(4000);
			XamplifyUtil.callClickEvent(properties.getProperty("addpartnerToGroup"));
			Thread.sleep(3000);
			XamplifyUtil.takeScreenshot(driver, "AddPartnerToGroup");
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("modernPopupClose"));
		}

// Delete the partner
		public static void deletePartner() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0);");
			searchAndVerifyPartner(); 
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("deletepartneronboard"));
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("yesdeleteit"));
			Thread.sleep(9000);
			XamplifyUtil.takeScreenshot(driver, "deletePartner");
		}
		
// Onboarding partner pagination
		public static void pagenation() throws Throwable {
			Thread.sleep(5000);
			WebElement pagination2 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("pagenation2"))));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", pagination2);
			Thread.sleep(4000);
			// Wait until the element is clickable and then click it
			wait.until(ExpectedConditions.elementToBeClickable(pagination2)).click();
			Thread.sleep(3000);
			XamplifyUtil.takeScreenshot(driver, "pagination2");
		}
		
//Sort And No of Records in Page 
		public static void SortAndNoofrecord() throws InterruptedException {
			Thread.sleep(4000);
		    WebElement sortDropdown = driver.findElement(By.xpath(properties.getProperty("sort")));
		    Select sortbyindex = new Select(sortDropdown);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 200)");
		    List<WebElement> sortOptions = sortbyindex.getOptions();
		    for (int i = 0; i < sortOptions.size(); i++) {
		        sortbyindex.selectByIndex(i);
		        Thread.sleep(6000); // If you need a short wait, use it here
		        XamplifyUtil.takeScreenshot(driver, "sortPartner_" + i);
		    }	
	//No of records for page
			Thread.sleep(4000);
			 WebElement noOfRecordsDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(properties.getProperty("noOfRecordsInPage"))));
			    Select noOfRecords = new Select(noOfRecordsDropdown);
			    List<WebElement> recordOptions = noOfRecords.getOptions();
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");		        
			    noOfRecords.getOptions().get(1).click();
				Thread.sleep(4000);
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);
		        XamplifyUtil.takeScreenshot(driver, "sortPartner_1");
				Thread.sleep(4000);
		}

// filter partners with partner fields
		public static void filterPartner(String Field, String Condition, String Value) throws InterruptedException {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("partner_filter")))).click();
			applyFilter(Field, Condition, Value);
		}
		
// Filter fields
		public static void applyFilter(String Field, String Condition, String Value) throws InterruptedException {
			//Thread.sleep(5000);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("partner_filter")))).click();
			try {
				WebElement field = driver.findElement(By.xpath(properties.getProperty("partner_filter_fieldname")));
				new Select(field).selectByVisibleText(Field);
				Thread.sleep(1000);
				WebElement condition = driver.findElement(By.xpath(properties.getProperty("partner_filter_condition")));
				new Select(condition).selectByVisibleText(Condition);
				Thread.sleep(1000);
				WebElement value = driver.findElement(By.xpath(properties.getProperty("partner_filter_Value")));
				value.sendKeys(Value);
				Thread.sleep(2000);
				XamplifyUtil_contacts.callClickEvent(properties.getProperty("filter_submit"));
				Thread.sleep(2000);
		        XamplifyUtil.takeScreenshot(driver, "filterPartner_");
				logger.info("Successfully applied filter fields");
			} catch (Exception e) {
				logger.error("Error in applyFilterFields method", e);
				throw e;
			}
		}

//add other filter record for multiple condition
		public static void addFilterRecord(String Field, String Condition, String Value) throws InterruptedException {
			try {
				Thread.sleep(4000);
				XamplifyUtil.callClickEvent(properties.getProperty("addFilter_record"));
				WebElement field = driver.findElement(By.xpath(properties.getProperty("partner_filter_fieldname2")));
				new Select(field).selectByVisibleText(Field);
				Thread.sleep(1000);
				WebElement condition = driver.findElement(By.xpath(properties.getProperty("partner_filter_condition2")));
				new Select(condition).selectByVisibleText(Condition);
				Thread.sleep(1000);
				WebElement value = driver.findElement(By.xpath(properties.getProperty("partner_filter_Value2")));
				value.sendKeys(Value);
				Thread.sleep(2000);
				XamplifyUtil_contacts.callClickEvent(properties.getProperty("filter_submit"));
				Thread.sleep(2000);
		        XamplifyUtil.takeScreenshot(driver, "MultipleFilterConditionPartner_");
			} catch (Exception e) {
				logger.error("Error in addFilterFields method", e);
				throw e;
			}
		}

// Delete the filter record
		public static void deleteFilterRecord() throws InterruptedException {
			try {
				Thread.sleep(4000);
				XamplifyUtil.callClickEvent(properties.getProperty("deleteFilter_record"));
				Thread.sleep(2000);
				XamplifyUtil_contacts.callClickEvent(properties.getProperty("filter_submit"));
				Thread.sleep(2000);
		        XamplifyUtil.takeScreenshot(driver, "DeleteFilterConditionPartner_");
			} catch (Exception e) {
				logger.error("Error in deleteFilterFields method", e);
				throw e;
			}
		}
		




}
