package StepDef;

import com.mongodb.BasicDBObject;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.cert.CollectionCertStoreParameters;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDef {

    private String endpointUrl = "http://localhost:8083/device  ";
    private String endpointUrls = "http://localhost:8083/device";
    private String Url = "http://localhost:8083/device/";

    private Response response;
    private String requestBody;
    private String deviceId;


    @When("I make a POST request to {string} endpoint")
    public void i_make_a_POST_request_to_endpoint(String endpoint) {
        // Construct the request body with sample data, without the id field
        requestBody = "{\"id\":\"6406006a2214d790fc5065d6\",\"name\":\"New device\",\"ip\":\"192.168.0.100\"}";

        // Send a POST request with the request body to the specified endpoint
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(endpointUrls);
    }

    @Then("I should receive a response with status code {int} and message show the newly added data")
    public void i_should_receive_a_response_with_status_code_and_message_show_the_newly_added_data(int expectedStatusCode) {
        // Verify that the response status code matches the expected status code
        assertEquals(expectedStatusCode, response.getStatusCode());

        // Verify that the response body contains the name and ip of the newly added data
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("\"id\":\"6406006a2214d790fc5065d6\""));
        assertTrue(responseBody.contains("\"name\":\"New device\""));
        assertTrue(responseBody.contains("\"ip\":\"192.168.0.100\""));
    }

    @When("I make a GET request to start {string} endpoint")
    public void i_make_a_get_request_to_start_endpoint(String endpoint) {
        response = RestAssured.get(endpointUrl);

    }


    @Then("I should receive a message")
    public void iShouldReceiveAMessage() {
        response.getBody().asString();

    }

    @When("I make a DELETE request to {string} endpoint")
    public void iMakeADELETERequestToEndpoint(String endpoint) {
        deviceId = "6406006a2214d790fc5065d6";
        response = RestAssured.given()
                .pathParam("id", deviceId)
                .delete(Url + "{id}");

        }

    @Then("I should receive a response with status code {int}")
    public void iShouldReceiveAResponseWithStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
    }


    