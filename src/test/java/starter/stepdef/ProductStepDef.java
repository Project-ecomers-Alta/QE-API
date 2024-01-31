package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.internal.util.SafeExceptionRethrower;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.ecommerceapp.EcommerceApp;
import starter.ecommerceapp.EcommerceAppResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ProductStepDef {
    @Steps
    EcommerceApp ecommerceapp;

    @Given("Post product with json {string}")
    public void postProductWithJson(String json) {
        File jsonProduct = new File (Constants.REQ_BODY + json);
        ecommerceapp.postProduct(jsonProduct);
    }

    @When("Send request post product")
    public void sendRequestPostProduct() {
        SerenityRest.when().post(EcommerceApp.PRODUCT_USER);
    }

    @Given("Get list product sales")
    public void getListProductSales() {
        ecommerceapp.getProductSales();
    }

    @When("Send request get product sales")
    public void sendRequestGetProductSales() {
        Response response = SerenityRest.when().get(EcommerceApp.PRODUCT_SALES);
        int productID = response.jsonPath().get("data[0].id");
        int imageID = response.jsonPath().get("data[0].details_images[0].id");
        System.out.println("Product ID: " + productID);
        System.out.println("Image ID: " + imageID);
    }

    @Given("Get all products")
    public void getAllProducts() {
        ecommerceapp.getAllProducts();
    }

    @When("Send request get all products")
    public void sendRequestGetAllProducts() {
        SerenityRest.when().get(EcommerceApp.PRODUCT_USER);
    }

    @Given("Get product with parameter {string}")
    public void getProductWithParameterString(String param) {
        ecommerceapp.getProductsWithParam(param);
    }

    @When("Send request get product with parameter")
    public void sendRequestGetProductWithParameter() {
        SerenityRest.when().get(EcommerceApp.GET_PRODUCTS);
    }

    @And("Response body data category was {string}")
    public void responseBodyDataCategoryWasString(String param) {
        SerenityRest.and().body(EcommerceAppResponses.DATA_CATEGORY, equalTo(param));
    }

    @Given("Product with id {int}")
    public void getProductWithId(int id) {
        ecommerceapp.getProductWithID(id);
    }

    @When("Send request get product with id")
    public void sendRequestGetProductWithId() {
        SerenityRest.when().get(EcommerceApp.GET_PRODUCT_ID);
    }

    @And("Response body data id was {int}")
    public void responseBodyDataIdWas(int id) {
        SerenityRest.and().body(EcommerceAppResponses.DATA_PRODUCT_ID, equalTo(id));
    }

    @Given("Get product with invalid id {string}")
    public void getProductWithInvalidId(String id) {
        ecommerceapp.getProductWithInvalidProductID(id);
    }

    @Given("Update product data with product id {int} and json {string}")
    public void updateProductDataWithProductId(int id, String json) {
        File jsonUpdateProduct = new File (Constants.REQ_BODY + json);
        ecommerceapp.updateProduct(id, jsonUpdateProduct);
    }

    @When("Send request put product data")
    public void sendRequestPutProductData() {
        SerenityRest.when().put(EcommerceApp.UPDATE_PRODUCT_ID);
    }

    @When("Send request delete product")
    public void sendRequestDeleteProduct() {
        SerenityRest.when().delete(EcommerceApp.GET_PRODUCT_ID);
    }

    @Given("Product with id {int} and image {string}")
    public void productWithIdAndImage(int id, String image) {
        File imageProduct = new File (Constants.IMAGE_DIR, image);
       ecommerceapp.postImage(id, imageProduct);
    }

    @When("Send request post image")
    public void sendRequestPostImage() {
        SerenityRest.when().post(EcommerceApp.POST_IMAGE);
    }

    @Given("Product with id {int} and image with id {int}")
    public void productWithIdAndImageWithId(int product_id, int image_id) {
        ecommerceapp.deleteImage(product_id, image_id);
    }

    @When("Send request delete image")
    public void sendRequestDeleteImage() {
        SerenityRest.when().delete(EcommerceApp.DELETE_IMAGE);
    }
}
