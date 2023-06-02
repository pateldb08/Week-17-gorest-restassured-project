package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class UserAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in";
        RestAssured.basePath= "/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }
    //1. Verify the if the total record is 20
    @Test
    public void test01(){
        response.body(("size()"),equalTo((10)));
    }
    //2.verify that a particular id has the required name
    @Test
    public void test02(){
        response.body("findAll{it.id == 2368367}.name", hasItem("Avadhesh Singh"));
    }
    @Test
    //3. Test to verify that a particular id has the required name
    public void test03(){
        response.body("name",hasItem("Rajendra Patel"));
    }
    @Test
    //4.// Test to verify that the response body has list of names
    public void test04(){
        response.body("name", hasItems("Nawal Khanna","Dulari Kakkar","Dayaanidhi Agarwal"));
    }
    @Test
    //5. test to verify that the userId has this email
    public void test05(){
        response.body("findAll{it.id =='2358938'}.email", hasItem("iii_bakula_kakkar@mohr-pfeffer.example"));
    }
    //6.status is active for perticular user name
    @Test
    public void  test06(){
        response.body("findAll{it.name == 'Rajendra Patel'}.status", hasItem("active"));
    }
   // 7.verify the gender by name
    @Test
    public void test07(){
        response.body("findAll{it.name== 'Rajendra Patel'}.gender",hasItem("female"));
    }


    @Test
    public void test08(){
        response.body("findAll{it.id == '2406416'}.email",hasItem("anish_desai@kreiger.example"));
    }








}
