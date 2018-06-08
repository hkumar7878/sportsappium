package com.cucumber.framework.stepdefinition.CommonSteps;

import org.apache.log4j.Logger;
import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.configreader.ObjectRepo;

import cucumber.api.java.en.Given;

public class CommonSteps {
	
	private final Logger log= LoggerHelper.getLogger(CommonSteps.class);
	
	@Given("^navigate to web site$")
	public void navigate_to_web_site() throws Throwable {
		try
		{
			System.out.println("-------Inside common steps method--------");
			TestBase.driver.get(ObjectRepo.reader.getWebSite());
		}
		
		catch(Exception e)
		{
			e.getMessage();
		}
	
	  
	}
}
