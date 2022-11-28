package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Baseclass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TimeSheetPage;
import utilities.XLUtils;

public class TC_ProjectHours_002 extends Baseclass {
	
	
	@Test(priority = 1)
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
	
	@Test(dataProvider = "TC_001-Timesheet",priority = 2)
	public void EnterTimesheet(String project,String hours,String comments) throws Exception {

		HomePage Hp=new HomePage(driver);
		TimeSheetPage Tp=new TimeSheetPage(driver);

		Hp.ClickAddNew();
		logger.info("clicked on Add New button"+Integer.parseInt(project));
		Thread.sleep(4000);
		Tp.selectProject(Integer.parseInt(project));
		
		Tp.setHours(hours);
		
		Tp.setComments(comments);
		
		Thread.sleep(4000);
		
		Tp.ClickSubmit();
		
		Thread.sleep(4000);
		
	}

	@DataProvider(name = "TC_001-Timesheet")
	String[][] getData() throws Exception {

		String path = "C:\\Users\\Prasanth M\\eclipse-workspace\\Maven_Hybrid_Framework\\testData\\TC_001-Timesheet.xlsx";
		
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int cellcount = XLUtils.getCellCount(path, "Sheet1", 1);
		

		String[][] logindata = new String[rowcount][cellcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}
		}
		
		
		return logindata;

	}
}
