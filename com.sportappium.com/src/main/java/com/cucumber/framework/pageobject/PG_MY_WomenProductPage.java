package com.cucumber.framework.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.framework.Helper.JavaScript.JavaScriptHelper;
import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.relevantcodes.extentreports.LogStatus;

import ErrorCollectors.ErrorCollector;
import io.appium.java_client.AppiumDriver;

public class PG_MY_WomenProductPage extends TestBase{
	
	AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_HomePage_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	JavaScriptHelper javascriptHelper;
	static boolean flag;
	public static String err_Msg;
	String strClothing;
	String strFootWear;
	String strAccessories;
	String strPersonalCare;
	
	public PG_MY_WomenProductPage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);		
		//waitHelper.waitForElement(driver,20,lnkClothing);
	}
	
	@FindBy(xpath="//span[text()='Clothing']")
	WebElement lnkClothing;
	
	@FindBy(xpath="//span[text()='Footwear']")
	WebElement lnkFootwear;
	
	@FindBy(xpath="//span[text()='Accessories']")
	WebElement lnkAccessories;
	
	@FindBy(xpath="//span[text()='Personal Care & Grooming']")
	WebElement lnkPersonalCare;
	
	public void verifyMenProPageDisplay(String deviceID,String stepName,String passResult,String failResult)
	{
		try
		{
			log.info("---------Checking Men Product Page------------");
			Thread.sleep(2000);
			flag=GenericHelper.isDisplayed(lnkClothing);
			Assert.assertTrue(flag, "Men Product page is not displayed");
			System.out.println("---------Men Product page is displayed---------");
			if(deviceID.contains("42003a0fd3148479"))		
				androidReadDevice_logger1.log(LogStatus.PASS, stepName,passResult);					
			else if(deviceID.contains("emulator-5554"))	
				androidEmulator_logger1.log(LogStatus.PASS, stepName,passResult);		
		}		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))		
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,e.getMessage());		
			else if(deviceID.contains("emulator-5554"))
				androidEmulator_logger1.log(LogStatus.FAIL, stepName,e.getMessage());
			ErrorCollector.addVerificationFailure(e);
		}

		catch (AssertionError e)
		{
			System.out.println(e.getMessage());
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))		
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,failResult);							
			else if(deviceID.contains("emulator-5554"))
				androidEmulator_logger1.log(LogStatus.FAIL, stepName,failResult);
			ErrorCollector.addVerificationFailure(e);
		}
	}

	
	public void verifyMenProPageProdOptions(String deviceID,String stepName,String passResult,String failResult, String [] prodOptions)
	{
		try
		{
			log.info("---------Checking Men Product options on Men Product Page------------");
			strClothing=generichelper.readValueFromElement(lnkClothing);
			strFootWear=generichelper.readValueFromElement(lnkFootwear);
			if(strClothing.trim().equals(prodOptions[0]) && GenericHelper.isDisplayed(lnkClothing)&& strFootWear.trim().equals(prodOptions[1]) && GenericHelper.isDisplayed(lnkFootwear))
				flag=true;
			//flag=GenericHelper.isDisplayed(lnkClothing);
			Assert.assertTrue(flag, "Men Product page is not displayed");
			System.out.println("---------Men Product page is displayed---------");
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.PASS, stepName,passResult);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.PASS, stepName,passResult);
			}
		}
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,strErrMsg_GenLib);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.FAIL, stepName,strErrMsg_GenLib);
			}
			ErrorCollector.addVerificationFailure(e);
		}

		catch (AssertionError e)
		{
			System.out.println(e.getMessage());
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,failResult);				
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.FAIL, stepName,failResult);
			}
			ErrorCollector.addVerificationFailure(e);
		}
	}

}
