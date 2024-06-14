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
        LOGGER.info("Setting up the base URI for RestAssured");
        RestAssured.baseURI = "https://belita-shop.by";
    }

    @Test
    public void getPosts() {
        LOGGER.info("Starting test: getPosts");
        given().log().all()
                .when().get("")
                .then().log().body().statusCode(200);
        LOGGER.info("Test getPosts completed successfully");
    }

    @Test
    public void getResponseToVerifyServerHeader() {
        LOGGER.info("Starting test: getResponseToVerifyServerHeader");
        Response response = given().log().all()
                .when().get("/auth/")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.getHeader("Server"), "nginx");
        LOGGER.info("Test getResponseToVerifyServerHeader completed successfully");
    }

    @Test
    public void getResponseToVerifyContentEncodingHeader() {
        LOGGER.info("Starting test: getResponseToVerifyContentEncodingHeader");
        Response response = given().log().all()
                .when().get("/oplata-i-dostavka/")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.getHeader("Content-Encoding"), "gzip");
        LOGGER.info("Test getResponseToVerifyContentEncodingHeader completed successfully");
    }

    @Test
    public void getResponseToVerifyPragmaHeader() {
        LOGGER.info("Starting test: getResponseToVerifyPragmaHeader");
        File file = new File("src/test/resources/json/newUser.json");
        Response response = given().log().all()
                .when().post("/auth/?login=yes")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
        LOGGER.info("Test getResponseToVerifyPragmaHeader completed successfully");
    }
}
