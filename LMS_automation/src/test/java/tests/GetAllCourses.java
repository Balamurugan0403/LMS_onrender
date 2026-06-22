package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllCourses {
	@Test
	public void getAllCourseStructures() {
	    Response res = RestAssured.given()
	            .header("Authorization", "Bearer " + BaseTest.token)
	            .when()
	            .get("/courses-structure/getAll");

	    res.then().statusCode(200);
	    res.prettyPrint();
	}	

}
