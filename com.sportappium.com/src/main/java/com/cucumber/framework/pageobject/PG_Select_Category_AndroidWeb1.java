package com.cucumber.framework.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;

import io.appium.java_client.AppiumDriver;

public class PG_Select_Category_AndroidWeb1 {
	
	public AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_HomePage_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	static boolean flag;
	
	public PG_Select_Category_AndroidWeb1(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		waitHelper.waitForElement(driver,20,txtSearchOptionsHd);
	
	}
	@FindBy(xpath="//h3[contains(text(),'Search by Car name or brand')]")
	WebElement txtSearchOptionsHd;
}
