package tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllRoles extends BaseTest {

    @Test
    public void getroles() {
        Response res = RestAssured.given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .when()
                .get("/roles/getAll");

        res.then().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void getrolesWithoutToken() {
        Response res = RestAssured.given()
                .when()
                .get("/roles/getAll");
        res.then().statusCode(401);
        res.prettyPrint();
    }
}