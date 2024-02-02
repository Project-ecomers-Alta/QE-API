package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ecommerceapp.EcommerceApp;
import starter.ecommerceapp.EcommerceAppResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {
    @Steps
    EcommerceApp ecommerceapp;

    @Given("Login user with json {string}")
    public void loginUserWithJson(String json) {
        File jsonLoginUser = new File (Constants.REQ_BODY+json);
        ecommerceapp.loginUser(jsonLoginUser);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        Response response = SerenityRest.when().post(EcommerceApp.LOGIN_USER);
        String tokenUser = response.jsonPath().get("data.token");
        System.out.println("Token User: " + tokenUser);
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) {
        SerenityRest.and().body(EcommerceAppResponses.MESSAGE, equalTo(message));
    }

    @Given("Login admin with json {string}")
    public void loginAdminWithJson(String json) {
        File jsonLoginAdmin = new File (Constants.REQ_BODY+json);
        ecommerceapp.loginAdmin(jsonLoginAdmin);
    }

    @When("Send request post login admin")
    public void sendRequestPostLoginAdmin() {
        Response response = SerenityRest.when().post(EcommerceApp.LOGIN_ADMIN);
        String tokenAdmin = response.jsonPath().get("data.token");
        System.out.println("Token Admin: " + tokenAdmin);
    }

    @Given("Update password with valid data {string}")
    public void updatePasswordWithValidData(String json) {
        File jsonUpdatePassword = new File(Constants.REQ_BODY + json);
        ecommerceapp.updatePassword(jsonUpdatePassword);
    }

    @When("Send request update password")
    public void sendRequestUpdatePassword() {
        SerenityRest.when().put(EcommerceApp.UPDATE_PASSWORD);
    }

    @Given("Login user without email {string}")
    public void loginUserWithoutEmail(String json) {
        File jsonLoginUserWithoutEmail = new File (Constants.REQ_BODY+json);
        ecommerceapp.loginAdmin(jsonLoginUserWithoutEmail);
    }

    @Given("Login user without password {string}")
    public void loginUserWithoutPassword(String json) {
        File jsonLoginUserWithoutPassword = new File (Constants.REQ_BODY+json);
        ecommerceapp.loginAdmin(jsonLoginUserWithoutPassword);
    }

    @Given("Login user invalid email {string}")
    public void loginUserInvalidEmail(String json) {
        File jsonLoginUserInvalidEmail = new File (Constants.REQ_BODY+json);
        ecommerceapp.loginAdmin(jsonLoginUserInvalidEmail);
    }

    @Given("Update password without input data {string}")
    public void updatePasswordWithoutInputData(String json) {
        File jsonUpdatePasswordWithoutInput = new File(Constants.REQ_BODY + json);
        ecommerceapp.updatePassword(jsonUpdatePasswordWithoutInput);
    }

    @Given("Update password minimum {string}")
    public void updatePasswordMinimum(String json) {
        File jsonUpdatePasswordMinimum = new File(Constants.REQ_BODY + json);
        ecommerceapp.updatePassword(jsonUpdatePasswordMinimum);
    }
}
