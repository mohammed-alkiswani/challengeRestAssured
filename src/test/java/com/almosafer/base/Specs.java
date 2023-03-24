package com.almosafer.base;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Specs {


    public static String getEnv(){

        String env = System.getProperty("env", "PRODUCTION");
        String baseURL ;

        if ("PRODUCTION".equals(env)) {
            baseURL = "https://www.almosafer.com";
        } else {
            throw new RuntimeException("Env not supported");
        }
        return baseURL;

    }

    public static RequestSpecification getRequestSpec(){
        return given()
                .baseUri(getEnv())
                .contentType(ContentType.JSON)
                .log().all();


    }
}
