package com.cucumber.framework.pageobject;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.model.Test;
import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.cucumber.framework.utility.ApplicationLib;
import com.relevantcodes.extentreports.LogStatus;

import ErrorCollectors.ErrorCollector;

public class PG_NewCarSelectCategory_AndroidWeb extends TestBase{
	AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_NewCarSelectCategory_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	//ApplicationLib appLibOnj= new ApplicationLib();
	String actHdTxt;
	static boolean flag;
	public static String err_Msg;
	
	public PG_NewCarSelectCategory_AndroidWeb(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		//waitHelper.waitForElement(driver,40,txtNewCarPageHd);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Select a Category')]")
	WebElement txtNewCarPageHd;
	
	@FindBy(xpath="//a[text()='Search New Car']")
	//@FindBy(xpath="//ul[@class='cd-pad-l-r']//li//a[contains(text(),'New Car')]")
	WebElement btnSearchNewCar;
	
	@FindBy(xpath="//label[@id='Maruti']")
	//@FindBy(xpath="//ul[@class='cd-pad-l-r']//li//a[contains(text(),'New Car')]")
	WebElement btnMarutiCar;
	
	/**
	 * 
	 * @param expTxt
	 * @param passResult
	 * @param failResult
	 * @param deviceID
	 */
	
	public void verifyPgHeader(String expTxt,String passResult,String failResult,String deviceID)
	{
		try
		{
			Thread.sleep(1000);	
			System.out.println("Checking New Car page for....."  + deviceID);
			log.info("Checking Car Dekho home page" + deviceID);
				actHdTxt=generichelper.readValueFromElement(txtNewCarPageHd);
				Assert.assertEquals(expTxt.trim(), actHdTxt.trim());
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
	
	/**
	 * 
	 * @param searchOption
	 * @param passResult
	 * @param failResult
	 * @param deviceID
	 * @return
	 */
	
	public PG_SearchNewCar_By_Brand_Option_AndroidWeb clickSearchByOption_Btn(String searchOption,String passResult,String failResult,String deviceID)
	{
		//Thread.sleep(1000);	
		try
		{
		
			System.out.println("Clicking on "  + searchOption);
			log.info("Checking Car Dekho home page" + deviceID);
			if(searchOption.contains("Search New Car"))
				
				{
					//WebElement btnSearchNewCar=driver.findElement(By.xpath("//a[text()='Search New Car']"));
					System.out.println("Searching");
					flag=GenericHelper.click(btnSearchNewCar);
					Assert.assertTrue(flag, "Search New Car button is not clicked");
					System.out.println("Car dekho home page is displayed");
				}
		
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
		return new PG_SearchNewCar_By_Brand_Option_AndroidWeb(driver);
	}
}
