package com.internethero.internetheropjct;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class brokenImage {
	  static int invalidimg;

	
	public static void main(String[] args)
	{

	
	
	try {
		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("i m in chrome");
		driver.get("https://the-internet.herokuapp.com/broken_images");
  
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
	}
	