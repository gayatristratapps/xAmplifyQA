package com.xamplify.automation;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class AccessSharedAssets {
	
	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\AccessSharedAssets.properties");
	final Logger logger = LogManager.getLogger(UploadAsset.class);

	@Test
	public void hoverandclickoncontent_module() throws InterruptedException {

		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("partner_content_leftmenu"), 50);

// click on left side content menu
		Thread.sleep(3000);
		
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_accesssharedassets")); // click on AccesssharedAssets
				Thread.sleep(3000);
		
				XamplifyUtil.clickElementWithWait(driver, properties.getProperty("clickon_filter_icon"), 30);
				//XamplifyUtil.callClickEvent(properties.getProperty("clickon_filter_icon"));
				Thread.sleep(3000);
				WebElement fieldname_drpdown = driver.findElement(By.xpath(properties.getProperty("clickon_fieldname_dropdown")));
				fieldname_drpdown.click();
				Thread.sleep(3000);
				XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown"), "Asset Name");
				Thread.sleep(2000);
				
				WebElement condition_drpdown = driver.findElement(By.xpath(properties.getProperty("clickon_condition_dropdown")));
				condition_drpdown.click();
				Thread.sleep(3000);
				XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown"), "Contains");
				Thread.sleep(2000);
			
				XamplifyUtil.sendTextEvent(properties.getProperty("clickon_value_field"),"png");
				Thread.sleep(3000);
				
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectdate_field"));
				Thread.sleep(1000);
				XamplifyUtil.callClickEvent(properties.getProperty("select_from_date"));
				Thread.sleep(1000);
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_todate_field"));
				Thread.sleep(1000);
				XamplifyUtil.callClickEvent(properties.getProperty("select_to_date"));
				Thread.sleep(1000);
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
				Thread.sleep(4000);

				XamplifyUtil.callClickEvent(properties.getProperty("partner_clickon_view_icon"));
				Thread.sleep(2000);
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_insideview"));
				Thread.sleep(4000);

				XamplifyUtil.callClickEvent(properties.getProperty("clickon_view_close"));
				Thread.sleep(4000);
				
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_download_Asset"));
				Thread.sleep(4000);
				XamplifyUtil.callClickEvent(properties.getProperty("assetview_section_close"));
				Thread.sleep(4000);
			
				XamplifyUtil.sendTextEvent(properties.getProperty("partner_asset_search"), "png");
				Thread.sleep(2000);
				XamplifyUtil.callClickEvent(properties.getProperty("partner_asset_searh_icon"));
				Thread.sleep(3000);
				
				XamplifyUtil.callClickEvent(properties.getProperty("partner_Asset_Analytics"));
				Thread.sleep(4000);
				
				XamplifyUtil.callClickEvent(properties.getProperty("asset_analytics_section_close"));
				Thread.sleep(4000);
		
	}
}
