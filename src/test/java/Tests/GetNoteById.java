package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class GetNoteById {
	
	@Test
	public void getNoteById() {
		
		Response res = given()
				.headers("Authorization", "Bearer "+ ApiRoutes.TOKEN)
				.when()
				.get(ApiRoutes.GET_ID+"6a32dc1cd1c35dfced39d92c");
		
		res.then()
		.statusCode(200);
		
		res.prettyPrint();
	}
	
	@Test
	public void getNoteByIdPathParam() {
		
		String note_id = "6a32dc1cd1c35dfced39d92c";
		
		Response res = given()
				.headers("Authorization", "Bearer "+ ApiRoutes.TOKEN)
				.pathParam("id", note_id)
				.when()
				.get(ApiRoutes.GET_ID_PATH_PARAM);
		
		res.then()
		.statusCode(200);
		
		res.prettyPrint();
	}

}
