package com.example.ecoandrich.api;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.ecoandrich.persistence.DepartmentLocationResponse;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DepartmentControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }
    
    @Test
    void 부서_및_지역_정보를_페이징하여_조회한다() {
        // when
        ExtractableResponse<Response> response = given().log().all()
                .contentType(JSON)
                .get("/department")
                .then()
                .log().all()
                .extract();

        // then
        List<DepartmentLocationResponse> body = response.jsonPath().getList("", DepartmentLocationResponse.class);
        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(200),
                () -> assertThat(body).hasSize(10)
        );
    }

    @Test
    void 존재하지_않는_페이지면_예외() {
        // when
        ExtractableResponse<Response> response = given().log().all()
                .contentType(JSON)
                .get("/department?page=100")
                .then()
                .log().all()
                .extract();

        // then
        assertThat(response.statusCode()).isNotEqualTo(200);
    }
}
