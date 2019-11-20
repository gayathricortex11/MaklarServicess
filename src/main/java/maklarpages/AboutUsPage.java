package maklarpages;

import static core.Action.click;
import static core.Action.sendKeys;
import static core.Action.verifyElementPresent;
import static core.Action.waitForElement;
import static org.junit.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.PrintStream;

//import static com.qa.hubspot.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import core.BasePage;

@Test
@Listeners({TestAllureListener.class})

public class AboutUsPage extends BasePage {
	
	private BasePage basePage;
	public void setUp(WebDriver driver) throws Exception {
		 basePage = new BasePage();
		 driver = core.BasePage.initialize_driver(getDriver());
		 basePage = new AboutUsPage();
		}
	
	@Test
	@Parameters("contacttest")
	@Step("ContactCreationCase")
	@JsonIgnoreProperties("Info")
	@Description("Test Case Description:- Give proper values in all fields and check on Contacts Page ")
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
	@Test
	@Step("ContactCreationCase1")
	@JsonIgnoreProperties("Info")
	@Description("Test Case Description:- without fill name and email fields and check the validation message on Contacts Page ")
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
	@JsonIgnoreProperties("Info")
	@Description("Test Case Description:- fill invalid email and check the validation message on Contacts Page ")
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


}
