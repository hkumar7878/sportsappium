package com.cucumber.framework.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;

import io.appium.java_client.AppiumDriver;

/**
 * 
 * @author hiteshg
 * This page class is related with the results for different cars
 * which is opened and display different car's results after clicking on search button
 * on car options page
 */

public class PG_SearchedCarResults_AndroidWeb {
	AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_SearchedCarResults_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();

	static boolean flag;
	
	
	public PG_SearchedCarResults_AndroidWeb(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		//waitHelper.waitForElement(driver,40,txtNewCarPageHd);
	}
	
	

}
