package com.internethero.internetheropjct;
import org.testng.annotations.*;
import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
//import utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;


@Test
public class tcbasicAuth {

	WebDriver driver;
	

		//public void __OrangeLogin(){
	//		logger = extent.startTest("_OrangeLogin");
	//		Log.startTestCase("_AddContact");
			
	//	}


	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}
	
	@Test
	public void basicAuthTest()
	{		String actual = driver.findElement(By.cssSelector("#content > div > p")).getText();
	Assert.assertEquals(actual, "Congratulations! You must have the proper credentials.");

		
	}
	
	@AfterMethod	
	public void tearDown() {
			driver.close();
	}



//	@AfterMethod
	//public void cleanup(ITestResult result) {
	//	cleanuptest(result);
	//}

//	@BeforeTest
	//public void startReport(){
	//	extent = new ExtentReports (testoutput, false);
	//	extent
	//	.addSystemInfo("Host Name", " Internet ")
	//	.addSystemInfo("Environment", "Assignment")
	//	.addSystemInfo("User Name", "Farah Khan");
	//	extent.loadConfig(new File(extentConfigutaion));
	//}

//	@AfterTest
	//public void endReport(){
	//	extent.flush();
	//	extent.close();
	}
