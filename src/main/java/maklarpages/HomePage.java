package maklarpages;

import static core.Action.click;
import static core.Action.sendKeys;
import static core.Action.verifyElementPresent;
import static core.Action.waitForElement;
import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import core.BasePage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;

@Test
@Listeners({TestAllureListener.class})
public class HomePage extends BasePage {
	
	private BasePage basePage;
	public void setUp(WebDriver driver) throws Exception {
		 basePage = new BasePage();
		 driver = core.BasePage.initialize_driver(driver);
		 
		}
	
	@Test
	@Parameters("homepage")
	@Step("VerifyLinks")
	@JsonIgnoreProperties("Info")
	@Description("Verifying Text And Links On HomePAge")
	@Link("Text and Links on Homepage")
	@Attachment("Text and Links on HomePage")
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
