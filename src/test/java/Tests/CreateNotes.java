package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import payload.NotesPayload;
import routes.ApiRoutes;
public class CreateNotes {
	
	@Test
	public void createNotes() {
		
		Response res = given()
				.headers("Authorization", "Bearer "+ ApiRoutes.TOKEN)
				.contentType("application/json")
				.body(NotesPayload.getNotes())
				.when()
				.post(ApiRoutes.NOTES);
		
		res.then().statusCode(201);
		
		res.prettyPrint();
		
				
		
	}

}
