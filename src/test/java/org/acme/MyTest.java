package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;


@Disabled
@QuarkusTest
public class MyTest {

    @Test
    public void testHelloEndpoint() {
        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body("{ \"an order\": { \"header\": \"John Doe's whishlist\", \"items\" : [ { \"name\": \"a\", \"qty\": 1 }, { \"name\": \"b\", \"qty\": 2 } ] } }")
        .when()
            .post("/myOrder")
        .then()
            .statusCode(200)
            .body("'Decision-1'", notNullValue());
    }

}