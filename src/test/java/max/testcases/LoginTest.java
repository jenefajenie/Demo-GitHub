package max.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import max.base.TestBase;
import max.utilities.TestUtil;

public class LoginTest extends TestBase {
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void loginTest(String username,String password) throws InterruptedException {
	
		
		/*driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys("jenefa.malaysia");
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("Test123");
		driver.findElement(By.xpath(OR.getProperty("loginbtn"))).click();*/
		type("username",username);
		type("password",password);
		click("loginbtn");
		Thread.sleep(3000);
		log.debug("Login Successful");
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("configbtn"))),"Configuration button is not present");
		
		log.debug("Configuration button is present");
		
		
		
		
		
	}
	
		
		
		
	}


