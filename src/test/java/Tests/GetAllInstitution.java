package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class GetAllInstitution {

	@Test
	public void getAllInstitution() {
		
		Response res = 	when()
				.get(ApiRoutes.INSTITUTION);
		res.then()
		.statusCode(200);
		
		res.prettyPrint();
	}
}
