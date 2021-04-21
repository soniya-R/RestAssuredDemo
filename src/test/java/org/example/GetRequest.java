package org.example;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetRequest {

    /**
     * Getting details of all employees
     */
    @Test
    public void getAllEmployeeDetails() {
        baseURI = "http://dummy.restapiexample.com/";
        // Response response =
        given().log().all()
                .contentType("application/json")
                .when()
                .get("api/v1/employees")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    /**
     * Getting detail of specific employee
     */
    @Test
    public void getSingleEmployeeDetails() {
        baseURI = "http://dummy.restapiexample.com/";
        String response = given()
                .contentType("application/json")
                .when()
                .get("api/v1/employee/14")
                .then()
                .log().all()
                .assertThat().statusCode(200).extract().response().asString();
        System.out.println(response);
    }
}
