package com.cucumber.framework.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.framework.Helper.DropDown.DropDownHelper;
import com.cucumber.framework.Helper.JavaScript.JavaScriptHelper;
import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.relevantcodes.extentreports.LogStatus;

import ErrorCollectors.ErrorCollector;
import io.appium.java_client.AppiumDriver;

public class PG_MY_HomePage extends TestBase{
	
	AppiumDriver driver;
	private final Logger log = LoggerHelper.getLogger(PG_HomePage_AndroidWeb.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	JavaScriptHelper javascriptHelper;
	static boolean flag;
	public static String err_Msg;
	
	public PG_MY_HomePage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);		
		waitHelper.waitForElement(driver,20,imgHomePageLogo);
	}
	
	@FindBy(xpath="//span[@class='logo']")
	WebElement imgHomePageLogo;
	
	@FindBy(xpath="//div[@class='ripple-container ']//a[@href='/shop/men'][1]")
	WebElement btnMen;
	
	@FindBy(xpath="//div[@id='menu']//a[text()='Women']")
	WebElement menuWomen;
	
	@FindBy(xpath="//li[@class='main-items itemexpanded']")
	List<WebElement> menuMenOptions;
	
	public void verifyHomePage(String deviceID,String stepName,String passResult,String failResult,String HomePage)
	{
		try
		{
			log.info("---------Checking Myntra home page------------");
			flag=GenericHelper.isDisplayed(imgHomePageLogo);
			Assert.assertTrue(flag, "Myntra home page is not displayed");
			System.out.println("---------Myntra home page is displayed---------");
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
			String screenshot_path=GenericHelper.captureScreenShot3(driver, HomePage,HomePage,deviceID,"Samsung7");
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				String fail_image=androidReadDevice_logger1.addScreenCapture(screenshot_path);
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,strErrMsg_GenLib);
				//androidReadDevice_logger1.log(LogStatus.FAIL,stepName,fail_image);
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
			String screenshot_path=GenericHelper.captureScreenShot3(driver, HomePage,HomePage,deviceID,"Samsung7");
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				String fail_image=androidReadDevice_logger1.addScreenCapture(screenshot_path);
				//androidReadDevice_logger1.log(LogStatus.FAIL, stepName,strErrMsg_GenLib);
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,fail_image);
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.FAIL, stepName,failResult);
			}
			ErrorCollector.addVerificationFailure(e);
		}
	}
	/*
	 * This method will verify whether Men, Women etc buttons are displayed on home page
	 * 
	 * 
	 */
	
	public void verifyHomePageMenu(String deviceID,String menuName,String stepName,String passResult,String failResult)

	{
		javascriptHelper= new JavaScriptHelper(driver);
		try
		{
			log.info("---------Checking Menu for------------"  +menuName);
			if(menuName=="Men")
			{
				
				//javascriptHelper.scrollIntoView(btnMen);
				waitHelper.waitForElement(driver,20,btnMen);
				flag=GenericHelper.isDisplayed(btnMen);
				Assert.assertTrue(flag, menuName + "is displayed successfully");
			
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
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,e.getMessage());				
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.FAIL, stepName,e.getMessage());
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
	public PG_MY_MenProductPage clickBtn(String deviceID,String menuName,String stepName,String passResult,String failResult)
	{
		javascriptHelper= new JavaScriptHelper(driver);
		try
		{
			log.info("---------Clicking------------"  +menuName);
			if(menuName=="Men")
			{
				
				javascriptHelper.scrollIntoView(btnMen);
				waitHelper.waitForElement(driver,20,btnMen);
				flag=GenericHelper.click(btnMen);
				Assert.assertTrue(flag, menuName + "is clicked successfully");				
			}			
			else if(menuName=="Women")
			{
				javascriptHelper.scrollIntoView(menuWomen);
				waitHelper.waitForElement(driver,20,menuWomen);
				flag=GenericHelper.click(btnMen);
				Assert.assertTrue(flag, menuWomen + "is displayed successfully");
				
			}
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
			e.getMessage();
			System.out.println(e.getMessage());
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,failResult);							
			else if(deviceID.contains("emulator-5554"))
				androidEmulator_logger1.log(LogStatus.FAIL, stepName,failResult);
			ErrorCollector.addVerificationFailure(e);
		}
		return new PG_MY_MenProductPage(driver);
	}	
	
	
	public void verifyMenuOptions(String deviceID,String menuName,String stepName,String passResult,String failResult,List<String> options)
	{
		javascriptHelper= new JavaScriptHelper(driver);
		List<String> optionValues=new ArrayList<String>();
 		try
		{
			log.info("---------Checking options for------------"  +menuName);
			if(menuName=="Men")
			{
				optionValues=DropDownHelper.getAllOptionsUsingNonSelect(menuMenOptions);
				Assert.assertTrue(flag, menuName + "is clicked successfully");
				System.out.println("---------Men Menu is clicked successfully---------");
				
			}
			
			else if(menuName=="Women")
			{
				waitHelper.waitForElement(driver,20,menuWomen);
				flag=GenericHelper.click(btnMen);
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
		
		
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			log.info(e.getMessage());
			if(deviceID.contains("42003a0fd3148479"))
			{
				androidReadDevice_logger1.log(LogStatus.FAIL, stepName,e.getMessage());
			}
			
			else if(deviceID.contains("emulator-5554"))
			{
				androidEmulator_logger1.log(LogStatus.FAIL, stepName,e.getMessage());
			}
			ErrorCollector.addVerificationFailure(e);
		}
		
		catch (AssertionError e)
		{
			e.getMessage();
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
