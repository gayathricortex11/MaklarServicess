package maklarpages;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import core.BasePage;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;


public class TestAllureListener implements ITestListener  {
	
	private static String getTestMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment (value="page screenshot" , type="image/png")
	public byte[] saveScreenshotPNG(WebDriver driver)
	{
		byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Allure.getLifecycle().addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", screenShot);
		return screenShot;
		
		
	}
	@Attachment (value="{0}" , type="text/plain")
	public static String saveTextLog(String message)
	{
		return message;
	}
	
	@Attachment (value="{0}" , type="text/html")
	public static String attachHtml(String html)
	{
		return html;
	}
	@Override
	public void onStart(ITestContext iTestContext)
	{
		System.out.println("Iam in OnStart Method"+iTestContext.getName());
		iTestContext.setAttribute("WebDriver", BasePage.getDriver());
	}
	@Override
	public void onFinish(ITestContext iTestContext)
	{
		System.out.println("Iam in OnFinish Method"+iTestContext.getName());
		
	}
	@Override
	public void onTestStart(ITestResult iTestResult)
	{
		System.out.println("Iam in On TestStart Method"+getTestMethodName(iTestResult)+"start");
		
	}
	
	@Override
	@Test
	public void onTestSuccess(ITestResult iTestResult)
	{
		
		System.out.println("Test Success Method"+ getTestMethodName(iTestResult)+"Succeed");
		Object testClass= iTestResult.getInstance();
		//WebDriver driver= BasePage.getDriver();
		
		ITestContext context = iTestResult.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");

		
		System.out.print(testClass);
		if(driver instanceof WebDriver)
		{
			System.out.println("Screenshot captured for TestCase"+getTestMethodName(iTestResult) );
			saveScreenshotPNG(driver);
		}
		saveTextLog(getTestMethodName(iTestResult)+"failed and screenshot taken!");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test Success Method"+ getTestMethodName(iTestResult)+"Failed");
		Object testClass= iTestResult.getInstance();
		WebDriver driver= BasePage.getDriver();
		System.out.print(testClass);
		if(driver instanceof WebDriver)
		{
			System.out.println("Screenshot captured for TestCase"+getTestMethodName(iTestResult) );
			saveScreenshotPNG(driver);
		}
		saveTextLog(getTestMethodName(iTestResult)+"failed and screenshot taken!");
		
	}

	
	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
