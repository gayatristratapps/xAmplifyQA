package com.xamplify.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class ContactFormHelper {
    private WebDriver driver;
    private Properties props;
    private WebDriverWait wait;

    public ContactFormHelper(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;
        this.wait = new WebDriverWait(driver, 120);
    }

    public void fillOneAtATimeForm() {
        WebElement emailText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(props.getProperty("con_oat_emailfield"))));
        emailText.sendKeys("gayatri" + new Random().nextInt(1000) + "@gmail.com");

        WebElement legalBasisField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(props.getProperty("con_legalbasis"))));
        legalBasisField.click();

        legalBasisField.sendKeys("Legitimate interest - existing customer", Keys.ENTER);
        legalBasisField.sendKeys("Legitimate interest - prospect/lead", Keys.ENTER);

        waitAndSendKeys(By.xpath(props.getProperty("con_firstname")), "GAYATRI");
        waitAndSendKeys(By.xpath(props.getProperty("con_lastname")), "A");
        waitAndSendKeys(By.id("title"), "sse");
        waitAndSendKeys(By.id("address"), "sri maartuhi homes, citizens colony, lingampally");
        waitAndSendKeys(By.id("city"), "Hyderabad");
        waitAndSendKeys(By.id("state"), "Telegana");
        waitAndSendKeys(By.id("zip"), "5000S0");

        WebElement addCompanyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(props.getProperty("con_addcompbutton"))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addCompanyBtn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addCompanyModal")));

        WebElement popupInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
        popupInput.clear();
        popupInput.sendKeys("AutoTestCompany");

        waitAndSendKeys(By.id("website"), "www.automate.com");

        WebElement addCompanyConfirmBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(props.getProperty("con_addcompbutton_Add"))));
        addCompanyConfirmBtn.click();

        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("responseMessage")));
            if (errorMsg.getText().contains("Duplicate Entry")) {
                String uniqueName = "AutoTestCompany_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
                nameField.clear();
                nameField.sendKeys(uniqueName);
                addCompanyConfirmBtn.click();
            }
        } catch (TimeoutException ignored) {}

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(props.getProperty("con_addbutton"))));
        addButton.click();
    }

    private void waitAndSendKeys(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }
}
