package testmaklarpages;

import static maklarpages.HomePage.verifyTextAndLinkOnHomePage;

import org.testng.annotations.Listeners;
//import static maklarpages.HomePage;
//import static maklarpages.HomePage;
//import org.junit.Test;
import org.testng.annotations.Test;

import core.BaseTestCase;
import maklarpages.TestAllureListener;
@Test
@Listeners({TestAllureListener.class})
public class TestHomePage extends BaseTestCase {
	public static String AdmbaseUrl="http://staging-maklarservice.cortexcraft.com/";
	@Test
	public static void testHomePage() throws Exception{
		driver.get(AdmbaseUrl);
		verifyTextAndLinkOnHomePage(driver);
		
	}

}
