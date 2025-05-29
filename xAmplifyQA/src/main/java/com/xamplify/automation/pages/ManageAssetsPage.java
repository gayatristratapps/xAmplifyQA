package com.xamplify.automation.pages;

//import java.DamUtil.Properties;
import com.xamplify.util.DamUtil;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public void searchanddownloadAsset(String assetName) throws InterruptedException {
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
		
//		DamUtil.callClickEvent(properties.getProperty("clickon_Asset_searchclear"));
//		Thread.sleep(2000);
		
		
    }

    

    public void asset_DownloadandpreviewEditActions(String AssetNameUpdate) throws InterruptedException {
    	
    	DamUtil.callClickEvent(properties.getProperty("clickon_download_asset"));
		Thread.sleep(2000);
		
		DamUtil.callClickEvent(properties.getProperty("clickon_Asset_preview"));
		Thread.sleep(5000);
		DamUtil.callClickEvent(properties.getProperty("clickon_Asset_preview_close"));
		Thread.sleep(2000);
		
		DamUtil.callClickEvent(properties.getProperty("clickon_asset_analytics"));
		Thread.sleep(2000);

		DamUtil.callClickEvent(properties.getProperty("clickon_asset_analytics_close"));
		Thread.sleep(4000);
		//logger.info("analytics icon has been clicked-but no parnter details avaliable");

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
//		DamUtil.callClickEvent(properties.getProperty("clickon_asset_delete"));
//		Thread.sleep(2000);
//		DamUtil.callClickEvent(properties.getProperty("clickon_yesdelete"));
//		Thread.sleep(2000);
//		DamUtil.takeScreenshot(driver, "Asset Deleted Successfully");
//		Thread.sleep(2000);
//		DamUtil.callClickEvent(properties.getProperty("clickon_Asset_searchclear"));
//		Thread.sleep(2000);
	}

public void replace_assets(String filepath) throws InterruptedException, AWTException {
	
	DamUtil.callClickEvent(properties.getProperty("manageAssets_editIcon"));
      Thread.sleep(3000);
	DamUtil.callClickEvent(properties.getProperty("clickon_replace_button"));
	Thread.sleep(4000);
	WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
	browse.click();
	Thread.sleep(3000);

	DamUtil.imageupload(filepath);
	Thread.sleep(3000);

	DamUtil.callClickEvent(properties.getProperty("clickon_replace_update"));
	Thread.sleep(2000);
}


   
    	public void views_png() throws InterruptedException {
    		

    		DamUtil.clickElementWithWait(driver, properties.getProperty("hoveron_listview"), 30);
    		Thread.sleep(1000);
    		// clicking on grid view
    		WebElement gridview = driver.findElement(By.xpath(properties.getProperty("clickon_gridview")));
    		gridview.click();
    		Thread.sleep(6000);
    		
    		//logger.info("assets viewed in grid view");
    		
    		DamUtil.callClickEvent(properties.getProperty("hoveron_asset_gv"));
    		Thread.sleep(2000);

    		DamUtil.callClickEvent(properties.getProperty("clickon_Asset_preview"));
    		Thread.sleep(2000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_Asset_preview_close"));
    		Thread.sleep(2000);
//    		WebDriverWait wait = new WebDriverWait(driver, 10);
//    		String originalWindow = driver.getWindowHandle();// store the current window handle
//    		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // wait for new tab to open
//    		Thread.sleep(5000);
//
//    		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle
//
//    		driver.switchTo().window(tabs.get(1)); // switch to the new tab
//
//    		Thread.sleep(3000);
//    		driver.close(); // switch back to original tab and close the new tab
//
//    		driver.switchTo().window(tabs.get(0));
//
//    		Thread.sleep(3000);
//    		
    		DamUtil.clickElementWithWait(driver, properties.getProperty("hoveron_gridview"), 30);
    		Thread.sleep(1000);

    		// clickng on folder list view
    		WebElement foldergridview = driver.findElement(By.xpath(properties.getProperty("clickon_foldergridview")));
    		foldergridview.click();
    			Thread.sleep(3000);
    			DamUtil.callClickEvent(properties.getProperty("hoveron_asset_fgv"));
    			Thread.sleep(3000);
    			DamUtil.callClickEvent(properties.getProperty("clickon_folderasset_preview_fgv"));
    			Thread.sleep(3000);
    			
    		//logger.info("assets viewed in foldergrid view");
    		
    			DamUtil.callClickEvent(properties.getProperty("clickon_fv_uparrow"));
    		Thread.sleep(3000);
    		DamUtil.callClickEvent(properties.getProperty("hoveron_fgv"));
    		Thread.sleep(3000);
    	

    		// clickng on folder grid view
    		WebElement folderlistview = driver.findElement(By.xpath(properties.getProperty("clickon_folderlistview")));
    		folderlistview.click();
    		Thread.sleep(3000);
    		
    		WebElement search_dropdown = driver.findElement(By.xpath(properties.getProperty("clickon_searchdropdown_flv")));
    		search_dropdown.click();
    		Thread.sleep(3000);
    		
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_searchdropdown_flv"), "Search In Folder");
    		Thread.sleep(3000);
    		
    		DamUtil.sendText(By.xpath(properties.getProperty("clickon_search_asset_flv")), "png");
    		Thread.sleep(3000);
    		
    		DamUtil.callClickEvent(properties.getProperty("clickon_searchicon_asset_flv"));
    		Thread.sleep(3000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_asset_delete"));
    		Thread.sleep(2000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_yesdelete"));
    		Thread.sleep(2000);
    		DamUtil.takeScreenshot(driver, "Asset Deleted Successfully");
    		
    		DamUtil.callClickEvent(properties.getProperty("clickon_fv_uparrow"));
    		Thread.sleep(3000);

    		DamUtil.callClickEvent(properties.getProperty("hoveron_flv"));
    		Thread.sleep(3000);
    		// clickng on list view
    		WebElement listview = driver.findElement(By.xpath(properties.getProperty("clickon_listview")));
    		listview.click();
    		Thread.sleep(3000);
    	}

    	// search asset and view asset and download asset --succesfull
    	public void asset_filter_png() throws InterruptedException {

    		DamUtil.clickElementWithWait(driver, properties.getProperty("clickon_filter_icon"), 30);
    		//DamUtil.callClickEvent(properties.getProperty("clickon_filter_icon"));
    		Thread.sleep(3000);
    		WebElement fieldname_drpdown = driver.findElement(By.xpath(properties.getProperty("clickon_fieldname_dropdown")));
    		fieldname_drpdown.click();
    		Thread.sleep(3000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown"), "Asset Name");
    		Thread.sleep(2000);
    		
    		WebElement condition_drpdown = driver.findElement(By.xpath(properties.getProperty("clickon_condition_dropdown")));
    		condition_drpdown.click();
    		Thread.sleep(3000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown"), "Contains");
    		Thread.sleep(2000);
    	
    		DamUtil.sendText(By.xpath(properties.getProperty("clickon_value_field")), "png");
    		Thread.sleep(3000);
    		
    		DamUtil.callClickEvent(properties.getProperty("clickon_selectdate_field"));
    		Thread.sleep(1000);
    		DamUtil.callClickEvent(properties.getProperty("select_from_date"));
    		Thread.sleep(1000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_todate_field"));
    		Thread.sleep(1000);
    		DamUtil.callClickEvent(properties.getProperty("select_to_date"));
    		Thread.sleep(1000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
    		Thread.sleep(4000);

    		DamUtil.callClickEvent(properties.getProperty("clickon_addacondition_icon_filter"));
    		Thread.sleep(1000);
    		fieldname_drpdown.click();
    		Thread.sleep(3000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown2"), "Folder");
    		Thread.sleep(2000);
    		condition_drpdown.click();
    		Thread.sleep(3000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown2"), "Contains");
    		Thread.sleep(2000);
    		DamUtil.sendText(By.xpath(properties.getProperty("clickon_value_field2")),"default");
    		Thread.sleep(3000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
    		Thread.sleep(4000);
    		
    		DamUtil.callClickEvent(properties.getProperty("clickon_addacondition_icon_filter"));
    		Thread.sleep(1000);
    		fieldname_drpdown.click();
    		Thread.sleep(3000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown3"), "Type");
    		Thread.sleep(2000);
    		
    		WebElement assettype_drpdown = driver.findElement(By.xpath(properties.getProperty("clickon_Assettype_drpdown")));
    		assettype_drpdown.click();
    		Thread.sleep(1000);
    		
    		DamUtil.selectDropdownByValue(properties.getProperty("clickon_Assettype_drpdown"), "png");
    		Thread.sleep(2000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
    		Thread.sleep(4000);
    				
    		DamUtil.callClickEvent(properties.getProperty("clickon_addacondition_icon_filter"));
    		Thread.sleep(1000);
    		fieldname_drpdown.click();
    		Thread.sleep(3000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown4"), "Tags");
    		Thread.sleep(2000);
    		condition_drpdown.click();
    		Thread.sleep(3000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown4"), "Contains");
    		Thread.sleep(2000);
    		DamUtil.sendText(By.xpath(properties.getProperty("clickon_value_field3")),"re");
    		Thread.sleep(3000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
    		Thread.sleep(4000);
    		
    		
    		
    		DamUtil.callClickEvent(properties.getProperty("clickon_addacondition_icon_filter"));
    		Thread.sleep(1000);
    		fieldname_drpdown.click();
    		Thread.sleep(3000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown5"), "Created By");
    		Thread.sleep(2000);
    		DamUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown5"), "=");
    		Thread.sleep(2000);
    		DamUtil.sendText(By.xpath(properties.getProperty("clickon_value_field4")),"vendor automate");
    		Thread.sleep(3000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
    		Thread.sleep(4000);
    		
    	DamUtil.scrollToBottom(driver);
    	Thread.sleep(4000);
    		DamUtil.callClickEvent(properties.getProperty("clickon_remove_filter"));
    		Thread.sleep(4000);
    		
    		
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

