package org.example;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteRequest {
    @Test
    /**
     *  Deleting and asserting the status code and message
     */
    public void deleteData() {
        baseURI = "http://dummy.restapiexample.com/";
        given()
                .contentType("application/json")
                .when()
                .delete("public/api/v1/delete/2")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("message", equalTo("Successfully! Record has been deleted"));
    }

}
