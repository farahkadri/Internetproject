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



public class slider {
@Test
	public static void main(String[] args)
	{
    System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		WebElement Slide = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/input"));
		Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(Slide, 55, 0).build();
        action.perform();
	    String verifiedrange= driver.findElement(By.xpath("//*[@id=\"range\"]")).getText();
	    Assert.assertEquals(verifiedrange, "5");
	    System.out.println("The max range is 5");
	    Action action1 = move.dragAndDropBy(Slide, -55, 0).build();
	    action1.perform();
	    String verifiedrange1= driver.findElement(By.xpath("//*[@id=\"range\"]")).getText();
	    Assert.assertEquals(verifiedrange1, "0");
	    System.out.println("The min range is 0");
	
		
	}

	
}



