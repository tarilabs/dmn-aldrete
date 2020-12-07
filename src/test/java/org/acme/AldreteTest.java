package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class AldreteTest {

    @Test
    public void testAldrete() {
        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body("{\r\n  \"Respiration\": \"Able to take deep breath and cough\",\r\n  \"O2 Saturation\": \"Maintains >92% on room air\",\r\n  \"Consciousness\": \"Fully awake\",\r\n  \"BP mm Hg compared to reference\": 10,\r\n  \"Extremities able to move\": 4\r\n}")
        .when()
            .post("/aldrete")
        .then()
            .statusCode(200)
            .body("'Aldrete score'", is(10))
            .body("'Patient dimission'", is("Patient can exit surgical unit"));
    }
}