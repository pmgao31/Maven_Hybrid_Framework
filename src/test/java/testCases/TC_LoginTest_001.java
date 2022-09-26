package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Baseclass;
import pageObjects.LoginPage;
import utilities.Reporting;

public class TC_LoginTest_001 extends Baseclass {

	@Test
	public void logintest() throws Exception {

		LoginPage lp = new LoginPage(driver);

		lp.setUsername(username);
		logger.info("Entered usename");

		lp.setPassword(pwd);
		logger.info("Entered Password");

		lp.ClickSignInbtn();
		logger.info("clicked on Sign In button");

		if (driver.getTitle().equals("Timesheet")) {
			logger.info("Test Case Passed");
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "logintest");
			logger.info("Test Case Failed");
			Assert.assertTrue(false);
			
		}

	}

}
