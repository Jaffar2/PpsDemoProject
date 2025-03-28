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
        if (Setup.getExtentTest() != null) {
            Setup.getExtentTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
        }
    }
    public static void logHTML(String json) {
        if (Setup.getExtentTest() != null) {
            Setup.getExtentTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.XML));
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
}
