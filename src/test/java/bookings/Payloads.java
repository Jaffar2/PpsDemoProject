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

    public static String createAgentsIdAccountsPayloadFromString() {

        String Payload = "{\n" +
                "  \"accounts\": [\n" +
                "    {\n" +
                "      \"effectiveDate\": \"2025-03-29\",\n" +
                "      \"commissionHold\": 0,\n" +
                "      \"company\": 0,\n" +
                "      \"accountName\": \"string\",\n" +
                "      \"specialHandling\": \"string\",\n" +
                "      \"netRetainedCommAllowedCode\": true,\n" +
                "      \"forCause\": true,\n" +
                "      \"agentAccountNo\": 0,\n" +
                "      \"accountStatus\": 0,\n" +
                "      \"statusReason\": 0,\n" +
                "      \"statusDate\": \"2025-03-29\",\n" +
                "      \"statusDescription\": \"string\",\n" +
                "      \"currencyOptions\": 0,\n" +
                "      \"currency\": 0,\n" +
                "      \"paForPayments\": 0,\n" +
                "      \"division\": 0,\n" +
                "      \"territory\": 0,\n" +
                "      \"billingMethod\": 0,\n" +
                "      \"reservedAcctCommPercentage\": 0,\n" +
                "      \"advances\": true,\n" +
                "      \"minPaymentAmount\": 0,\n" +
                "      \"chargebackMethod\": 0,\n" +
                "      \"overrideMinimumAmount\": true,\n" +
                "      \"onSubmission\": 0,\n" +
                "      \"onIssue\": 0,\n" +
                "      \"communicationCode\": 0,\n" +
                "      \"advancedRequested\": 0,\n" +
                "      \"entityItems\": [\n" +
                "        {\n" +
                "          \"entityType\": 0,\n" +
                "          \"entitySubType\": 0,\n" +
                "          \"id\": 0,\n" +
                "          \"value\": 0\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        return Payload;

    }

}
