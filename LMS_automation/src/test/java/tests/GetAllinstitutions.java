package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllinstitutions extends BaseTest{
	@Test
	public void getAllInstitutions() {
		Response response = RestAssured.given().when().get("/getAll/institution");
		response.then().statusCode(200);
		response.prettyPrint();
//		String mes=response.jsonPath().getString("message");
//		System.out.println(mes);
	}

}
