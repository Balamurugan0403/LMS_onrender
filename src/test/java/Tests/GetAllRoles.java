package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class GetAllRoles {

	@Test
	public void getAllRoles() {
		
		Response res = given()
				.headers("Authorization", "Bearer "+ ApiRoutes.TOKEN)
				.when()
				.get(ApiRoutes.ROLES);
		
		res.then()
		.statusCode(200);
		
		res.prettyPrint();
		
	}
	
	@Test
	public void getAllRolesWithoutToken() {
		
		Response res = when()
				.get(ApiRoutes.ROLES);
		
		res.then()
		.statusCode(401);
		
		res.prettyPrint();
		
	}
}
