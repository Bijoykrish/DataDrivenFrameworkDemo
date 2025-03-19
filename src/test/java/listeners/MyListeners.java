package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.ExtendReporter;

public class MyListeners implements ITestListener {
    ExtentReports extendReport = ExtendReporter.getExtendReport();
    ExtentTest extendTest;


    @Override
    public void onTestStart(ITestResult result) {
        extendTest = extendReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extendTest.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extendTest.log(Status.FAIL,"Test Failed");
        extendTest.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
       extendReport.flush();
    }
}
