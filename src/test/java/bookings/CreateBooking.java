package bookings;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateBooking extends BookingAPIs {

    String createdId;

    @Epic("endToend smokeTest")
    @Feature("get Token")
    @Test(description = "request for a token", priority = 1)
    @Story("get token")
    @Severity(SeverityLevel.NORMAL)
    @Link("link to JIRA-Tickets")
    @Attachment("link to logFile")
    public void getToken() throws IOException {
      String requestPayload = Payloads.getToken();
      Response response = requestToken(requestPayload);
      Assert.assertEquals(response.statusCode(), 200);
  }

    @Epic("endToend smokeTest")
    @Feature("smokeTest endToend on all environments")
    @Test(description = "create booking with valid info", priority = 2)
    @Story("booking creation")
    @Severity(SeverityLevel.NORMAL)
    @Link("link to JIRA-Tickets")
    @Attachment("link to logFile")

      public void createBooking() throws IOException {
        String requestPayload = Payloads.createBookingIdPayloadFromString();
        Response response = createBooking(requestPayload);
        Assert.assertEquals(response.statusCode(), 200);
        createdId = response.jsonPath().getString("bookingid");
        System.out.println(createdId);
    }
    
    @Epic("endToend smokeTest")
    @Feature("smokeTest endToend on all environments")
    @Test(description = "Get bookings", priority = 3)
    @Story("booking listing")
    @Severity(SeverityLevel.NORMAL)
    @Link("link to JIRA-Tickets")
    @Attachment("link to logFile")

      public void getBookings() throws IOException {
        // Map<String,Object> requestPayload = Payloads.createBookingIdPayloadFromMap("Jim","Brown",111,true,"2018-01-01","2019-01-01","Breakfast");
        Response response = getBookingList();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Epic("endToend smokeTest")
    @Feature("smokeTest endToend on all environments")
    @Test(description = "Get booking for a given id", priority = 4)
    @Story("booking listing")
    @Severity(SeverityLevel.NORMAL)
    @Link("link to JIRA-Tickets")
    @Attachment("link to logFile")

      public void getBookingById() throws IOException {
        // Map<String,Object> requestPayload = Payloads.createBookingIdPayloadFromMap("Jim","Brown",111,true,"2018-01-01","2019-01-01","Breakfast");
        Response response = getBookingById(createdId);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
