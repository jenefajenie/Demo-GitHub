package max.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import max.base.TestBase;

public class TestUtil extends TestBase {
	
	public static String screenshotPath;
	public static String screenshotName;
	
	
	public static void captureScreenshot() throws IOException {
		
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		screenshotName= d.toString().replace(":", "_").replace(" ","_")+".png";
		
		
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		
		
	}
	@DataProvider(name="dp")
	    public Object[][] getData(Method m) {
		String sheetname= m.getName();
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
	public String getScreenshotPath() {
		return screenshotPath;
	}

}
