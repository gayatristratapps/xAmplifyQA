package com.xamplify.automation.pages;

//import java.DamUtil.Properties;
import com.xamplify.util.DamUtil;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.xamplify.DamUtil.TeamVendorDamUtil;
//
//
//public class ManageAssetsPage {
//	WebDriver driver;
//	Properties properties;
//
//	public ManageAssetsPage(WebDriver driver, Properties properties) {
//		this.driver = driver;
//		this.properties = properties;
//	}
//	
//	
//	public void hoverContent() throws InterruptedException {
//		TeamVendorDamUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50);
//		Thread.sleep(2000);
//	}
//
//}



public class ManageAssetsPage {

	WebDriver driver;
   Properties properties;
   
   public ManageAssetsPage(WebDriver driver, Properties properties) {
		this.driver = driver;
		this.properties = properties;
		//this.wait = new WebDriverWait(driver, 70);
	}
	

    public void hoverOnContentMenu() {
        DamUtil damUtil = new DamUtil(driver);
		damUtil.hover(By.xpath(properties.getProperty("Content_leftmenu")));
		damUtil.callClickEvent(properties.getProperty("Content_leftmenu"));
    }

    public void clickManageAssets() throws InterruptedException {
        DamUtil.click(By.xpath(properties.getProperty("manageAssets_menuItem")));
        Thread.sleep(5000);
    }

    public void searchAsset(String assetName) throws InterruptedException {
        //DamUtil.callClickEvent(By.xpath(properties.getProperty("manageAssets_searchField")));
    	
    	// click on sorting dropdown and sort by values

    			WebElement sort_Asset = driver.findElement(By.xpath(properties.getProperty(("Clickondropdown"))));
    			sort_Asset.click();
    			Thread.sleep(2000);

    			DamUtil.selectDropdownByText(properties.getProperty("Clickondropdown"), "Created On(ASC)");
    			Thread.sleep(4000);
    			
        
        WebElement searchInput = driver.findElement(By.xpath(properties.getProperty("manageAssets_searchField")));
        searchInput.sendKeys(assetName);
        searchInput.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
    }

    public void asset_EditActions(String AssetNameUpdate) throws InterruptedException {
        DamUtil.callClickEvent(properties.getProperty("manageAssets_editIcon"));
        Thread.sleep(3000);
        
     
       DamUtil.sendText(By.xpath(properties.getProperty("Name")), AssetNameUpdate);
        Thread.sleep(2000);
       
        Thread.sleep(2000);
        
        DamUtil.callClickEvent(properties.getProperty("click_update_asset"));
		Thread.sleep(5000);
		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);

		String expectedresult_asset = "Updated Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			System.out.println("Asset updated successfully");
		} else {
			System.out.println("Asset not updated successfully");
		}

		Thread.sleep(2000);

    }

    
    
public void video_asset_Actions() throws InterruptedException, AWTException {
		
		Thread.sleep(5000);		
//		DamUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
//		Thread.sleep(3000);	
		//logger.info("Refresh icon has been clicked");
		DamUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
		Thread.sleep(6000);	

		DamUtil.callClickEvent(properties.getProperty("clickon_edit_video_asset"));
		Thread.sleep(6000);

		DamUtil.callClickEvent(properties.getProperty("clickon_replace_button"));
		Thread.sleep(4000);
		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
		browse.click();
		Thread.sleep(3000);

		DamUtil.imageupload("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\replace_mp4_file.mp4");
		Thread.sleep(3000);

		DamUtil.callClickEvent(properties.getProperty("clickon_replace_update"));
		Thread.sleep(2000);
		
		DamUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
		Thread.sleep(5000);
		DamUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
		Thread.sleep(8000);
		DamUtil.callClickEvent(properties.getProperty("clickon_preview_videoasset"));
		Thread.sleep(7000);
		DamUtil.callClickEvent(properties.getProperty("clickon_manageasset_breadcrumb"));
		Thread.sleep(5000);

		DamUtil.callClickEvent(properties.getProperty("clickon_videoasset_Analytics"));
		Thread.sleep(2000);
		DamUtil.callClickEvent(properties.getProperty("clickon_videoasset_Analytics"));
		Thread.sleep(2000);
		DamUtil.callClickEvent(properties.getProperty("clickon_videoasset_Analytics"));
		Thread.sleep(2000);
		DamUtil.callClickEvent(properties.getProperty("clickon_manageasset_breadcrumb"));
		Thread.sleep(5000);
		DamUtil.callClickEvent(properties.getProperty("clickon_asset_delete"));
		Thread.sleep(2000);
		DamUtil.callClickEvent(properties.getProperty("clickon_yesdelete"));
		Thread.sleep(2000);
		DamUtil.takeScreenshot(driver, "Asset Deleted Successfully");
	}

    public void content_clickDocDownload() {
        DamUtil.click(By.xpath(properties.getProperty("manageAssets_doc_downloadIcon")));
    }

    public void content_clickDocShare() {
        DamUtil.click(By.xpath(properties.getProperty("manageAssets_doc_shareIcon")));
    }

    public void content_clickDocPublish() {
        DamUtil.click(By.xpath(properties.getProperty("manageAssets_doc_publishIcon")));
    }

    public void content_clickDocUnpublish() {
        DamUtil.click(By.xpath(properties.getProperty("manageAssets_doc_unpublishIcon")));
    }
    // ========================
    // PPT Asset Methods
    // ========================

    public void content_clickPptEdit() {
        DamUtil.click(By.xpath(properties.getProperty("manageAssets_ppt_editIcon")));
    }

    public void content_clickPptDownload() {
        DamUtil.click(By.xpath(properties.getProperty("manageAssets_ppt_downloadIcon")));
    }

    public void content_clickPptShare() {
        DamUtil.click(By.xpath(properties.getProperty("manageAssets_ppt_shareIcon")));
    }

}
    // ========================
    // More asset types can be added below using the same pattern
    // ========================

