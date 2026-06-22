package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllNotes extends BaseTest {
	@Test
    public void getAllNotes() {
        Response res = RestAssured.given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .queryParam("page", 1)
                .queryParam("limit", 50)
                .queryParam("sortBy", "lastEdited")
                .queryParam("sortOrder", "desc")
                .when()
                .get("/getAll/notes");

        res.then().statusCode(200);
        res.prettyPrint();

        int totalNotes = res.jsonPath().getInt("pagination.totalNotes");
        System.out.println("Total Notes: " + totalNotes);
    }
}