package com.internethero.internetheropjct;


import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class brokenImage {

	System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	System.out.println("i m in chrome");
	driver.get("https://the-internet.herokuapp.com/broken_images");
    List <WebElement>  naturalWidth = driver.findElements(By.tagName("img"));

	
	public void isImageBroken(WebElement image)
	{
	    if (image.getAttribute("naturalWidth").equals("0"))
	    {
	        System.out.println(image.getAttribute("outerHTML") + " is broken.");

	    }
	}
	
	for (WebElement image : driver.findElements(By.cssSelector("img")))
	{
	    isImageBroken(image);
	}
	
	
	
	
	

}