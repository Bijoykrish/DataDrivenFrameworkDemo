package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporter {
    public static ExtentReports getExtendReport() {
        String extendReportFilePath = System.getProperty("user.dir") + "/reports/extendreport.html";

        // Create Spark Reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extendReportFilePath);
        sparkReporter.config().setDocumentTitle("TutorialNinja Test Automation Reports");
        sparkReporter.config().setReportName("TutorialNinja Test Execution Report");

        // Create ExtentReports instance and attach the reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Selenium Version","4.21.0");
        extent.setSystemInfo("Operating sysytem","Windows 11");
        extent.setSystemInfo("Executed by","Bijoy Krishna");



        return extent;
    }
}
