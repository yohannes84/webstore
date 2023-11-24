package com.example.pms.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import java.util.Collections;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

class ProductControllerTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    void testGettingAllProducts() {
        // add the Products
        ProductDTO product1 = ProductDTO.builder()
                .productNumber(654654656)
                .name("ideal vaseline")
                .price(345.78)
                .description("vaseline for vegans")
                .noInStock(5)
                .reviews(Collections.emptyList())
                .build();

        ProductDTO product2 = ProductDTO.builder()
                .productNumber(654674656)
                .name("ideal lotion")
                .price(345.56)
                .description("lotion for vegans")
                .noInStock(4)
                .reviews(Collections.emptyList())
                .build();

        given()
                .contentType("application/json")
                .body(product1)
                .when().post("/api/products").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(product2)
                .when().post("/api/products").then()
                .statusCode(201);
        Response response = given().when().get("/api/products");
        System.out.println(response.getBody().asString());

        // get all products and verify
        given()
                .when().get("/api/products").then()
                .statusCode(200)
                .and()
                .body("productNumber", hasItems(654654656, 654674656))
                .body("name", hasItems("ideal vaseline", "ideal lotion"))
                .body("price", hasItems(345.78f, 345.56f));

        //cleanup
        given()
                .when()
                .delete("/654654656");
        given()
                .when()
                .delete("/654674656");
    }

    @Test
    public void testGetOneProduct() {
        // add the product to be fetched
        ProductDTO product = ProductDTO.builder()
                .productNumber(654654656)
                .name("Maveriks")
                .price(345.78)
                .description("vaseline for vegans")
                .noInStock(5)
                .reviews(Collections.emptyList())
                .build();
        given()
                .contentType("application/json")
                .body(product)
                .when().post("/api/products").then()
                .statusCode(201);
        // test getting the product
        given()
                .when()
                .get("/api/products/654654656")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("productNumber",equalTo(654654656))
                .body("name",equalTo("Maveriks"))
                .body("price",equalTo(345.78f));
        //cleanup
        given()
                .when()
                .delete("/api/products/654654656");
    }

    @Test
    public void testDeleteProduct() {
        // add the product to be deleted
        ProductDTO product = ProductDTO.builder()
                .productNumber(654654656)
                .name("Maveriks")
                .price(345.78)
                .description("vaseline for vegans")
                .noInStock(5)
                .reviews(Collections.emptyList())
                .build();

        given()
                .contentType("application/json")
                .body(product)
                .when().post("/api/products").then()
                .statusCode(201);

        given()
                .when()
                .delete("/api/products/654654656");

        given()
                .when()
                .get("/api/products/654654656")
                .then()
                .statusCode(404)
                .and()
                .body("message",equalTo("Product not found with id: 654654656"));
    }

    @Test
    public void testUpdateProduct() {
        // add the product
        ProductDTO product = ProductDTO.builder()
                .productNumber(654654656)
                .name("ideal vaseline")
                .price(345.78)
                .description("vaseline for vegans")
                .noInStock(5)
                .reviews(Collections.emptyList())
                .build();

        ProductDTO updatedProduct = ProductDTO.builder()
                .productNumber(654654656)
                .name("ideal vaseline")
                .price(245.56)
                .description("vaseline for vegans")
                .noInStock(2)
                .reviews(Collections.emptyList())
                .build();

        given()
                .contentType("application/json")
                .body(product)
                .when().post("/api/products").then()
                .statusCode(201);
        //update product
        given()
                .contentType("application/json")
                .body(updatedProduct)
                .when().put("/api/products/"+updatedProduct.getProductNumber()).then()
                .statusCode(200);
        // get the product and verify
        given()
                .when()
                .get("/api/products/654654656")
                .then()
                .statusCode(200)
                .and()
                .body("productNumber",equalTo(654654656))
                .body("price",equalTo(245.56f))
                .body("noInStock",equalTo(2));
        //cleanup
        given()
                .when()
                .delete("/api/products/654654656");
    }

    @Test
    public void testAddingProduct(){

        ProductDTO product = ProductDTO.builder()
                .productNumber(654654656)
                .name("Maveriks")
                .price(345.78)
                .description("vaseline for vegans")
                .noInStock(5)
                .reviews(Collections.emptyList())
                .build();

        given()
                .contentType("application/json")
                .body(product)
                .when().post("/api/products").then()
                .statusCode(201);

        given()
                .when()
                .get("/api/products/654654656")
                .then()
                .statusCode(200)
                .and()
                .body("productNumber",equalTo(654654656))
                .body("price",equalTo(345.78f))
                .body("name", equalTo("Maveriks"))
                .body("description",equalTo("vaseline for vegans"))
                .body("noInStock",equalTo(5));
        //cleanup
        given()
                .when()
                .delete("/api/products/654654656");


    }


}