package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HealthCheckTest extends BaseTest {

	@Test
	public void healthCheck() {

		Response response = RestAssured.given().when().get("/");

		System.out.println("Status Code: " + response.getStatusCode());
		response.then().statusCode(200);
		response.prettyPrint();
		Assert.assertTrue(response.getBody().asString().contains("API Running"), "Health check failed!");
	}
}