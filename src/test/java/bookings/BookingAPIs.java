package bookings;

import io.restassured.response.Response;
import restutils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class BookingAPIs {

    public Response createBooking(Map<String,Object> createBookingPayload) {
        String endPoint = (String) Base.dataFromJsonFile.get("createBookingEndpoint");
        return RestUtils.performPost(endPoint,createBookingPayload,new HashMap<>());

    }


    }
