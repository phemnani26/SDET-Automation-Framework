
package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import api.PayloadBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class ApiSteps {

    Response response;

    @Given("user sends GET request")
    public void user_sends_get_request() {

        response =
                given()
                .when()
                .get("https://echo.free.beeceptor.com/sample-request?author=beeceptor");

        response.prettyPrint();
    }

    @Then("validate GET response status code")
    public void validate_get_response_status_code() {

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "GET Status Code Validation Failed");
    }

    @And("validate path field")
    public void validate_path_field() {

        String path =
                response.jsonPath()
                        .getString("path");

        System.out.println("PATH = " + path);

        Assert.assertNotNull(path);
    }

    @And("validate ip field")
    public void validate_ip_field() {

        String ip =
                response.jsonPath()
                        .getString("ip");

        System.out.println("IP = " + ip);

        Assert.assertNotNull(ip);
    }

    @And("validate headers")
    public void validate_headers() {

        Assert.assertNotNull(
                response.jsonPath()
                        .getMap("headers"));

        System.out.println("Headers validated");
    }

    @Given("user sends POST request")
    public void user_sends_post_request() {

        response =
                given()
                .header("Content-Type", "application/json")
                .body(PayloadBuilder.createOrderPayload())
                .when()
                .post("https://echo.free.beeceptor.com/sample-request?author=beeceptor");

        response.prettyPrint();
    }

    @Then("validate POST response status code")
    public void validate_post_response_status_code() {

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "POST Status Code Validation Failed");
    }

    @And("validate customer information")
    public void validate_customer_information() {

        String name =
                response.jsonPath()
                        .getString("parsedBody.customer.name");

        Assert.assertEquals(
                name,
                "Jane Smith");
    }

    @And("validate payment information")
    public void validate_payment_information() {

        String method =
                response.jsonPath()
                        .getString("parsedBody.payment.method");

        Assert.assertEquals(
                method,
                "credit_card");
    }

    @And("validate product information")
    public void validate_product_information() {

        String product =
                response.jsonPath()
                        .getString("parsedBody.items[0].name");

        Assert.assertEquals(
                product,
                "Wireless Headphones");
    }
}

