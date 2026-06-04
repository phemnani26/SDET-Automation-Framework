package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import api.PayloadBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import util.Log;

public class ApiSteps {

    Response response;

    @Given("user sends GET request")
    public void user_sends_get_request() {

        response =
                given()
                .when()
                .get("https://echo.free.beeceptor.com/sample-request?author=beeceptor");

        response.prettyPrint();

        Log.logger.info("GET request sent successfully");
    }

    @Then("validate GET response status code")
    public void validate_get_response_status_code() {

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "GET Status Code Validation Failed");

        Log.logger.info("GET Status Code validated successfully");
    }

    @And("validate path field")
    public void validate_path_field() {

        String path =
                response.jsonPath()
                        .getString("path");

        Log.logger.info("PATH = " + path);

        Assert.assertEquals(
                path,
                "/sample-request?author=beeceptor",
                "Path Validation Failed");

        Log.logger.info("Path validated successfully");
    }

    @And("validate ip field")
    public void validate_ip_field() {

        String ip =
                response.jsonPath()
                        .getString("ip");

        Log.logger.info("IP = " + ip);

        Assert.assertNotNull(
                ip,
                "IP is null");

        Assert.assertTrue(
                ip.contains(":"),
                "IP format validation failed");

        Log.logger.info("IP validated successfully");
    }

    @And("validate headers")
    public void validate_headers() {

        Assert.assertNotNull(
                response.jsonPath()
                        .getMap("headers"));

        Log.logger.info("Headers validated successfully");
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

        Log.logger.info("POST request sent successfully");
    }

    @Then("validate POST response status code")
    public void validate_post_response_status_code() {

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "POST Status Code Validation Failed");

        Log.logger.info("POST Status Code validated successfully");
    }

    @And("validate customer information")
    public void validate_customer_information() {

        String name =
                response.jsonPath()
                        .getString("parsedBody.customer.name");

        String email =
                response.jsonPath()
                        .getString("parsedBody.customer.email");

        String phone =
                response.jsonPath()
                        .getString("parsedBody.customer.phone");

        Assert.assertEquals(
                name,
                "Jane Smith");

        Assert.assertEquals(
                email,
                "janesmith@example.com");

        Assert.assertEquals(
                phone,
                "1-987-654-3210");

        Log.logger.info(
                "Customer information validated successfully");
    }

    @And("validate payment information")
    public void validate_payment_information() {

        String method =
                response.jsonPath()
                        .getString("parsedBody.payment.method");

        String transactionId =
                response.jsonPath()
                        .getString("parsedBody.payment.transaction_id");

        Float amount =
                response.jsonPath()
                        .getFloat("parsedBody.payment.amount");

        String currency =
                response.jsonPath()
                        .getString("parsedBody.payment.currency");

        Assert.assertEquals(
                method,
                "credit_card");

        Assert.assertEquals(
                transactionId,
                "txn_67890");

        Assert.assertEquals(
                amount,
                111.97f);

        Assert.assertEquals(
                currency,
                "USD");

        Log.logger.info(
                "Payment information validated successfully");
    }

    @And("validate product information")
    public void validate_product_information() {

        String productId =
                response.jsonPath()
                        .getString("parsedBody.items[0].product_id");

        String productName =
                response.jsonPath()
                        .getString("parsedBody.items[0].name");

        int quantity =
                response.jsonPath()
                        .getInt("parsedBody.items[0].quantity");

        Float price =
                response.jsonPath()
                        .getFloat("parsedBody.items[0].price");

        Assert.assertEquals(
                productId,
                "A101");

        Assert.assertEquals(
                productName,
                "Wireless Headphones");

        Assert.assertEquals(
                quantity,
                1);

        Assert.assertEquals(
                price,
                79.99f);

        Log.logger.info(
                "Product information validated successfully");
    }
}