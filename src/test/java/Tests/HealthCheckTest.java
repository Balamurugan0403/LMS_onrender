package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class HealthCheckTest {
	
	@Test
	public void healthCheck() {

	    Response res = given()
	            .when()
	            .get(ApiRoutes.HEALTH);

	    res.then()
	       .statusCode(200);

	    System.out.println("Response Body:");
	    res.prettyPrint();
	}
}
