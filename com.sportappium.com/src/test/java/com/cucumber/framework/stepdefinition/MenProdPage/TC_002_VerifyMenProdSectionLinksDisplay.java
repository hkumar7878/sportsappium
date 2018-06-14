package com.cucumber.framework.stepdefinition.MenProdPage;

import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PG_MY_HomePage;
import com.cucumber.framework.pageobject.PG_MY_MenProductPage;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class TC_002_VerifyMenProdSectionLinksDisplay {
	private final Logger log= LoggerHelper.getLogger(TC_002_VerifyMenProdSectionLinksDisplay.class);	
	TestBase testbaseObj= new TestBase();
	public AppiumDriver driver;
	PG_MY_HomePage objMYhomePage;
	PG_MY_MenProductPage objMenProdPage;
	String [] arrMenProdOpton= {"Clothing","Footwear","Accessories","Personal Care & Grooming"};

	
	@Then("^verify correct men sections links are displayed$")
	public void verify_correct_men_sections_links_are_displayed() throws Throwable {
		try
		{
			driver=TestBase.driver;
			String stepName="Verify Men Product Options";
			String passResult="All Men Prod options are appearing correctly";
			String failResult="Men Prod Options are not appearing correctly";
			objMenProdPage= new PG_MY_MenProductPage(driver);
			objMenProdPage.verifyMenProPageProdOptions(TestBase.deviceID, stepName, passResult, failResult,arrMenProdOpton);
		}
		
		catch(Exception e)
		{
			e.getMessage();
			System.out.println(e.getMessage());
		}
	}

}
