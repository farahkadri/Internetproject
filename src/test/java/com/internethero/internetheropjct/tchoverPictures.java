package com.internethero.internetheropjct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class tchoverPictures {
	
	WebDriver driver;
    
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/hovers");
	}

	@Test
	public void hoverPictures()
	
	{
        WebElement element = driver.findElement(By.cssSelector(" #content > div > div:nth-child(3) > img"));
        WebElement element1 = driver.findElement(By.cssSelector(" #content > div > div:nth-child(4) > img"));
        WebElement element2 = driver.findElement(By.cssSelector(" #content > div > div:nth-child(5) > img"));


        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
		System.out.println("got that");
       // driver.findElement(By.linkText("iPads")).click();
		String actual = driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5 ")).getText();
		Assert.assertEquals(actual, "name: user1");
		System.out.println("It matched user 1");
		
		action.moveToElement(element1).build().perform();
		System.out.println("got that");
		String actual1 = driver.findElement(By.cssSelector("#content > div > div:nth-child(4) > div > h5 ")).getText();
		Assert.assertEquals(actual, "name: user2");
		System.out.println("It matched user 2");
		
		action.moveToElement(element2).build().perform();
		System.out.println("got that");
       // driver.findElement(By.linkText("iPads")).click();
		String actual2 = driver.findElement(By.cssSelector(" #content > div > div:nth-child(5) > div > h5")).getText();
		Assert.assertEquals(actual, "name: user3");
		System.out.println("It matched user 3");

		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
}


}
