package testmaklarpages;

import static maklarpages.AssociationPage.paymentPage;
import static maklarpages.AssociationPage.paymentPage1;

import org.junit.Test;

import core.BaseTestCase;

public class TestAssociationPage extends BaseTestCase {
		public static String AdmbaseUrl="http://staging-maklarservice.cortexcraft.com/";
		@Test
		public static void testAssociationPage() throws Exception{
			driver.get(AdmbaseUrl);
			paymentPage(driver);	
		}
		@Test
		public static void testAssociationPage1() throws Exception{
			driver.get(AdmbaseUrl);
			paymentPage1(driver);
			
		}

}
