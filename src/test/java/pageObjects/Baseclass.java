package pageObjects;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import utilities.ReadConfig;

public class Baseclass {
	
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUSERNAME();
	public String pwd = readConfig.getPWD();
	public static WebDriver driver;
	public static Logger logger;

	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String bro) {

		logger = Logger.getLogger("Timesheet");
		PropertyConfigurator.configure("log4j.properties");

		if (bro.equals("chrome")) {

//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();

		} else if (bro.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getChromePath());
			driver = new FirefoxDriver();

		} else if (bro.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL opened");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {
//		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws Exception {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot Taken");
		
		
		
	}
}
