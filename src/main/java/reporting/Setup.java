package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static org.javers.core.JaversBuilder.logger;

public class Setup implements ITestListener {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        if (extentReports == null) {
            String fileName = ExtentReportManager.getReportNameWithTimeStamp();
            //String fullReportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + fileName;
            String fullReportPath = System.getenv("WORKSPACE") + File.separator + "reports" + File.separator + "extentReport.html";
            extentReports = ExtentReportManager.createInstance(fullReportPath, "Test API Automation Report", "Test Execution Report");
            System.out.println("Extent Report initialized at: " + fullReportPath);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
            System.out.println("Extent Report flushed and saved.");
        } else {
            System.out.println("Extent Report was null in onFinish.");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        if (extentReports == null) {
            throw new IllegalStateException("ExtentReports instance is not initialized. Ensure onStart() is called before any test.");
        }

        ExtentTest test = extentReports.createTest(
                result.getTestClass().getName() + " - " + result.getMethod().getMethodName(),
                result.getMethod().getDescription()
        );

        extentTest.set(test);
        System.out.println("🔹 Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //getExtentTest().pass("Test passed: " + result.getMethod().getMethodName());
        logger.info("✅ Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //getExtentTest().fail("Test failed: " + result.getMethod().getMethodName());
        logger.error("❌ Test failed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getExtentTest().skip("Test skipped: " + result.getMethod().getMethodName());
    }

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }
}

