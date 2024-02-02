package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ecommerceapp.EcommerceApp;
import starter.utils.Constants;

import java.io.File;

public class RegisterUserStepDef {
    @Steps
    EcommerceApp ecommerceapp;

    @Given ("Register user with json {string}")
    public void registerUser (String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY + json);
        ecommerceapp.registerUser(jsonRegisterUser);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(EcommerceApp.REGISTER_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+ json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Register user without username {string}")
    public void registerUserWithoutUsername(String json) {
        File jsonRegisterInvalidUsername = new File(Constants.REQ_BODY + json);
        ecommerceapp.registerUser(jsonRegisterInvalidUsername);
    }

    @Given("Register user without email {string}")
    public void registerUserWithoutEmail(String json) {
        File jsonRegisterInvalidEmail = new File(Constants.REQ_BODY + json);
        ecommerceapp.registerUser(jsonRegisterInvalidEmail);
    }

    @Given("Register user without password {string}")
    public void registerUserWithoutPassword(String json) {
        File jsonRegisterInvalidPassword = new File(Constants.REQ_BODY + json);
        ecommerceapp.registerUser(jsonRegisterInvalidPassword);
    }

    @Given("Register user without domicile {string}")
    public void registerUserWithoutDomicile(String json) {
        File jsonRegisterInvalidDomicile = new File(Constants.REQ_BODY + json);
        ecommerceapp.registerUser(jsonRegisterInvalidDomicile);
    }

    @Given("Register user invalid email {string}")
    public void registerUserInvalidEmail(String json) {
        File jsonRegisterInvalidEmail2 = new File(Constants.REQ_BODY + json);
        ecommerceapp.registerUser(jsonRegisterInvalidEmail2);
    }

    @Given("Register user password minimum {string}")
    public void registerUserPasswordMinimum(String json) {
        File jsonRegisterPasswordMinimum = new File(Constants.REQ_BODY + json);
        ecommerceapp.registerUser(jsonRegisterPasswordMinimum);
    }
}
