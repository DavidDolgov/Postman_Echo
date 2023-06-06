package ru.netology;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldReturnInfoFromPostmanEcho() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Отправляемый текст")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Отправляемый текст"));
    }
}
