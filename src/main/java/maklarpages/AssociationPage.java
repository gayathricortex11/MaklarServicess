package maklarpages;

import static core.Action.click;
import static core.Action.doubleclick;
import static core.Action.sendKeys;
import static core.Action.verifyElementPresent;
import static core.Action.waitForElement;
import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import groovyjarjarantlr.collections.List;

public class AssociationPage {
	public static void paymentPage(WebDriver driver)throws Exception
	{
		Thread.sleep(1000);
		waitForElement(driver,By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"));
		WebElement analyst = driver.findElement(By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(analyst).moveToElement(driver.findElement(By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"))).click().build().perform();
		Robot robot1=new Robot();
		robot1.keyPress(KeyEvent.VK_B);
		robot1.keyPress(KeyEvent.VK_O);
		robot1.keyPress(KeyEvent.VK_F);
		robot1.keyPress(KeyEvent.VK_L);
		robot1.keyPress(KeyEvent.VK_I);
		robot1.keyPress(KeyEvent.VK_N);
		robot1.keyPress(KeyEvent.VK_K);
		robot1.delay(3000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.delay(1500);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.delay(1500);
		robot1.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		waitForElement(driver,By.xpath("//*[@id='step-1']/div/div[1]/div[1]/input"));
		sendKeys(driver,By.xpath("//*[@id='step-1']/div/div[1]/div[1]/input"),"198002043233");
		
		Thread.sleep(3000);
		waitForElement(driver,By.xpath("//*[@id='search-button']"));
		click(driver,By.xpath("//*[@id='search-button']"));		
		
		waitForElement(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[1]/label/small"));
		assertTrue("Presence of Ägare/säljare + objekt Text",verifyElementPresent(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[1]/label/small")));
		
		waitForElement(driver, By.xpath("//*[@id='fullname-text']"));
		assertTrue("Presence of David Oskar Petter Walman text",verifyElementPresent(driver, By.xpath("//*[@id='fullname-text']")));
		
		waitForElement(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[2]/label/small"));
		assertTrue("Presence of Personnummer/org.nr",verifyElementPresent(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[2]/label/small")));
		
		waitForElement(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[3]/label"));
		assertTrue("Presence of Objekt",verifyElementPresent(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[3]/label")));
		
		waitForElement(driver, By.xpath("//*[@id='address-text']"));
		assertTrue("Presence of Address",verifyElementPresent(driver, By.xpath("//*[@id='address-text']")));
		
		Thread.sleep(3000);
		waitForElement(driver,By.xpath("//div[@class='selected-brf']//button[@id='search-button']"));
		click(driver,By.xpath("//div[@class='selected-brf']//button[@id='search-button']"));
		
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-2']/div/div[3]/div/div/div[1]/div/div[1]"));
		click(driver,By.xpath("//*[@id='step-2']/div/div[3]/div/div/div[1]/div/div[1]"));
		
		waitForElement(driver,By.xpath("//*[@id='step-2']/div/div[3]/div/div/button"));
		click(driver,By.xpath("//*[@id='step-2']/div/div[3]/div/div/button"));
		

		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-3']/div/div/div/div[1]/button"));
		click(driver,By.xpath("//*[@id='step-3']/div/div/div/div[1]/button"));
		Thread.sleep(2000);
		uploadFile("C:\\Users\\CCIL-SUREKHA\\agreement");
		Thread.sleep(2000);
		waitForElement(driver,By.xpath("//*[@id='step-3']/div/button"));
		click(driver,By.xpath("//*[@id='step-3']/div/button"));
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[1]/div/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[1]/div/div/div/input"),"test@test.com");
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='payment-form']"));
		click(driver,By.xpath("//*[@id='payment-form']"));
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='broker_mobile_number']"));
		sendKeys(driver,By.xpath("//*[@id='broker_mobile_number']"),"238-434 94 99");
		
	    Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[3]/div[1]/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[3]/div[1]/div/div/input"),"Test");
		
		Thread.sleep(1000);
		waitForElement(driver,By.cssSelector("#step-4 > div.col-xs-12.col-md-12 > div:nth-child(4) > div:nth-child(2) > div > div > input"));
		sendKeys(driver,By.cssSelector("#step-4 > div.col-xs-12.col-md-12 > div:nth-child(4) > div:nth-child(2) > div > div > input"),"Test");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[1]/div/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[1]/div/div/div/input"),"4111 1111 1111 1111");
		
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[2]/div[1]/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[2]/div[1]/div/div/input"),"02 / 20");
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[2]/div[2]/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[2]/div[2]/div/div/input"),"8494");
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[3]/div/div/label/input"));
		click(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[3]/div/div/label/input"));
		
	}
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
	private static void setClipboardData(String string) {
		
		// TODO Auto-generated method stub
		StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
	}
	public static void paymentPage1(WebDriver driver)throws Exception
	{
		Thread.sleep(1000);
		waitForElement(driver,By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"));
		WebElement analyst = driver.findElement(By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(analyst).moveToElement(driver.findElement(By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"))).click().build().perform();
		Robot robot1=new Robot();
		robot1.keyPress(KeyEvent.VK_B);
		robot1.keyPress(KeyEvent.VK_O);
		robot1.keyPress(KeyEvent.VK_F);
		robot1.keyPress(KeyEvent.VK_L);
		robot1.keyPress(KeyEvent.VK_I);
		robot1.keyPress(KeyEvent.VK_N);
		robot1.keyPress(KeyEvent.VK_K);
		robot1.delay(3000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.delay(1500);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.delay(1500);
		robot1.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		waitForElement(driver,By.xpath("//*[@id='step-1']/div/div[1]/div[1]/input"));
		sendKeys(driver,By.xpath("//*[@id='step-1']/div/div[1]/div[1]/input"),"8002043233");
		
		Thread.sleep(3000);
		waitForElement(driver,By.xpath("//*[@id='search-button']"));
		click(driver,By.xpath("//*[@id='search-button']"));	
		
		
		waitForElement(driver, By.xpath("//*[@id='personnummer-error']"));
		assertTrue("Tyvärr, vi kan ej hitta någon ägare med detta personnummer",verifyElementPresent(driver, By.xpath("//*[@id='personnummer-error']")));
		
		
	}
	
	public static void billingPage(WebDriver driver)throws Exception
	{
		Thread.sleep(1000);
		waitForElement(driver,By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"));
		WebElement analyst = driver.findElement(By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(analyst).moveToElement(driver.findElement(By.cssSelector("#blocks > div:nth-child(1) > div > div > div > div > form > input"))).click().build().perform();
		Robot robot1=new Robot();
		robot1.keyPress(KeyEvent.VK_B);
		robot1.keyPress(KeyEvent.VK_O);
		robot1.keyPress(KeyEvent.VK_F);
		robot1.keyPress(KeyEvent.VK_L);
		robot1.keyPress(KeyEvent.VK_I);
		robot1.keyPress(KeyEvent.VK_N);
		robot1.keyPress(KeyEvent.VK_K);
		robot1.delay(3000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.delay(1500);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.delay(1500);
		robot1.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		waitForElement(driver,By.xpath("//*[@id='step-1']/div/div[1]/div[1]/input"));
		sendKeys(driver,By.xpath("//*[@id='step-1']/div/div[1]/div[1]/input"),"198002043233");
		
		Thread.sleep(3000);
		waitForElement(driver,By.xpath("//*[@id='search-button']"));
		click(driver,By.xpath("//*[@id='search-button']"));		
		
		waitForElement(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[1]/label/small"));
		assertTrue("Presence of Ägare/säljare + objekt Text",verifyElementPresent(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[1]/label/small")));
		
		waitForElement(driver, By.xpath("//*[@id='fullname-text']"));
		assertTrue("Presence of David Oskar Petter Walman text",verifyElementPresent(driver, By.xpath("//*[@id='fullname-text']")));
		
		waitForElement(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[2]/label/small"));
		assertTrue("Presence of Personnummer/org.nr",verifyElementPresent(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[2]/label/small")));
		
		waitForElement(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[3]/label"));
		assertTrue("Presence of Objekt",verifyElementPresent(driver, By.xpath("//*[@id='step-1']/div/div[2]/div/div[3]/label")));
		
		waitForElement(driver, By.xpath("//*[@id='address-text']"));
		assertTrue("Presence of Address",verifyElementPresent(driver, By.xpath("//*[@id='address-text']")));
		
		Thread.sleep(3000);
		waitForElement(driver,By.xpath("//div[@class='selected-brf']//button[@id='search-button']"));
		click(driver,By.xpath("//div[@class='selected-brf']//button[@id='search-button']"));
		
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-2']/div/div[3]/div/div/div[1]/div/div[1]"));
		click(driver,By.xpath("//*[@id='step-2']/div/div[3]/div/div/div[1]/div/div[1]"));
		
		waitForElement(driver,By.xpath("//*[@id='step-2']/div/div[3]/div/div/button"));
		click(driver,By.xpath("//*[@id='step-2']/div/div[3]/div/div/button"));
		

		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-3']/div/div/div/div[1]/button"));
		click(driver,By.xpath("//*[@id='step-3']/div/div/div/div[1]/button"));
		Thread.sleep(2000);
		uploadFile("C:\\Users\\CCIL-SUREKHA\\agreement");
		Thread.sleep(2000);
		waitForElement(driver,By.xpath("//*[@id='step-3']/div/button"));
		click(driver,By.xpath("//*[@id='step-3']/div/button"));
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[1]/div/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[1]/div/div/div/input"),"test@test.com");
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='payment-form']"));
		click(driver,By.xpath("//*[@id='payment-form']"));
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='broker_mobile_number']"));
		sendKeys(driver,By.xpath("//*[@id='broker_mobile_number']"),"238-434 94 99");
		
	    Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[3]/div[1]/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[3]/div[1]/div/div/input"),"Test");
		
		Thread.sleep(1000);
		waitForElement(driver,By.cssSelector("#step-4 > div.col-xs-12.col-md-12 > div:nth-child(4) > div:nth-child(2) > div > div > input"));
		sendKeys(driver,By.cssSelector("#step-4 > div.col-xs-12.col-md-12 > div:nth-child(4) > div:nth-child(2) > div > div > input"),"Test");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[1]/div/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[1]/div/div/div/input"),"4111 1111 1111 1111");
		
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[2]/div[1]/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[2]/div[1]/div/div/input"),"02 / 20");
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[2]/div[2]/div/div/input"));
		sendKeys(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[2]/div[2]/div/div/input"),"8494");
		
		Thread.sleep(1000);
		waitForElement(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[3]/div/div/label/input"));
		click(driver,By.xpath("//*[@id='step-4']/div[4]/div[4]/div[3]/div/div/label/input"));
		
	}
		
	
	}

