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

public class basicAuth {
@Test
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("i m in chrome");
		//To handle chrome authentication popup pass the username and password in the URL,since elements are not identified using locators
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println("i m here");
		String actual = driver.findElement(By.cssSelector("#content > div > p")).getText();
		Assert.assertEquals(actual, "Congratulations! You must have the proper credentials.");
		System.out.println("I m not here");
		
	}

	
}

