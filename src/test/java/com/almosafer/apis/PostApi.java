package com.almosafer.apis;

import com.almosafer.base.Specs;
import com.almosafer.data.Route;
import com.almosafer.models.Pojopost;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class PostApi {

    public static Response getreviews(Pojopost pojopost){

         return given()
                   .spec(Specs.getRequestSpec())
                   .header("x-api-key","apikey-hotel")
                   .body(pojopost)

                .when()
                   .post(Route.POST_ROUTE)

                .then()
                   .log().all()
                   .extract().response();
    }
}
