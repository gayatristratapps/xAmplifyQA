package com.xamplify.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class ManagePartner {
  
	static WebDriver driver = Instance.getInstance();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Managepartner.properties");
	static Properties newproperties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Partners.properties");
	static String groupName = "NewGroup" + System.currentTimeMillis();
 
	@Test(priority = 1, enabled = true)
	public void CreateNewPartnerGroup() throws InterruptedException {
		Thread.sleep(3000);
		// Step 1: Hover over the "Partner" section
		hoverOnPartners();
		Thread.sleep(6000);  
		WebElement AllTile = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Alltile"))));
		wait.until(ExpectedConditions.elementToBeClickable(AllTile)).click();
		// XamplifyUtil.callClickEvent(properties.getProperty("Alltile"));
		Thread.sleep(8000);
		XamplifyUtil.callClickEvent(properties.getProperty("checkAll"));
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("Action"));
		XamplifyUtil.callClickEvent(properties.getProperty("CreateGroup"));
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(properties.getProperty("groupName"), groupName);
		XamplifyUtil.sendTextEvent(properties.getProperty("legalInGroup"), "Legitimate interest - prospect/lead");
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(properties.getProperty("legalInGroup"), Keys.ENTER);
		XamplifyUtil.callClickEvent(properties.getProperty("savechanges"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "newGroupManagePartner");
	}

	@Test(priority = 2, enabled = true)
	public void exportToMail() throws InterruptedException {
		hoverOnPartners();
		Thread.sleep(5000);
		WebElement AllTile = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Alltile"))));
		wait.until(ExpectedConditions.elementToBeClickable(AllTile)).click();
		// XamplifyUtil.callClickEvent(properties.getProperty("Alltile"));
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("checkAll"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("exportemail"));
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "exportMailManagePartner");
	}

	@Test(priority = 3, enabled = true) // false
	public static void Mpartners_Sortandsearch_Copyandsavegroup() throws Throwable {
		hoverOnPartners(); // Mangae partners
		Thread.sleep(5000);
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

	@Test(priority = 4, enabled = true)
	public void Mpartners_EditGroup() throws InterruptedException {
		Thread.sleep(3000);
		hoverOnPartners();
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("editGroup"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("oneatatime"));
// Upload One At a Time in edit Group
		oneAtATime_EditGroup();
		hoverOnPartners();
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("editGroup"));
		Thread.sleep(3000);
// Upload Csv in edit Group
		uploadCsv_EditGroup();
//Edit and update the partner
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(properties.getProperty("editGroup"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("editpartner"));
		partners.updatepartnerForm();
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("updatepartner"));
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "updatePartnerInGroup");
		Thread.sleep(3000);
//Search the partner in partner group
		String searchkey = partners.getMailId;
		XamplifyUtil.callClickEvent(properties.getProperty("search"));
		XamplifyUtil.sendTextEvent(properties.getProperty("search"), searchkey);
		XamplifyUtil.sendKeyEvent(properties.getProperty("search"), Keys.ENTER);
		// partners.verifySearchResults(searchkey);
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "SearchpartnerInGroup");
	}

	@Test(priority = 5, enabled = true)
	public void Mpartners_publishContent() throws InterruptedException {
//publish Campaigns
		hoverOnPartners();
		Thread.sleep(2000);
		driver.findElement(By.xpath(newproperties.getProperty("searchmanage"))).clear();
		XamplifyUtil.sendTextEvent(newproperties.getProperty("searchmanage"), "Newgroup");
		Thread.sleep(1000);
		XamplifyUtil.sendKeyEvent(newproperties.getProperty("searchmanage"), Keys.ENTER);
		Thread.sleep(6000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("campain"));
		Thread.sleep(5000);
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
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("campain"));
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("unpublishAssets"));
		try {
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
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("campain"));
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("unpublishTrack"));
		try {
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
//publish Tracks
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("campain"));
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("unpublishPlaybook"));
		try {
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

	@Test(priority = 7, enabled = false)
	public void Mpartners_DeleteGroup() throws InterruptedException {
		hoverOnPartners();
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("searchmanage"));
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(newproperties.getProperty("searchmanage"), groupName);
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(newproperties.getProperty("searchmanage"), Keys.ENTER);
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("deletemanage"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(newproperties.getProperty("deletemanagelist"));
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "DeleteManagePartner");
	}

	@Test(priority = 8, enabled = false) // isssue with robo class
	public void exportToExcel() throws InterruptedException, AWTException {
		hoverOnPartners();
		Thread.sleep(5000);
		WebElement AllTile = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Alltile"))));
		wait.until(ExpectedConditions.elementToBeClickable(AllTile)).click();
		// XamplifyUtil.callClickEvent(properties.getProperty("Alltile"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("checkAll"));
		XamplifyUtil.callClickEvent(properties.getProperty("Action"));
		XamplifyUtil.callClickEvent(properties.getProperty("exportexcel"));
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// XamplifyUtil.excelDownload();
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "exportExcelManagePartner");
	}

	@Test(priority = 6, enabled = true)
	public void pagenation() throws Throwable {
		hoverOnPartners();
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

	// methods..................................
	public static void hoverOnPartners() throws InterruptedException {
		Thread.sleep(3000);
		WebElement hoverElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hoverpartner"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		XamplifyUtil.hoverAndClick(driver, properties, "hoverpartner", "managepartner");
	}

	public void oneAtATime_EditGroup() throws InterruptedException {
		partners.onboardpartnerForm();
		// Step 3: Click on proceed button and accept t&c then continue to upload
		XamplifyUtil.callClickEvent(newproperties.getProperty("oneatatimeproceed"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("pContinue"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("acceptT&C"));
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "OneataTime");
	}

	public void uploadCsv_EditGroup() throws InterruptedException {
		Thread.sleep(3000);
		String filePath = partners.CreateCSVFile();
		// Step:Locate file input and upload CSV
		Thread.sleep(4000);
		WebElement uploadElement = driver.findElement(By.xpath(properties.getProperty("uploadCSV")));
		uploadElement.sendKeys(filePath);
		// Step: Select Legal Basis Selection
		// String legalBasisXPath = newproperties.getProperty("legall");
		XamplifyUtil.sendTextEvent(newproperties.getProperty("legall"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(newproperties.getProperty("legall"), Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("codePass1");

		// Step: Click on save button and accept t&c then continue to upload
		XamplifyUtil.callClickEvent(properties.getProperty("actionCSV"));
		Thread.sleep(2000);
		System.out.println("codePass2");
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

}
