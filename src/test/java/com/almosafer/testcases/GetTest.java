package com.almosafer.testcases;


import com.almosafer.apis.GetApis;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Feature("GET API")
public class GetTest {

    @Story("verification GET airline")
    @Test
    public void verification_GET_airline(){


        Response response = GetApis.getFlightInfo();

       assertThat(response.statusCode(),equalTo(200));
       assertThat(response.<String>path("airline[0].code"),is(equalTo("RJ")));
       assertThat(response.<String>path("airline[0].label.en"),is(equalTo("Royal Jordanian")));

    }


    @Story("verification GET airport")
    @Test
    public void verification_GET_airport (){

        Response response = GetApis.getFlightInfo();

        assertThat(response.statusCode(),equalTo(200));
        assertThat(response.<String>path("airport[0].code"),is(equalTo("AQJ")));
        assertThat(response.<String>path("airport[0].tz"),is(equalTo("Asia/Amman")));
        assertThat(response.<String>path("airport[0].timeZone"),is(equalTo("2.00")));
        assertThat(response.<String>path("airport[0].type"),is(equalTo("4")));
        assertThat(response.<String>path("airport[0].label.en"),is(equalTo("King Hussein International Airport")));
        assertThat(response.<String>path("airport[0].country.label.en"),is(equalTo("Jordan")));
        assertThat(response.<String>path("airport[0].country.code"),is(equalTo("JO")));
        assertThat(response.<String>path("airport[0].city.en"),is(equalTo("Aqaba")));

    }



}
