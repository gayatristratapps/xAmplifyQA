package com.xamplify.automation;

import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class Logout {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Logout.properties");
	final Logger logger = LogManager.getLogger(Login.class);
	
	

@Test(priority=1,enabled=true)


public void Logoutprocess() throws InterruptedException, SQLException {

	logger.info("Logging out to the application");
	Thread.sleep(5000);
	XamplifyUtil.getElementById("headerdropDownLi").click();
	Thread.sleep(4000);

	
	
	XamplifyUtil.callClickEvent(properties.getProperty("click_logout_button"));
	
	logger.info("Successfully Logout to the application");
	
}

}


