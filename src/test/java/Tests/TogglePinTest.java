package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class TogglePinTest {

    @Test
    public void togglePin() {

        String noteId = "6a32dc1cd1c35dfced39d92c";

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .pathParam("id", noteId)
        .when()
                .put(ApiRoutes.TOGGLE_PIN_PATH_PARAM);

        res.then()
                .statusCode(200);

        res.prettyPrint();
    }
}