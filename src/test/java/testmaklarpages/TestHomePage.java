package testmaklarpages;

import static maklarpages.HomePage.verifyTextAndLinkOnHomePage;
//import static maklarpages.HomePage;
//import static maklarpages.HomePage;
import org.junit.Test;

import core.BaseTestCase;

public class TestHomePage extends BaseTestCase {
	public static String AdmbaseUrl="http://staging-maklarservice.cortexcraft.com/";
	@Test
	public static void testHomePage() throws Exception{
		driver.get(AdmbaseUrl);
		verifyTextAndLinkOnHomePage(driver);
		
	}

}
