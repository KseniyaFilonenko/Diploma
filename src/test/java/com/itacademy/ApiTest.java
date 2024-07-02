package com.itacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class ApiTest {
    @BeforeTest
    public void setUpTest() {
        RestAssured.baseURI = "https://belita-shop.by";
    }

    @Test
    public void getResponseToVerifyServerHeaderTest() {
        Response response = given().log().all()
                .when().get("/auth/")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.getHeader("Server"), "nginx");
    }

    @Test
    public void getResponseToVerifyContentEncodingHeaderTest() {
        Response response = given().log().all()
                .when().get("/oplata-i-dostavka/")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.getHeader("Content-Encoding"), "gzip");
    }

    @Test
    public void postLoginTest() {
        File file = new File("src/test/resources/json/existedUser.json");
        given().log().all().contentType(ContentType.JSON).body(file)
                .when().post("/auth/?login=yes")
                .then().log().body().statusCode(200);
    }
    @Test
    public void postAddToCartTest() {
        Response response = given().header("Content-Type", "application/x-www-form-urlencoded")
                .body("action=addInBasket&id=41270&quantity=1&basket=%2Fpersonal%2Fcart%2F&order=%2Fpersonal%2Forder%2F&currency=BYN")
                .log().all()
                .when().post("/local/templates/.default/components/bitrix/sale.basket.basket.small/dbBasket/ajax.php")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
    }
}
