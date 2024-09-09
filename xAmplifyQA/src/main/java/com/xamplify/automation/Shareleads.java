package com.xamplify.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class Shareleads {

	private static final int TWO_SECONDS = XamplifyUtil.TWO_SECONDS;
	private static final int THREE_SECONDS = XamplifyUtil.THREE_SECONDS;
	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Shareleads.properties");
	final Logger logger = LogManager.getLogger(Shareleads.class);

	@Test(priority = 1, enabled = true)
	public void hoveron_shareleads() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("hovershareleads")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// mouse hover action on the element
		action.moveToElement(ele).perform();

		XamplifyUtil.clickEvent(properties.getProperty("add_shareleads"), driver);
	}

	private void callClickEvent(String propertyKey) {
		XamplifyUtil.clickEvent(propertyKey, driver);
	}

	private void callSendClickEvent(String propertyKey, String sendKey) {
		XamplifyUtil.sendClickEvent(propertyKey, driver, sendKey);

		//driver.findElement(By.xpath(properties.getProperty("add_shareleads"))).click(); //add share leads

	}

	@Test(priority = 2, enabled = true)
	public void shareleads_oneatatime() throws InterruptedException {
		Thread.sleep(Shareleads.THREE_SECONDS);
		logger.debug("Starting creating partner using One at a time");

		driver.findElement(By.xpath(properties.getProperty("sharelistname"))).click();

		callClickEvent(properties.getProperty("sharelistname"));

		Thread.sleep(2000);

		callSendClickEvent(properties.getProperty("sharelistname"), "AutoSlist" + System.currentTimeMillis());

		logger.info("starts onboarding share leads"); // enter list name
		callClickEvent(properties.getProperty("sh_oneattime"));

		Thread.sleep(Shareleads.TWO_SECONDS);
		driver.findElement(By.xpath(properties.getProperty("sh_emailid"))).click();
		driver.findElement(By.xpath(properties.getProperty("sh_emailid")))
				.sendKeys("Gayatri_automated" + System.currentTimeMillis() + "@getnada.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("sh_firstname"))).sendKeys("Gayatri");
		driver.findElement(By.cssSelector(properties.getProperty("sh_lastname"))).sendKeys("autoshare");
		driver.findElement(By.cssSelector(properties.getProperty("sh_company"))).sendKeys("automatecompany");

		driver.findElement(By.xpath(properties.getProperty("sh_legalbasis"))).click();

		WebElement shlegal = driver.findElement(By.xpath(properties.getProperty("sh_legalbasis")));
		shlegal.sendKeys("Legitimate interest - existing customer");// enter data for legal basis field
		shlegal.sendKeys(Keys.ENTER);// click enter in the keyboard
		shlegal.sendKeys("Legitimate interest - prospect/lead");// enter data for legal basis field
		shlegal.sendKeys(Keys.ENTER);// click enter in the keyboard

		driver.findElement(By.cssSelector(properties.getProperty("sh_jobtitle"))).sendKeys("jobtitle");
		driver.findElement(By.cssSelector(properties.getProperty("sh_Address"))).sendKeys("Address");
		driver.findElement(By.cssSelector(properties.getProperty("sh_state"))).sendKeys("state");

		driver.findElement(By.xpath(properties.getProperty("sh_mobileno"))).sendKeys("9876543210");
		driver.findElement(By.xpath(properties.getProperty("sh_country"))).click();
		driver.findElement(By.xpath(properties.getProperty("sh_country"))).sendKeys("india");

		driver.findElement(By.xpath(properties.getProperty("sh_country"))).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath(properties.getProperty("sh_city"))).sendKeys("Hyderabad");

		driver.findElement(By.cssSelector(properties.getProperty("sh_zipcode"))).sendKeys("567890");

		driver.findElement(By.xpath(properties.getProperty("sh_add"))).click(); // click on the add button
		driver.findElement(By.xpath(properties.getProperty("sh_save"))).click(); // click on the save button
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("sh_accept"))).click(); // click on the accept button

		sleepForTenSeconds();

	}

	private void sleepForTenSeconds() throws InterruptedException {
		XamplifyUtil.sleepForTenSeconds();
	}

	@Test(priority = 3, enabled = true)
	public void Shareleads_Copy_list_from_clipboard_tab() throws InterruptedException, SQLException, IOException

	{
		Thread.sleep(2000);

		hoveron_shareleads();
		Thread.sleep(2000);
		logger.debug("Starting creating partner using copy from clipboard - tab separated");

		driver.findElement(By.xpath(properties.getProperty("sh_copyclipboard_tab"))).click();// click copy from
		sleepForTenSeconds();
		driver.findElement(By.xpath(properties.getProperty("sharelistname"))).click();
		driver.findElement(By.xpath(properties.getProperty("sharelistname")))
				.sendKeys("Auto_tab_Slist" + System.currentTimeMillis()); // enter list name
		sleepForTenSeconds();
		driver.findElement(By.xpath(properties.getProperty("sh_tab_legalbasis"))).click();

		driver.findElement(By.xpath(properties.getProperty("sh_tab_legalbasis")))
				.sendKeys("Legitimate interest - prospect/lead"); // enter legal basis

		driver.findElement(By.xpath(properties.getProperty("sh_tab_legalbasis"))).sendKeys(Keys.ENTER); // enter from
																										// keyboard

		Select delimiter1 = new Select(driver.findElement(By.xpath(properties.getProperty("sh_dropdown"))));
		delimiter1.selectByValue("TabSeperated"); // select tab separated in the drop down
		sleepForTenSeconds();
		driver.findElement(By.xpath(properties.getProperty("sh_tab_textarea"))).click(); // click on the textarea
		sleepForTenSeconds();
		((JavascriptExecutor) driver).executeScript(
				"document.getElementById('copyFromclipTextArea').value='gayatri	A	Stratapps	QAAutomationEngineer	';");
		Thread.sleep(5000);
		driver.findElement(By.id("copyFromclipTextArea"))
				.sendKeys(System.currentTimeMillis() + "gayatri@stratapps.com	");
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("sh_verify"))).click(); // click on the verify button
		driver.findElement(By.xpath(properties.getProperty("sh_save"))).click(); // click on the save button
		sleepForTenSeconds();
		driver.findElement(By.xpath(properties.getProperty("sh_tab_accept"))).click(); // click on the accept button
		Thread.sleep(Shareleads.THREE_SECONDS);
	}

	@Test(priority = 4, enabled = true)
	public void shareleads_Copy_list_from_clipboard_comma() throws InterruptedException, SQLException, IOException

	{
		Thread.sleep(Shareleads.THREE_SECONDS);

		logger.debug("Starting creating partner using copy from clipboard - comma separated");
		hoveron_shareleads();
		driver.findElement(By.xpath(properties.getProperty("sharelistname"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("sharelistname")))
				.sendKeys("Autocoma" + System.currentTimeMillis()); // enter list name

		driver.findElement(By.xpath(properties.getProperty("sh_copyclipboard_comma"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("sh_comma_legalbasis"))).click();

		driver.findElement(By.xpath(properties.getProperty("sh_comma_legalbasis")))
				.sendKeys("Legitimate interest - existing customer"); // enter legal basis

		driver.findElement(By.xpath(properties.getProperty("sh_comma_legalbasis"))).sendKeys(Keys.ENTER);

		Select delimiter2 = new Select(driver.findElement(By.xpath(properties.getProperty("sh_dropdown"))));
		delimiter2.selectByValue("CommaSeperated"); // select value form the drop down
		sleepForTenSeconds();

		driver.findElement(By.xpath(properties.getProperty("sh_comma_textarea"))).click();
		sleepForTenSeconds();
		driver.findElement(By.xpath(properties.getProperty("sh_comma_textarea")))
				.sendKeys(("Gayatri,A,Stratapps,QAAutomationEngineer,")); // enter the data in text area
		driver.findElement(By.xpath(properties.getProperty("sh_comma_textarea")))
				.sendKeys(("Gayatri") + "_" + System.currentTimeMillis());
		driver.findElement(By.xpath(properties.getProperty("sh_comma_textarea"))).sendKeys("@getnada.com");

		driver.findElement(By.xpath(properties.getProperty("sh_verify"))).click(); // click on the verify button
		driver.findElement(By.xpath(properties.getProperty("sh_save"))).click(); // click on the save button
		driver.findElement(By.xpath(properties.getProperty("sh_comma_accept"))).click(); // click on the accept button
		Thread.sleep(4000);
	}

	@Test(priority = 5, enabled = true)
	public void shareleads_uploadcsv() throws InterruptedException, SQLException, IOException

	{
		Thread.sleep(Shareleads.THREE_SECONDS);

		logger.debug("Starting creating partner using upload a csv");
		hoveron_shareleads();

		driver.findElement(By.id("uploadCSV")).click(); // click on the upload csv
		Thread.sleep(5000);

		XamplifyUtil.executeRuntimeProcess();

		// Runtime.getRuntime().exec("D:\\git\\xAmplifyQA\\xAmplifyQA\\Uploadshareleads.exe");
		// // by using auto it create

		Thread.sleep(Shareleads.THREE_SECONDS);

		driver.findElement(By.xpath(properties.getProperty("sh_csv_legalbasis"))).click();// click on the legal basis

		driver.findElement(By.xpath(properties.getProperty("sh_csv_legalbasis")))
				.sendKeys("Legitimate interest - existing customer"); // enter legal basis

		driver.findElement(By.xpath(properties.getProperty("sh_csv_legalbasis"))).sendKeys(Keys.ENTER); // click on the
																										// enter

		driver.findElement(By.xpath(properties.getProperty("sh_csvlist"))).clear();

		driver.findElement(By.xpath(properties.getProperty("sh_csvlist")))
				.sendKeys("Autoupload" + System.currentTimeMillis()); // enter list name

		driver.findElement(By.xpath(properties.getProperty("sh_csv_save"))).click();
		sleepForTenSeconds();
		driver.findElement(By.xpath(properties.getProperty("sh_csv_verify"))).click();
		Thread.sleep(2000);

	}

	@Test(priority = 6, enabled = true)
	public void manage_shareleads() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

		WebElement ele = driver.findElement(By.xpath(properties.getProperty("hovershareleads")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// mouse hover action on the element
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("manage_shareleads"))).click();
		Thread.sleep(6000);
	}

	@Test(priority = 7, enabled = true)
	public void manage_shareleads_sortby_copy_publish() throws InterruptedException, AWTException {

		WebDriverWait sh_sortby = new WebDriverWait(driver, 70);
		WebElement msh_sort = sh_sortby.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("manage_sh_sortby")))); // select
																														// dropdown

		Select msh_sort1 = new Select(msh_sort); // sort by

		msh_sort1.selectByVisibleText("List name (A-Z)");
		logger.debug("Sorted List name a-z");
		Thread.sleep(4000);

		msh_sort1.selectByVisibleText("List name (Z-A)");
		logger.debug("Sorted List name Z-A");

		Thread.sleep(4000);

		msh_sort1.selectByVisibleText("Creation date (ASC)");
		logger.debug("sorted Creation date (ASC)");
		Thread.sleep(4000);

		msh_sort1.selectByVisibleText("Creation date (DESC)");
		logger.debug("sorted Creation date (DESC)");

		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("manage_sh_gridview"))).click();

		Thread.sleep(4000);

		msh_sort1.selectByVisibleText("Assigned date (ASC)");
		logger.debug("sorted Assigned date (ASC)");
		Thread.sleep(5000);
		msh_sort1.selectByVisibleText("Assigned date (DESC)");
		logger.debug("sorted Assigned date (DESC)");
		Thread.sleep(Shareleads.THREE_SECONDS);

		WebElement sh_search = driver.findElement(By.xpath(properties.getProperty("manage_sh_grid_search"))); //search
		sh_search.sendKeys("Auto");
		sh_search.sendKeys(Keys.ENTER);
		Thread.sleep(Shareleads.THREE_SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(properties.getProperty("manage_sh_gridview_preview")))); //click for preview
		element.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("manage_sh_gridview_preview_cls"))).click(); //close the preview
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("manage_sh_grid_search_expand"))).click();  //expand 

		WebElement dwnclck = driver.findElement(By.xpath(properties.getProperty("manage_sh_download"))); // click for download
		dwnclck.click();

		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			;
			sleepForTenSeconds();
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_S);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		logger.debug("download success");

		Thread.sleep(2000);

		WebElement sh_searchclr = driver.findElement(By.xpath(properties.getProperty("manage_sh_grid_search"))); //click on the search

		sh_searchclr.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		sh_searchclr.sendKeys(Keys.ENTER);

		logger.debug("cleared text in search field");

		Thread.sleep(4000);

		msh_sort1.selectByVisibleText("Creation date (DESC)");
		logger.debug("sorted Creation date (DESC)");

		Thread.sleep(7000);

		driver.findElement(By.xpath(properties.getProperty("manage_sh_copy"))).click();

		WebElement we = driver.findElement(By.xpath(properties.getProperty("manage_sh_copy_save")));
		we.click();

		logger.debug("copy&save success");
		Thread.sleep(7000);

		driver.findElement(By.xpath(properties.getProperty("manage_sh_publishicon"))).click(); 

		logger.debug("click for publish icon");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("manage_sh_publish_selectcom"))).click();  //select company
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("manage_sh_publish_selectall"))).click();  //select all the partners in the company

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("manage_sh_publish_submit"))).click();
		Thread.sleep(2000);
		logger.debug("click for published");

		driver.findElement(By.xpath(properties.getProperty("manage_sh_publish_submit_close"))).click();

		Thread.sleep(10000);

	}

	@Test(priority = 8, enabled = true)
	public void delete_shareleadlist() throws InterruptedException {

		manage_shareleads();

		WebDriverWait sh_del = new WebDriverWait(driver, 70);
		WebElement msh_del = sh_del.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("manage_sh_delete")))); //click on the delete icon

		msh_del.click();

		driver.findElement(By.xpath(properties.getProperty("manage_sh_deleted"))).click();

		logger.debug("Deleted shareleads list");

	}

}
