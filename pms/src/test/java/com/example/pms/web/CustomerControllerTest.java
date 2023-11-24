package com.example.pms.web;

import com.example.pms.domain.CustomerDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class CustomerControllerTest {
    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    void testGettingAllProducts() {
        // add the Products

        CustomerDTO customer = CustomerDTO.builder()
                .customerId(67725367)
                .name("Maveriks")
                .email("ywoldemi@gmail.com")
                .street("Jasper Avenue")
                .phone("242442444")
                .city("Edmonton")
                .zip("T4T Y75")
                .build();


        CustomerDTO customer2 = CustomerDTO.builder()
                .customerId(78894933)
                .name("AxumiteSoul")
                .email("axumite@gmail.com")
                .street("Danforth Avenue")
                .phone("5353453567")
                .city("Scarborough")
                .zip("UER Y75")
                .build();

        given()
                .contentType("application/json")
                .body(customer)
                .when().post("/api/customers").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(customer2)
                .when().post("/api/customers").then()
                .statusCode(201);
        Response response = given().when().get("/api/customers");
        System.out.println(response.getBody().prettyPrint());

        // get all products and verify
        given()
                .when().get("/api/customers").then()
                .statusCode(200)
                .and()
                .body("customerId", hasItems(67725367, 78894933))
                .body("name", hasItems("Maveriks", "AxumiteSoul"))
                .body("phone", hasItems("242442444", "5353453567"))
                .body("email",hasItems("ywoldemi@gmail.com", "axumite@gmail.com"))
                .body("street", hasItems("Danforth Avenue", "Jasper Avenue"))
                .body("city",hasItems("Edmonton","Scarborough"))
                .body("zip",hasItems("UER Y75","T4T Y75" ));

        //cleanup
        given()
                .when()
                .delete("/api/customers/67725367");
        given()
                .when()
                .delete("/api/customers/78894933");
    }

    @Test
    public void testAddingProduct(){

        CustomerDTO customer = CustomerDTO.builder()
                .customerId(67725367)
                .name("Maveriks")
                .email("ywoldemi@gmail.com")
                .street("Jasper Avenue")
                .phone("242442444")
                .city("Edmonton")
                .zip("T4T Y75")
                .build();

        given()
                .contentType("application/json")
                .body(customer)
                .when().post("/api/customers").then()
                .statusCode(201);

        given()
                .when()
                .get("/api/customers/67725367")
                .then()
                .statusCode(200)
                .and()
                .body("customerId", equalTo(67725367))
                .body("name",equalTo("Maveriks"))
                .body("email",equalTo("ywoldemi@gmail.com"))
                .body("street", equalTo("Jasper Avenue"))
                .body("city",equalTo("Edmonton"))
                .body("phone",equalTo("242442444"))
                .body("zip",equalTo("T4T Y75"));
        //cleanup
        given()
                .when()
                .delete("/api/products/67725367");


    }

    @Test
    public void testDeleteCustomer() {
        // add the product to be deleted
        CustomerDTO customer = CustomerDTO.builder()
                .customerId(67725367)
                .name("Maveriks")
                .email("ywoldemi@gmail.com")
                .street("Jasper Avenue")
                .phone("242442444")
                .city("Edmonton")
                .zip("T4T Y75")
                .build();

        given()
                .contentType("application/json")
                .body(customer)
                .when().post("/api/customers").then()
                .statusCode(201);

        given()
                .when()
                .delete("/api/customers/67725367");

        given()
                .when()
                .get("/api/customers/67725367")
                .then()
                .statusCode(404)
                .and()
                .body("message",equalTo("Customer not found with id: 67725367"));
    }
}
