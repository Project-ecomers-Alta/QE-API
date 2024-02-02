package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ecommerceapp.EcommerceApp;
import starter.utils.Constants;

import java.io.File;

public class UserStepDef {

    @Steps
    EcommerceApp ecommerceapp;
    @Given("Get user login")
    public void getUserLogin() {
        ecommerceapp.getUserLogin();
    }

    @When("Send request get user login")
    public void sendRequestGetUserLogin() {
        SerenityRest.when().get(EcommerceApp.USER_DATA);
    }

    @Given("Update user with valid data {string}")
    public void updateUserWithValidData(String json) {
        File jsonUpdateUserData = new File(Constants.REQ_BODY + json);
        ecommerceapp.putUserValidData(jsonUpdateUserData);
    }

    @When("Send request update user data")
    public void sendRequestUpdateUserData() {
        SerenityRest.when().put(EcommerceApp.USER_DATA);
    }

    @Given("Get user shop")
    public void getUserShop() {
        ecommerceapp.getUserShop();
    }

    @When("Send request get user shop")
    public void sendRequestGetUserShop() {
        SerenityRest.when().get(EcommerceApp.USER_SHOP);
    }

    @Given("Update user shop with valid data {string}")
    public void updateUserShopWithValidData(String json) {
        File jsonUpdateUserShopValidData = new File(Constants.REQ_BODY + json);
        ecommerceapp.putUserValidShop(jsonUpdateUserShopValidData);
    }

    @When("Send request update user shop")
    public void sendRequestUpdateUserShop() {
        SerenityRest.when().put(EcommerceApp.USER_SHOP);
    }

    @Given("Delete user login data")
    public void deleteUserLoginData() {
        ecommerceapp.deleteUserLoginData();
    }

    @When("Send request delete user login data")
    public void sendRequestDeleteUserLoginData() {
        SerenityRest.when().delete(EcommerceApp.USER_DATA);
    }
}
