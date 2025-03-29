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

    public static String createAgentsPayloadFromString() {

        String Payload = "{\n" +
                "  \"agentDetails\": {\n" +
                "    \"title\": 0,\n" +
                "    \"agentType\": 0,\n" +
                "    \"userName\": \"string\",\n" +
                "    \"businessOrIndividual\": 0,\n" +
                "    \"externalAgentRef\": \"string\",\n" +
                "    \"nationalInsuranceType\": 0,\n" +
                "    \"nationalInsuranceReference\": \"string\",\n" +
                "    \"nationalInsuranceCountry\": 0,\n" +
                "    \"taxCertification\": 0,\n" +
                "    \"vatRegistrationNoFlag\": 0,\n" +
                "    \"VatRegistrationNo\": \"string\",\n" +
                "    \"additionalNameLine\": \"string\",\n" +
                "    \"businessName\": \"string\",\n" +
                "    \"personalStatus\": 0,\n" +
                "    \"dateOfDeath\": \"2025-03-29T22:30:49.443Z\",\n" +
                "    \"firstName\": \"string\",\n" +
                "    \"middleName\": \"string\",\n" +
                "    \"surName\": \"string\",\n" +
                "    \"suffix\": 0,\n" +
                "    \"gender\": 0,\n" +
                "    \"dateOfBirth\": \"2025-03-29T22:30:49.443Z\",\n" +
                "    \"nationalProducerNumber\": \"string\",\n" +
                "    \"commissionHold\": 0,\n" +
                "    \"commissionHoldNote\": \"string\",\n" +
                "    \"additionalInformation\": {\n" +
                "      \"addressUnknown\": 0,\n" +
                "      \"maximumAdvancedAmount\": 0,\n" +
                "      \"useDefault\": 0,\n" +
                "      \"language\": 0,\n" +
                "      \"currentStatusDate\": \"2025-03-29T22:30:49.443Z\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"companies\": [\n" +
                "    {\n" +
                "      \"company\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"addressDetails\": [\n" +
                "    {\n" +
                "      \"openingEffectivedDate\": \"2025-03-29T22:30:49.443Z\",\n" +
                "      \"addressType\": 0,\n" +
                "      \"mainAddressFlag\": 0,\n" +
                "      \"houseNumber\": \"string\",\n" +
                "      \"houseName\": \"string\",\n" +
                "      \"address1\": \"string\",\n" +
                "      \"address2\": \"string\",\n" +
                "      \"city\": \"string\",\n" +
                "      \"postCode\": \"string\",\n" +
                "      \"country\": 0,\n" +
                "      \"province\": \"string\",\n" +
                "      \"postOfficeBox\": \"string\",\n" +
                "      \"state\": 0,\n" +
                "      \"plus4\": \"string\",\n" +
                "      \"addressUnknown\": 0,\n" +
                "      \"municipality\": \"string\",\n" +
                "      \"description\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"contactDetails\": [\n" +
                "    {\n" +
                "      \"openingEffectiveDate\": \"2025-03-29T22:30:49.443Z\",\n" +
                "      \"contactType\": 0,\n" +
                "      \"contactName\": \"string\",\n" +
                "      \"mainContactFlag\": 0,\n" +
                "      \"countryCode\": 0,\n" +
                "      \"phone\": \"string\",\n" +
                "      \"invalidPhoneFlag\": 0,\n" +
                "      \"mobile\": \"string\",\n" +
                "      \"invalidMobileFlag\": 0,\n" +
                "      \"email\": \"string\",\n" +
                "      \"invalidEmailFlag\": 0,\n" +
                "      \"fax\": \"string\",\n" +
                "      \"invalidFaxFlag\": 0,\n" +
                "      \"fromContactHour\": \"2025-03-29T22:30:49.443Z\",\n" +
                "      \"toContactHour\": \"2025-03-29T22:30:49.443Z\",\n" +
                "      \"contactDefaultMethod\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"paymentArrangements\": [\n" +
                "    {\n" +
                "      \"payment\": {\n" +
                "        \"openingEffectiveDate\": \"2025-03-29T22:30:49.443Z\",\n" +
                "        \"arrangementId\": 0,\n" +
                "        \"arrangementType\": 0,\n" +
                "        \"arrangementName\": \"string\",\n" +
                "        \"paymentMethod\": 0,\n" +
                "        \"mainArrangementFlag\": 0,\n" +
                "        \"currency\": 0,\n" +
                "        \"paymentFrequency\": 0,\n" +
                "        \"paymentDay\": 0,\n" +
                "        \"paymentMonth\": 0,\n" +
                "        \"brand\": 0,\n" +
                "        \"collectPeriodTimingMthd\": 0,\n" +
                "        \"externalBillingId\": \"string\"\n" +
                "      },\n" +
                "      \"billing\": {\n" +
                "        \"billingNotice\": 0,\n" +
                "        \"billingFormat\": 0,\n" +
                "        \"billingMethod\": 0,\n" +
                "        \"billingMedia\": 0,\n" +
                "        \"leadTime\": 0\n" +
                "      },\n" +
                "      \"bankAccount\": {\n" +
                "        \"ibanAcctNo\": \"string\",\n" +
                "        \"bankName\": \"string\",\n" +
                "        \"accountName\": \"string\",\n" +
                "        \"country\": 0,\n" +
                "        \"accountType\": 0,\n" +
                "        \"sortCode\": \"string\",\n" +
                "        \"authorization\": 0,\n" +
                "        \"bicCode\": \"string\"\n" +
                "      },\n" +
                "      \"mandate\": {\n" +
                "        \"mandateType\": 0,\n" +
                "        \"mandateStatus\": 0,\n" +
                "        \"mandateId\": \"string\",\n" +
                "        \"mandateStartDate\": \"2025-03-29T22:30:49.443Z\",\n" +
                "        \"mandateEndDate\": \"2025-03-29T22:30:49.443Z\",\n" +
                "        \"mandateReasonCode\": \"string\",\n" +
                "        \"mandateBatchSendRef\": \"string\",\n" +
                "        \"mandateRefusalBatchRef\": \"string\",\n" +
                "        \"soleAuthorisedSignatoryFlag\": 0\n" +
                "      },\n" +
                "      \"creditCardDetails\": {\n" +
                "        \"cardType\": 0,\n" +
                "        \"cardNumber\": \"string\",\n" +
                "        \"cardStatus\": 0,\n" +
                "        \"transactionType\": 0,\n" +
                "        \"expiryDate\": \"2025-03-29T22:30:49.443Z\",\n" +
                "        \"statusDate\": \"2025-03-29T22:30:49.443Z\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"linkagesDetails\": [\n" +
                "    {\n" +
                "      \"linkageType\": 0,\n" +
                "      \"clientLinkageId\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"commissionInformation\": [\n" +
                "    {\n" +
                "      \"company\": 0,\n" +
                "      \"product\": 0,\n" +
                "      \"version\": 0,\n" +
                "      \"sourceCodeRelevence\": 0,\n" +
                "      \"productCommissionstyle\": 0,\n" +
                "      \"commissionFormat\": 0,\n" +
                "      \"indemnityTerms\": 0,\n" +
                "      \"initialCommissionSacrificeType\": 0,\n" +
                "      \"initialCommissionSacrificeFactorType\": 0,\n" +
                "      \"renewalOrLevelCommissionSacrificeType\": 0,\n" +
                "      \"renewalOrLevelCommissionSacrificeFactorType\": 0,\n" +
                "      \"defaultCompanyAgentStatus\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"lettersRecipients\": [\n" +
                "    {\n" +
                "      \"letterCode\": 0,\n" +
                "      \"recipientType\": 0,\n" +
                "      \"role\": 0,\n" +
                "      \"recipientsGroup\": 0,\n" +
                "      \"addressType\": 0,\n" +
                "      \"noOfCopies\": 0,\n" +
                "      \"copyCode\": 0,\n" +
                "      \"linkage\": 0,\n" +
                "      \"priorityInGroup\": 0,\n" +
                "      \"emailFlag\": 0,\n" +
                "      \"postFlag\": 0,\n" +
                "      \"faxFlag\": 0,\n" +
                "      \"mandatoryFlag\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"notes\": [\n" +
                "    {\n" +
                "      \"noteText\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"entityItems\": {\n" +
                "    \"entityType\": 0,\n" +
                "    \"entitySubType\": [\n" +
                "      {\n" +
                "        \"code\": 0,\n" +
                "        \"entityList\": [\n" +
                "          {\n" +
                "            \"entityId\": 0,\n" +
                "            \"value\": \"string\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        return Payload;

    }

}
