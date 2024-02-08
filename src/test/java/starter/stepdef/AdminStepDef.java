package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ecommerceapp.EcommerceApp;
import starter.ecommerceapp.EcommerceAppResponses;

import static org.hamcrest.Matchers.equalTo;

public class AdminStepDef {

    @Steps
    EcommerceApp ecommerceApp;

    @Given("Get all users by admin")
    public void getAllUsersByAdmin() {
        ecommerceApp.getAllUser();
    }

    @When("Send request get all users")
    public void sendRequestGetAllUsers() {
        SerenityRest.when().get(EcommerceApp.GET_ALL_USERS);
    }

    @Given("Get users by admin with parameter {string}")
    public void getUsersByAdminWithId(String param) {
        ecommerceApp.getUsers(param);
    }

    @When("Send request get users")
    public void sendRequestGetUsers() {
        SerenityRest.when().get(EcommerceApp.GET_USERS);
    }

    @And("Response body data username was {string}")
    public void responseBodyDataUsernameWas(String param) {
        SerenityRest.and().body(EcommerceAppResponses.DATA_USERNAME_USERS, equalTo(param));
    }

    @Given("Get all orders by admin")
    public void getAllOrdersByAdmin() {
        ecommerceApp.getAllOrders();
    }

    @Given("Get orders by admin with id {int}")
    public void getOrdersByAdminWithId(int id) {
        ecommerceApp.getOrders(id);
    }
    @When("Send request get all orders")
    public void sendRequestGetAllOrders() {
        SerenityRest.when().get(EcommerceApp.GET_ALL_ORDERS);
    }

    @When("Send request get orders")
    public void sendRequestGetOrders() {
        SerenityRest.when().get(EcommerceApp.GET_ORDERS);
    }

    @And("Response body data id orders was {int}")
    public void responseBodyDataIdOrdersWas(int id) {
        SerenityRest.and().body(EcommerceAppResponses.DATA_ID_ORDERS, equalTo(id));
    }

    @Given("Get all users by user")
    public void getAllUsersByUser() {
        ecommerceApp.getAllUserByUser();
    }

    @Given("Get users by user with parameter {string}")
    public void getUsersByUserWithParameter(String parameter) {
        ecommerceApp.getUsersByUser(parameter);
    }

    @Given("Get all orders by user")
    public void getAllOrdersByUser() {
        ecommerceApp.getOrdersByUser();
    }

    @Given("Get orders by user with id {int}")
    public void getOrdersByUserWithId(int id) {
        ecommerceApp.getOrderWithIDByUser(id);
    }
}
