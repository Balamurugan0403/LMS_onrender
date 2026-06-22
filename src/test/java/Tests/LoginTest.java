package Tests;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
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

        String message = res.jsonPath().getString("message[0].value");
        Assert.assertEquals(message, "Admin logged in successfully");
        
        String token = res.jsonPath().getString("token");
        Assert.assertNotNull(token);
        Assert.assertFalse(token.isEmpty());


        String email = res.jsonPath().getString("user.email");
        Assert.assertEquals(email, "sam@gmail.com");

  
        String institution = res.jsonPath().getString("institutionName");
        Assert.assertEquals(institution, "PSG");

        res.prettyPrint();
    }

 
    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                // email,              password,  expectedMessage
                {"sam@gmail.comm",    "123",     "Email is invalid"},
                {"sam@gmail.com",     "1234",    "Password is incorrect"},
                {"",                  "",        "All fields are required"},
                {"",                  "123",     "All fields are required"},
                {"sam@gmail.com",     "",        "All fields are required"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(String email, String password, String expectedMessage) {
        Response res = given()
                .contentType(ContentType.JSON)
                .body(LoginPayload.getLoginBody(email, password))
                .when()
                .post(ApiRoutes.LOGIN);

      
        res.then().statusCode(400);

        String actualMessage = res.jsonPath().getString("message[0].value");
        Assert.assertEquals(actualMessage, expectedMessage);

        res.prettyPrint();
    }
}
