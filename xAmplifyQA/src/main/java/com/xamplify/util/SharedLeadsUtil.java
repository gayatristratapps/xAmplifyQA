package com.xamplify.util;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.automation.PropertiesFile;

public class SharedLeadsUtil {
    private static  WebDriver driver;
    private Properties props;
    private static final Logger logger = LogManager.getLogger(SharedLeadsUtil.class);

    
    
    public SharedLeadsUtil(WebDriver driver) {
        this.driver = driver;
        this.props = PropertiesFile.readPropertyFile("src/main/resources/Sharedleads.properties");
    }

   

    public void clickEditSortDropdown() throws InterruptedException {
        logger.info("Clicking edit sort dropdown...");
        driver.findElement(By.xpath(props.getProperty("sharedleads_edit_sort"))).click();
        Thread.sleep(1000);
    }

    public void selectSortOptions() throws InterruptedException {
        By dropdownLocator = By.xpath(props.getProperty("sharedleads_edit_sort"));
        for (int i = 1; i <= 6; i++) {
            String value = i + ": Object";
            logger.info("Selecting sort option: " + value);
            driver.findElement(dropdownLocator).sendKeys(value);
            Thread.sleep(1000);
        }
    }

    
 
    
    
    
public void unsubscribeTileAction() throws Exception {
    logger.info("Starting Unsubscribe action on Shared Leads tile.");

    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement unsubscribeTile = wait.until(ExpectedConditions
            .elementToBeClickable(By.xpath(props.getProperty("sharedlead_edit_Unsubscribed"))));

    if (unsubscribeTile.isEnabled()) {
        unsubscribeTile.click();
    } else {
        logger.debug("Sharedleads-Unsubscribe tile is disabled because its count is '0'");
        return;
    }
   // Thread.sleep(1000);

    // Perform filter search
    
    
   
    
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter_search"));
    Thread.sleep(1000);

    manageTilesEmailReports();
    Thread.sleep(3000);

    logger.info("Resubscribing sharedlead.");
    XamplifyUtil.callClickEvent(props.getProperty("sharedlead_edit_Subscribe"));
    Thread.sleep(1000);

    WebElement reason = XamplifyUtil.getElementById("comment");
    reason.sendKeys("Resubscribe sharedlead 123");

    XamplifyUtil.callClickEvent(props.getProperty("sharedlead_edit_Resubscribe"));
    XamplifyUtil.takeScreenshot(driver, "Resubscribed sharedlead");

    logger.info("Resubscribe action completed and screenshot taken.");
}

public void manageTilesEmailReports() throws Exception {
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter_emailreport"));
    Thread.sleep(1000);
}

public void clickValidTileIfPresent(int count) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement validTile = wait.until(ExpectedConditions
            .elementToBeClickable(By.xpath(props.getProperty("sharedlead_edit_valid"))));

    if (count > 0 && validTile.isEnabled()) {
        validTile.click();} else {
            logger.debug("Sharedleads-Valid tile is disabled because its count is '0' or it's not visible.");
        }
    }

public int getTileCount(String tileXpath) {
    WebElement tile = driver.findElement(By.xpath(props.getProperty(tileXpath)));
    String tileText = tile.getText(); // e.g., "Valid (5)" or "Exclude (0)"
    
    // Extract digits from the string
    String countStr = tileText.replaceAll("\\D+", "");
    
    if (countStr.isEmpty()) {
        return 0;
    }
    return Integer.parseInt(countStr);
}


public void clickTileIfEnabled(String tileKey, String tileName, int count) throws Exception {
    logger.info("Attempting to click on " + tileName + " tile.");
    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement tile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty(tileKey))));

    if (count > 0 && tile.isEnabled()) {
        tile.click();
        logger.info(tileName + " tile clicked.");
    } else {
        logger.debug(tileName + " tile is disabled because its count is '0' or it's not visible.");
    }
}

public void performAllTileActions() throws Exception {
    logger.info("Performing actions on all Shared Leads tiles.");
    Thread.sleep(2000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedleadsAll"));
    Thread.sleep(2000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter"));
    Thread.sleep(2000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter_search"));
    Thread.sleep(5000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter_sort"));
    Thread.sleep(1000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter_emailreport"));
    Thread.sleep(1000);
    XamplifyUtil.takeScreenshot(driver, "EmailReportForAllTileSharedleads");
}

public void performValidTileActions() throws Exception {
    logger.info("Performing actions on Valid Shared Leads tile.");
    Thread.sleep(3000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedleadsValid"));
    Thread.sleep(3000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter"));
    Thread.sleep(2000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter_sort"));
    Thread.sleep(2000);
    XamplifyUtil.callClickEvent(props.getProperty("sharedAll_filter_emailreport"));
    Thread.sleep(1000);
    XamplifyUtil.takeScreenshot(driver, "EmailReportForValidTileSharedleads");
}
public int getCountValue(String tileXpathKey) {
    try {
        WebElement tile = driver.findElement(By.xpath(props.getProperty(tileXpathKey)));
        String tileText = tile.getText(); // e.g., "Exclude (3)"
        String countStr = tileText.replaceAll("\\D+", "");
        return countStr.isEmpty() ? 0 : Integer.parseInt(countStr);
    } catch (Exception e) {
        logger.error("Failed to get count for tile: " + tileXpathKey, e);
        return 0;
    }
}

public void clickTileIfEnabled(String tileKey) throws Exception {
    int count = getCountValue(tileKey);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement tile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty(tileKey))));

    if (count > 0 && tile.isEnabled()) {
        tile.click();
    } else {
        logger.debug(tileKey + " tile is disabled or has count 0.");
    }
}

public void sharedleadsFilter() throws InterruptedException {
    XamplifyUtil.callClickEvent(props.getProperty("sharedlead_filter"));
    Thread.sleep(1000);
}

public void closeFilter() throws InterruptedException {
    XamplifyUtil.callClickEvent(props.getProperty("close_filter"));
    Thread.sleep(1000);
}

public void manageTilesSort(By dropdownLocator, String optionText) throws InterruptedException {
    selectFromDropdown(driver, dropdownLocator, optionText);
    Thread.sleep(1000);
}


public static void selectFromDropdown(WebDriver driver, By dropdownLocator, String optionText) {
    try {
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    } catch (Exception e) {
        System.err.println("Dropdown selection failed for: " + optionText);
        e.printStackTrace();
    }
}










public void manageTilesEmailReports(String screenshotName) throws InterruptedException {
    XamplifyUtil.callClickEvent(props.getProperty("email_reports_button"));
    Thread.sleep(1000);
    XamplifyUtil.takeScreenshot(driver, screenshotName);
}

public static void sendTextEvent(String propertyKey, String text) {
	driver.findElement(By.xpath(propertyKey)).sendKeys(text);
}
}




