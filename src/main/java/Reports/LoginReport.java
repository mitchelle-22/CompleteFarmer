package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginReport {
    private static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("Complete Farmer Test Report");
            spark.config().setDocumentTitle("Test Results");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
