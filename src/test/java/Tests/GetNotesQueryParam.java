package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class GetNotesQueryParam {
	
	@Test
	public void getNotesQueryParam() {
		
		Response res = given()
				.headers("Authorization", "Bearer "+ ApiRoutes.TOKEN)
				.when()
				.get(ApiRoutes.GETALL_NOTES+"?limit=2&sortOrder=desc");
		
		res.then().statusCode(200);
		res.prettyPrint();
	}
	
	@Test
	public void getNotesQueryParams() {
		
		Response res = given()
				.headers("Authorization", "Bearer "+ ApiRoutes.TOKEN)
				.queryParam("limit", 2)
                .queryParam("sortOrder", "desc")
				.when()
				.get(ApiRoutes.GETALL_NOTES);
		
		res.then().statusCode(200);
		res.prettyPrint();
	}

}
