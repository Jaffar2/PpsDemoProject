package bookings;

import utils.ExcelUtils;

import java.io.IOException;

public class ExcelTest {

    public static void main(String[] args) throws IOException {
        System.out.println(ExcelUtils.getExcelDataAsListOfMap("CreateBookingDataScenarios", "Sheet1"));

    }
}
