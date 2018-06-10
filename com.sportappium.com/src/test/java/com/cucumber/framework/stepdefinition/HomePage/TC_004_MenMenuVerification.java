package com.cucumber.framework.stepdefinition.HomePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PG_HomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class TC_004_MenMenuVerification {
	
	TestBase testbaseObj= new TestBase();
	public AppiumDriver driver;
	PG_HomePage homePgObject;
	
	List<String> menMenuOptions=Arrays.asList("SHOES","CLOTHING","ACCESSORIES","ALL MEN'S");
	
	@When("^click on Men menu drop down$")
	public void click_on_Men_menu_drop_down() throws Throwable {
		driver=TestBase.driver;
		System.out.println(driver.hashCode());
		homePgObject= new PG_HomePage(driver);
		String stepName="Click on Men Menu drop down";
		String passResult="Men Menu on Home page is clicked successfully";
		String failResult="Men Menu on Home page is NOT clicked";
		homePgObject.clickBtn(TestBase.deviceID, "Men", stepName, passResult, failResult);
	 
	}

	@Then("^men menu drop down displays correct drop down options$")
	public void men_menu_drop_down_displays_correct_drop_down_options() throws Throwable {
		String stepName="Verify Men Menu Drop down values";
		String passResult="Correct Men Menu drop down values are displayed";
		String failResult="Incorrect Men Menu drop down values are displayed";
		homePgObject.verifyMenuOptions(TestBase.deviceID, "Men", stepName, passResult, failResult,menMenuOptions);
	}

}
