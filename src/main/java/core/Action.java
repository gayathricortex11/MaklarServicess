package core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.rules.TestName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.junit.JUnitTestClass;


public class Action {
		public static TestName testName = new TestName();
		public static WebDriverWait webDriverWait;
		public static String getTextNow(WebDriver driver, By by){
			WebElement element = getWebElement(driver, by);
		    return (String) ((JavascriptExecutor) driver).executeScript(
		        "return jQuery(arguments[0]).text();", element);
		}
		/** Author: 
		 * Description: Waits for the element to be loaded
		 */
		  public  static void waitFor(WebDriver driver,By by){	
			  StackTraceElement caller = new Throwable().getStackTrace()[1];
			  String callerInfo = caller.getClassName()
			            + " " + caller.getMethodName()   
			            + " line " + caller.getLineNumber()  ;
			  log(callerInfo,"Waiting for Element with id "+ by.toString());
			  webDriverWait = new WebDriverWait(driver, 90);
		      webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
		   }
		  
		  /**
		   * Author: 
		   */
		  public static void waitForElement(WebDriver driver, By by){
			  StackTraceElement caller = new Throwable().getStackTrace()[1];
			  String callerInfo = caller.getClassName()
			            + " " + caller.getMethodName()   
			            + " line " + caller.getLineNumber()  ;
			  log(callerInfo,"Waiting for Element with id "+ by.toString());
			 for(int i=0; i<= 20; i++){
			 if(!verifyElementPresent(driver, by)){
				 waitTill(2000);
			 }
				 else{
					 break;
				 }
			  
			  }
		  }
		  public static boolean verifyElementIsEnabled(WebDriver driver,By by) {
				StackTraceElement caller = new Throwable().getStackTrace()[1];
				  String callerInfo = caller.getClassName()
				            + " " + caller.getMethodName()   
				            + " line " + caller.getLineNumber()  ;
				 log(callerInfo,"verify element is enabled "+by.toString());
				return driver.findElement(by).isEnabled();
			}
		  public static void doubleclick(WebDriver driver, By by) {
				StackTraceElement caller = new Throwable().getStackTrace()[1];
				  String callerInfo = caller.getClassName()
				            + " " + caller.getMethodName()   
				            + " line " + caller.getLineNumber()  ;
				 log(callerInfo,"Double click on "+by.toString());
				//For FF browser.
				((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');"
						+ "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
						+ "arguments[0].dispatchEvent(evt);",getWebElement(driver,by));
			}
		  /** 
			 * @Author: 
			 *   mouseOverJavascript is used to move mouse over using javascript(without native elements).
			 */
			public static void mouseOverJavascript(WebDriver driver, By by) {
				WebElement element = getWebElement(driver,by);
				String code = "var fireOnThis = arguments[0];"
						+ "var evObj = document.createEvent('MouseEvents');"
						+ "evObj.initEvent( 'mouseover', true, true );"
						+ "fireOnThis.dispatchEvent(evObj);";
				((JavascriptExecutor) driver).executeScript(code, element);
			}
		  public static void scrollToElement(WebDriver driver,By by) throws Exception{
			  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
			  log(callerInfo,"scrolling to the element with id "+by.toString());
			  WebElement elm = driver.findElement(by);
		      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);
			  /*Actions dragger = new Actions(driver);
			  WebElement draggablePartOfScrollbar = driver.findElement(by);
			  int numberOfPixelsToDragTheScrollbarDown = 5000;
			  dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();*/
			}
		  /** Author:
			 * Description: Waits for the element to be visible
			 */
		    public static void waitForVisible(WebDriver driver,By by){
		    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
		    	  String callerInfo = caller.getClassName()
		  	            + " " + caller.getMethodName()   
		  	            + " line " + caller.getLineNumber() ;
		    	log(callerInfo,"Waiting for element to be visible with id"+by.toString());
		    	webDriverWait = new WebDriverWait(driver, 90);
		        WebElement elm = driver.findElement(by);
		        webDriverWait.until(ExpectedConditions.visibilityOf(elm));
		    }
		    public static WebElement getWebElement(WebDriver driver,By by){
		    	StackTraceElement caller = new Throwable().getStackTrace()[1];
		    	  String callerInfo = caller.getClassName()
		  	            + " " + caller.getMethodName()   
		  	            + " line " + caller.getLineNumber()  ;
		    	 log(callerInfo,"Reading Element "+by.toString());
		    	 WebElement ele =  driver.findElement(by);
		    	 return ele;
		    }
		    public static List<WebElement> getWebElements(WebDriver driver,By by){
		    	StackTraceElement caller = new Throwable().getStackTrace()[1];
		    	  String callerInfo = caller.getClassName()
		  	            + " " + caller.getMethodName()   
		  	            + " line " + caller.getLineNumber()  ;
		    	 log(callerInfo,"Reading Element "+by.toString());
		    	List<WebElement> lis = driver.findElements(by);
		    	return lis;
		    }
	    /**
	     * Author: 
	     * Description: This function verify if the element is present
	     * It returns true if the element is present and returns false if the element is not present
	     */
	     public static boolean verifyElementPresent(WebDriver driver, By by){
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo,"Verifying for element to be present "+by.toString());
	         try{        	
	             if(driver.findElement(by).isDisplayed()){
	            	 return true;
	             }else {
	            	 return false;
	             }
	         }
	         catch(Exception ex){
	        	 return false;
	         }
	     }
	     /**
	      * Author: 
	      * Description: This function verify if the element is present
	      * It returns true if the element is present and returns false if the element is not present
	      */
	      public static boolean verifyElementPresentOnPageSource(WebDriver driver, By by){
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	  log(callerInfo,"verifying for element to be present on page soruce"+by.toString());
	          try{
	              driver.findElement(by);
	              	 return true;
	          }
	          catch(Exception ex){
	         	 return false;
	          }
	      }
	     /**
	      * Author:
	      * Description:This function verify if the elment is not present
	      * It throw an exception if the element is present and returns true if the element is not present
	      */
	     public static boolean verifyElementNotPresent(WebDriver driver, By by){
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	  log(callerInfo,"verifying for element not to be present on page soruce"+by.toString());
	    	 try{
	    		driver.findElement(by);
	    		throw new Exception("Element founded");
	    	 }catch(Exception e){
	    		 return true;
	    	 }
	     }
	     public static boolean verifySubElementPresentOnPageSource(WebDriver driver, WebElement ele,By subBy){
	   	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	   	  String callerInfo = caller.getClassName()
	 	            + " " + caller.getMethodName()   
	 	            + " line " + caller.getLineNumber()  ;
	   	  log(callerInfo,"verifying for element to be present on page soruce"+subBy.toString());
	         try{
	            ele.findElement(subBy);
	             	 return true;
	         }
	         catch(Exception ex){
	        	 return false;
	         }
	     }

	     
	     public static void click(WebDriver driver,By by) throws Exception {
	    	 StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	 String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	  try {   
	    	   getWebElement(driver,by).click(); 
	    	    } catch(Exception e){
	    	     log(callerInfo, "Element Not displayed" + by);
	    	     throw e;
	    	  }
	    	  log(callerInfo, "On Page " + driver.getCurrentUrl());
	    	 } 
	     /**
	      * desc   :This function is used to perform click and hold mouse operation
	      */
	     public static void clickAndHold(WebDriver driver,By by) throws Exception{
	    	 StackTraceElement caller = new Throwable().getStackTrace()[1];
	   	     String callerInfo = caller.getClassName()
	 	            + " " + caller.getMethodName()   
	 	            + " line " + caller.getLineNumber()  ;
	   	     log(callerInfo,"Clearing the element "+by.toString());
	   	 	waitUntillElementIsPresent(driver,by);
	    	 Actions act = new Actions(driver);
	    	 act.clickAndHold(driver.findElement(by)).build().perform();
	     }
	     /** 
	      * @DESC    this function is used to perform normal mouse hover action
	      */
	     public static void mouseHoverSelenium(WebDriver driver,By by) throws Exception{
	    	 StackTraceElement caller = new Throwable().getStackTrace()[1];
	   	     String callerInfo = caller.getClassName()
	 	            + " " + caller.getMethodName()   
	 	            + " line " + caller.getLineNumber()  ;
	   	     log(callerInfo,"Clearing the element "+by.toString());
	   	 	waitUntillElementIsPresent(driver,by);
	    	 Actions action = new Actions(driver);
	 		action.moveToElement(driver.findElement(by)).build().perform();
	     }
	     
	     public static void mouseHoverOnWebEle(WebDriver driver,WebElement ele) throws Exception{

	    	 Actions action = new Actions(driver);
	 		action.moveToElement(ele).build().perform();
	     }
	     /**
	      * Author: 
	      * Description: This function clears the text present in the element specified
	      */
	     public static void clear(WebDriver driver,By by) throws Exception{
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo,"Clearing the element "+by.toString());
	    	 	waitUntillElementIsPresent(driver,by);
	    		 driver.findElement(by).clear();
	     }
	     /**
	      * Author:
	      * Description:This function send the text to the textbox specified
	      */
	  public static void sendKeys(WebDriver driver,By by, String text) throws Exception{
		  waitFor(driver, by);
		  StackTraceElement caller = new Throwable().getStackTrace()[1];
		  String callerInfo = caller.getClassName()
		            + " " + caller.getMethodName()   
		            + " line " + caller.getLineNumber();
		  log(callerInfo,"Send keys to the element "+by.toString() +" and text "+text);
	      driver.findElement(by).sendKeys(text);
	  }
	  
	  public static boolean sendKeys1(WebDriver driver,By by, String text) throws Exception{
		  waitFor(driver, by);
		  StackTraceElement caller = new Throwable().getStackTrace()[1];
		  String callerInfo = caller.getClassName()
		            + " " + caller.getMethodName()   
		            + " line " + caller.getLineNumber();
		  log(callerInfo,"Send keys to the element "+by.toString() +" and text "+text);
		  try{
		  driver.findElement(by).sendKeys(text);
		  return true;
		  } catch(Exception ex){
	            return false;
	        }
	  }
	    /**
	     * Author: 
	     * Description: This function verifies whether the text is present in the give path
	     * It returns true if the text is present, returns false if the text is not present
	     */
	     public static boolean verifyTextPresent(WebDriver driver,By by,String text){
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo,"Verifing text present on the element "+by.toString());
	        try{
	        	waitFor(driver, by);
	            return driver.findElement(by).getText().contains(text);
	        }
	        catch(Exception ex){
	            return false;
	        }
	     }
	 	public static void selectFromDropDown(WebDriver driver,By by , String option){
			Select droplist = new Select(getWebElement(driver,by));   
			droplist.selectByVisibleText(option);
		}
	     public static String getAttribute(WebDriver driver,By by,String attribute){
	    	 waitFor(driver, by);
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo,"Get Attributes of  "+by.toString());
	         try{
	             return driver.findElement(by).getAttribute(attribute);            
	         }
	         catch(Exception ex){
	             return null;
	         }
	      }
	     /**
	      * Author: 
	      * Description: This function verifies that the element is enabled or not
	      */
	     public static boolean verifyIfElementIsEnabled(WebDriver driver, By by)  {  
	    	 waitFor(driver, by);
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo,"Verify if the element is enabled "+by.toString());
	         return driver.findElement(by).isEnabled();
	     }
	     public static String getText(WebDriver driver, By by) throws Exception{
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo,"Get text of the element "+by.toString());
	    	 waitUntillElementIsPresent(driver,by);
	    	 return driver.findElement(by).getText();
	     }
	     /**
	      * Author: 
	      * Description:
	      */
	     public boolean clickAlertOkButton(WebDriver driver, String alertString) {
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo,"click on the alert button if present ");
	            Alert alert = driver.switchTo().alert();
	            if (!alert.getText().contains(alertString)) {
	                return false;
	            }
	            alert.accept();
	            return true;
	        }
	     /**
	      * @author :
	      * @desc:	click on ok button
	      */
	     public static void clickAlertOkButton(WebDriver driver) throws Exception {
	 		try{
	 			try{
	 				WebDriverWait wait = new WebDriverWait(driver, 100);
	 				wait.until(ExpectedConditions.alertIsPresent());
	 			} catch (Exception e){
	 				throw e;
	 			}
	 			Alert alert = driver.switchTo().alert();		
	 			alert.accept();
	 		} catch (Exception e){
	 			throw e;
	 		}
	 	}
	     
	     
	     public static String getTextFromAlert(WebDriver driver) throws Exception {
	    	 String alert=null;	
	    	 try{
		 			try{
		 				WebDriverWait wait = new WebDriverWait(driver, 100);
		 				wait.until(ExpectedConditions.alertIsPresent());
		 			} catch (Exception e){
		 				throw e;
		 			}
		 			alert = driver.switchTo().alert().getText();		
		 			
		 		} catch (Exception e){
		 			throw e;
		 		}
				return alert;
		 	}
	     
	     public static boolean verifyAlertPresent(WebDriver driver) 
	     { 
	         try 
	         { 
	             driver.switchTo().alert(); 
	             return true; 
	         }   
	         catch (NoAlertPresentException Ex) 
	         { 
	             return false; 
	         }  
	     }  
	     public void clickAlertCancelButton(WebDriver driver) {
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo,"Click on cancel button on alert");
	         Alert alert = driver.switchTo().alert();
	         alert.dismiss();
	     }
	     public void doubleClick(WebDriver driver, By by) {
	    	 waitFor(driver, by);
	    	  StackTraceElement caller = new Throwable().getStackTrace()[1];
	    	  String callerInfo = caller.getClassName()
	  	            + " " + caller.getMethodName()   
	  	            + " line " + caller.getLineNumber()  ;
	    	 log(callerInfo," Double click java function "+ by.toString());
	            ((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');"
	            + "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
	            + "arguments[0].dispatchEvent(evt);",driver.findElement(by));
			}
		 /**
		  * Author: 
		  * Description:This function navigates the url
		  */
		 public static void navigateTo(WebDriver driver, String url) {	
			  StackTraceElement caller = new Throwable().getStackTrace()[1];
			  String callerInfo = caller.getClassName()
			            + " " + caller.getMethodName()   
			            + " line " + caller.getLineNumber()  ;
			 log(callerInfo,"Navigate to "+url);
			 driver.navigate().to(url);
		 }
		 /**
		  * Author: 
		  * Description: This function clicks on the "Enter" button in Keyboard
		  */
		 public static void hitEnter(WebDriver driver, By by) {
			  StackTraceElement caller = new Throwable().getStackTrace()[1];
			  String callerInfo = caller.getClassName()
			            + " " + caller.getMethodName()   
			            + " line " + caller.getLineNumber()  ;
			 log(callerInfo," Hit enter on "+by.toString());
			 try {
				 waitFor(driver, by);
				 driver.findElement(by).sendKeys(Keys.RETURN);   
			 } catch(Exception e){
			 }
		 }
		 /**
		  * Author: 
		  * Description: Wait untill the element is present
		  */
		 public static void waitUntillElementIsPresent(WebDriver driver,By by) throws Exception{
			for(int i=0;i<20;i++)
			{
			 try{
				 driver.findElement(by);
				 break;
			 }
			 catch(Exception ex){
				 waitTill(1000);
			}
			}
		 }
		 public static int getRandomIntwithinRange(int low, int high){
				Random random = new Random();
			    int randomNum = random.nextInt((high - low) + 1) + low;
			    return randomNum;
		}
		 /**
			 * Author: 
			 * This function prints the data to the console and logs the data in the log file
			 */
			public static void log(String callerInfo, String msg){
				if(callerInfo == null){
					StackTraceElement caller = new Throwable().getStackTrace()[1];
			    	  callerInfo = caller.getClassName()
			  	            + " " + caller.getMethodName()   
			  	            + " line " + caller.getLineNumber()  ;
				}
				Calendar cal = Calendar.getInstance();
				cal.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				System.out.print("--->"+sdf.format(cal.getTime())+" ");
				System.out.println(callerInfo + " | "+msg);
			}
			/**Author: 
			  * @Desc: browser waits for specified time
			  * @params:  long  <<  time
			  */
			 public static void waitTill(long time){
				 try{
					 Thread.sleep(time);
				 }
				 catch(Exception e){
				 }
			}
			 public static void waitTill(){
				 waitTill(2000);
			 }		
			public static void pageDown(WebDriver driver, String value){
				  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"+value+")", "");
			}
			public static void scrollUp(WebDriver driver, String value){
				  ((JavascriptExecutor) driver).executeScript("window.scrollBy("+value+",0)", "");
			}
			
			public static void jSClick(WebDriver driver,By by){
				WebElement ele = getWebElement(driver,by);
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
				 waitTill();
			}
			
		public static String uniqueDateAndTime()throws Exception{
			DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
			Date dateobj = new Date();
			String date=df.format(dateobj);
			return date;
		}

}
