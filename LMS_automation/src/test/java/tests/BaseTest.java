package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTest {

	public static String token;

	@BeforeSuite
	public void setup() {

		RestAssured.baseURI = "https://lms-server-3-wedg.onrender.com/";
		//baseURI is the static variable used for all methods in rest assured to avoid repetition of base url in every method
		Map<String, Object> payload = new HashMap<>();

		payload.put("email", "sam@gmail.com");
		payload.put("password", "123");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).post("/user/login");

		token = response.jsonPath().getString("token");

		System.out.println("Generated Token:");
		System.out.println(token);
	}
}