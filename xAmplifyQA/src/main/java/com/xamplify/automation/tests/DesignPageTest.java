package com.xamplify.automation.tests;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.xamplify.automation.pages.DesignPages;
import com.xamplify.automation.pages.OnboardingPartnerPage;

public class DesignPageTest {
	
	final static Logger logger = LogManager.getLogger(DesignPageTest.class);

	  @Test(priority = 1, enabled = true) public void
	  CreateRegularPublicPage()throws InterruptedException {
	  System.out.println(" ");
	  logger.info("Create Regular Public Page in Design Pages");
	  DesignPages.designDesignPage(); DesignPages.RegularTab();
	  DesignPages.createPage(); DesignPages.regularpublicPageSaveandClose();
	  logger.info("Successfully Created Regular Public Page in Design Pages");
	  System.out.println(" "); }
	  
	  @Test(priority = 2, enabled = true) public void
	  CreateRegularPrivatePage()throws InterruptedException {
	  logger.info("Create Regular Private Page in Design Pages");
	  DesignPages.designDesignPage(); 
	  DesignPages.RegularTab();
	  DesignPages.createPage(); DesignPages.regularPrivatePageSaveandClose();
	  logger.info("Successfully Created Regular Private Page in Design Pages");
	  System.out.println(" "); }
	  
	  @Test(priority = 3, enabled = true) public void CreateCobrandedPublicPage()
	  throws InterruptedException {
	  logger.info("Create Cobranded Public Page in Design Pages");
	  DesignPages.designDesignPage(); DesignPages.cobrandedTab();
	  DesignPages.createPage(); DesignPages.cobrandedpublicpagecreation();
	  logger.info("Successfully Created Cobranded Public Page in Design Pages");
	  System.out.println(" "); }
	  
	  @Test(priority = 4, enabled = true) public void CreateCobrandedPrivatePage()
	  throws InterruptedException {
	  logger.info("Create Cobranded Private Page in Design Pages");
	  DesignPages.designDesignPage(); DesignPages.cobrandedTab();
	  DesignPages.createPage(); DesignPages.cobrandedprivatepagecreation();
	  logger.info("Successfully Created Cobranded Private Page in Design Pages");
	  System.out.println(" "); }
	 
	 

	  @Test(priority = 5, enabled = true) public void regularpublicpage() throws  InterruptedException, UnsupportedFlavorException, IOException {
	  logger.info("Regular Public Page Actions in Manage Pages");
	  DesignPages.designManagePage(); DesignPages.PageTab("RegularPublic");
	  DesignPages.searchPage(); 
	  DesignPages.copyPage(); 
	  DesignPages.editpage();
	  DesignPages.CopyAndEmbeddedPage();
	  DesignPages.PreviewPage(); 
	  DesignPages.PageAnalytics(); 
	  DesignPages.copyPage(); 
	  DesignPages.DeletePage(); 
	  logger.info("Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Regular Public Page in Manage Pages"); System.out.println(" "); 
	  }
	  
	  @Test(priority = 6, enabled = true) public void regularprivatepage() throws
	  InterruptedException, UnsupportedFlavorException, IOException {
	  System.out.println(" ");
	  logger.info("Create Regular Private Page in Design Pages");
	  DesignPages.designManagePage(); DesignPages.PageTab("RegularPrivate");
	  DesignPages.searchPage(); 
	  DesignPages.copyPage(); 
	  DesignPages.editpage();
	  DesignPages.CopyAndEmbeddedPage();
	  DesignPages.PreviewPage(); 
	  DesignPages.PageAnalytics(); 
	  DesignPages.DeletePage(); 
	  logger.info("Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Regular Private Page in Manage Pages"); 
	  System.out.println(" "); 
	  }
	  
	  @Test(priority = 7, enabled = true) public void cobrandedpublicpage() throws
	  InterruptedException, UnsupportedFlavorException, IOException {
	  System.out.println(" ");
	  logger.info("Create Cobranded public Page in Design Pages");
	  DesignPages.designManagePage(); 
	  DesignPages.PageTab("CoBrandedPublic");
	  DesignPages.searchPage(); 
	  DesignPages.copyPage(); 
	  DesignPages.editpage();
	  DesignPages.CopyAndEmbeddedPage();
	  DesignPages.PreviewPage(); 
	  DesignPages.PageAnalytics(); 
	  DesignPages.DeletePage(); 
	  logger.info("Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Cobranded Public Page in Manage Pages"); 
	  System.out.println(" "); 
	  }
	  
	  @Test(priority = 8, enabled = true) public void cobrandedprivatepage() throws
	  InterruptedException, UnsupportedFlavorException, IOException {
	  System.out.println(" ");
	  logger.info("Create Cobranded Private Page in Design Pages");
	  DesignPages.designManagePage(); DesignPages.PageTab("CoBrandedPrivate");
	  DesignPages.searchPage(); DesignPages.copyPage(); DesignPages.editpage();
	  DesignPages.CopyAndEmbeddedPage();
	  DesignPages.PreviewPage(); 
	  DesignPages.PageAnalytics(); DesignPages.DeletePage(); logger.
	  info("Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for CoBranded Private Page in Manage Pages"); 
	  System.out.println(" "); 
	  }
	 
	
	
	/*
	 * @Test(priority = 1, enabled = true) public void CopyAndEmbeddedPages() throws
	 * InterruptedException, UnsupportedFlavorException, IOException {
	 * System.out.println(" ");
	 * logger.info("Copy And Embedded Pages in Design Pages");
	 * DesignPages.designManagePage(); DesignPages.PageView();
	 * DesignPages.PageAnalytics();
	 * logger.info("Successfully Copy And Embedded Pages in Design Pages");
	 * System.out.println(" "); }
	 */
	
	
	
}
