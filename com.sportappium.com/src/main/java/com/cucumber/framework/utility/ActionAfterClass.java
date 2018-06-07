package com.cucumber.framework.utility;

import com.cucumber.framework.Helper.TestBase.TestBase;

public class ActionAfterClass {
	TestBase testBaseObj;
	
	public void actionAfterTest(String scenarioName, String browserID)
	{
		/*
		if(browserID.contains("FireFox"))
		{
			TestBase.report.endTest(testBaseObj.FF_logger);
			TestBase.report.flush();
			System.out.println("Extent report is flushed for Firefox");
		}
		
		else if (browserID.contains("Chrome"))
		{
			TestBase.report1.endTest(testBaseObj.CH_logger);
			TestBase.report1.flush();
			System.out.println("Extent report is flushed for Chrome");
		}*/
		
		if(browserID.contains("Samsung Galaxy Emulator"))
		{
			TestBase.androidEmulatorRPT.endTest(TestBase.androidEmulator_logger1);
			TestBase.androidEmulatorRPT.flush();
			System.out.println("Extent report is flushed for emulator-5554");
		}
		
		else if (browserID.contains("Samsung7"))
		{
			TestBase.androidReadDeviceRPT.endTest(TestBase.androidReadDevice_logger1);
			TestBase.androidReadDeviceRPT.flush();
			System.out.println("Extent report is flushed for 42003a0fd3148479");
		}
	}
	

}
