package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostsAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2";
        response = given()
                .when()
                .get("/posts")
                .then().statusCode(200);
    }
    // Test to verify the total number of records displayed on a page
    @Test
    public void test001() {
        response.body(("size()"), equalTo(10));
    }

    // Test to verify the title of  ID
    @Test
    public void test002() {
        response.body("findAll{it.id == 40868}.title", hasItem("Taedium vesco amet est amiculum."));
    }
    @Test
    public void test003() { // Test to verify that a particular ID exists or not
        response.body("findAll{it}.id", hasItem(38981));
    }

    @Test
    public void test004() { // Test to verify That multiple IDs exist
        response.body("findAll{it}.id", hasItems(38981, 38980, 38979));
    }
    // Test to verify the body of  ID
    @Test
    public void test005() {
        response.body("findAll{it.id == 40868}.body", hasItem("Est cupressus tonsor. Copia illum cubitum. Aureus assentator blanditiis. Benigne demergo aut. Quae nihil angulus. Sub temeritas volutabrum. Denuncio coma degenero. Undique cubitum accommodo. Via quos vita. Pecus turbo termes. Cum cornu venia. Pecco concido cornu. Doloremque aperte deprimo. Degenero templum comminor. Utique undique tero. Turpe adnuo voluptatum. Et ater vomito."));
    }






}
