package br.com.viccari.dev;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import br.com.viccari.dev.dtos.SizeDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import javax.ws.rs.core.MediaType;

@QuarkusTest
class SizeResourceTest {

    @Test
    void testHelloEndpoint() {
        var dto = SizeDTO.builder()
            .description("aaa")
            .shortDescription("bbb")
            .sizeRange("111")
        .build();

        given()
          .when()
            .body(dto)
            .contentType(MediaType.APPLICATION_JSON)
            .post("/hello")
          .then()
             .statusCode(201)
             .body(notNullValue());
    }

}