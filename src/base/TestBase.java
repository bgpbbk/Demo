package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import datatable.XL_Reader;

public class TestBase {	
		
		public static Properties CONFIG=null;
		public static Properties GmailTest_OR=null;
		public static WebDriver driver=null;
		public static XL_Reader datatable=null;
		
		public void initialize() throws IOException{
		
		//Initializing Config Properties file
		
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config\\Config.properties");
		CONFIG.load(fs);
		
		//Initializing GmailTest_OR properties file
		
		GmailTest_OR = new Properties();
		fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\Config\\GmailTest_OR.properties");
		GmailTest_OR.load(fs);
		
		//Initializing webdriver
		
		if (CONFIG.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",".//src//Config//chromedriver.exe");
			driver=new ChromeDriver();						
			
		} else if(CONFIG.getProperty("browser").equals("firefox")){
			driver=new FirefoxDriver();

			}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		} 
		
		public void testURL(){
			
			driver.get(CONFIG.getProperty("TestSiteName"));
		}
		
		public static WebElement getObjectByid(String IDkey) throws Exception{
			
			try {
				
				return driver.findElement(By.id(GmailTest_OR.getProperty(IDkey)));
			} catch (Exception e) {
				printScreenshot(IDkey);
				return null;
			}
		}
		
		public static WebElement getObjectByName(String Namekey) throws Exception{
			try {
				
				return driver.findElement(By.name(GmailTest_OR.getProperty(Namekey)));
			    } catch (Exception e) {
				printScreenshot(Namekey);
				return null;
			    	
			}
		}
		
		public static WebElement getObjectByXpath(String Xpathkey) throws Exception{
			
			try {
				
				return driver.findElement(By.xpath(GmailTest_OR.getProperty(Xpathkey)));
			    } catch (Exception e) {
				printScreenshot(Xpathkey);
				return null;
			}
		}
		
		public void setValue(WebElement element,String IDkey1){
			
			element.sendKeys(IDkey1);		
		}
		
		public String getValue(WebElement element) {

			return element.getText();
		}
		
		public WebElement Click(WebElement element) {

			try {
				element.click();
				return element;
				
			    } catch (Exception e ) {
				return null;

			}

		}
		
		public static void tearDown(){
			
			driver.quit();
		}
		
		public static void printScreenshot(String ssname) throws Exception{
			System.out.println("printScreenshot method started");			
			File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile,new File(System.getProperty("user.dir")+".//Screenshots//"+ssname+".png"));
			System.out.println("printScreenshot method ended");
		}
		
		public static void driverinit(){			
			
			System.setProperty("webdriver.chrome.driver",".//src//Config//chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println(driver);
		}
	}

