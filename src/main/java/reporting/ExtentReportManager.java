package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    // Use a ThreadLocal flag to ensure request/response logging happens only once per thread/test
    private static ThreadLocal<Boolean> isRequestLogged = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<Boolean> isResponseLogged = ThreadLocal.withInitial(() -> false);

    public static ExtentReports createInstance(String fileName, String reportName, String documentTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getReportNameWithTimeStamp() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return "TestReport_" + dateTimeFormatter.format(localDateTime) + ".html";
    }

    public static void logPassDetails(String log) {
        if (Setup.getExtentTest() != null) {
            Setup.getExtentTest().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
        }
    }

    public static void logFailureDetails(String log) {
        if (Setup.getExtentTest() != null) {
            Setup.getExtentTest().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
        }
    }

    public static void logExceptionDetails(String log) {
        if (Setup.getExtentTest() != null) {
            Setup.getExtentTest().fail(log);
        }
    }

    public static void logInfoDetails(String log) {
        if (Setup.getExtentTest() != null) {
            Setup.getExtentTest().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
        }
    }

    public static void logWarningDetails(String log) {
        if (Setup.getExtentTest() != null) {
            Setup.getExtentTest().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
        }
    }

    public static void logJson(String json) {
        // Log the request only once
        if (Setup.getExtentTest() != null && !isRequestLogged.get()) {
            Setup.getExtentTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
            isRequestLogged.set(true);  // Mark request as logged
        }
    }

    public static void logHTML(String html) {
        // Log the HTML only once
        if (Setup.getExtentTest() != null && !isRequestLogged.get()) {
            Setup.getExtentTest().info(MarkupHelper.createCodeBlock(html, CodeLanguage.XML));
            isRequestLogged.set(true);  // Mark HTML as logged
        }
    }

    public static void logHeaders(List<Header> headersList) {
        if (Setup.getExtentTest() != null) {
            String[][] arrayHeaders = headersList.stream()
                    .map(header -> new String[]{header.getName(), header.getValue()})
                    .toArray(String[][]::new);
            Setup.getExtentTest().info(MarkupHelper.createTable(arrayHeaders));
        }
    }

    public static void logResponse(String responseJson) {
        // Log the response only once
        if (Setup.getExtentTest() != null && !isResponseLogged.get()) {
            Setup.getExtentTest().info(MarkupHelper.createCodeBlock(responseJson, CodeLanguage.JSON));
            isResponseLogged.set(true);  // Mark response as logged
        }
    }

    // Reset flags for each test to ensure no duplication for subsequent tests
    public static void resetLoggingFlags() {
        isRequestLogged.set(false);
        isResponseLogged.set(false);
    }
}

