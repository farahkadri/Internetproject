package com.internethero.internetheropjct;
import org.testng.annotations.*;
import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
//import utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;


public class tcbrokenImage {
	
	WebDriver driver;
	static int invalidimg;

	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");


	}

	@Test
	
	public void brokenImageTest()
	{
		try {
		invalidimg = 0;
	      List allImages  = driver.findElements(By.tagName("img"));
	      System.out.println("Total  images are " + allImages.size());
	      for (int i = 0; i < allImages.size(); i++) {
	        WebElement img = (WebElement) allImages.get(i);
	        if (img != null) {
	          verifyimgActive(img);
	        }
	      }
	      System.out.println("Total invalid images are " + invalidimg);
	      driver.quit();
    } catch (Exception e) {
      e.printStackTrace();
     System.out.println(e.getMessage());
    }
	}
  

  public static void verifyimgActive(WebElement img) {
    try {
      HttpResponse response = new DefaultHttpClient().execute(new HttpGet(img.getAttribute("src")));
      if (response.getStatusLine().getStatusCode() != 200)
      invalidimg++;
    } catch (Exception e) {
      e.printStackTrace();
    
  }

	}
	
	@AfterMethod	
	public void tearDown() {
			driver.close();
	}

}
