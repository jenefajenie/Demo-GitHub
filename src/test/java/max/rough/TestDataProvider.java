package max.rough;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import max.base.TestBase;

public class TestDataProvider extends TestBase {
	@Test(dataProvider="getData")
	public void testDataProvider(String username,String password, String alerttext ) throws InterruptedException {
	driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(username);
	driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
	driver.findElement(By.xpath(OR.getProperty("loginbtn"))).click();
	Thread.sleep(3000);
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	Assert.assertEquals(alert.getText().contains(alerttext),"Alert Text not found..!!!");
	
}
	@DataProvider(name="getData")
	public Object[][] getData() {
		String sheetname= "TestDataProvider";
		int rows=excel.getRowCount(sheetname);
		int cols=excel.getColumnCount(sheetname);
		Object[][] data= new Object[rows-1][cols];
		
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			for(int colNum=0; colNum<cols; colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetname,colNum,rowNum);
			}
		}
		
		return data;
		
		
	} 
}
