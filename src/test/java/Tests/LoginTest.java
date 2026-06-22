package Tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import routes.ApiRoutes;

public class LoginTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ApiRoutes.BASE_URL;
    }

    @Test
    public void validLogin() {

        Map<String, Object> payload = new HashMap<>();

        payload.put("email", "sam@gmail.com");
        payload.put("password", "123");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/user/login");

        response.prettyPrint();

        response.then().statusCode(201);

        String message = response.jsonPath().getString("message[0].value");

        Assert.assertEquals(message, "Admin logged in successfully");

        String token = response.jsonPath().getString("token");

        Assert.assertNotNull(token);
        Assert.assertFalse(token.isEmpty());

        System.out.println("Generated Token : " + token);
    }

    @Test
    public void invalidEmail() {

        Map<String, Object> payload = new HashMap<>();

        payload.put("email", "invalid@gmail.com");
        payload.put("password", "123");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/user/login");

        response.prettyPrint();

        response.then().statusCode(400);

        String message = response.jsonPath().getString("message[0].value");

        Assert.assertEquals(message, "Email is invalid");
    }

    @Test
    public void invalidpassword() {

        Map<String, Object> payload = new HashMap<>();

        payload.put("email", "sam@gmail.com");
        payload.put("password", "wrongpassword");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/user/login");

        response.prettyPrint();

        response.then().statusCode(400);

        String message = response.jsonPath().getString("message[0].value");

        Assert.assertEquals(message, "Password is incorrect");
    }

    @Test
    public void missingFields() {

        Map<String, Object> payload = new HashMap<>();

        payload.put("email", "");
        payload.put("password", "");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/user/login");

        response.prettyPrint();

        response.then().statusCode(400);

        String message = response.jsonPath().getString("message[0].value");

        Assert.assertEquals(message, "All fields are required");
    }
}
