package starter.ecommerceapp;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class EcommerceApp {
    public static String REGISTER_USER = Constants.BASE_URL + "/register";
    public static String LOGIN_USER = Constants.BASE_URL + "/login";
    public static String LOGIN_ADMIN = Constants.BASE_URL + "/login";
    public static String GET_ALL_USERS = Constants.BASE_URL + "/users";
    public static String GET_USERS = Constants.BASE_URL + "/users?search={param}";
    public static String GET_ALL_ORDERS = Constants.BASE_URL + "/orders";
    public static String GET_ORDERS = Constants.BASE_URL + "/orders?search={id}";
    public static String USER_DATA = Constants.BASE_URL + "/user";
    public static String USER_SHOP = Constants.BASE_URL + "/user/shop";
    public static String PRODUCT_USER = Constants.BASE_URL + "/product";
    public static String PRODUCT_SALES = Constants.BASE_URL + "/product-penjualan";
    public static String GET_PRODUCTS = Constants.BASE_URL + "/products?search={param}";
    public static String GET_PRODUCT_ID = Constants.BASE_URL + "/product/{id}";
    public static String UPDATE_PRODUCT_ID = Constants.BASE_URL + "/product/{id}";
    public static String POST_IMAGE = Constants.BASE_URL + "/product/{id}/image";
    public static String DELETE_IMAGE = Constants.BASE_URL + "/product/{product_id}/image/{image_id}";
    public static String POST_CART = Constants.BASE_URL + "/cart";
    public static String GET_CART = Constants.BASE_URL + "/cart";


    @Step ("Register User")
    public void registerUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Login User")
    public void loginUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Login Admin")
    public void loginAdmin (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Post Product")
    public void postProduct (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Get Product Sales")
    public void getProductSales () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step ("Get All Products")
    public void getAllProducts () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step ("Get Product with Parameter")
    public void getProductsWithParam (String param) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("param", param);
    }

    @Step ("Get Product with Product ID")
    public void getProductWithID (int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id);
    }

    @Step ("Get Product with Invalid Product ID")
    public void getProductWithInvalidProductID (String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id);
    }

    @Step ("Update Product")
    public void updateProduct (int id, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Post Image")
    public void postImage (int id, File image) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id)
                .multiPart("image", image, "image/jpg");
    }

    @Step ("Delete image")
    public void deleteImage (int product_id, int image_id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("product_id", product_id)
                .pathParam("image_id", image_id);
    }


    @Step ("Post cart")
    public void postCart (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Get All Cart")
    public void getAllCart () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step ("Get all users by admin")
    public void getAllUser (){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.ADMIN_TOKEN);
    }

    @Step ("Get users by admin with parameter")
    public void getUsers(String param){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.ADMIN_TOKEN)
                .pathParam("param", param);
    }

    @Step ("Get all orders by admin")
    public void getAllOrders(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.ADMIN_TOKEN);
    }

    @Step ("Get Orders by admin with id")
    public void getOrders(int id){
            SerenityRest.given()
                    .header("Authorization", "Bearer " + Constants.ADMIN_TOKEN)
                    .pathParam("id", id);
        }
    @Step ("Get user login")
    public void getUserLogin(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    @Step ("Put User with valid data")
    public void putUserValidData(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }
    @Step ("Get user shop")
    public void getUserShop(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    @Step ("Update user shop with valid data")
    public void putUserValidShop(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }
    @Step ("Delete user login data")
    public void deleteUserLoginData(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
