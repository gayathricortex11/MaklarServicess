package maklarpages;

import static core.Action.click;
import static core.Action.sendKeys;
import static core.Action.verifyElementPresent;
import static core.Action.waitForElement;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUsPage {
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
