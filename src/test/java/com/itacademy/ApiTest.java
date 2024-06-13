package com.itacademy;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class ApiTest {
    private static final Logger LOGGER = LogManager.getLogger(ApiTest.class);
    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://belita-shop.by";
    }

    @Test
    public void getPosts() {
        given().log().all()
                .when().get("")
                .then().log().body().statusCode(200);
    }

    @Test
    public void getResponseToVerifyServerHeader() {
        Response response = given().log().all()
                .when().get("/auth/")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.getHeader("Server"), "nginx");
    }

    @Test
    public void getResponseToVerifyContentEncodingHeader() {
        Response response = given().log().all()
                .when().get("/oplata-i-dostavka/")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.getHeader("Content-Encoding"), "gzip");
    }

    @Test
    public void getResponseToVerifyPragmaHeader() {
        File file = new File("src/test/resources/json/newUser.json");
        Response response = given().log().all()
                .when().post("/auth/?login=yes")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
    }
}
