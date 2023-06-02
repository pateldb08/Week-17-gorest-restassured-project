package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostExtractionTest {

        static ValidatableResponse response;

        @BeforeClass
        public static void inIt() {
            RestAssured.baseURI = "http://gorest.co.in/public/v2";
            response = given()
                    .when()
                    .get("/posts")
                    .then().statusCode(200);
        }
    // 01.Test to extract the title of a particular record
    @Test
    public void test01() {
        List<String> titles = response.extract().path("title");
        System.out.println("The list of all titles : " + titles);
    }
    //02. Test to extract total number of records
    @Test
    public void test02(){
        int numberOfRecords = response.extract().path("size()");
        System.out.println("The total number of records :" + numberOfRecords);
        //System.out.println("The Total Number Of Records : " + response.extract().path("size()"));
    }
    //03.Test to extract the response body of a particular record
    @Test
    public void test03(){
            String responseBody = response.extract().path("body[5]");
        System.out.println("The response body of the 6th record is :" + responseBody);
      //  System.out.println("The Response Body Of Record Number 6 : " + response.extract().path("body[5]"));
    }
    //04.Extract all user_id
    @Test
    public void test004() {
        System.out.println("The User IDs Of All Records : " + response.extract().path("user_id"));
    }
    //05. extract all titles from the response body
    @Test
    public void test005() { // Test to extract all titles from the response body
        System.out.println("All Titles From The Response Body : " + response.extract().path("title"));
    }
    //06. extract the response body by id
    @Test
    public void test006() {
        System.out.println("The Response Body Of Record Having ID As 40867 : " + response.extract().path("findAll{it.id == 40868}.body"));
    }
    //07.  extract the title of a particular record
    @Test
    public void test007() {
        System.out.println("The Title Of ID 40868: " + response.extract().path("findAll{it.id == 40868}.title"));
    }






    }
