package Tests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import routes.ApiRoutes;

public class UpdateNoteTest {

    @Test
    public void updateNote() {

        String noteId = "6a32dc1cd1c35dfced39d92c";

        Map<String, Object> payload = new HashMap<>();

        payload.put("title", "API Test Note (edited)");
        payload.put("content", "Updated content");

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", noteId)
                .body(payload)
        .when()
                .put(ApiRoutes.UPDATE_NOTE_PATH_PARAM);

        res.then()
                .statusCode(200);

        res.prettyPrint();
    }
}