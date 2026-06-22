package tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNote extends BaseTest{
	@Test
    public void createNote() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "API Test Note");
        payload.put("content", "Created by tester");
        payload.put("tags", Arrays.asList("qa", "demo"));
        payload.put("isPinned", false);
        payload.put("color", "#ffeb3b");

        Response res = RestAssured.given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/create/notes");

        res.then().statusCode(201);
        res.prettyPrint();

        String message = res.jsonPath().getString("message");
        System.out.println(message); 
        String noteId = res.jsonPath().getString("data._id");
        System.out.println("Created Note ID: " + noteId);
	}

}
