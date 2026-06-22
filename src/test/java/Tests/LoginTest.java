package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import payload.LoginPayload;
import routes.ApiRoutes;

public class LoginTest {

    @Test
    public void validLoginTest() {

        Response res = given()
                .contentType(ContentType.JSON)
                .body(LoginPayload.getLoginBody("sam@gmail.com", "123"))
                .when()
                .post(ApiRoutes.LOGIN);

        res.then().statusCode(201);
        res.prettyPrint();
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"sam@gmail.comm", "123"},
                {"sam@gmail.com", "1234"},
                {"", ""},
                {"", "123"},
                {"sam@gmail.com", ""}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(String email, String password) {

        Response res = given()
                .contentType(ContentType.JSON)
                .body(LoginPayload.getLoginBody(email, password))
                .when()
                .post(ApiRoutes.LOGIN);

        res.then().statusCode(400);
    }
}