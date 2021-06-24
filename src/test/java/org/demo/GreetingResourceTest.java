package org.demo;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().accept(ContentType.TEXT).get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello"));
    }

    @Test
    public void testHelloEndpointHtml() {
        given()
          .when().accept(ContentType.HTML).get("/hello")
          .then()
             .statusCode(200)
             .body(is("<html><body><font style='color:blue;font-size:24;'>Hello HTML</font></body></html>"));
    }

    @Test
    public void testHelloEndpointXml() {
        given()
          .when().accept(ContentType.XML).get("/hello")
          .then()
             .statusCode(200)
             .body(is("<?xml version=\"1.0\"?><hello>Hello XML</hello>"));
    }
    
    @Test
    public void testHelloEndpointJson() {
        given()
          .when().accept(ContentType.JSON).get("/hello")
          .then()
             .statusCode(200)
             .body(is("{message:'Hello JSON'}"));
    }
 
}