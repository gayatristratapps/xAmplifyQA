package com.xamplify.automation.tests;


import com.xamplify.automation.pages.ContactsPage;
import com.xamplify.util.DriverFactory;
import com.xamplify.automation.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class ContactsTest {

    private WebDriver driver;
    private ContactsPage contactsPage;
    private Properties props;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
        props = PropertiesFile.readPropertyFile("src/main/resources/Contacts.properties");
        contactsPage = new ContactsPage(driver, props);
        driver.get("https://your-app-url.com"); // replace with actual URL
    }

    @Test
    public void testAddContactOneAtATime() {
        contactsPage.clickAddContacts();
        contactsPage.clickOneAtATime();
        contactsPage.enterEmail("test@example.com");
        contactsPage.enterFirstName("John");
        contactsPage.enterLastName("Doe");
        contactsPage.enterMobileNumber("1234567890");
        contactsPage.clickAddButton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
