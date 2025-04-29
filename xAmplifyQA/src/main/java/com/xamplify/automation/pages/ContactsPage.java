package com.xamplify.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class ContactsPage {

    private WebDriver driver;
    private Properties props;

    public ContactsPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;
    }

    public void clickAddContacts() {
        driver.findElement(By.xpath(props.getProperty("Addcontacts"))).click();
    }

    public void clickOneAtATime() {
        driver.findElement(By.xpath(props.getProperty("con_oneatatimelist"))).click();
    }

    public void enterEmail(String email) {
        driver.findElement(By.xpath(props.getProperty("con_oat_emailfield"))).sendKeys(email);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.xpath(props.getProperty("con_firstname"))).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.xpath(props.getProperty("con_lastname"))).sendKeys(lastName);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(By.xpath(props.getProperty("con_mobileno"))).sendKeys(mobile);
    }

    public void clickAddButton() {
        driver.findElement(By.xpath(props.getProperty("con_addbutton"))).click();
    }

    
}
