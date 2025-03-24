package bookings;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String createBookingIdPayloadFromString(String firstname, String lastname,int totalprice,boolean depositpaid,String checkin, String checkout, String additionalneeds) {

        String Payload = "{\n" +
                "    \"firstname\" : \""+firstname+"\",\n" +
                "    \"lastname\" : \""+lastname+"\",\n" +
                "    \"totalprice\" : \""+totalprice+"\",\n" +
                "    \"depositpaid\" : \""+depositpaid+"\",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \""+checkin+"\",\n" +
                "        \"checkout\" : \""+checkout+"\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \""+additionalneeds+"\"\n" +
                "}";

        return Payload;

    }

    public static Map<String,Object> createBookingIdPayloadFromMap(String firstname, String lastname,int totalprice,boolean depositpaid,String checkin, String checkout, String additionalneeds) {

     Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", "Jim");
        payload.put("lastname", "Brown");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", "Breakfast");

        return payload;

    }

}
