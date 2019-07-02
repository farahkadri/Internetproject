package com.internethero.internetheropjct;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.http.HttpResponse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class imagebroken {
	
	private WebDriver driver;
	private int invalidImageCount;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
	}

	@Test
	public void validateInvalidImages() {
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);

			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


	
	//public static void main(String[] args)
	//{

//	System.setProperty("webdriver.chrome.driver","E:\\Drivers\\win_chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
//	System.out.println("i m in chrome");
//	driver.get("https://the-internet.herokuapp.com/broken_images");
//	List<WebElement> linkslist = driver.findElements(By.tagName("img"));
//	System.out.println("Total Images are "+linkslist.size());

//	linkslist.addAll(driver.findElements(By.tagName("img")));
	
//	List<WebElement> activelinks = new ArrayList<WebElement>();
	
//	for (int i= 0;i<linkslist.size();i++)
//	{
//		if(linkslist.get(i).getAttribute("href")!= "null")
//		{
	//		activelinks.add(linkslist.get(i));
//		}
//	}
//	System.out.println(activelinks.size());
	//}
//}
