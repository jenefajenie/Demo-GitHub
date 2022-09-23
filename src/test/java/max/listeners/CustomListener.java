package max.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import max.utilities.TestUtil;

public class CustomListener implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {

		
        

	}

	public void onTestSuccess(ITestResult result) {

		
		
		

	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
			System.out.println("On Custom listener class" + TestUtil.screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Click to view screenshot");
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+"height=200 width=200 ></img></a>");
		
		
		

	}

	public void onTestSkipped() {
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ISuite arg0) {
		
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {


		
	}


}



