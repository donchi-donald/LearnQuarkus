package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {



    @Test
    public void shouldGetAllBooks(){
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
            .get("/api/books")
        .then()
            .statusCode(200)
            .body("size()", is(3));

    }
    @Disabled @Test
    public void shouldCountAllBooks(){
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .when()
            .get("/api/books/count")
        .then()
            .statusCode(200)
        .body( is("3"));
    }

    @Test
    public void shouldGetABook(){
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .pathParams("id", 1)
            .when()
        .get("/api/books/{id}")
            .then()
        .statusCode(200)
            .body("title", is("Amour de vie"))
            .body("author", is("Donald Donchi"))
            .body("genre", is("Romantique"))
            .body("id", is(1))
            .body("yearOfPublication", is(2022));

    }

    @BeforeAll
    public static void initializeBooks(){

    }

}
