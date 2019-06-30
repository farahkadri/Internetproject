package utilties;
import java.io.File;
import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.apache.log4j.PropertyConfigurator;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
//import junit.framework.Assert;
import org.apache.log4j.xml.DOMConfigurator;

public class CommonLibrary {

	static DesiredCapabilities capability = null;
	//public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void openFireFoxBrowser(String URL, String platform){
		switch(platform) {
		case "windows":
			System.setProperty("webdriver.gecko.driver", browser+"win_firefoxdriver.exe");
			break;
		case "linux":
			System.setProperty("webdriver.gecko.driver", browser+"linux_firefoxdriver.exe");
			break;
		case "mac":
			System.setProperty("webdriver.gecko.driver", browser+"mac_firefoxdriver.exe");
			break;
		default:
			System.setProperty("webdriver.gecko.driver", browser+"win_firefoxdriver.exe");
		}
		capability = DesiredCapabilities.firefox();
		capability.setPlatform(org.openqa.selenium.Platform.ANY);
		driver = new FirefoxDriver(capability);
		maximzeBrowser();
		openWeb(URL);		
	} 

	@SuppressWarnings("deprecation")
	public static void openChromeBrowser(String URL, String platform){
		switch(platform) {
		case "windows":
			System.setProperty("webdriver.chrome.driver", browser+"win_chromedriver.exe");
			break;
		case "linux":
			System.setProperty("webdriver.chrome.driver", browser+"linux_chromedriver.exe");
			break;
		case "mac":
			System.setProperty("webdriver.chrome.driver", browser+"mac_chromedriver.exe");
			break;
		default:
			System.setProperty("webdriver.chrome.driver", browser+"win_chromedriver.exe");
		}
		capability = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		capability.setCapability(ChromeOptions.CAPABILITY, options);
		capability.setPlatform(org.openqa.selenium.Platform.ANY);
		driver = new ChromeDriver(capability);
		maximzeBrowser();
		openWeb(URL);		
	}

	@SuppressWarnings("deprecation")
	public static void openIEBrowser(String URL, String platform){
		switch(platform) {
		case "windows":
			System.setProperty("webdriver.ie.driver", browser+"win_iedriver.exe");
			break;
		case "linux":
			System.setProperty("webdriver.ie.driver", browser+"linux_iedriver.exe");
			break;
		case "mac":
			System.setProperty("webdriver.ie.driver", browser+"mac_iedriver.exe");
			break;
		default:
			System.setProperty("webdriver.ie.driver", browser+"win_iedriver.exe");
		}
		capability = DesiredCapabilities.internetExplorer();
		capability.setBrowserName("internet explorer");
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setPlatform(org.openqa.selenium.Platform.ANY);
		capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capability.setJavascriptEnabled(true);
		driver = new InternetExplorerDriver(capability);
		maximzeBrowser();
		openWeb(URL);		
	}

	public void setupBrowser(String browser, String platform) {
		DOMConfigurator.configure(domConfiguration);
		PropertyConfigurator.configure(log4jprop);
		switch(browser){		
		case "firefox":
			openFireFoxBrowser(weburl, platform);
			break;
		case "ie":
			openIEBrowser(weburl, platform);
			break;
		case "chrome":
			openChromeBrowser(weburl, platform);
			break;	
		}
		implicitWait(20);
	}

	//This method is used for verifying the title of any WebPage
	public static void openWeb(String URL){
		Constants.driver.get(URL);
	}

	public static void sleepApp(int time) throws Exception{
		Thread.sleep(time);
	}

	public static void verifyTitle(String title){
		String actualTitle = driver.getTitle();
		if(title.equals(actualTitle)){
			System.out.println("Correct Title is Displaying" );
		}
		else{
			System.out.println("Expected Title :" +title +" is NOT matching Actual Tile " +actualTitle);
		}
	}

	public static void verifyCurrentURL(String URL){
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(URL)){
			System.out.println("Correct URL is displaying" );
		}
		else{
			System.out.println("Expected URL is " +URL + "Not matching actual URL " +actualURL);
		}
	}

	public static void enterText(By locator, String text){
		findElementByAnyLocator(locator).sendKeys(text);
	}

	public static void clickAtAnyElement(By locator){
		findElementByAnyLocator(locator).click();
	}
	public static WebElement findElementByAnyLocator(By locator ){
		WebElement we = driver.findElement(locator);
		return we;
	}

	public static WebElement findElementById(String id){
		return driver.findElement(By.id(id));
	}

	public static WebElement findElementByxpath(String xpath){
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement findElementByCSS(String css){
		return driver.findElement(By.cssSelector(css));
	}

	/*public static WebElement findElement(By locator){
		return driver.findElement(locator);
	}
	 */

	public static void clickUsingID(String id){
		findElementById(id).click();
	}

	public static void clickUsingCSS(String css){
		findElementByCSS(css).click();
	}

	public static void clickUsingXpath(String xpath){
		findElementByxpath(xpath).click();
	}

	public static WebElement findElement (By locator){
		return driver.findElement(locator);
	}

	public static void typeText(By locator , String value){
		findElement(locator).sendKeys(value);
	}

	public static boolean verifyText(WebElement element , String expectedText){

		String actualText = element.getText();
		actualText=actualText.trim();
		if(actualText.equals(expectedText))
			return true;
		else
			return false;
	}

	public static void mouseHover(By locator){
		Actions obj = new Actions(driver);
		obj.moveToElement(findElement(locator)).build().perform();

	}

	public static void doubleClick(By locator){
		Actions obj = new Actions(driver);
		obj.doubleClick(findElementByAnyLocator(locator)).build().perform();
	}

	public static void dragAndDrop(By locator , int x , int y){
		Actions obj = new Actions(driver);
		obj.dragAndDropBy(findElementByAnyLocator(locator), x, y).perform();
	}


	public static void pressAnyKey(Keys keys){
		Actions a = new Actions(driver);
		a.keyDown(keys);
		a.keyUp(keys);
	}

	public static void moveToAnyElementAndClick(By locator){
		Actions a = new Actions(driver);
		a.moveToElement(findElementByAnyLocator(locator)).click(findElement(locator)).build().perform();
	}

	public static void moveToAnyElementByOffset(By locator , int x , int y){
		Actions a = new Actions(driver);
		a.moveToElement(findElementByAnyLocator(locator), x, y);
	}

	public static void implicitWait(int waitSeconds){
		driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
	}

	public static void explicitWaitForElement(WebElement element){
		int wait=5000;
		WebDriverWait ww = new WebDriverWait(driver, wait);
		ww.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void explicitWaitForAlert(){ 
		WebDriverWait w1 = new WebDriverWait(driver, 10);
		w1.until(ExpectedConditions.alertIsPresent());
	}

	public static void checkAnyCheckBox(By locator){
		if(findElementByAnyLocator(locator).isSelected()){
		}
		else{
			findElementByAnyLocator(locator).click();
		}
	}

	public static void unCheckAnyCheckBox(By locator){
		if(findElementByAnyLocator(locator).isSelected()){
			findElementByAnyLocator(locator).click();
		}
	}

	public static void selectValuesFromDropDownByIndex(By locator , int index){
		if(findElementByAnyLocator(locator).isSelected()){
			System.out.println("Value from Drop down is already selected" );
		}
		else{	
			Select dropdown = new Select(findElementByAnyLocator(locator));
			dropdown.selectByIndex(index);
		}
	}

	public static void selectValuesFromDropDownByValue(By locator , String index){
		if(findElementByAnyLocator(locator).isSelected()){
			System.out.println("Value from Drop down is already selected" );
		}
		else{	
			Select dropdown = new Select(findElementByAnyLocator(locator));
			dropdown.selectByValue(index);
		}
	}
	public static void selectValuesFromDropDownByVisibleText(By locator , String index){
		Select dropdown = new Select(findElementByAnyLocator(locator));
		dropdown.selectByVisibleText(index);
	}

	public static boolean verifyElementDisplayed(By locator){
		return findElementByAnyLocator(locator).isDisplayed();
	}

	public static boolean verifyElementEnabled(By locator){
		return findElementByAnyLocator(locator).isEnabled();
	}

	public static boolean verifyElementSelected(By locator) {
		return findElementByAnyLocator(locator).isSelected();
	}

	public static void navigate(String URL){
		driver.navigate().to(URL);
	}

	public static void navigateBack(){
		driver.navigate().back();
	}

	public static void navigateForward(){
		driver.navigate().forward();
	}

	public static void refreshBrowser(){
		driver.navigate().refresh();
	}

	public static void storePopUpText(){
		System.out.println(driver.switchTo().alert().getText());
	}

	public static void acceptPopUp(){
		driver.switchTo().alert().accept();
	}

	public static void dismissPopUp(){
		driver.switchTo().alert().dismiss();
	}

	public static void getCSSValue(By locator, String valueToBeFetched){
		String S1 = findElementByAnyLocator(locator).getCssValue(valueToBeFetched);
		System.out.println(valueToBeFetched +"is" +S1);
	}

	public static void killBrowser(){
		driver.quit();
	}

	public static void maximzeBrowser(){
		Constants.driver.manage().window().maximize();
	}

	public static boolean elementPresent(By locator){ 
		boolean isPresent = driver.findElements(locator).size()!=0;
		if(isPresent){
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void findAllLinks(){
		List<WebElement> we = driver.findElements(By.tagName("a"));
		System.out.println("There are " +we.size() + "Links in this page");

		for(int i=0; i<we.size();i++){
			System.out.println("Name of WebElement is " +we.get(i).getText());
			System.out.println("Type attribute of Element is "  +we.get(i).getAttribute("type"));
		}
	}

	public static void Exp(int timeout, By locator){
		WebDriverWait ww = new WebDriverWait(driver, timeout);
		ww.until(ExpectedConditions.alertIsPresent());
	}

	public static void moveSlider(By locator , int x , int y){
		Actions a = new Actions(driver);
		a.dragAndDropBy(findElementByAnyLocator(locator), x, y).build().perform();
	}

	public static void moveSliderBy(By locator , int x , int y){
		new Actions(driver).clickAndHold(findElementByAnyLocator(locator)).moveByOffset(x, y).release().perform();
	}

	public static void datePicker(By locator ,String date){
		String temp = getLocatorText(locator);
		((JavascriptExecutor) driver).executeScript("$('"+temp+"').val('"+date+"')");
	}
	
	public static void selectDate(WebElement element ,String date){
		element.clear();
		element.sendKeys(date);
	}

	public static String getLocatorText(By locator) {
		String result = "";
		if (locator.toString().toLowerCase().contains("by.selector"))
			result = locator.toString().substring(13);
		else if (locator.toString().toLowerCase().contains("by.cssselector"))
			result = locator.toString().substring(16);
		else if (locator.toString().toLowerCase().contains("by.id"))
			result = "#" + locator.toString().substring(7);
		return result;
	}

	public static void saveScreenshot(String screenshotpath) {
		try {
			File pngFile = new File(screenshotpath);
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, pngFile);
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectOptionWithText(WebElement autoCompleteId,WebElement autoCompleteSearchId,String textToSelect)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(autoCompleteId));
			autoCompleteId.click();
			wait.until(ExpectedConditions.visibilityOf(autoCompleteSearchId));

			List<WebElement> optionsToSelect = autoCompleteSearchId.findElements(By.tagName("md-option"));
			wait.until(ExpectedConditions.visibilityOfAllElements(optionsToSelect));
			for (WebElement option : optionsToSelect)
			{
				//System.out.println(option.getAttribute("value"));
				if (option.getAttribute("value").equals(textToSelect))
				{
					System.out.println("Trying to select text: " + textToSelect);
					option.click();
					break;
				}
			}
		}
		catch (final Exception e)
		{
			System.out.println("Can't work with auto complete");
		}
	}

	public static void cleanuptest(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			String screenshotpath=sysdir+screenShot+result.getName()+".png";
			saveScreenshot(screenshotpath);
			System.out.println("Error:"+ result.getThrowable());
			Log.error("Error in "+ result.getThrowable());

			//Create report file for adding status, error details, screenshot and Log file link.
			logger.log(LogStatus.FAIL, "Test Case failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Error: "+result.getThrowable());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotpath));
			System.out.println(System.getProperty("user.dir")+"\\logfile.log");
			logger.log(LogStatus.FAIL,"Log File : <a href="+sysdir+"logfile.log>Log_File</a>");
		} else {
			Log.endTestCase(result.getName());
			logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		}
		//driver.quit();
		extent.endTest(logger);
	}
}