package com.cucumber.framework.stepdefinition.NewCar;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PG_HomePage_AndroidWeb;


import com.cucumber.framework.pageobject.PG_NewCarSelectCategory_AndroidWeb;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TC_01_NewCarPageDisplayVerification {
	private final Logger log= LoggerHelper.getLogger(TC_01_NewCarPageDisplayVerification.class);
	
	TestBase testbaseObj= new TestBase();
	public AppiumDriver driver;
	PG_HomePage_AndroidWeb cdHomePgObject;
	PG_NewCarSelectCategory_AndroidWeb cdNewCarSelCatObject;

	
	@Then("^user verifies home page is displayed$")
	public void user_verifies_home_page_is_displayed() throws Throwable {
		driver=TestBase.driver;
		System.out.println(driver.hashCode());
		cdHomePgObject= new PG_HomePage_AndroidWeb(driver);
		System.out.println("Inside step def and browser Name is " + TestBase.deviceID);
		String passResult="Car Dekho home page is displayed";
		String failResult="Car Dekho home page is not displayed";
		cdHomePgObject.verifyHomePage(TestBase.deviceID,passResult,failResult);
	    
	}

	@Then("^verify New Car button is displayed on the home page$")
	public void verify_New_Car_Button_is_displayed_on_the_home_page() throws Throwable {
	   
	   System.out.println("------Checking New Car Button verification-----------");
	   String passResult="New Button is displayed";
	   String failResult="New Button is not displayed";
	   cdHomePgObject.verifyBtnDisplay("New Car",passResult,failResult,TestBase.deviceID);
	   
	}

	@Then("^click on New Car button$")
	public void click_on_New_Car_button() throws Throwable {
		System.out.println("------Clicking New Car Button-----------");
		String passResult="New Button is clicked successfully";
		String failResult="New Button could not be clicked";
		cdNewCarSelCatObject = new PG_NewCarSelectCategory_AndroidWeb(driver);
		cdNewCarSelCatObject= cdHomePgObject.clickBtn("New Car",passResult,failResult, TestBase.deviceID);
	}

	@Then("^Verify select a category page is displayed$")
	public void verify_Select_Category_page_is_displayed() throws Throwable {
		System.out.println("------Checking New Car Page-----------");
		String passResult="New Car Page is displayed successfully";
		String failResult="New Car Page is not displayed";
		cdNewCarSelCatObject.verifyPgHeader("Select a Category",passResult,failResult,TestBase.deviceID);
	    
	}


}
