package com.gorest.testbase;

import io.restassured.RestAssured;
import org.junit.Before;

public class TestBase {
    @Before
    public static void inIt(){
        RestAssured.baseURI = "http://gorest.co.in";
        RestAssured.basePath="/public/v2";
    }


}
