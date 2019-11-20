package maklarpages;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.qameta.allure.Step;

import static core.Action.click;
import static core.Action.sendKeys;
import static core.Action.verifyElementPresent;
import static core.Action.waitForElement;
import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

//import static core.GlobalConstants.CHROMEpATH;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase1 {
	@Test
	 
	// Here this parameters we will take from testng.xml
	@Parameters("Browser")
	public  void test1(String browser) throws Exception {
	 
	if(browser.equalsIgnoreCase("FF")){
	
	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	 
	WebDriver driver=new FirefoxDriver();
	 
	driver.manage().window().maximize();
	 
	driver.get("http://staging-maklarservice.cortexcraft.com/");
	
	contactCreationPage(driver);
	contactCreationPage1(driver);
	contactCreationPage2(driver);
	verifyTextAndLinkOnHomePage(driver);
	driver.quit();
	 
	}
	else if(browser.equalsIgnoreCase("IE")){
	 
	System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
	 
	WebDriver driver=new InternetExplorerDriver();
	 
	driver.manage().window().maximize();
	 
	driver.get("http://staging-maklarservice.cortexcraft.com/");
	contactCreationPage(driver);
	contactCreationPage1(driver);
	contactCreationPage2(driver);
	verifyTextAndLinkOnHomePage(driver);
	
	driver.quit();
	}
	else if(browser.equalsIgnoreCase("chrome")){
		 
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 
		WebDriver driver=new ChromeDriver();
		 
		driver.manage().window().maximize();
		 
		driver.get("http://staging-maklarservice.cortexcraft.com/");
		contactCreationPage(driver);
		contactCreationPage1(driver);
		contactCreationPage2(driver);
		verifyTextAndLinkOnHomePage(driver);
		driver.quit();
		}
	}

	
	public static void contactCreationPage1(WebDriver driver)throws Exception
	{
		Thread.sleep(1000);	//*[@id="header-bg"]/div/a[1]
		
		waitForElement(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		assertTrue("Presence of menu icon",verifyElementPresent(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg")));
		
		Thread.sleep(2000);
		waitForElement(driver, By.linkText("Om oss"));
		assertTrue("Presence of About Us link",verifyElementPresent(driver, By.linkText("Om oss")));
		click(driver,By.linkText("Om oss"));
		
		
		/*Thread.sleep(1000);
		waitForElement(driver, By.xpath("//*[@id='name']"));
		sendKeys(driver, By.xpath("//*[@id='name']"),"Test");
		
		Thread.sleep(1000);
		waitForElement(driver, By.xpath("//*[@id='email']"));
		sendKeys(driver,By.xpath("//*[@id='email']"),"test@test.com");*/
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='phone']"));
		sendKeys(driver, By.xpath("//*[@id='phone']"),"23874849394");
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='message']"));
		sendKeys(driver,By.xpath("//*[@id='message']"),"test");
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='contact-form']/div/div[3]/div/input"));
		click(driver, By.xpath("//*[@id='contact-form']/div/div[3]/div/input"));
		
		waitForElement(driver, By.xpath("//*[@id='name-error']"));
		assertTrue("Måste anges.",verifyElementPresent(driver, By.xpath("//*[@id='name-error']")));
		
		waitForElement(driver, By.xpath("//*[@id='email-error']"));
		assertTrue("Måste anges.",verifyElementPresent(driver, By.xpath("//*[@id='email-error']")));
		
		
	}
	@Test
	@Step("ContactCreationCase2")
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static void contactCreationPage2(WebDriver driver)throws Exception
	{
		Thread.sleep(1000);	//*[@id="header-bg"]/div/a[1]
		
		waitForElement(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		assertTrue("Presence of menu icon",verifyElementPresent(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg")));
		
		Thread.sleep(2000);
		waitForElement(driver, By.linkText("Om oss"));
		assertTrue("Presence of About Us link",verifyElementPresent(driver, By.linkText("Om oss")));
		click(driver,By.linkText("Om oss"));
		
		
		Thread.sleep(1000);
		waitForElement(driver, By.xpath("//*[@id='name']"));
		sendKeys(driver, By.xpath("//*[@id='name']"),"Test");
		
		Thread.sleep(1000);
		waitForElement(driver, By.xpath("//*[@id='email']"));
		sendKeys(driver,By.xpath("//*[@id='email']"),"test");
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='phone']"));
		sendKeys(driver, By.xpath("//*[@id='phone']"),"23874849394");
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='message']"));
		sendKeys(driver,By.xpath("//*[@id='message']"),"test");
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='contact-form']/div/div[3]/div/input"));
		click(driver, By.xpath("//*[@id='contact-form']/div/div[3]/div/input"));
		
		waitForElement(driver, By.xpath("//*[@id='email-error']"));
		assertTrue("Fyll i en giltig e-postadress.",verifyElementPresent(driver, By.xpath("//*[@id='email-error']")));	
		
	}

	public static void contactCreationPage(WebDriver driver)throws Exception
	{
		Thread.sleep(1000);	//*[@id="header-bg"]/div/a[1]
		
		waitForElement(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		assertTrue("Presence of menu icon",verifyElementPresent(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg")));
		
		Thread.sleep(2000);
		waitForElement(driver, By.linkText("Om oss"));
		assertTrue("Presence of About Us link",verifyElementPresent(driver, By.linkText("Om oss")));
		click(driver,By.linkText("Om oss"));
		
		
		Thread.sleep(1000);
		waitForElement(driver, By.xpath("//*[@id='name']"));
		sendKeys(driver, By.xpath("//*[@id='name']"),"Test");
		
		Thread.sleep(1000);
		waitForElement(driver, By.xpath("//*[@id='email']"));
		sendKeys(driver,By.xpath("//*[@id='email']"),"test@test.com");
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='phone']"));
		sendKeys(driver, By.xpath("//*[@id='phone']"),"23874849394");
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='message']"));
		sendKeys(driver,By.xpath("//*[@id='message']"),"test");
		
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("//*[@id='contact-form']/div/div[3]/div/input"));
		click(driver, By.xpath("//*[@id='contact-form']/div/div[3]/div/input"));
		
		
	}
	public static void verifyTextAndLinkOnHomePage(WebDriver driver)throws Exception
	{
		Thread.sleep(1000);	//*[@id="header-bg"]/div/a[1]
		waitForElement(driver, By.cssSelector("#header-bg > a"));
		assertTrue("Presence of MaklarService Heading",verifyElementPresent(driver, By.cssSelector("#header-bg > a")));
		waitForElement(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		assertTrue("Presence of menu icon",verifyElementPresent(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg")));
		waitForElement(driver, By.linkText("Priser"));
		assertTrue("Presence of prices link",verifyElementPresent(driver, By.linkText("Priser")));
		click(driver, By.linkText("Priser"));
		Thread.sleep(2000);
		waitForElement(driver, By.linkText("Om oss"));
		assertTrue("Presence of About Us link",verifyElementPresent(driver, By.linkText("Om oss")));
		click(driver,By.linkText("Om oss"));
		Thread.sleep(1000);
		waitForElement(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		click(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		Thread.sleep(1000);
		waitForElement(driver, By.linkText("Integritetspolicy"));
		assertTrue("Presence of Integritetspolicy link",verifyElementPresent(driver, By.linkText("Integritetspolicy")));
		click(driver,By.linkText("Integritetspolicy"));
		Thread.sleep(2000);
		waitForElement(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		click(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("/html/body/div[4]/ul/li[2]"));
		assertTrue("Presence of Priser link",verifyElementPresent(driver, By.xpath("/html/body/div[4]/ul/li[2]")));
		click(driver,By.xpath("/html/body/div[4]/ul/li[2]"));
		Thread.sleep(2000);
		waitForElement(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		click(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		Thread.sleep(1000);
		waitForElement(driver, By.xpath("/html/body/div[4]/ul/li[3]"));
		assertTrue("Presence of Hem link",verifyElementPresent(driver, By.xpath("/html/body/div[4]/ul/li[3]")));
		click(driver,By.xpath("/html/body/div[4]/ul/li[3]"));
		Thread.sleep(1000);
		waitForElement(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		click(driver, By.cssSelector("body > div.mobilemenu > div > div.toggle.svg"));
		Thread.sleep(2000);
		waitForElement(driver, By.xpath("/html/body/div[4]/ul/li[4]"));
		assertTrue("Presence of Om oss link",verifyElementPresent(driver, By.xpath("/html/body/div[4]/ul/li[4]")));
		click(driver,By.xpath("/html/body/div[4]/ul/li[4]"));
		
	}

	}