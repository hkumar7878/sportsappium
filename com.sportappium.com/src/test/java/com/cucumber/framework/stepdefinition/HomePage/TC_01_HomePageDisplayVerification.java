package com.cucumber.framework.stepdefinition.HomePage;

import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PG_HomePage;
import com.cucumber.framework.pageobject.PG_MY_HomePage;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class TC_01_HomePageDisplayVerification {
private final Logger log= LoggerHelper.getLogger(TC_01_HomePageDisplayVerification.class);
	
	TestBase testbaseObj= new TestBase();
	public AppiumDriver driver;
	PG_MY_HomePage objMYhomePage;
	
	
	@Then("^user verifies home page is displayed$")
	public void user_verifies_home_page_is_displayed() throws Throwable {
		driver=TestBase.driver;
		System.out.println(driver.hashCode());
		objMYhomePage= new PG_MY_HomePage(driver);
		String stepName="Verify the Adidas Home page";
		String passResult="Adidas home page is displayed";
		String failResult="Adidas home page is not displayed";
		objMYhomePage.verifyHomePage(TestBase.deviceID,stepName,passResult,failResult);
	    
	}

}
