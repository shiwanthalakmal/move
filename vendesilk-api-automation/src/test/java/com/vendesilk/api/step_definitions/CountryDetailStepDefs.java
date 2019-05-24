package com.vendesilk.api.step_definitions;

import com.google.gson.JsonObject;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public class CountryDetailStepDefs {

    Response response;
    ValidatableResponse validatableResponse;

    @Given("^The webservice is up and running$")
    public void theWebserviceIsUpAndRunning() {
        given().get("/").then().statusCode(200);
    }

    @When("^User wants to get information for all countries$")
    public void userEntersTheUrlForAllCountries() {
        validatableResponse = given().get("/all").then();
        response = validatableResponse.extract().response();
    }

    @Then("^the response code should be \"([^\"]*)\"$")
    public void theStatusCodeShouldBe(String statusCode) throws Throwable {
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }

    @And("^the response should be returned in a valid JSON format$")
    public void theResponseShouldBeReturnedInAValidJSONFormat() {
        URL schema_path = this.getClass().getClassLoader().getResource("schema/test-api-country-schema");
        validatableResponse.body(matchesJsonSchema(new File(schema_path.getPath())));
    }

    @And("^the returned response should include the following countries$")
    public void theReturnedResponseShouldIncludeTheFollowingCountries(DataTable table) {
        List<String> countries = new ArrayList<String>();
        countries = table.asList(String.class);
        for (String country : countries) {
            validatableResponse.assertThat().body("RestResponse.result.alpha2_code", hasItem(country));
        }
    }

    @When("^User wants to get the response for country \"([^\"]*)\"$")
    public void userWantsToGetTheResponseForCountry(String country) {
        validatableResponse = given().get("/iso2code/" + country).then();
        response = validatableResponse.extract().response();
    }


    @And("^the returned response should include \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
    public void theReturnedResponseShouldIncludeAnd(String name, String alpha2code, String alpha3code) {
        validatableResponse.assertThat()
                .root("RestResponse")
                .body("messages", hasItem("Country found matching code [" + alpha2code + "]."))
                .appendRoot("result")
                .body("name", is(name))
                .body("alpha2_code", is(alpha2code))
                .body("alpha3_code", is(alpha3code));
    }

    @When("^User wants to get information for unexisted country: \"([^\"]*)\"$")
    public void userWantsToGetInformationForUnexistedCountry(String countryCode) {
        validatableResponse = given().get("/iso2code/" + countryCode).then();
        response = validatableResponse.extract().response();
    }

    @But("^no results should be returned$")
    public void noResultsShouldBeReturned() {
        validatableResponse.assertThat().body("RestResponse", not(hasKey("result")));
    }

    @And("^a message should be returned saying \"([^\"]*)\" not found$")
    public void aMessageShouldBeReturnedSayingNotFound(String countryCode) {
        validatableResponse.assertThat()
                .body("RestResponse.messages", hasItem("No matching country found for requested code [" + countryCode + "]."));
    }

    @When("^User wants to add a new country: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void userWantsToAddANewCountry(String name, String alpha2code, String alpha3code) {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");

        JsonObject country = new JsonObject();
        country.addProperty("name", name);
        country.addProperty("alpha2_code", alpha2code);
        country.addProperty("alpha3_code", alpha3code);

        httpRequest.body(country.toString());

        validatableResponse = httpRequest.post("/register").then();
        response = validatableResponse.extract().response();
    }
}
