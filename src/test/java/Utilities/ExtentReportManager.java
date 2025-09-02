package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
	private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            // Generate unique report file name with timestamp
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/Reports/TestReport_" + timestamp + ".html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Extent Report Example");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // Add environment/system info
            extent.setSystemInfo("Tester", "Aniket Pawar");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
        return extent;
    }
}





    

