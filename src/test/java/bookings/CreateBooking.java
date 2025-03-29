package bookings;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JSONUtils;

import java.io.IOException;
import java.util.Map;

public class CreateBooking extends BookingAPIs {
  String createdId;


  public CreateBooking() {
  }

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
    //System.out.println(createdId);
  }

  @Epic("endToend smokeTest")
  @Feature("smokeTest endToend on all environments")
  @Test(description = "Get bookings", priority = 3)
  @Story("booking listing")
  @Severity(SeverityLevel.NORMAL)
  @Link("link to JIRA-Tickets")
  @Attachment("link to logFile")

  public void getBookings() throws IOException {
    Response response = getBookingList();
    Assert.assertEquals(response.statusCode(), 200);
  }

  @Epic("endToend smokeTest")
  @Feature("smokeTest endToend on all environments")
  @Test(description = "Get booking for a given id", priority = 4)
  @Story("get booking")
  @Severity(SeverityLevel.NORMAL)
  @Link("link to JIRA-Tickets")
  @Attachment("link to logFile")

  public void getBookingById() throws IOException {
    Response response = getBookingById(createdId);
    Assert.assertEquals(response.statusCode(), 200);
  }

  @Epic("endToend smokeTest")
  @Feature("smokeTest endToend on all environments")
  @Test(description = "Get agents Service to search person on provided parameter", priority = 4)
  @Story("get agents")
  @Severity(SeverityLevel.NORMAL)
  @Link("link to JIRA-Tickets")
  @Attachment("link to logFile")

  public void getAgents() throws IOException {
    Response response = getAgent();
    Assert.assertEquals(response.statusCode(), 200);

  }
  @Epic("endToend smokeTest")
  @Feature("smokeTest endToend on all environments")
  @Test(description = "Get agents Service to search person on provided parameter", priority = 4)
  @Story("get agents")
  @Severity(SeverityLevel.NORMAL)
  @Link("link to JIRA-Tickets")
  @Attachment("link to logFile")

  public void getAgentsWithId() throws IOException {
    Response response = getAgentWithIdAccounts();
    Assert.assertEquals(response.statusCode(), 200);

  }
}
