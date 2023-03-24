package com.almosafer.apis;

import com.almosafer.base.Specs;
import com.almosafer.data.Route;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetApis {

    public static Response getFlightInfo(){

        return given()
                .spec(Specs.getRequestSpec())

                .when()
                   .get(Route.GET_ROUTE)

                .then()
                    .log().all()
                     .extract().response();

    }
}
