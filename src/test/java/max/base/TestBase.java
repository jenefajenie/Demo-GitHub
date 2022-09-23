package max.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import max.utilities.ExcelReader;

public class TestBase {
	
	
	
	/*initializing webdriver- done
	 * properties- done
	 * log4j-log4j jar file,.log file(application and selenium), log4j property file, logger class
	 * Excel reading
	 * ExtentReports
	 * DB
	 * mailing
	  */
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\data.xlsx");
	public static WebDriverWait wait;
	
	
	
	@BeforeSuite
	
	public void setUp() {
		
		if(driver==null) {
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config property loaded..!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("\"OR property loaded..!!!\"");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\DELL\\Documents\\selenium workspace\\MAX\\src\\test\\resources\\execuetables\\geckodriver.exe");
				driver=new FirefoxDriver();
			}else if(config.getProperty("browser").equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\selenium workspace\\MAX\\src\\test\\resources\\execuetables\\chromedriver.exe");
				driver=new ChromeDriver();
				log.debug("Chrome is Lauched");
				}else if(config.getProperty("browser").equals("ie")){
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\execuetables\\IEDriverServer.exe");
					driver=new InternetExplorerDriver();
					}
			driver.get(config.getProperty("testsiurl"));
			log.debug("MAX website is launched");
			driver.manage().window().maximize();
			
			//new WebDriverWait(driver, Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			
		}
		
		
		}
	public void click(String locator) {
		if(locator.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}else if(locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		
	}
	else if(locator.endsWith("_ID")) {
		driver.findElement(By.id(OR.getProperty(locator))).click();
		
	}
		}
	public void type(String locator, String value) {
		if(locator.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);}
		else if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
	}
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
			
		}
		catch(NoSuchElementException e){
			
			return false;
		}
		
		
		
		
	}
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
		driver.quit();}
		
		
	}

}
