package starter.ecommerceapp;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class EcommerceApp {
    public static String REGISTER_USER = Constants.BASE_URL + "/register";
    public static String LOGIN_USER = Constants.BASE_URL + "/login";


    @Step ("Register User")
    public void registerUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Login User")
    public void loginUser (File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

}
