package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2";
        response = given()
                .when()
                .get("users")
                .then().statusCode(200);
    }

    @Test
    //01.Extract all Ids
    public void test01() {
        List<Integer> allIds = response.extract().path("id");
        System.out.println("The List Of All IDs : " + allIds);
    }

    //02.Extract all names
    @Test
    public void test02() {
        List<String> names = response.extract().path("name");
        System.out.println("List of names : " + names);
    }

    @Test
    // 03.Test to extract the name of 5th object
    public void test003() {
        String name = response.extract().path("name[4]");
        System.out.println("The Name On The 5th Object : " + name);
    }

    //04. Test to extract all names having inactive status
    @Test
    public void test004() {
        List<String> allNamesWithStatusInactive = response.extract().path("findAll{it.status == 'inactive'}.name");
        System.out.println("The List Of Names Having Inactive Status : " + allNamesWithStatusInactive);
    }

    @Test
    //05. Test to extract all genders having active status
    public void test05() {
        List<String> allGendersWithStatusActive = response.extract().path("findAll{it.status == 'active'}.gender");
        System.out.println("The List Of All Genders Having Active Status : " + allGendersWithStatusActive);
    }

    @Test
    //06. Test to extract all names having female gender
    public void test06() {
        List<String> allNamesWithGenderFemale = response.extract().path("findAll{it.gender == 'female'}.name");
        System.out.println("The List Of All Names Having Female Gender : " + allNamesWithGenderFemale);
    }

    @Test
    //07.Test to extract all emails having inactive status
    public void test07() {
        List<String> allEmailsWithStatusInactive = response.extract().path("findAll{it.status == 'inactive'}.email");
        System.out.println("The List Of Emails having Inactive Status :" + allEmailsWithStatusInactive);
    }

    @Test
    public void test008() { //08 Test to extract all IDs having male gender
        List<Integer> allIdsWithMaleGender = response.extract().path("findAll{it.gender == 'male'}.id");
        System.out.println("The List Of All IDs Having Male Gender : " + allIdsWithMaleGender);
    }

    @Test
    public void test009() { //09. Test to extract all status
        List<String> allStatuses = response.extract().path("status");
        System.out.println("The List Of All Statuses : " + allStatuses);
    }

    @Test
    public void test010() { //10. Test to extract email of a name
        System.out.println("The Email Of Anish Desai : " + response.extract().path("findAll{it.name == 'Anish Desai'}.email"));
    }

    @Test
    public void test011() { //11.Test to extract gender of ID 2406415
        System.out.println("The Gender Of ID 2406416 : " + response.extract().path("findAll{it.id == 2406415}.gender"));
    }
}






