package com.xamplify.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xamplify.automation.partners;
import com.xamplify.automation.pages.OnboardingPartnerPage;

public class OnboardingPartnerTest {
	final Logger logger = LogManager.getLogger(OnboardingPartnerTest.class);

	@Test(priority = 1, enabled = true)
	public void UploadCSV_partner() throws InterruptedException {
		System.out.println(" ");
		logger.info("onboarding partner using Upload CSV");
		OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.OnboardParnerThroughUploadCSV();
		logger.info("Successfully onboarded partner using Upload CSV");
		System.out.println(" ");
	}  
	
	@Test(priority = 2, enabled = true)
	public void OneAtaTime_partner() throws InterruptedException {
		logger.info("onboarding partner using One At a Time");
		OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.OnboardPartnerOneAtaTime();
		logger.info("Successfully Onboarded partner using One at a time");
		System.out.println(" ");
	}
	
	@Test(priority = 3, enabled = true)
	public void EditPartner() throws InterruptedException {
		logger.info("edit partner and update the partner details");
		//OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.partnerEdit();
		logger.info("Successfully updated the partner details");
		System.out.println(" ");
	}
	
	@Test(priority = 4, enabled = true)
	public void SearchPartner() throws InterruptedException {
		logger.info("search the partner");
		OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.searchAndVerifyPartner();
		logger.info("Successfully search the partner");
		System.out.println(" ");
	}
	
	@Test(priority = 5, enabled = true)
	public void ExportExcellReportPartner() throws InterruptedException {
		logger.info("export the partner details to excel report");
		OnboardingPartnerPage.exportToExcel();
		logger.info("Successfully exported the partner details to excel");
		System.out.println(" ");
	}
	
	@Test(priority = 6, enabled = true)
	public void ExportEmailReportPartner() throws InterruptedException {
		logger.info("export the partner details to email report");
		OnboardingPartnerPage.exportToEmail();
		logger.info("Successfully exported the partner details to email");
		System.out.println(" ");
	}
	
	@Test(priority = 7, enabled = true)
	public void CreateGroupPartner() throws InterruptedException {
		logger.info("create new partner group");
		OnboardingPartnerPage.createGroup();
		logger.info("Successfully created the partner group");
		System.out.println(" ");
	}
	
	@Test(priority = 8, enabled = true)
	public void AddToGroupPartner() throws InterruptedException {
		logger.info("Add partner to existing group");
		OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.addToGroup();
		logger.info("Successfully Added the partner to the group");
		System.out.println(" ");
	}
	
	@Test(priority = 9, enabled = true)
	public void ApplyFilter_partner() throws InterruptedException {
		logger.info("Apply Filter with partner Fields ");
		OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.filterPartner("City", "Contains", "Hyderabad");
		logger.info("Successfully Appllied Filter");
		logger.info("Apply multiple Filter condition");
		OnboardingPartnerPage.addFilterRecord("Email Id", "Contains", "us1user1743671923219@gmail.com");
		logger.info("Successfully applied Multiple filter conditions");
		logger.info("Delete applied filter record ");
		OnboardingPartnerPage.deleteFilterRecord();	
		logger.info("Successfully Delete applied filter record");
		System.out.println(" ");
		
	}
	
	@Test(priority = 10, enabled = true)
	public void DeletePartner() throws InterruptedException {
		logger.info("Deleted the partner");
		OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.deletePartner();
		logger.info("Successfully Deleted the partner");
		System.out.println(" ");
	}
	
	@Test(priority = 11, enabled = true)
	public void PaginationPartner() throws Throwable {
		logger.info("navigate to next page through pagination");
		OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.pagenation();
		logger.info("successfully navigated to next page through pagination");
		System.out.println(" ");

	}
	
	@Test(priority = 12, enabled = true)
	public void SortAndRecordsPerPage() throws Throwable {
		logger.info("Sort the records and no of records per page");
		OnboardingPartnerPage.HoverPartners_OnboardingPartner();
		OnboardingPartnerPage.SortAndNoofrecord();
		logger.info("successfully sort and select no of partner records per page");
		System.out.println(" ");
	}
	
	
}
