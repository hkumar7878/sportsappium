package com.cucumber.framework.pageobject;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ErrorCollectors.ErrorCollector;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.relevantcodes.extentreports.LogStatus;

public class PG_HomePage_AndroidWeb extends TestBase{
	
	AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_HomePage_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	static boolean flag;
	public static String err_Msg;
	//PageAndroidWeb_NewCar cdobjNewCar;
	
	public PG_HomePage_AndroidWeb(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		waitHelper.waitForElement(driver,20,txtHomePageHd);
		//waitHelper.waitForElementVisible(locator, timeOutInSeconds, pollingEveryInMillSec);(driver,20,txtHomePageHd);
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'Welcome to your trusted car advisor')]")
	WebElement txtHomePageHd;
	
	/*@FindBy(xpath="//h1[contains(text(),'Unit test')]")
	WebElement txtHomePageHd;*/
	
	@FindBy(xpath="//a[@class='fab new']")
	WebElement btnNewCar;
	
	@FindBy(xpath="//a[@class='fab used']")
	WebElement btnUsedCar;
	
	
	public void verifyHomePage(String deviceID,String passResult,String failResult)
	{
		try
		{
			log.info("---------Checking Car Dekho home page------------");
			flag=GenericHelper.isDisplayed(txtHomePageHd);
			Assert.assertTrue(flag, "Car dekho home page is not displayed");
			System.out.println("---------Car dekho home page is displayed---------");
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.PASS, passResult);
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
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.FAIL, failResult);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.FAIL, failResult);
			}
			ErrorCollector.addVerificationFailure(e);
		}
	}
	
	public void verifyBtnDisplay(String btnName,String passResult,String failResult,String deviceID)
	{
		try
		{
			Thread.sleep(2000);
			log.info("Checking New Car button existence on home page");
			if(btnName.equalsIgnoreCase("New Car"))
			{
				flag=GenericHelper.isDisplayed(btnNewCar);
				Assert.assertTrue(flag, "New Car button is not displayed");
				System.out.println("New Car button is displayed");
			}
			
			if(btnName.equalsIgnoreCase("Used Car"))
			{
				flag=GenericHelper.isDisplayed(btnUsedCar);
				Assert.assertTrue(flag, "Used Car button is not displayed");
			}
			
			
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.PASS, passResult);
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
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.FAIL, failResult);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				//androidEmulator_logger1
				androidEmulator_logger1.log(LogStatus.FAIL, failResult);
			}
			
		}
	}
	
	
	public PG_NewCarSelectCategory_AndroidWeb clickBtn(String btnName,String passResult,String failResult,String deviceID) throws InterruptedException
	{
		
		Thread.sleep(2000);
		try
		{
			log.info(".........Clicking on New Car button........");
			if(btnName.equalsIgnoreCase("New Car"))
			{
				System.out.println("Checking new car button clicking");
				flag=GenericHelper.click(btnNewCar);
				Assert.assertTrue(flag, "New Car button is not clicked");
			}
			
			if(btnName.equalsIgnoreCase("Used Car"))
			{
				flag=GenericHelper.click(btnUsedCar);
				Assert.assertTrue(flag, "Used Car button is not clicked");
			}
			
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.PASS, passResult);
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
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.FAIL, failResult);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.FAIL, failResult);
			}
		}
		return new PG_NewCarSelectCategory_AndroidWeb(driver);
		
	}
	
	public PG_UsedCar_AndroidWeb clickUsedCarBtn(String btnName,String passResult,String failResult,String deviceID)
	{
		PG_UsedCar_AndroidWeb cdobjUsedCar;
		try
		{
			log.info(".........Clicking on New Car button........");			
			if(btnName.equalsIgnoreCase("Used Car"))
			{
				flag=GenericHelper.click(btnUsedCar);
				Assert.assertTrue(flag, "Used Car button is not clicked");
			}
			
			
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.PASS, passResult);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				//androidEmulator_logger1
				androidEmulator_logger1.log(LogStatus.PASS, passResult);
			}
		}
		
		catch(Exception e)
		{
			e.getMessage();
			System.out.println(e.getMessage());
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))			
				androidReadDevice_logger1.log(LogStatus.FAIL, failResult);			
			else if(deviceID.contains("emulator-5554"))
				androidEmulator_logger1.log(LogStatus.FAIL, failResult);
			ErrorCollector.addVerificationFailure(e);
			
		}
		return new PG_UsedCar_AndroidWeb(driver);
		
	}
	
	

}
