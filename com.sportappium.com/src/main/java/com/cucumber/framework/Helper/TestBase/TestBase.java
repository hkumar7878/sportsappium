package com.cucumber.framework.Helper.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.configreader.PropertyFileReader;

import org.openqa.selenium.remote.BrowserType;

import com.cucumber.framework.configuration.browser.ChromeBrowser;
//import com.cucumber.framework.configuration.browser.FireFoxBrowser;
import com.cucumber.framework.utility.ActionBeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestBase {
	
	private final static Logger log=LoggerHelper.getLogger(TestBase.class);
	//public static WebDriver driver;
	public static AppiumDriver driver;
	public static Properties prop=null;
	ActionBeforeClass actionBeforeClass;
	public static String browserID=null;
	public static String deviceName=null;
	public static String deviceID=null;
	public static String XMLtestCaseName;
	String app_URL=null;
	static DesiredCapabilities cap= new DesiredCapabilities();
	
	public static ExtentReports report;
	public static ExtentReports androidEmulatorRPT;
	
	public static ExtentReports androidReadDeviceRPT;
    public static ExtentReports report1;
    
    public static ExtentTest FF_logger;
    public static ExtentTest androidEmulator_logger1;
    
    public static ExtentTest CH_logger;
    public static ExtentTest androidReadDevice_logger1;
    public static String scenarioName;
    public static URL url;
    //String XMLtestCaseName;
    
    @Before
	public void before(Scenario scenario) throws Exception
	{
		actionBeforeClass = new ActionBeforeClass();
    	scenarioName=scenario.getName();
		System.out.println("Before TESTNG before method");
		System.out.println("Starting of Before method");
		ObjectRepo.reader=new PropertyFileReader();
		String bName=ObjectRepo.reader.getBrowserName();
		System.out.println("Inside Before method");
	    //actionBeforeClass.beforeScenarioAction(bName,scenarioName,"test");
		actionBeforeClass.beforeScenarioAction(XMLtestCaseName,scenarioName,"test");
	   // setUpAndroidDriver(String deviceID,String tcName);
	    setUpAndroidDriver(deviceID,XMLtestCaseName);
	}
	
	@After
	public void after(Scenario scenario) throws Exception
	{
		driver.quit();
		log.info("Quited the scenario driver");
		System.out.println("Quited the scenario driver");
		System.out.println("---------Again restarting the driver instance for next scenarios--------");
		//setUpAndroidDriver(deviceID,XMLtestCaseName);
	}
	
	
	
	
	public static AppiumDriver getAnroidBrowserObject(String deviceID,String tcName) throws Exception
	{
		try
		{
			log.info(deviceID);
			switch(tcName.trim()){
			
			case "Samsung7":
				
				cap= DesiredCapabilities.android();
				cap.setCapability("no", true);
				cap.setCapability("pageLoadStrategy", "none");
				cap.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
				cap.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability("applicationName", "Samsung S4");
				cap.setCapability(MobileCapabilityType.VERSION, "7.0");
				cap.setCapability("udid", deviceID);
				//URL url = new URL("http://0.0.0.0:4723/wd/hub");
			//	url = new URL("http://0.0.0.0:4723/wd/hub");
				url = new URL("http://127.0.0.1:4723/wd/hub");
				driver= new AppiumDriver(url,cap);
				break;	
				//Testing git
				
				
			case "Samsung Galaxy Emulator":
				cap= DesiredCapabilities.android();
				cap.setCapability("no", true);
				cap.setCapability("pageLoadStrategy", "none");
				cap.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
				cap.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability("applicationName", "Samsung S5");
				cap.setCapability(MobileCapabilityType.VERSION, "5.1.1");
				cap.setCapability("udid", deviceID);
				//URL url1 = new URL("http://0.0.0.0:4724/wd/hub");
			//	url = new URL("http://0.0.0.0:4724/wd/hub");
				url = new URL("http://127.0.0.1:4725/wd/hub");
				driver= new AppiumDriver(url,cap);
				break;
			}	
			return driver;
		}
		
		catch(Exception e)
		{
			log.equals(e);
			throw e;
		}
	}
	

	
	public static void setUpAndroidDriver(String deviceID,String tcName) throws Exception
	{		
		try
		{
			driver=getAnroidBrowserObject(deviceID,tcName);
			log.debug("Initialize Webdriver : " + driver.hashCode());
			driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	

}
