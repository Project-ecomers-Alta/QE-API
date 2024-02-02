package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ecommerceapp.EcommerceApp;
import starter.utils.Constants;

import java.io.File;

public class OrderStepDef {
    @Steps
    EcommerceApp ecommerceApp;
    @Given("Post order with json {string}")
    public void postOrderWithJson(String json) {
        File postOrder = new File (Constants.REQ_BODY + json);
        ecommerceApp.postOrder(postOrder);
    }

    @When("Send request post order")
    public void sendRequestPostOrder() {
        SerenityRest.when().post(EcommerceApp.POST_GET_ORDER);
    }

    @Given("Get order user")
    public void getOrderUser() {
        ecommerceApp.getOrder();
    }

    @When("Send request get order")
    public void sendRequestGetOrder() {
        Response response = SerenityRest.when().get(EcommerceApp.POST_GET_ORDER);
        int orderID = response.jsonPath().get("data[0].Id");
        System.out.println("Order ID: " + orderID);
    }

    @Given("Order id {int}")
    public void orderId(int id) {
        ecommerceApp.cancelOrders(id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(EcommerceApp.CANCEL_ORDERS);
    }
}
