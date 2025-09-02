package TestBase;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReportManager;

public class BaseClass {

	public WebDriver x;
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	public static ExtentReports extent;
    public static ExtentTest test;
    
    @BeforeSuite
    public void reportSetup() {
        extent = ExtentReportManager.getReportInstance();
    }
	
	@BeforeClass(groups= {"sanity","regression","ddt","master"})
	@Parameters({"os","browser"})
	
	public void setup(String os, String br) {
		logger.info("==== Browser setup started ====");
		
		switch(br.toLowerCase()) {
		
		case "chrome": x = new ChromeDriver();break;
		case "edge" : x = new EdgeDriver(); break;
		default: System.out.println("Invalid browser name"); return;
		
		
		}
		
		x.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		x.manage().deleteAllCookies();
		
		x.get("https://tutorialsninja.com/demo/");
		x.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","regression","ddt","master"})
	public void close() {
		logger.info("==== Browser closed ====");
		x.quit();
	}
	
	@AfterSuite
    public void tearDownReport() {
        extent.flush();  // generates the HTML report
    }
}
