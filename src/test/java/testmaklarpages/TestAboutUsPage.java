package testmaklarpages;

import static maklarpages.AboutUsPage.contactCreationPage;
import static maklarpages.AboutUsPage.contactCreationPage1;
import static maklarpages.AboutUsPage.contactCreationPage2;


import org.junit.Test;

import core.BaseTestCase;

public class TestAboutUsPage extends BaseTestCase {
	public static String AdmbaseUrl="http://staging-maklarservice.cortexcraft.com/";
	@Test
	public static void testContactCreationPage() throws Exception{
		driver.get(AdmbaseUrl);
		contactCreationPage(driver);	
	}
	@Test
	public static void testContactCreationPage1() throws Exception{
		driver.get(AdmbaseUrl);
		contactCreationPage1(driver);	
	}
	@Test
	public static void testContactCreationPage2() throws Exception{
		driver.get(AdmbaseUrl);
		contactCreationPage2(driver);
		
	}

}
