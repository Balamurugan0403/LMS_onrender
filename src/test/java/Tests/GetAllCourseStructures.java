package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class GetAllCourseStructures {

	@Test
	public void getAllCourseStructures() {
		
		Response res = given()
				.headers("Authorization", "Bearer "+ ApiRoutes.TOKEN)
				.when()
				.get(ApiRoutes.COURSE_STRUCTURE);	
		
		res.then()
		.statusCode(200);
		
		res.prettyPrint();
	}
}
