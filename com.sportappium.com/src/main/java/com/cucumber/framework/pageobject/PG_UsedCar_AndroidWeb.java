package com.cucumber.framework.pageobject;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.cucumber.framework.utility.ApplicationLib;
import com.relevantcodes.extentreports.LogStatus;

import ErrorCollectors.ErrorCollector;

public class PG_UsedCar_AndroidWeb extends TestBase{
	AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_HomePage_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	ApplicationLib appLibOnj= new ApplicationLib();
	String actHdTxt;
	static boolean flag;
	public static String err_Msg;
	
	public PG_UsedCar_AndroidWeb(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		//waitHelper.waitForElement(driver,20,txtUsedCarPageHd);
	}
	
	@FindBy(xpath="//span[contains(text(),'Know everything')]")
	WebElement txtUsedCarPageHd;
	
	public void verifyPgHeader(String expTxt,String passResult,String failResult,String deviceID)
	{
		try
		{
				log.info("Checking Used Car Page");
				actHdTxt=generichelper.readValueFromElement(txtUsedCarPageHd);
				Assert.assertEquals(expTxt.trim(), actHdTxt.trim());
				System.out.println("Car dekho Used Car page is displayed");
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

}
