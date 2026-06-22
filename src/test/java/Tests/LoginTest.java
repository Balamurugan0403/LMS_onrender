package Tests;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginTest {

    @Test
    public void validLogin() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "sam@gmail.com");
        payload.put("password", "123");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/user/login");
        response.then().statusCode(201);
        response.prettyPrint();
        String message = response.jsonPath().getString("message[0].value");
        Assert.assertEquals(message, "Admin logged in successfully");
    }

    @Test
    public void invalidEmail() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "invalid@gmail.com");
        payload.put("password", "123");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/user/login");
        response.then().statusCode(400);
        response.prettyPrint();
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
                .post("/user/login");
        response.then().statusCode(400);
        response.prettyPrint();
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
                .post("/user/login");
        response.then().statusCode(400);
        response.prettyPrint();
        String message = response.jsonPath().getString("message[0].value");
        Assert.assertEquals(message, "All fields are required");
    }
}
