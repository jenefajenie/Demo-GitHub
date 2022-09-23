package max.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import max.base.TestBase;
@Test
public class Signals extends TestBase {
	
	public void signal() {
	
	log.debug("configuration button is present");
	Reporter.log("Configuration button is present");
	click("configbtn_XPATH");
	Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("signalbtn_XPATH"))),"Signal button is not present");
	Reporter.log("Signal button is present");
	log.debug("Signals button is present");
	}
	
}
