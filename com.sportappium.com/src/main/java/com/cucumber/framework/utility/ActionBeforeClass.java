package com.cucumber.framework.utility;

import com.cucumber.framework.Helper.TestBase.TestBase;

public class ActionBeforeClass extends TestBase{
	
	/*public void beforeScenarioAction(String browserType,String scenarioName,String tcDesc)
	
	{
		
		try{
		browserID=browserType;
		if(browserID.contains("Firefox"))
        {
            System.out.println("Inside beforeTestAction method and trying to start the report test");
			FF_logger=report.startTest(scenarioName, tcDesc);
            
        }

        else if(browserID.contains("Chrome"))
        {
        	System.out.println("Inside beforeTestAction method and trying to start the report test");
        	CH_logger=report1.startTest(scenarioName, tcDesc);
        }
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}*/
	
public void beforeScenarioAction(String deviceName,String scenarioName,String tcDesc)
	
	{
		
		try{
			
			//this.deviceName;
			
			if(deviceName.contains("Samsung7"))
			{
				System.out.println("Inside beforeTestAction method and trying to start the report test");
				androidReadDevice_logger1=androidReadDeviceRPT.startTest(scenarioName, tcDesc);      
			}

        else if(deviceName.contains("Samsung Galaxy Emulator"))
        {
        	System.out.println("Inside beforeTestAction method and trying to start the report test");
        	androidEmulator_logger1=androidEmulatorRPT.startTest(scenarioName, tcDesc);
        }
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


}
