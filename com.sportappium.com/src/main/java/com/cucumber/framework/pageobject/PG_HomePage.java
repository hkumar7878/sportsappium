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

public class PG_HomePage extends TestBase{
	
	AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_HomePage_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	JavaScriptHelper javascriptHelper;
	static boolean flag;
	public static String err_Msg;
	
	public PG_HomePage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//commit
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		waitHelper.waitForElement(driver,20,imgAdidasLogo);
		//waitHelper.waitForElementVisible(locator, timeOutInSeconds, pollingEveryInMillSec);(driver,20,txtHomePageHd);
	}
	
	@FindBy(xpath="//span[@class='header-item-logo']")
	WebElement imgAdidasLogo;
	
	@FindBy(xpath="//div[@id='menu']//a[text()='Men']")
	WebElement menuMen;
	
	@FindBy(xpath="//div[@id='menu']//a[text()='Women']")
	WebElement menuWomen;
	
	public void verifyHomePage(String deviceID,String stepName,String passResult,String failResult)
	{
		try
		{
			log.info("---------Checking Adidas home page------------");
			flag=GenericHelper.isDisplayed(imgAdidasLogo);
			Assert.assertTrue(flag, "Adidas home page is not displayed");
			System.out.println("---------Adidas home page is displayed---------");
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.PASS, stepName,passResult);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.PASS, stepName,passResult);
			}
		}
		
		
		catch(Throwable e)
		{
			e.getMessage();
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
	}
	
	public void verifyHomePageMenu(String deviceID,String menuName,String stepName,String passResult,String failResult)
	{
		javascriptHelper= new JavaScriptHelper(driver);
		try
		{
			log.info("---------Checking Menu for------------"  +menuName);
			if(menuName=="Men")
			{
				
				javascriptHelper.scrollIntoView(menuMen);
				waitHelper.waitForElement(driver,20,menuMen);
				flag=GenericHelper.isDisplayed(menuMen);
				Assert.assertTrue(flag, menuName + "is displayed successfully");
				System.out.println("---------Adidas home page is displayed---------");
				
			}
			
			else if(menuName=="Women")
			{
				javascriptHelper.scrollIntoView(menuWomen);
				waitHelper.waitForElement(driver,20,menuWomen);
				flag=GenericHelper.isDisplayed(menuWomen);
				Assert.assertTrue(flag, menuWomen + "is displayed successfully");
				System.out.println("---------Women Menu on Home page is displayed---------");
			}
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.PASS, stepName,passResult);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.PASS, stepName,passResult);
			}
		}
		
		
		catch(Throwable e)
		{
			e.getMessage();
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
	}
	
	
}
