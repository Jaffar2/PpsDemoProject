package bookings;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    String FIRST_NAME = "Jim";

    public static String getToken(){
        String Payload = "{" + 
                        "    \"username\" : \"admin\"," + 
                        "    \"password\" : \"password123\"" + 
                        "}";

        return Payload;
    }
    public static String createBookingIdPayloadFromString() {

        String Payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : \"111\",\n" +
                "    \"depositpaid\" : \"true\",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        return Payload;

    }

    public static Map<String,Object> createBookingIdPayloadFromMap(String firstname, String lastname,int totalprice,boolean depositpaid,String checkin, String checkout, String additionalneeds) {

     Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", firstname);
        payload.put("lastname", lastname);
        payload.put("totalprice", totalprice);
        payload.put("depositpaid", depositpaid);

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout", checkout);

        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", additionalneeds);

        return payload;

    }

}
