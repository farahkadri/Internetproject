package com.internethero.internetheropjct;

public class hoverPictures {

}

package farah.automation;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Basicauth {
@Test
	public static void main(String[] args)
	{/**
		System.setProperty("webdriver.chrome.driver","C:/Users/umul/Downloads/apiTest/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("i m in chrome");
		//To handle chrome authentication popup pass the username and password in the URL,since elements are not identified using locators
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println("i m here");
		String actual = driver.findElement(By.cssSelector("#content > div > p")).getText();
		Assert.assertEquals(actual, "Congratulations! You must have the proper credentials.");
		System.out.println("I m not here");**/
		System.setProperty("webdriver.chrome.driver","C:/Users/umul/Downloads/apiTest/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		WebElement Slide = driver.findElement(By.cssSelector("#content > div > div"));
		Actions builder = new Actions(driver);
		Action dragslider = builder.dragAndDropBy(Slide, 5, 0).build();
		((Actions)dragslider).perform();
		String Maxelementnum = driver.findElement(By.cssSelector("#range")).getText();
		Assert.assertEquals(Maxelementnum, "5");
		System.out.println("verified");
	}

	
}

