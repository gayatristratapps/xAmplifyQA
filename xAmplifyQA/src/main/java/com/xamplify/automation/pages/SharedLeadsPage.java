package com.xamplify.automation.pages;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Properties;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.automation.Instance;
import com.xamplify.util.SharedLeadsUtil;
import com.xamplify.util.XamplifyUtil;

public class SharedLeadsPage {
    WebDriver driver;
    Properties properties;
    Logger logger = LogManager.getLogger(SharedLeadsPage.class);

	/*
	 * public SharedLeadsPage() { this.driver = Instance.getInstance();
	 * this.properties = com.xamplify.automation.PropertiesFile.readPropertyFile(
	 * "D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Sharedleads.properties"
	 * ); }
	 */
    public SharedLeadsPage(WebDriver driver, Properties properties) {
        this.driver = driver;
        this.properties = properties;
    }

    public void hoverOnSharedLeads() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Hovering on Shared Leads section.");
        XamplifyUtil.callClickEvent(properties.getProperty("sharedleads"));
        Thread.sleep(3000);
        logger.info("Hovered and clicked on Shared Leads section.");
    }

    public void applySharedLeadsFilter() throws Exception {
        logger.info("Applying filter on Shared Leads.");
        Thread.sleep(5000);
        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter"));
        Thread.sleep(1000);
        XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_fieldname"), "City");
        Thread.sleep(1000);
        XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_drop"), "Contains");
        Thread.sleep(1000);
        XamplifyUtil.sendTextEvent(properties.getProperty("sharedAll_filter_value"), "HYDerabad");
        Thread.sleep(1000);
        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_submit"));
        Thread.sleep(8000);
        logger.info("Filter applied successfully.");
        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_close"));
        Thread.sleep(2000);
        
    }

    public void closeFilter() throws Exception {
        logger.info("Closing the filter.");
        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_close"));
        Thread.sleep(1000);
        logger.info("Filter closed.");
    }

    public void filterSearch() throws Exception {
        logger.info("Searching with filter.");
        Thread.sleep(1000);
      
        
        SharedLeadsUtil.sendTextEvent(properties.getProperty("sharedAll_filter_search"), "a");
        Thread.sleep(2000);
        XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.ENTER);
        Thread.sleep(1000);
        logger.info("Filter search applied.");
    }

    public void clearSearch() throws Exception {
        logger.info("Clearing search filter.");
        XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.BACK_SPACE);
        Thread.sleep(2000);
        XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.ENTER);
        Thread.sleep(2000);
        logger.info("Search filter cleared.");
    }

    public void manageSharedleadsTilesSort() throws Exception {
        logger.info("Managing Shared Leads tiles sorting.");
        Thread.sleep(6000);
        List<String> sortOptions = Arrays.asList("Email (A-Z)", "Email (Z-A)", "First name (ASC)", "First name (DESC)", "Last name (ASC)");
        for (String option : sortOptions) {
            XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_sort"), option);
            Thread.sleep(3000);
        }
        Thread.sleep(1000);
        logger.info("Shared Leads tiles sorting completed.");
    }

    public void manageSharedleadsTilesEmailreports() throws Exception {
        logger.info("Managing email reports for Shared Leads tiles.");
        Thread.sleep(4000);
        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_emailreport"));
        logger.info("Email report triggered.");
    }

    
    
    

    public void manageSharedleadsAllTilesEmailreports() throws Exception {
        logger.info("Managing email reports for Shared Leads tiles.");
        Thread.sleep(4000);
        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_emailreport"));
        logger.info("Email report triggered.");
    }
    
    
    
    
    public void applyAllEditTileSortOptions() throws InterruptedException {
    	 Thread.sleep(3000);

    	  XamplifyUtil.callClickEvent(properties.getProperty("sharedleads_edit_sort"));
          Thread.sleep(3000);

        By dropdownLocator = By.xpath(properties.getProperty("sharedleads_edit_sort"));

        for (int i = 1; i <= 6; i++) {
            String option = i + ": Object";
            manageSharedleadsEditTilesSort(dropdownLocator, option);
        }
    }

    
    public void clickMoreLessButton() throws InterruptedException {
        logger.info("Clicking more/less button...");
		Thread.sleep(3000);

        driver.findElement(By.id("more_less_button_0")).click();
    }

  public void clickInfoIcon() throws InterruptedException {
    	
        logger.info("Clicking info icon...");
        Thread.sleep(7000);
        driver.findElement(By.xpath(properties.getProperty("sharedleads_infoicon"))).click();
        Thread.sleep(2000);
    }
    
    public void clickunsubscribeicon() throws InterruptedException {
        logger.info("Clicking unsub icon...");
	  
    
    
    XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsub"));
	Thread.sleep(1000);

	XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsubReason"));
	Thread.sleep(1000);

	XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsubSubmit"));
	Thread.sleep(2000);
    
    }
    
    
    
    
    
    
    
    
    
    
    
    public void manageSharedleadsEditTilesSort(By locator, String value) {
        logger.info("Managing sorting on Shared Leads edit tiles.");
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                WebElement dropdownElement = driver.findElement(locator);
                Select dropdown = new Select(dropdownElement);
                dropdown.selectByValue(value);

                String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
                if (selectedValue.equals(value)) {
                    System.out.println("Selected value: " + dropdown.getFirstSelectedOption().getText());
                    return;
                } else {
                    System.out.println("Selection did not register correctly. Attempt " + (attempt + 1));
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException caught. Retrying... Attempt " + (attempt + 1));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        throw new RuntimeException("Failed to select value '" + value + "' after " + maxAttempts + " attempts due to stale element reference.");
    }
    
    
    
    
    public void sharedLeadsListUnsubscribeTile() throws Exception {
        logger.info("Starting Unsubscribe action on Shared Leads tile.");

        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Check if Unsubscribe tile is clickable
        WebElement unsubscribeTile = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(properties.getProperty("sharedlead_edit_Unsubscribed"))));

        if (unsubscribeTile.isEnabled()) {
            unsubscribeTile.click();
            logger.info("Unsubscribe tile clicked.");
        } else {
            logger.warn("Unsubscribe tile is disabled due to 0 count.");
            return;
        }

        // Apply filter and download email report
        filterSearch();
        Thread.sleep(1000);  // You can replace this with explicit wait for results load
        manageSharedleadsTilesEmailreports();

        // Resubscribe logic
        logger.info("Resubscribing shared lead.");
        XamplifyUtil.callClickEvent(properties.getProperty("sharedlead_edit_Subscribe"));

        WebElement reasonField = XamplifyUtil.getElementById("comment");
        reasonField.sendKeys("Resubscribe sharedlead 123");

        XamplifyUtil.callClickEvent(properties.getProperty("sharedlead_edit_Resubscribe"));

        XamplifyUtil.takeScreenshot(driver, "Resubscribed sharedlead");
        logger.info("Resubscribe action completed and screenshot taken.");
    }
    
    
    public void sharedLeadsEditListValidTile(int count) throws Exception {
        logger.info("Starting Valid Tile action on Shared Leads edit list.");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement validTile = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(properties.getProperty("sharedlead_edit_valid"))));

        if (count > 0 && validTile.isEnabled()) {
            validTile.click();
            logger.info("Valid tile clicked successfully.");
        } else {
            logger.warn("SharedLeads - Valid tile is disabled or not clickable because its count is 0 or it's not visible.");
        }
    }
    
  
	public int getValidTileCount() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
	public void sharedLeadsEditListExcludeTile(int count) throws Exception {
	    logger.info("Starting Exclude Tile action on Shared Leads edit list.");

	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement excludeTile = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath(properties.getProperty("sharedlead_edit_exclude"))));

	    if (count > 0 && excludeTile.isEnabled()) {
	        excludeTile.click();
	        logger.info("Exclude tile clicked successfully.");
	    } else {
	        logger.warn("SharedLeads - Exclude tile is disabled because its count is '0' or it's not visible.");
	    }
	}

	public void sharedLeadsEditListUndeliverableTile(int count) throws Exception {
	    logger.info("Starting Undeliverable Tile action on Shared Leads edit list.");

	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement undeliverableTile = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath(properties.getProperty("sharedlead_edit_Undeliverable"))));

	    if (count > 0 && undeliverableTile.isEnabled()) {
	        undeliverableTile.click();
	        logger.info("Undeliverable tile clicked successfully.");
	    } else {
	        logger.warn("Undeliverable tile is disabled because its count is '0' or it's not visible.");
	    }
	}


	public int getExcludeTileCount() {
	    String countText = driver.findElement(By.xpath(properties.getProperty("sharedlead_edit_exclude"))).getText();
	    
	    // Extract only digits from the string
	    String digitsOnly = countText.replaceAll("[^0-9]", ""); // removes non-digits

	    if (digitsOnly.isEmpty()) {
	        // Log warning or return 0 if no number is present
	        System.out.println("No numeric value found in Undeliverable tile text: " + countText);
	        return 0;
	    }

	    return Integer.parseInt(digitsOnly);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getUndeliverableTileCount() {
	    String countText = driver.findElement(By.xpath(properties.getProperty("sharedlead_edit_Undeliverable"))).getText();
	    
	    // Extract only digits from the string
	    String digitsOnly = countText.replaceAll("[^0-9]", ""); // removes non-digits

	    if (digitsOnly.isEmpty()) {
	        // Log warning or return 0 if no number is present
	        System.out.println("No numeric value found in Undeliverable tile text: " + countText);
	        return 0;
	    }

	    return Integer.parseInt(digitsOnly);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void manageAllSharedLeadsTileActions() throws Exception {
	    logger.info("Starting actions on all Shared Leads tiles.");

	    hoverOnSharedLeads();
	    logger.debug("Clicking on shared lead in partner account.");
		Thread.sleep(55000);
		
		XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsAll"));
		

	    applySharedLeadsFilter();
	    filterSearch();

	    manageSharedleadsTilesSort();
	    manageSharedleadsAllTilesEmailreports();

	    XamplifyUtil.takeScreenshot(driver, "EmailReportForAllTileSharedleads");
	    logger.info("Actions on all Shared Leads tiles completed.");
	}

	
	
	public void manageValidSharedLeadsTileActions() throws Exception {
	    logger.info("Starting actions on Valid Shared Leads tile.");

	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement validTile = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath(properties.getProperty("sharedleadsValid"))));
	    validTile.click();
	    Thread.sleep(4000);
	    applySharedLeadsFilter();
	    Thread.sleep(3000);

	    manageSharedleadsAllTilesEmailreports();
	    XamplifyUtil.takeScreenshot(driver, "EmailReportForValidTileSharedleads");
	    logger.info("Email report for Valid Tile Shared Leads captured.");
	}
	public void manageExcludeSharedLeadsTileActions() throws Exception {
	    logger.info("Starting actions on Exclude Shared Leads tile.");

	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement excludeTile = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath(properties.getProperty("sharedleads_exclude"))));

	    int count = getTileCount("sharedleads_exclude");


	    if (count > 0 && excludeTile.isEnabled()) {
	        excludeTile.click();

	        applySharedLeadsFilter();
	        manageSharedleadsTilesSort();
	        manageSharedleadsTilesEmailreports();

	        XamplifyUtil.takeScreenshot(driver, "EmailReportForExcludeTileSharedleads");
	        closeFilter();

	        logger.info("Actions on Exclude tile completed successfully.");
	    } else {
	        logger.warn("SharedLeads - Exclude [from All] tile is disabled because its count is '0' or it's not visible.");
	    }
	}

	public int getTileCount(String countXpathKey) {
	    String text = driver.findElement(By.xpath(properties.getProperty(countXpathKey))).getText().trim();
	    
	    // Remove non-digit characters
	    String numericOnly = text.replaceAll("[^0-9]", ""); // e.g., "21 Excluded" → "21"

	    try {
	        return Integer.parseInt(numericOnly);
	    } catch (NumberFormatException e) {
	        logger.error("Unable to parse count from text: '" + text + "'", e);
	        return 0; // or handle gracefully
	    }
	}

	
	
	
	
	public void manageUndeliverableSharedLeadsTileActions() throws Exception {
	    logger.info("Starting actions on Undeliverable Shared Leads tile.");

	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement undeliverableTile = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath(properties.getProperty("sharedleads_undeliverable"))));

	    int count = getTileCount("sharedleads_undeliverable");


	    if (count > 0 && undeliverableTile.isEnabled()) {
	        logger.info("Undeliverable tile is enabled, clicking.");
	        undeliverableTile.click();

	        applySharedLeadsFilter();
	        manageSharedleadsTilesSort();
	        manageSharedleadsTilesEmailreports();

	        XamplifyUtil.takeScreenshot(driver, "EmailReportForUndeliverableTile");
	        logger.info("Email report for Undeliverable Tile Shared Leads captured.");
	    } else {
	        logger.warn("Undeliverable tile count is 0 or tile is disabled, skipping action.");
	    }
	}

	
	public void manageUnsubscribeSharedLeadsTileActions() throws Exception {
	    logger.info("Starting Unsubscribe action on Shared Leads tile.");

	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement unsubscribeTile = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath(properties.getProperty("sharedleads_unsubscribe"))));

	    int count = getTileCount("sharedleads_unsubscribe");
	    

	    if (count > 0 && unsubscribeTile.isEnabled()) {
	        logger.info("Unsubscribe tile is enabled, proceeding to click.");
	        unsubscribeTile.click();

	        applySharedLeadsFilter();
	        manageSharedleadsTilesSort();
	        manageSharedleadsTilesEmailreports();

	        XamplifyUtil.takeScreenshot(driver, "EmailReportForUnsubscribeTile");
	        logger.info("Captured Email report for Unsubscribe Tile Shared Leads.");
	    } else {
	        logger.warn("Unsubscribe tile is either disabled or count is 0. Skipping click.");
	    }
	}

	
	

	
	
	public void manageSharedLeadsSort() throws Exception {
	    logger.info("Starting sorting actions on Shared Leads.");

	    

		hoverOnSharedLeads();
		Thread.sleep(3000);
	    
	    WebDriverWait wait = new WebDriverWait(driver, 50);

	    By dropdownLocator = By.xpath(properties.getProperty("manageSharedSort"));
	    wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator)).click();

	    // Perform sorting with retry logic
	    manageSharedleadsEditTilesSort(dropdownLocator, "1: Object");
	    manageSharedleadsEditTilesSort(dropdownLocator, "2: Object");
	    manageSharedleadsEditTilesSort(dropdownLocator, "3: Object");
	    manageSharedleadsEditTilesSort(dropdownLocator, "4: Object");

	    logger.info("Sorting actions completed.");
	}

	
	
	
	
	public void manageSharedLeadsGrid() throws Exception {
	    logger.info("Managing Shared Leads Grid actions.");
	    Thread.sleep(3000);

	    XamplifyUtil.callClickEvent(properties.getProperty("manageSharedGrid"));
	    Thread.sleep(2000);

	    WebElement shgrid = driver.findElement(By.xpath(properties.getProperty("manageSharedGridInfoicon")));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(shgrid).perform();

	    Thread.sleep(3000);
	    shgrid.click();

	    Thread.sleep(2000);
	    applySharedLeadsFilter(); // Assume this is defined in SharedLeadsPage
	    Thread.sleep(1000);

	    manageSharedleadsTilesEmailreports(); // Also assumed present
	    Thread.sleep(1000);

	    //filterSearch(); // Also assumed present
	    Thread.sleep(1000);

	    XamplifyUtil.takeScreenshot(driver, "GridforSharedLeads");
	    logger.info("Grid management actions completed.");
	}

	
    
}
    
    
    
  
