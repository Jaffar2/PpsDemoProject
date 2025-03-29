package restutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

import static io.restassured.RestAssured.requestSpecification;


public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String,String>headers) {
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .log().all();
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request body is ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        //System.out.println("====================***************"+ response.getBody().prettyPrint());
        ExtentReportManager.logJson(response.getBody().prettyPrint());

    }
    private static void printResponseLogInReportFail(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logFailureDetails("Response body is ");
        //System.out.println("====================***************"+ response.getBody().prettyPrint());
        ExtentReportManager.logHTML(response.getBody().prettyPrint());

    }

    public static Response performPost(String endPoint, String requestPayload, Map<String,String>headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response =  requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String,String>headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response =  requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endPoint, Object requestPayloadAsPojo, Map<String,String>headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayloadAsPojo, headers);
        Response response =  requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
    //public static Response performGet(String endpoint, Map<String,String> headers){
          //return getRequestSpecification(endpoint,"",headers).get();
    public static Response performGet(String endpoint, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, "", headers);
        Response response=requestSpecification.get();
        printRequestLogInReport(requestSpecification);
        if(response.statusCode()==404) {
            printResponseLogInReportFail(response);
        }
        else {
            printResponseLogInReport(response);
        }
        return response;

    }
}
