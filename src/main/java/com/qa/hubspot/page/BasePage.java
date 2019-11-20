package com.qa.hubspot.page;

import static core.GlobalConstants.CHROMEpATH;
import static core.GlobalConstants.baseUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public interface BasePage{
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static WebDriver initialize_driver(WebDriver driver) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		Thread.sleep(1000);
		//driver =  new ChromeDriver();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		System.out.println(baseUrl);
		driver.get(baseUrl);
		tdriver.set(driver);
		return getDriver();
		
	}
	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return tdriver.get();
	}
	
	
	
		
}

