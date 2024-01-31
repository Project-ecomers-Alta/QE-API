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
}
