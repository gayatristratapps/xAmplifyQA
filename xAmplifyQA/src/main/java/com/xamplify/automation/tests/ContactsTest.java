package com.xamplify.automation.tests;

import com.xamplify.automation.pages.ContactsPage;
import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class ContactsTest {

    WebDriver driver;
    ContactsPage contactsPage;
    Properties props;

    @BeforeClass
    public void beforeClass() {
        driver = Instance.getInstance();
        props = PropertiesFile.readPropertyFile("src/main/resources/Contacts.properties");
        contactsPage = new ContactsPage(driver, props);
    }

    @Test(priority = 1, enabled=true)
    public void testAddContact_OneAtATime() throws Exception {
        // Hover before click for menu access clarity
        contactsPage.hoverContacts();
        contactsPage.clickAddContacts();
        contactsPage.completeOneAtATimeFlow();
    }

    @Test(priority = 2, enabled=true)
    public void testUploadContacts_CSV() throws Exception {
        contactsPage.hoverContacts();
        contactsPage.clickAddContacts();
        contactsPage.uploadCSVAndHandle();
    }

    @AfterClass
    public void tearDown() {
        Instance.quitInstance();
    }
}
