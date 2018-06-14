package com.cucumber.framework.stepdefinition.MenProdPage;

import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PG_MY_HomePage;
import com.cucumber.framework.pageobject.PG_MY_MenProductPage;
import com.cucumber.framework.stepdefinition.HomePage.TC_01_HomePageDisplayVerification;
import cucumber.api.java.en.Then;

import io.appium.java_client.AppiumDriver;

public class TC_001_MenProductPageVerification {
private final Logger log= LoggerHelper.getLogger(TC_001_MenProductPageVerification.class);
	
TestBase testbaseObj= new TestBase();
public AppiumDriver driver;
PG_MY_HomePage objMYhomePage;
PG_MY_MenProductPage objMenProdPage;
/*

@Then("^user verifies home page is displayed$")
public void user_verifies_home_page_is_displayed() throws Throwable {
	driver=TestBase.driver;
	System.out.println(driver.hashCode());
	objMYhomePage= new PG_MY_HomePage(driver);
	String stepName="Verify the Myntra Home page";
	String passResult="Myntra home page is displayed";
	String failResult="Myntra home page is not displayed";
	objMYhomePage.verifyHomePage(TestBase.deviceID,stepName,passResult,failResult);
    
}*/

@Then("^verify Men button displays on home page$")
public void verify_Men_button_displays_on_home_page() throws Throwable {
	driver=TestBase.driver;
	String stepName="Verify the Men button on home page";
	String passResult="Men button is displayed on home page";
	String failResult="Men button is NOT displayed on home page";
	objMYhomePage= new PG_MY_HomePage(driver);
	objMYhomePage.verifyHomePageMenu(TestBase.deviceID,"Men",stepName,passResult,failResult);
}

@Then("^click on Men button$")
public void click_on_Men_button() throws Throwable {
	String stepName="Click on Men button";
	String passResult="Men button is clicked successfully";
	String failResult="Men button is NOT clicked";
	objMenProdPage = new PG_MY_MenProductPage(driver);	
	objMenProdPage=objMYhomePage.clickBtn(TestBase.deviceID,"Men",stepName,passResult,failResult);
   
}

@Then("^verify Men Product page is displayed$")
public void verify_Men_Product_page_is_displayed() throws Throwable {
	String stepName="Verify Men Product Page";
	String passResult="Men Product Page is displayed successfully";
	String failResult="Men Product page is not displayed";
	objMenProdPage.verifyMenProPageDisplay(TestBase.deviceID, stepName, passResult, failResult);
    
}

}
