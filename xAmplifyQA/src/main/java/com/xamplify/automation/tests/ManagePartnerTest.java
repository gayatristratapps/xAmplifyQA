package com.xamplify.automation.tests;

import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.xamplify.automation.pages.ManagePartnersPage;
import com.xamplify.automation.pages.OnboardingPartnerPage;

public class ManagePartnerTest {

	final Logger logger = LogManager.getLogger(ManagePartnerTest.class);
	

	@Test(priority = 1, enabled = true)
	public void CreatePartnerGroup_ManagePartner() throws InterruptedException {
		System.out.println(" ");
		logger.info("Creating new partner group in Manage partners");
		ManagePartnersPage.HoverOnPartnersManagePartners();
		ManagePartnersPage.CreateNewPartnerGroup();
		logger.info("Successfully Created new partner group");
		System.out.println(" ");
	}

	@Test(priority = 2, enabled = true)
	public void Sortandsearch_Copyandsavegroup_ManagePartner() throws Throwable {
		System.out.println(" ");
		logger.info("Sort & search partner group and copy&save the partner group in Manage partners");
		ManagePartnersPage.HoverOnPartnersManagePartners();
		ManagePartnersPage.Mpartners_Sortandsearch_Copyandsavegroup();
		logger.info("Successfully Sort & search partner group and copy&save the partner group in Manage partners");
		System.out.println(" ");
	}
	
	@Test(priority = 3, enabled = true)
	public void EmailReport_ManagePartner() throws InterruptedException {
		System.out.println(" ");
		logger.info("Generate partner EmailReport in Manage partners");
		ManagePartnersPage.HoverOnPartnersManagePartners();
		ManagePartnersPage.exportToMail();
		logger.info("Successfully Generated partner EmailReport in Manage partners");
		System.out.println(" ");
	}
	
	@Test(priority = 4, enabled = true)
	public void EditGroup_ManagePartner() throws InterruptedException {
		System.out.println(" ");
		logger.info("Edit partner group in Manage partners");
		ManagePartnersPage.HoverOnPartnersManagePartners();
		ManagePartnersPage.Mpartners_EditGroup();
		logger.info("Apply Filter with partner Fields ");
		ManagePartnersPage.filterManagePartner("City", "Contains", "Hyderabad");
		logger.info("Successfully Appllied Filter");
		logger.info("Apply multiple Filter condition");
		OnboardingPartnerPage.addFilterRecord("Email Id", "Contains", "us1user1743671923219@gmail.com");
		logger.info("Successfully applied Multiple filter conditions");
		logger.info("Delete applied filter record ");
		OnboardingPartnerPage.deleteFilterRecord();	
		logger.info("Successfully Delete applied filter record");
		logger.info("Successfully Edit partner group in Manage partners");
		System.out.println(" ");
	}

	@Test(priority = 5, enabled = true)
	public void PublishContent_ManagePartner() throws InterruptedException {
		System.out.println(" ");
		logger.info("Publish Content to partner in Manage partners");
		ManagePartnersPage.HoverOnPartnersManagePartners();
		ManagePartnersPage.Mpartners_publishContent();
		logger.info("Successfully Publish Content to partner in Manage partners");
		System.out.println(" ");
	}
	
	@Test(priority = 6, enabled = true)
	public void DeleteGroup_ManagePartner() throws InterruptedException {
		System.out.println(" ");
		logger.info("Delete partner group in Manage partners");
		ManagePartnersPage.HoverOnPartnersManagePartners();
		ManagePartnersPage.Mpartners_DeleteGroup();
		logger.info("Successfully Deleted the partner group in Manage partners");
		System.out.println(" ");
	}
	
	@Test(priority = 7, enabled = true)
	public void ExportExcelReport_ManagePartner() throws InterruptedException, AWTException {
		System.out.println(" ");
		logger.info("Export partner Excel Report in Manage partners");
		ManagePartnersPage.HoverOnPartnersManagePartners();
		ManagePartnersPage.exportToExcel();
		logger.info("Successfully Export partner Excel Report Manage partners");
		System.out.println(" ");
	}
	
	@Test(priority = 8, enabled = true)
	public void Pagination_ManagePartner() throws Throwable {
		System.out.println(" ");
		logger.info("Edit partner group in Manage partners");
		ManagePartnersPage.HoverOnPartnersManagePartners();
		ManagePartnersPage.pagenation();
		logger.info("Successfully Edit partner group in Manage partners");
		System.out.println(" ");
	}
	
	@Test(priority = 11, enabled = true)
	public void Home() throws Throwable {
		System.out.println(" ");
		logger.info("Navigate to Home Page");
		ManagePartnersPage.backToHome();
		logger.info("Successfully Navigate to Home Page");
		System.out.println(" ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
