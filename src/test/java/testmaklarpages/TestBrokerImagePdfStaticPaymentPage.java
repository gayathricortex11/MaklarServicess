package testmaklarpages;

import static maklarpages.BrokerImagePdfStaticPaymentPage.checkFileUploadAndPaymentProcess;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.BaseTestCase;
import maklarpages.TestAllureListener;


@Test(priority=1)
@Listeners({TestAllureListener.class})
	public class TestBrokerImagePdfStaticPaymentPage extends BaseTestCase {
		public static String AdmbaseUrl="http://staging-maklarservice.cortexcraft.com/";
		@Test
		public static void testPaymentPage() throws Exception{
			driver.get(AdmbaseUrl);
			checkFileUploadAndPaymentProcess(driver);
			
		}
		
	}



