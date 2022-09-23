package max.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import max.base.TestBase;
import max.utilities.TestUtil;

public class LoginTest1 extends TestBase {
	@Test(dataProviderClass= TestUtil.class,dataProvider="dp")
	public void loginTest1(String username,String password, String alerttext ) throws InterruptedException {
		
	
	/*driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(username);
	driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
	driver.findElement(By.xpath(OR.getProperty("loginbtn"))).click();*/
		type("username_XPATH",username);
		type("password_XPATH",password);
		click("loginbtn_XPATH");
		Thread.sleep(3000);
		

	
	log.debug("Login Successful");
	
	/*Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("configbtn"))),"Configuration button is not present");
	Assert.fail("Login not successful");
	log.debug("Configuration button is present");
	Reporter.log("Configuration button is present");*/
	
	/*Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	Assert.assertEquals(alert.getText().contains(alerttext),"Alert Text not found..!!!");
	log.debug("Alert is present");*/
	
}
	
}
