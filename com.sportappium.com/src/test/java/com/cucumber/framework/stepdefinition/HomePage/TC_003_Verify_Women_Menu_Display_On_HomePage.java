package com.cucumber.framework.stepdefinition.HomePage;

import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PG_HomePage;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class TC_003_Verify_Women_Menu_Display_On_HomePage {

	
private final Logger log= LoggerHelper.getLogger(TC_003_Verify_Women_Menu_Display_On_HomePage.class);
	
	TestBase testbaseObj= new TestBase();
	public AppiumDriver driver;
	PG_HomePage homePgObject;
	
	@Then("^verify Women drop down is displayed on Home Page$")
	public void verify_Women_drop_down_is_displayed_on_Home_Page() throws Throwable {
		driver=TestBase.driver;
		System.out.println(driver.hashCode());
		homePgObject= new PG_HomePage(driver);
		String stepName="Verify Men menu on Adidas Home page";
		String passResult="Men Menu on Home page is displayed successfully";
		String failResult="Men Menu on Home page is NOT displayed";
		homePgObject.verifyHomePageMenu(TestBase.deviceID, "Women", stepName, passResult, failResult);
	   
	}
}
