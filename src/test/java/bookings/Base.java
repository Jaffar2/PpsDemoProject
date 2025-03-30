package bookings;

import org.testng.annotations.BeforeMethod;
import reporting.ExtentReportManager;
import utils.JSONUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String, Object> dataFromJsonFile;

    static {

        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        try {
            dataFromJsonFile = JSONUtils.getJsonDataAsMap("bookings/" + env + "/bookingData.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @BeforeMethod
    public void beforeTest() {
        ExtentReportManager.resetLoggingFlags();
    }

}

