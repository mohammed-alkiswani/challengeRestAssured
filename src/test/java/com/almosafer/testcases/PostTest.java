package com.almosafer.testcases;

import com.almosafer.apis.PostApi;
import com.almosafer.models.Pojopost;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.Description;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Feature("POST API")
public class PostTest {


    @Story("verification productId")
    @Test
    public void verification_productId() {

        Pojopost pojopost = new Pojopost("1492981","Newest");

        Response response = PostApi.getreviews(pojopost);

        assertThat(response.statusCode(),equalTo(200));
        assertThat(response.<String>path("productId"),is(equalTo(pojopost.getProductId())));
        assertThat(response.<Integer>path("paging.totalResults"),equalTo(67));
        assertThat(response.<Integer>path("paging.totalPages"),equalTo(7));
        assertThat(response.<Integer>path("paging.pageSize"),equalTo(10));
        assertThat(response.<Integer>path("paging.currentPageNumber"),equalTo(0));
        assertThat(response.<String>path("paging.nextPageUrl"),is(equalTo("pageNo=1&pageSize=10&filters=&sortBy=Newest&imageOnly&totalResults=67&totalPages=7")));

    }

    @Story("verification reviews")
    @Test
    public void verification_reviews() {

        Pojopost pojopost = new Pojopost("1492981","Newest");

        Response response = PostApi.getreviews(pojopost);


        assertThat(response.statusCode(),equalTo(200));
        assertThat(response.<String>path("reviews[1].id"),is(equalTo( "64103d84f8a992380430b1ec")));
        assertThat(response.path("reviews[1].id"),is(not(equalTo(null) )));
        assertThat(response.<String>path("reviews[1].detail.likable"),is(equalTo( "The space of the room")));
        assertThat(response.<String>path("reviews[1].detail.unlikable"),is(equalTo( "The parking area")));
        assertThat(response.<String>path("reviews[1].detail.headline"),is(equalTo( "Good experience ")));
        assertThat(response.<String>path("reviews[1].detail.travelType"),is(equalTo( "Friends")));
        assertThat(response.<String>path("reviews[1].detail.checkout"), is(lessThanOrEqualTo(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))));
        assertThat(response.<String>path("reviews[1].detail.checkoutPhrase"),is(equalTo( "2 weeks ago")));

    }


}
