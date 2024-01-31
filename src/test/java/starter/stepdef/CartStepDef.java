package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ecommerceapp.EcommerceApp;
import starter.utils.Constants;

import java.io.File;

public class CartStepDef {
    @Steps
    EcommerceApp ecommerceapp;

    @Given("Post cart with json {string}")
    public void postCartWithJson(String json) {
        File postCart = new File (Constants.REQ_BODY + json);
        ecommerceapp.postCart(postCart);
    }

    @When("Send request post cart")
    public void sendRequestPostCart() {
        SerenityRest.when().post(EcommerceApp.POST_CART);
    }

    @Given("Get all carts")
    public void getAllCarts() {
        ecommerceapp.getAllCart();
    }

    @When("Send request get all carts")
    public void sendRequestGetAllCarts() {
        SerenityRest.when().get(EcommerceApp.GET_CART);
    }
}
