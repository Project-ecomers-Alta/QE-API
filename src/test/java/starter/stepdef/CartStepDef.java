package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
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
        Response response = SerenityRest.when().get(EcommerceApp.GET_CART);
        int cartID = response.jsonPath().get("data[0].id");
        System.out.println("Cart ID: " + cartID);
    }

    @Given("Delete all carts")
    public void deleteAllCarts() {
        ecommerceapp.deleteCart();
    }

    @When("Send request delete all carts")
    public void sendRequestDeleteAllCarts() {
        SerenityRest.when().delete(EcommerceApp.DELETE_CART);
    }

    @Given("Delete all carts with json {string}")
    public void deleteAllCartsWithJson(String json) {
        File deleteCart = new File (Constants.REQ_BODY + json);
        ecommerceapp.postCart(deleteCart);
    }

    @When("Send request get all carts have been deleted")
    public void sendRequestGetAllCartsHaveBeenDeleted() {
        SerenityRest.when().get(EcommerceApp.GET_CART);
    }
}
