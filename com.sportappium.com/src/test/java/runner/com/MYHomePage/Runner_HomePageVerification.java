package runner.com.MYHomePage;


import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.utility.ActionAfterClass;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features={"classpath:featurefile/MYT_MenProductPage/MYT_MenProductVerifcation.feature"}
,glue={"classpath:com.cucumber.framework.stepdefinition",
	   "classpath:com.cucumber.framework.Helper"},
		plugin = {"html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json"},
	
      //tags ={"@TC_001,@TC_002,@TC_003","~@TC_04"},
     tags ={"~@TC_001","@TC_002","~@TC_003","~@TC_004","~@TC_005","~@TC_006"},
      dryRun=true,
	  monochrome = false
)

public class Runner_HomePageVerification extends TestBase{
	
	
	TestBase testbaseObj= new TestBase();
	ActionAfterClass actionAfterClassObj;
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before running the suite-CarDekho Website");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After running the suite-Car Dekho Web site");
	}
	
	@AfterTest
	public void afterTest()
	{
		actionAfterClassObj = new ActionAfterClass();
		actionAfterClassObj.actionAfterTest(testbaseObj.scenarioName, XMLtestCaseName);
		System.out.println("After executing the test");
	}
	
	@BeforeTest
	@Parameters({"deviceID"})
    public void onBeforeTestMobile(String deviceID,ITestContext testContext)
	 	{
		 	TestBase.XMLtestCaseName=testContext.getName();
		 	this.deviceID=deviceID;
		 	
		 	try
		 	{
		 		if(XMLtestCaseName.contains("Samsung7"))
	            {
		 			System.out.println("Step 1 of report start and browserID is " + browserID);	
		 			System.out.println("Inside Before Test class of BASE CLASS: Chrome");
		 			String filePath=System.getProperty("user.dir")+"\\"+ new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date())+ "Samsung_RealDevice.html";
		 			//String filePath=System.getProperty("user.dir")+"\\" +"Samsung_RealDevice" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date() + "reports.html");
	                androidReadDeviceRPT=new ExtentReports(filePath,true, DisplayOrder.OLDEST_FIRST);
	                //androidReadDeviceRPT=new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html",filePath,true, DisplayOrder.OLDEST_FIRST);
	                System.out.println("Inside Before Test class: Chrome & Extent Report for" + browserID + "is Initilized");
	             
	            }	
		 		
		 		else if(XMLtestCaseName.contains("Samsung Galaxy Emulator"))
	            {
		 			System.out.println("Step 1 of report start and browserID is " + browserID);	
		 			System.out.println("Inside Before Test class of BASE CLASS: Chrome");
	                String filePath=System.getProperty("user.dir")+"\\"+ "Emulator1.html";
	                androidEmulatorRPT=new ExtentReports(filePath,true, DisplayOrder.OLDEST_FIRST);
	                System.out.println("Inside Before Test class: Chrome & Extent Report for" + browserID + "is Initilized");
	           
	            }
		 	}
		 	
		 	catch(Exception e)
		 	{
		 		System.out.println(e.getMessage());
		 	}
	 	}	
	@Test()
	public void runCukes()
	{
		System.out.println("Test 1");
		new TestNGCucumberRunner(getClass()).runCukes();
	}

}



















/*@AfterClass
public static void teardown() {
    Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
    Reporter.setSystemInfo("user", System.getProperty("user.name"));
    Reporter.setSystemInfo("os", "Win");
    Reporter.setTestRunnerOutput("Sample test runner output message");
    System.out.println("After running the AfterClass");
}*/

/*@BeforeClass
public static void setup() {
	System.out.println("Before running the beforeClass");
    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//    extentProperties.setExtentXServerUrl("http://localhost:1337");
//    extentProperties.setProjectName("MyProject");
    extentProperties.setReportPath("output/myreport.html");
}*/
//@BeforeMethod()
//@Before
/*public void before() throws Exception
{
	System.out.println("Before TESTNG before method");
	System.out.println("Starting of Before method");
	ObjectRepo.reader=new PropertyFileReader();
	String bName=ObjectRepo.reader.getBrowserName();
	//setUpDriver(ObjectRepo.reader.getBrowser());
	testbaseObj.setUpDriver(bName);
	//log.info(ObjectRepo.reader.getBrowser());
	System.out.println("Inside Before method");
}

//@AfterMethod()
//@After
public void after(Scenario scenario)
{
	testbaseObj.driver.quit();
	//log.info("");
}*/
