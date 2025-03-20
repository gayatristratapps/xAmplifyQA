package com.xamplify.automation;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class Pages {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Pages.properties");

	@Test(priority = 3, enabled = false)
	public void design() throws InterruptedException {
		// Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Designmodule"))));
		driver.findElement(By.xpath(properties.getProperty("Designmodule"))).click();// clicking on Design Module
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("DesignPages"));

	}

	@Test(priority = 4, enabled = false)
	public void regulartab() throws InterruptedException {

		XamplifyUtil.callClickEvent(properties.getProperty("Regular"));
		Thread.sleep(4000);

	}

	@Test(priority = 5, enabled = false)
	public void pagecreation() throws InterruptedException {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement hoveringregularpage = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(hoveringregularpage).perform();

		XamplifyUtil.callClickEvent(properties.getProperty("creatediv"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Openlinkinnewtab"))));

		XamplifyUtil.callClickEvent(properties.getProperty("Openlinkinnewtab"));
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("savebutton"))));
		XamplifyUtil.callClickEvent(properties.getProperty("savebutton"));
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

	}

	@Test(priority = 6, enabled = false)
	public void Savingregularpage() throws InterruptedException {

		Thread.sleep(5000);
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("nameoftheregularpage"), "Regularprivatepage", "new");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveandclose"));
		Thread.sleep(8000);
		XamplifyUtil.takeScreenshot(driver, "Regular private page");// takeScreenshot
		design();
	}

	@Test(priority = 7, enabled = false)
	public void creatingregularpublicpage() throws InterruptedException {
		Thread.sleep(8000);
		pagecreation();
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("nameoftheregularpage"), "Regularpublicpage", "new");
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("pagetypedropdown"), 1);
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveandclose"));
		Thread.sleep(8000);
		XamplifyUtil.takeScreenshot(driver, "Regular public page");
		design();
	}

	@Test(priority = 8, enabled = false)
	public void cobrandedtab() throws InterruptedException {
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("cobrandedtab"));
		Thread.sleep(3000);

	}

	@Test(priority = 9, enabled = false)
	public void cobrandedprivatepagecreation() throws InterruptedException {
		pagecreation();
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("nameoftheregularpage"), "cobrandedprivatepage",
				"new");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveandclose"));
		Thread.sleep(8000);
		XamplifyUtil.takeScreenshot(driver, "cobranded private page");
		design();
	}

	@Test(priority = 10, enabled = false)
	public void cobrandedpublicpagecreation() throws InterruptedException {
		cobrandedtab();
		Thread.sleep(3000);
		pagecreation();
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("nameoftheregularpage"), "cobrandedpublicpage",
				"new");
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("pagetypedropdown"), 1);
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveandclose"));
		Thread.sleep(8000);
		XamplifyUtil.takeScreenshot(driver, "cobranded public page");

	}

	@Test(priority = 11, enabled = false)
	public void Managepages() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Designmodule"))));
		XamplifyUtil.callClickEvent(properties.getProperty("Designmodule"));
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("ManagePages"));

	}

	@Test(priority = 12, enabled = true)
	public void ManageRegularpublicpage() throws InterruptedException {
		Managepages();
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("regularpublictab"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("copypage"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("copiedname"))).clear();
		Thread.sleep(2000);
		//XamplifyUtil.sendTextWithTimestamp(properties.getProperty("copiedname"), "Copiedregularpublicpage");
		XamplifyUtil.callClickEvent(properties.getProperty("savingcopiedregpublicpage"));
		Thread.sleep(7000);
		XamplifyUtil.callClickEvent(properties.getProperty("okbutton1"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("Editregpublicpage"));
		Thread.sleep(7000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("savebutton"));
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		XamplifyUtil.callClickEvent(properties.getProperty("editupdateandclose"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("previewtheregpublicpage"));	
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
		
	}
}