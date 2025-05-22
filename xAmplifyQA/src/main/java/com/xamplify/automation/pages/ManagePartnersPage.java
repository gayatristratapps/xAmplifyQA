package com.xamplify.automation.pages;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.partners;
import com.xamplify.util.XamplifyUtil;

public class ManagePartnersPage {
	static WebDriver driver = Instance.getInstance();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	static Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Managepartner.properties");
	static Properties newproperties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Partners.properties");
	static String groupName = "NewGroup" + System.currentTimeMillis();
	
// Hover on Partner module and open Manage partner
	public static void HoverOnPartnersManagePartners() throws InterruptedException {
		Thread.sleep(3000);
		WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hoverpartner"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		XamplifyUtil.hoverAndClick(driver, properties, "hoverpartner", "managepartner");
	}
	
// Create New Partner Group
	public static void CreateNewPartnerGroup() throws InterruptedException {
		Thread.sleep(6000);  
		WebElement AllTile = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Alltile"))));
		wait.until(ExpectedConditions.elementToBeClickable(AllTile)).click();
		// XamplifyUtil.callClickEvent(properties.getProperty("Alltile"));
		Thread.sleep(8000);
		XamplifyUtil.callClickEvent(properties.getProperty("checkAll"));
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("Action"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("CreateGroup"));
		Thread.sleep(3000);
		XamplifyUtil.sendTextEvent(properties.getProperty("groupName"), groupName);
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(properties.getProperty("legalInGroup"), "Legitimate interest - prospect/lead");
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(properties.getProperty("legalInGroup"), Keys.ENTER);
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("savechanges"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "newGroupManagePartner");
	}

// Export partner email report
	public static void exportToMail() throws InterruptedException {
		Thread.sleep(5000);
		WebElement AllTile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Alltile"))));
		wait.until(ExpectedConditions.elementToBeClickable(AllTile)).click();
		// XamplifyUtil.callClickEvent(properties.getProperty("Alltile"));
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("checkAll"));
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("exportemail"));
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "exportMailManagePartner");
	}
	
// Sort and search the partner group, copy and save the group
	public static void Mpartners_Sortandsearch_Copyandsavegroup() throws Throwable {
		Thread.sleep(7000);
		Select sortby1 = new Select(driver.findElement(By.xpath(newproperties.getProperty("sortbymanagepartners"))));
//sort the partner groups
		sortby1.selectByIndex(2);
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "sortManagePartner");
// Search Partner Group
		XamplifyUtil.callClickEvent(newproperties.getProperty("searchmanage"));
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(newproperties.getProperty("searchmanage"), "newgroup");
		Thread.sleep(1000);
		XamplifyUtil.sendKeyEvent(newproperties.getProperty("searchmanage"), Keys.ENTER);
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "SearchManagePartner");
		Thread.sleep(2000);
		// sort the partner groups
		sortby1.selectByIndex(4);
		Thread.sleep(6000);
//Copyand save partner group
		XamplifyUtil.callClickEvent(newproperties.getProperty("copyandsave"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(newproperties.getProperty("copyandsavename"))).clear();
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(newproperties.getProperty("copyandsavename"),
				"automated list" + "_" + System.currentTimeMillis());
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("savenamechanges"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "CopyandsaveGroup");
		Thread.sleep(2000);
	}
	
// upload a partner one at a time
	public static void oneAtATime_EditGroup() throws InterruptedException {
		OnboardingPartnerPage.onboardpartnerForm();
		// Step 3: Click on proceed button and accept t&c then continue to upload
		XamplifyUtil.callClickEvent(newproperties.getProperty("oneatatimeproceed"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("pContinue"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("acceptT&C"));
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "OneataTime");
	}

	public static void uploadCsv_EditGroup() throws InterruptedException {
		Thread.sleep(3000);
		String filePath = OnboardingPartnerPage.CreateCSVFile();
		// Step:Locate file input and upload CSV
		Thread.sleep(4000);
		WebElement uploadElement = driver.findElement(By.xpath(properties.getProperty("uploadCSV")));
		uploadElement.sendKeys(filePath);
		// Step: Select Legal Basis Selection
		// String legalBasisXPath = newproperties.getProperty("legall");
		XamplifyUtil.sendTextEvent(newproperties.getProperty("legall"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(newproperties.getProperty("legall"), Keys.ENTER);
		Thread.sleep(3000);
		// Step: Click on save button and accept t&c then continue to upload
		XamplifyUtil.callClickEvent(properties.getProperty("actionCSV"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveCSV"));
		Thread.sleep(3000);
		WebElement pcontinue = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("pContinue"))));
		pcontinue.click();
		Thread.sleep(3000);
		WebElement acceptTandC = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("acceptT&CCSV"))));
		acceptTandC.click();
		XamplifyUtil.takeScreenshot(driver, "Upload CSV EditGroup");
	}
		
// Edit Partner group
	public static void Mpartners_EditGroup() throws InterruptedException {
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("editGroup"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("oneatatime"));
// Upload One At a Time in edit Group
		oneAtATime_EditGroup();
		HoverOnPartnersManagePartners();
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("editGroup"));
		Thread.sleep(3000);
// Upload Csv in edit Group
		uploadCsv_EditGroup();
//Edit and update the partner
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("editGroup"));
		Thread.sleep(7000);
		XamplifyUtil.callClickEvent(properties.getProperty("editpartner"));
		OnboardingPartnerPage.updatepartnerForm();
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("updatepartner"));
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "updatePartnerInGroup");
		Thread.sleep(3000);
//Search the partner in partner group
		String searchkey = OnboardingPartnerPage.getMailId;
		XamplifyUtil.callClickEvent(properties.getProperty("search"));
		XamplifyUtil.sendTextEvent(properties.getProperty("search"), searchkey);
		XamplifyUtil.sendKeyEvent(properties.getProperty("search"), Keys.ENTER);
		// partners.verifySearchResults(searchkey);
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "SearchpartnerInGroup");
	}	
	
// Publish content to the partner
	public static void Mpartners_publishContent() throws InterruptedException {
		//publish Campaigns
				Thread.sleep(2000);
				driver.findElement(By.xpath(newproperties.getProperty("searchmanage"))).clear();
				System.out.println(groupName);
				XamplifyUtil.sendTextEvent(newproperties.getProperty("searchmanage"), groupName);
				Thread.sleep(1000);
				XamplifyUtil.sendKeyEvent(newproperties.getProperty("searchmanage"), Keys.ENTER);
				Thread.sleep(15000);
				XamplifyUtil.callClickEvent(properties.getProperty("publishIcon"));
				Thread.sleep(5000);
				//trycatch
				try {
					XamplifyUtil.callClickEvent(properties.getProperty("entinfo"));
					Thread.sleep(2000);
					XamplifyUtil.callClickEvent(properties.getProperty("shareContent"));
					Thread.sleep(5000);
					XamplifyUtil.takeScreenshot(driver, "campaignlaunchMPartner");
					XamplifyUtil.callClickEvent(properties.getProperty("closing"));
					Thread.sleep(2000);
				} catch (Exception e) {
					Thread.sleep(2000);
					String message = driver.findElement(By.xpath(properties.getProperty("NoCampaignsMsg"))).getText();
					System.out.println(message);
					Thread.sleep(2000);
					XamplifyUtil.takeScreenshot(driver, "NoCampaignlaunchMPartner");
					XamplifyUtil.callClickEvent(properties.getProperty("unpublishPopupClose"));
				}
				// publish Assets
				Thread.sleep(6000);
				XamplifyUtil.callClickEvent(newproperties.getProperty("publishContentIcon"));
				Thread.sleep(4000);
				XamplifyUtil.callClickEvent(properties.getProperty("unpublishAssets"));
				try {
					Thread.sleep(8000);
					XamplifyUtil.callClickEvent(properties.getProperty("entinfo"));
					Thread.sleep(2000);
					XamplifyUtil.callClickEvent(properties.getProperty("shareContent"));
					Thread.sleep(5000);
					XamplifyUtil.takeScreenshot(driver, "AssetlaunchMPartner");
					XamplifyUtil.callClickEvent(properties.getProperty("closing"));
					Thread.sleep(2000);
				} catch (Exception e) {
					Thread.sleep(2000);
					String message = driver.findElement(By.xpath(properties.getProperty("NoAssetMsg"))).getText();
					System.out.println(message);
					Thread.sleep(2000);
					XamplifyUtil.takeScreenshot(driver, "noAssetslaunchMPartner");
					XamplifyUtil.callClickEvent(properties.getProperty("unpublishPopupClose"));
				}

//publish Tracks
				Thread.sleep(6000);
				XamplifyUtil.callClickEvent(newproperties.getProperty("publishContentIcon"));
				Thread.sleep(4000);
				XamplifyUtil.callClickEvent(properties.getProperty("unpublishTrack"));
				try {
					Thread.sleep(8000);
					XamplifyUtil.callClickEvent(properties.getProperty("entinfo"));
					Thread.sleep(2000);
					XamplifyUtil.callClickEvent(properties.getProperty("shareContent"));
					Thread.sleep(5000);
					XamplifyUtil.takeScreenshot(driver, "TracklaunchMPartner");
					XamplifyUtil.callClickEvent(properties.getProperty("closing"));
					Thread.sleep(2000);
				} catch (Exception e) {
					Thread.sleep(2000);
					String message = driver.findElement(By.xpath(properties.getProperty("NoTrackPlaybookMsg"))).getText();
					System.out.println(message);
					Thread.sleep(2000);
					XamplifyUtil.takeScreenshot(driver, "noTracklaunchMPartner");
					XamplifyUtil.callClickEvent(properties.getProperty("unpublishPopupClose"));
				} 
		//publish playbook
				Thread.sleep(6000);
				XamplifyUtil.callClickEvent(newproperties.getProperty("publishContentIcon"));
				Thread.sleep(4000);
				XamplifyUtil.callClickEvent(properties.getProperty("unpublishPlaybook"));
				try {
					Thread.sleep(8000);
					XamplifyUtil.callClickEvent(properties.getProperty("entinfo"));
					Thread.sleep(2000);
					XamplifyUtil.callClickEvent(properties.getProperty("shareContent"));
					Thread.sleep(5000);
					XamplifyUtil.takeScreenshot(driver, "PlaybooklaunchMPartner");
					XamplifyUtil.callClickEvent(properties.getProperty("closing"));
					Thread.sleep(2000);
				} catch (Exception e) {
					Thread.sleep(2000);
					String message = driver.findElement(By.xpath(properties.getProperty("NoTrackPlaybookMsg"))).getText();
					System.out.println(message);
					Thread.sleep(2000);
					XamplifyUtil.takeScreenshot(driver, "noPlaybooklaunchMPartner");
					XamplifyUtil.callClickEvent(properties.getProperty("unpublishPopupClose"));
				}
				XamplifyUtil.takeScreenshot(driver, "campaignlaunchMPartner");
			}
	
// filter partners with partner fields
	public static void filterManagePartner(String Field, String Condition, String Value) throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("managePartner_filter")))).click();
		OnboardingPartnerPage.applyFilter(Field, Condition, Value);
	}

// Delete Partner group	in Manage partner
	public static void Mpartners_DeleteGroup() throws InterruptedException {
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("searchmanage"));
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(newproperties.getProperty("searchmanage"), groupName);
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(newproperties.getProperty("searchmanage"), Keys.ENTER);
		Thread.sleep(15000);
		//WebElement deletegroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("deletemanage"))));
		XamplifyUtil.callClickEvent(newproperties.getProperty("deletemanage"));
		//wait.until(ExpectedConditions.elementToBeClickable(deletegroup)).click();
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("deletemanagelist"));
		Thread.sleep(7000);
		XamplifyUtil.takeScreenshot(driver, "DeleteManagePartner");
		Thread.sleep(15000);
		
	}

// Export to excel	
	public static void exportToExcel() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		WebElement AllTile = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Alltile"))));
		wait.until(ExpectedConditions.elementToBeClickable(AllTile)).click();
		// XamplifyUtil.callClickEvent(properties.getProperty("Alltile"));
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("search"));
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(properties.getProperty("search"), OnboardingPartnerPage.getMailId);
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(properties.getProperty("search"), Keys.ENTER);
		Thread.sleep(9000);
		XamplifyUtil.callClickEvent(properties.getProperty("checkAll"));
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("Action"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("exportexcel"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "exportExcelManagePartner");
	}

// Manage partners pagination
	public static void pagenation() throws Throwable {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 2000)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(newproperties.getProperty("pagenation2"))).click();
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "pagination2");

		// driver.findElement(By.xpath(newproperties.getProperty("pagenation_last"))).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath(newproperties.getProperty("pagenation_first"))).click();
	}
	
	public static void backToHome() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='company-logo-thumbnail-wrapper']")).click();
	}
}
