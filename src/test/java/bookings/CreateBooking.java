package bookings;

import com.aventstack.extentreports.ExtentReports;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restutils.RestUtils;
import utils.JSONUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateBooking extends BookingAPIs {
    @Test
    public void createBooking() throws IOException {
        Map<String,Object> requestPayload = Payloads.createBookingIdPayloadFromMap("Jim","Brown",111,true,"2018-01-01","2019-01-01","Breakfast");
        Response response = createBooking(requestPayload);
        Assert.assertEquals(response.statusCode(), 200);

    }

}
