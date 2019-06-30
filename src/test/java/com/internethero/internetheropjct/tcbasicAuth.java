package com.internethero.internetheropjct;
import org.testng.annotations.*;
import java.io.File;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.log4j.xml.DOMConfigurator;
//import utilities.*;


@Test
public class tcbasicAuth {


		public void __OrangeLogin(){
			logger = extent.startTest("_OrangeLogin");
			Log.startTestCase("_AddContact");
			
		}


	@BeforeMethod
	@Parameters({"browser", "platform"})
	public void setup(String browser, String platform) {
		try{
			setupBrowser(browser, platform);
		}catch(Exception e) {}
	}

	@AfterMethod
	public void cleanup(ITestResult result) {
		cleanuptest(result);
	}

	@BeforeTest
	public void startReport(){
		extent = new ExtentReports (testoutput, false);
		extent
		.addSystemInfo("Host Name", " Internet ")
		.addSystemInfo("Environment", "Assignment")
		.addSystemInfo("User Name", "Farah Khan");
		extent.loadConfig(new File(extentConfigutaion));
	}

	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
} 