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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.automation.Instance;
	import com.xamplify.util.XamplifyUtil;

	public class SharedLeadsPage {

	    WebDriver driver = Instance.getInstance();
	    Properties properties = com.xamplify.automation.PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Sharedleads.properties");
	    final Logger logger = LogManager.getLogger(SharedLeadsPage.class);

	    public void hoverOnSharedLeads() throws InterruptedException {
	        Thread.sleep(3000);
	        logger.info("Hovering on Shared Leads section.");
	        XamplifyUtil.callClickEvent(properties.getProperty("sharedleads"));
	        Thread.sleep(2000);
	    }

	    public void applyFilter() throws Exception {
	        Thread.sleep(2000);
	        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter"));
	        Thread.sleep(1000);
	        XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_fieldname"), "City");
	        XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_drop"), "Contains");
	        XamplifyUtil.sendTextEvent(properties.getProperty("sharedAll_filter_value"), "HYDerabad");
	        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_submit"));
	        Thread.sleep(2000);
	        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_close"));
	    }

	    public void closeFilter() throws Exception {
	        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_close"));
	    }

	    public void searchWithFilter() throws Exception {
	        XamplifyUtil.sendTextEvent(properties.getProperty("sharedAll_filter_search"), "a");
	        Thread.sleep(2000);
	        XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.ENTER);
	    }

	    public void clearSearch() throws Exception {
	        XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.BACK_SPACE);
	        Thread.sleep(2000);
	        XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.ENTER);
	    }

	    public void sortTiles() throws Exception {
	        List<String> sortOptions = Arrays.asList("Email (A-Z)", "Email (Z-A)", "First name (ASC)", "First name (DESC)", "Last name (ASC)");
	        for (String option : sortOptions) {
	            XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_sort"), option);
	            Thread.sleep(3000);
	        }
	    }

	    public void emailReports() throws Exception {
	        XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_emailreport"));
	    }

	    public void sortEditTile(By locator, String value) {
	        int attempts = 3;
	        for (int i = 0; i < attempts; i++) {
	            try {
	                WebElement dropdown = driver.findElement(locator);
	                new Select(dropdown).selectByValue(value);
	                String selected = new Select(dropdown).getFirstSelectedOption().getAttribute("value");
	                if (selected.equals(value)) return;
	            } catch (StaleElementReferenceException e) {
	                logger.warn("Stale element, retrying...");
	            }
	            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
	        }
	        throw new RuntimeException("Failed to select value: " + value);
	    }

	    public void unsubscribeLead() throws Exception {
	        XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsub"));
			Thread.sleep(2000);

	        XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsubReason"));
			Thread.sleep(1000);

	        XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsubSubmit"));
			Thread.sleep(1000);

	    }
	    
	    
	
	    
	    public int getCountValue() {
	        try {
	            String countXpath = properties.getProperty("sharedleads_exclude");
	            WebElement countElement = driver.findElement(By.xpath(countXpath + "/../../div[@class='number']"));
	            String countText = countElement.getText().trim().replaceAll("[^0-9]", "");
	            return Integer.parseInt(countText);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0; // default to 0 on error
	        }
	    }

	    
	    
	    
	    
	    

	    public void clickExcludeTileIfEnabled() throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        WebElement excludeTile = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath(properties.getProperty("sharedleads_exclude"))));

	        int count = getCountValue();

	        if (count > 0 && excludeTile.isEnabled()) {
	            excludeTile.click();
	            Thread.sleep(2000);
	            performExcludeTileActions();
	        } else {
	            System.out.println("Exclude tile is disabled or count is 0.");
	        }
	    }

	    public void performExcludeTileActions() throws Exception {
	        sharedleadsFilter();
	        Thread.sleep(2000);
	        manageSharedleadsTilesSort();
	        Thread.sleep(1000);
	        manageSharedleadsTilesEmailreports();
	        Thread.sleep(1000);
	        XamplifyUtil.takeScreenshot(driver, "EmailReportForExcludeTileSharedleads");
	        closefilter();
	        Thread.sleep(1000);
	    }

	    // These would need to be implemented if not already:
	    public void sharedleadsFilter() throws InterruptedException {
	        // Implement the logic or call existing utility
	    	logger.info("Applying filter on Shared Leads.");


			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter"));
			Thread.sleep(1000);
			XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_fieldname"), "City");
			Thread.sleep(1000);
			XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_drop"), "Contains");
			Thread.sleep(1000);
			XamplifyUtil.sendTextEvent(properties.getProperty("sharedAll_filter_value"), "HYDerabad");

			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_submit"));
			Thread.sleep(2000);
			logger.info("Filter applied successfully.");
			XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_close"));
			Thread.sleep(2000);
	    }

	    public void manageSharedleadsTilesSort() throws InterruptedException {
	        // Sorting logic
	    	logger.info("Managing Shared Leads tiles sorting.");
			Thread.sleep(3000);
			// List of sorting options
			List<String> sortOptions = Arrays.asList("Email (A-Z)", "Email (Z-A)", "First name (ASC)", "First name (DESC)",
					"Last name (ASC)");

			// Iterate through the list and select each option
			for (String option : sortOptions) {

				XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_sort"), option);
				Thread.sleep(3000); // Sleep after each selection
			}

			Thread.sleep(1000);
			logger.info("Shared Leads tiles sorting completed.");
	    }

	    public void manageSharedleadsTilesEmailreports() throws InterruptedException {
	    	
	        // Email report logic
	    	logger.info("Managing email reports for Shared Leads tiles.");

			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_emailreport"));
			logger.info("Email report triggered.");
	    }

	    public void closefilter() throws InterruptedException {
	        // Logic to close filter
	    	logger.info("Closing the filter.");
			XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_close"));
			Thread.sleep(1000);
			logger.info("Filter closed.");
	    }  
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
