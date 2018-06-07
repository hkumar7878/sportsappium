package com.cucumber.framework.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.internal.thread.ThreadExecutionException;

import com.cucumber.framework.Helper.JavaScript.JavaScriptHelper;
import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.relevantcodes.extentreports.LogStatus;

import ErrorCollectors.ErrorCollector;
import io.appium.java_client.AppiumDriver;

/**
 * 
 * Purpose of this class page is to provide methods and functionalities related 
 * with Car options page
 *
 */

public class PG_SearchNewCar_By_Brand_Option_AndroidWeb extends TestBase{
	public AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_HomePage_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	JavaScriptHelper javascriptHelper;
	static boolean flag;
	public static String err_Msg;
	String actHdTxt;
	
	public PG_SearchNewCar_By_Brand_Option_AndroidWeb(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		//waitHelper.waitForElement(driver,20,txtSearchOptionsHd);
		//waitHelper.waitForElementVisible(locator, timeOutInSeconds, pollingEveryInMillSec);(driver,20,txtHomePageHd);
	}
	
		@FindBy(xpath="//h3[contains(text(),'Search by Car name or brand')]")
		WebElement txtSearchOptionsHd;
		
		@FindBy(xpath="//label[@id='Maruti']")
		WebElement btn_MarutiCar;
		
		@FindBy(xpath="//button[text()='SEARCH']")
		WebElement btn_Search;
		
		
		public void verifyPgHeader(String expTxt,String passResult,String failResult,String deviceID)
		{
			try
			{
					Thread.sleep(1000);	
					System.out.println("Checking Search New Car page for....."  + deviceID);
					log.info("Checking New Car Search Page " + deviceID);
					actHdTxt=generichelper.readValueFromElement(txtSearchOptionsHd);
					if(actHdTxt.contains(expTxt))
						flag=true;
					Assert.assertTrue(flag,"Actual text is not matching with exp text");
					System.out.println("Car dekho home page is displayed");
					if(deviceID.contains("42003a0fd3148479"))
					{
						androidReadDevice_logger1.log(LogStatus.PASS,passResult);
					}
					
					else if(deviceID.contains("emulator-5554"))
					{
						//androidEmulator_logger1
						androidEmulator_logger1.log(LogStatus.PASS, passResult);
					}
					
				}
				
				
				catch(Throwable e)
				{
					e.getMessage();
					System.out.println(e.getMessage());
					if(deviceID.contains("42003a0fd3148479"))
					{
						androidReadDevice_logger1.log(LogStatus.FAIL,failResult);
					}
					
					else if(deviceID.contains("emulator-5554"))
					{
						//androidEmulator_logger1
						androidEmulator_logger1.log(LogStatus.FAIL, failResult);
					}
					ErrorCollector.addVerificationFailure(e);
				}
			}
		
		public void selectCarBrandOption(String brandName,String passResult,String failResult,String deviceID)
		{
			
			javascriptHelper= new JavaScriptHelper(driver);
			log.info("Clicking Maruti Car option " + deviceID);
			try
			{
				if(brandName.equals("Maruti"))
				{
					//flag=GenericHelper.click(btn_MarutiCar);
					flag=javascriptHelper.scrollIntoViewAndClick(btn_MarutiCar);
					Assert.assertTrue(flag, "Maruti Car button is not clicked");
					
					System.out.println("Maruti Car button is clicked successfully");
				}
				else if(brandName.equals("Honda"))
				{
					
				}
	
				if(deviceID.contains("42003a0fd3148479"))
				{
					androidReadDevice_logger1.log(LogStatus.PASS,passResult);
				}
	
				else if(deviceID.contains("emulator-5554"))
					{
		
					androidEmulator_logger1.log(LogStatus.PASS, passResult);
					}			
			}
			
			catch(Throwable e)
			{
				e.getMessage();
				System.out.println(e.getMessage());
				if(deviceID.contains("42003a0fd3148479"))
				{
					androidReadDevice_logger1.log(LogStatus.FAIL,failResult);
				}
				
				else if(deviceID.contains("emulator-5554"))
				{
					//androidEmulator_logger1
					androidEmulator_logger1.log(LogStatus.FAIL, failResult);
				}
				ErrorCollector.addVerificationFailure(e);
			
			}
		}
		
		
		public PG_SearchedCarResults_AndroidWeb clickBtn(String btnName,String passResult,String failResult,String deviceID)
		{
			log.info("Clicking Maruti Car option " + deviceID);
			System.out.println("-----Clicking Search button on Car brand page-----");
			
			try
			{
				if(btnName.equals("Search"))
				{
					flag=generichelper.click(btn_Search);
					Assert.assertTrue(flag,"Failed to click Search button");
				}
				if(deviceID.contains("42003a0fd3148479"))
				{
					androidReadDevice_logger1.log(LogStatus.PASS,passResult);
				}
	
				else if(deviceID.contains("emulator-5554"))
					{
		
					androidEmulator_logger1.log(LogStatus.PASS, passResult);
					}
			
			}
			
			catch(Throwable e)
			{
				e.getMessage();
				System.out.println(e.getMessage());
				if(deviceID.contains("42003a0fd3148479"))
				{
					androidReadDevice_logger1.log(LogStatus.FAIL,failResult);
				}
				
				else if(deviceID.contains("emulator-5554"))
				{
					//androidEmulator_logger1
					androidEmulator_logger1.log(LogStatus.FAIL, failResult);
				}
				ErrorCollector.addVerificationFailure(e);
			
			}
			
			return new PG_SearchedCarResults_AndroidWeb(driver);
		}

}
