package com.internethero.internetheropjct;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@Test
public class tcbasicAuth {

	WebDriver driver;
	
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



	}
