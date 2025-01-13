package htl.leo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class PersonEndpointTest {

    @Test
    public void testCreatePerson() {
        String jsonBody = "{ \"name\": \"John Doe\", \"age\": 30 }";

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("/persons")
                .then()
                .statusCode(200)
                .body("name", equalTo("John Doe"))
                .body("age", equalTo(30));
    }

    @Test
    public void testGetAllPersons() {
        // Ensure some people exist first
        given()
                .contentType("application/json")
                .body("{\"name\":\"Jane Doe\", \"age\": 25}")
                .when()
                .post("/persons")
                .then()
                .statusCode(200);

        // Now test GET /persons
        given()
                .when()
                .get("/persons")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}
