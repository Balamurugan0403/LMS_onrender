package tests;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RolesTest extends BaseTest {

	@Test
	public void getRoles() {

		Response response = RestAssured.given()
		        .log().all()
		        .header("Authorization", "Bearer " + token)
		        .when()
		        .get("/roles/getAll");
		
		System.out.println("Status Code : " + response.getStatusCode());
		System.out.println("pretty print data");
		response.prettyPrint();
		
		System.out.println("log data");
		response.then().log().all();
		response.then().statusCode(200);
		System.out.println("the allowed methods:"+response.getHeader("Allow"));
		System.out.println("the roles are");
		List<String> roles = response.jsonPath().getList("roles.originalRole");

		for(String role : roles) {
		    System.out.println(role);
		}
	}
}