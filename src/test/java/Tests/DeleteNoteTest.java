package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class DeleteNoteTest {

    @Test
    public void deleteSingleNote() {

        String noteId = "6a32dc1cd1c35dfced39d92c";

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .pathParam("id", noteId)
        .when()
                .delete(ApiRoutes.DELETE_NOTE_PATH_PARAM);

        res.then()
                .statusCode(200);

        res.prettyPrint();
    }

    @Test
    public void deleteMultipleNotes() {

        String id1 = "6a32dc1cd1c35dfced39d92c";
        String id2 = "6a32dc1cd1c35dfced39d92d";

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
        .when()
                .delete(ApiRoutes.DELETE_NOTES + id1 + "/" + id2);

        res.then()
                .statusCode(200);

        res.prettyPrint();
    }

    @Test
    public void deleteInvalidId() {

        String invalidId = "abc";

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .pathParam("id", invalidId)
        .when()
                .delete(ApiRoutes.DELETE_NOTE_PATH_PARAM);

        res.then()
                .statusCode(400);

        res.prettyPrint();
    }
}