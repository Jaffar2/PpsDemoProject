package bookings;

import io.restassured.response.Response;
import restutils.RestUtils;
import java.util.HashMap;
import java.util.Map;


public class BookingAPIs {

    public Response requestToken(String payload) {
        String endPoint = (String) Base.dataFromJsonFile.get("tokenEndpoint");
        return RestUtils.performPost(endPoint, payload, Map.of("Content-Type", "application/json"));
    }
    public Response createBooking(String createBookingPayload) {
        String endPoint = (String) Base.dataFromJsonFile.get("createBookingEndpoint");
        return RestUtils.performPost(endPoint, createBookingPayload, new HashMap<>());
    }
    public Response getBookingList() {
        return RestUtils.performGet((String) Base.dataFromJsonFile.get("getBookingEndpoint")+"/"+1, Map.of());
    }
    public Response getBookingById(String id) {
        return RestUtils.performGet((String) Base.dataFromJsonFile.get("getBookingEndpoint")+"/"+id, Map.of());
    }
    public Response getAgent() {
        return RestUtils.performGet((String) Base.dataFromJsonFile.get("getAgentEndpoint"), Map.of());
    }

    public Response getAgentWithIdAccounts() {
        return RestUtils.performGet((String) Base.dataFromJsonFile.get("getAgentsWithIdEndpoint"), Map.of());
    }
    public Response createAgentsIdAccounts(String payload) {
        String endPoint = (String) Base.dataFromJsonFile.get("createAgentsWithIdEndpoint");
        return RestUtils.performPost(endPoint, payload, Map.of("Content-Type", "application/json"));
    }
}
