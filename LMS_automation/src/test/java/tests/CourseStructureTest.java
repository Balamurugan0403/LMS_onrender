package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CourseStructureTest extends BaseTest {

	@Test
	public void getAllCourses() {

		Response response = RestAssured.given().header("Authorization", "Bearer "+token).when()
				.get("/courses-structure/getAll");

		System.out.println("Status Code: " + response.getStatusCode());

		response.prettyPrint();
		response.then().statusCode(200);
		
	}
}
