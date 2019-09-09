package core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.commons.io.FileUtils;
import static core.GlobalConstants.*;
import junit.framework.TestCase;

public class BaseTestCase extends TestCase{
	 public static WebDriver driver;
	 public static final String dbUrl = "jdbc:mysql://localhost:3306/testautomation";	
	 public static final String dbUser = "root";
	 public static final String dbPassword = "Root@123";
	 public static String jdbcDriver = "com.mysql.jdbc .Driver";
	 public static Connection connection = null;
	 
    @Rule public TestName testName = new TestName();
    
	@Before
	public void setUp() throws Exception {
		String FolderName = System.getProperty("id");
		System.out.println(FolderName);
		System.out.println("in setup method"+FolderName);
		String location = "C://Screenshots//"+FolderName+"//";
		if(FolderName != null){
	    PrintStream out=new PrintStream(new FileOutputStream(location+this.getName()+".txt", true), false,"UTF-8");
		System.setOut(out);
		}
		if(BROWSER.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            System.out.println(baseUrl);
            driver.get(baseUrl);
            maximize();
        }else if(BROWSER.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", CHROMEpATH);
			Thread.sleep(1000);
			//driver =  new ChromeDriver();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);
			System.out.println(baseUrl);
			driver.get(baseUrl);
			/*ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);*/
			//driver.manage().window().maximize();
			//maximize();
        }else if(BROWSER.equalsIgnoreCase("safari")){
        	System.setProperty("webdriver.safari.driver", "C:\\selenium-safari-driver-2.29.1.jar");
        	System.setProperty("webdriver.safari.noinstall", "true");
        	driver =  new SafariDriver();
        	Thread.sleep(2000);
        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        	System.out.println(baseUrl);
			driver.get(baseUrl);
			//driver.manage().window().maximize();
			maximize();
        }else if(BROWSER.equalsIgnoreCase("internetExplorer")){
        	System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
        	driver =  new InternetExplorerDriver(); 
			System.out.println(baseUrl);
			driver.get(baseUrl);
			//driver.manage().window().maximize();
			maximize();
        }
	}	
	
	public static Connection getConnectionForDb() throws Exception{
		Connection conn = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		} catch (Exception e) {
			System.out.println(e);
			conn.close();
		}
		return conn;
	}
	
	public static void maximize(){
		/* Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		 Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(), (int) 
		 toolkit.getScreenSize().getHeight()); 
		 driver.manage().window().setSize(screenResolution); */
		 Dimension windowMinSize = new Dimension(1000,1200);
		 driver.manage().window().setSize(windowMinSize);
	 }
	 public void minimize()throws Exception{
		 Dimension windowMinSize = new Dimension(500,700);
		 driver.manage().window().setSize(windowMinSize);
	 }
	 public static String uniqueStringwithDateandTime(){
			Date now = new Date();  
			DateFormat df = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
			String s = df.format(now); 
			return s; 	
		}
	 @Override
	@After
	 public void tearDown() throws Exception {
		 try {
			  String FolderName = System.getProperty("id");
			  System.out.println(FolderName);
		      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		      desiredCapabilities.setJavascriptEnabled(true);
		      desiredCapabilities.setCapability("takesScreenshot", true);
		      File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		      System.out.println("File:" + srcFile);
		      String methodName = this.getName();
		      String date= uniqueStringwithDateandTime();
		      System.out.println(methodName);
		      String methodNameWithDate=methodName+date;
		      if(FolderName!=null){
		    	  String location="C:\\Screenshots"+"\\Images\\"+""+FolderName+"\\";
		    	  FileUtils.copyFile(srcFile, new File(location+methodName+ ".png"));
		      }else{
		    	  FileUtils.copyFile(srcFile, new File( System.getProperty("user.dir")+"\\Screenshots\\"+ methodNameWithDate + ".png"));
		      }
		      System.out.println("entered tear down..");   
		     } catch (Exception e ) {
		      System.out.println("Issue in tear down function .." + e);
		      e.printStackTrace();
		     }
		  driver.quit();
		  
		  System.out.println("END : " + this.getClass().getSimpleName());
		  System.out.println("End : "+ this.getName());
		  System.out.println("---------------ENDED BROWSER----------------------"); 
		  driver.quit();
	 }
	 
}
