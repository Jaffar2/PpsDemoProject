package restutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    // Method to create the RequestSpecification
    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    // Method to log request details in the Extent report
    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        // Query the request specification to extract the details
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);

        // Log details in the Extent report
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
    }

    // Method to log the successful response details
    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        // Log the full response body, ensuring it is not too large
        String responseBody = response.getBody().prettyPrint();

        // Check if the body is too large (e.g., more than 1000 characters)
        if (responseBody.length() > 1000) {
            String bodySnippet = responseBody.substring(0, 1000) + "...";
            ExtentReportManager.logInfoDetails("Response body (snippet): ");
            ExtentReportManager.logJson(bodySnippet);
        } else {
            // Log the entire response body if it's small enough
            ExtentReportManager.logInfoDetails("Response body is ");
            ExtentReportManager.logJson(responseBody);
        }
    }

    // Method to log response details when the request fails
    private static void printResponseLogInReportFail(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());

        // Log the response body, only a snippet if it's too large
        String responseBody = response.getBody().asString();
        String bodySnippet = responseBody.length() > 1000 ? responseBody.substring(0, 1000) + "..." : responseBody;
        ExtentReportManager.logFailureDetails("Response body is ");
        ExtentReportManager.logHTML(bodySnippet);
    }

    // Method to handle logging based on status codes
    private static void handleStatusCode(Response response) {
        int statusCode = response.getStatusCode();
        switch (statusCode) {
            case 200:
                ExtentReportManager.logInfoDetails("200 OK - The request was successful.");
                printResponseLogInReport(response);
                break;
            case 201:
                ExtentReportManager.logInfoDetails("201 Created - The resource was successfully created.");
                printResponseLogInReport(response);
                break;
            case 400:
                ExtentReportManager.logFailureDetails("400 Bad Request - The request was invalid.");
                printResponseLogInReportFail(response);
                break;
            case 401:
                ExtentReportManager.logFailureDetails("401 Unauthorized - Authentication is required.");
                printResponseLogInReportFail(response);
                break;
            case 403:
                ExtentReportManager.logFailureDetails("403 Forbidden - The request was valid, but the server is refusing action.");
                printResponseLogInReportFail(response);
                break;
            case 404:
                ExtentReportManager.logFailureDetails("404 Not Found - The requested resource could not be found.");
                printResponseLogInReportFail(response);
                break;
            case 405:
                ExtentReportManager.logFailureDetails("405 Method Not Allowed - The method specified in the request is not allowed.");
                printResponseLogInReportFail(response);
                break;
            case 408:
                ExtentReportManager.logFailureDetails("408 Request Timeout - The server timed out waiting for the request.");
                printResponseLogInReportFail(response);
                break;
            case 500:
                ExtentReportManager.logFailureDetails("500 Internal Server Error - The server encountered an error.");
                printResponseLogInReportFail(response);
                break;
            case 502:
                ExtentReportManager.logFailureDetails("502 Bad Gateway - The server received an invalid response from the upstream server.");
                printResponseLogInReportFail(response);
                break;
            case 503:
                ExtentReportManager.logFailureDetails("503 Service Unavailable - The server is currently unavailable.");
                printResponseLogInReportFail(response);
                break;
            case 504:
                ExtentReportManager.logFailureDetails("504 Gateway Timeout - The server did not receive a timely response.");
                printResponseLogInReportFail(response);
                break;
            default:
                ExtentReportManager.logFailureDetails(statusCode + " - Unexpected Status Code.");
                printResponseLogInReportFail(response);
                break;
        }
    }
    // Perform POST request with String payload
    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        // Log request and response after the request is made
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        // Handle status code and log the relevant information
        handleStatusCode(response);
        return response;
    }
    // Perform POST request with Map payload
    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        handleStatusCode(response);
        return response;
    }

    // Perform POST request with POJO payload
    public static Response performPost(String endPoint, Object requestPayloadAsPojo, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayloadAsPojo, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        handleStatusCode(response);
        return response;
    }

    // Perform GET request
    public static Response performGet(String endpoint, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, "", headers);
        Response response = requestSpecification.get();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        handleStatusCode(response);
        return response;
    }
}




