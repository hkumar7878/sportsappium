package com.cucumber.framework.stepdefinition.NewCar;

import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PG_HomePage_AndroidWeb;
import com.cucumber.framework.pageobject.PG_NewCarSelectCategory_AndroidWeb;
import com.cucumber.framework.pageobject.PG_SearchNewCar_By_Brand_Option_AndroidWeb;
import com.cucumber.framework.pageobject.PG_SearchedCarResults_AndroidWeb;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class TC_02_NewCarBrandResultsVerification {
private final Logger log= LoggerHelper.getLogger(TC_01_NewCarPageDisplayVerification.class);
	
	TestBase testbaseObj= new TestBase();
	public AppiumDriver driver;
	PG_HomePage_AndroidWeb cdHomePgObject;
	PG_NewCarSelectCategory_AndroidWeb cdNewCarSelCatObject;
	//PG_NewCarSelectCategory_AndroidWeb cdNewCarSelCatObject;
	PG_SearchNewCar_By_Brand_Option_AndroidWeb cdsearchNewCarBrandOptionObject;
	PG_SearchedCarResults_AndroidWeb cdSearchedCarResultsObject;
	
	
	@Then("^Click on Search New Car button$")
	public void click_on_Search_New_Car_button() throws Throwable {
		System.out.println("------Clicking New Car Button-----------");
		String passResult="New Button is clicked successfully";
		String failResult="New Button could not be clicked";
		driver=TestBase.driver;
		cdNewCarSelCatObject = new PG_NewCarSelectCategory_AndroidWeb(driver);
		cdsearchNewCarBrandOptionObject= cdNewCarSelCatObject.clickSearchByOption_Btn("Search New Car",passResult,failResult, TestBase.deviceID);
		
	}

	@Then("^Verify Search New Car page is displayed$")
	public void verify_Search_New_Car_page_is_displayed() throws Throwable {
		System.out.println("------Checking New Car Page-----------");
		String passResult="New Car Page is displayed successfully";
		String failResult="New Car Page is not displayed";
		cdsearchNewCarBrandOptionObject.verifyPgHeader("Car name or brand",passResult,failResult,TestBase.deviceID);
	    
	}

	@Then("^Click on Maruti button under Brands section$")
	public void click_on_Maruti_button_under_Brands_section() throws Throwable {
	  
		System.out.println("------Clicking Maruti Car button-----------");
		String passResult="Maruti Car option selected successfully";
		String failResult="Maruti Car option  was not selected";
		cdsearchNewCarBrandOptionObject.selectCarBrandOption("Maruti",passResult,failResult,TestBase.deviceID);
	}

	@Then("^Verify that Maruti module is selected$")
	public void verify_that_Maruti_module_is_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Click on Search button$")
	public void click_on_Search_button() throws Throwable {
	    System.out.println("--------Clicking Search button----------");
	    String passResult="Search button is clicked successfully";
		String failResult="Search button could not be clicked";
		driver=TestBase.driver;
		//cdSearchedCarResultsObject= new PG_SearchedCarResults_AndroidWeb(driver);
		
		//cdSearchedCarResultsObjectcdSearchedCarResultsObject
	   
	}

	@Then("^Verify Search result page specific to Maruti is displayed$")
	public void verify_Search_result_page_specific_to_Maruti_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Verify first search page should contain only maruti cars results only$")
	public void verify_first_search_page_should_contain_only_maruti_cars_results_only() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^scroll to bottom and click on Next button$")
	public void scroll_to_bottom_and_click_on_Next_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("^Verify next search page should contain only maruti cars results only$")
	public void verify_next_search_page_should_contain_only_maruti_cars_results_only() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
}
