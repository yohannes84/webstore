package com.example.pms.web;

import com.example.pms.domain.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrderControllerTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void testGetOneOrder() {
        // add the order to be fetched
        Customer customer = Customer.builder()
                .customerId(67725367)
                .name("Maveriks")
                .email("ywoldemi@gmail.com")
                .street("Jasper Avenue")
                .phone("242442444")
                .city("Edmonton")
                .zip("T4T Y75")
                .build();

        Payment payment = Payment.builder()
                .cardNumber(4244242424242L)
                .cvc(453)
                .cardType("Visa")
                .expirationDate("12/23").build();

        Order order = Order.builder()
                .id("56473T45")
                .customerInfo(customer)
                .paymentInfo(payment)
                .orderItems(Collections.emptyList())
                .build();
        given()
                .contentType("application/json")
                .body(order)
                .when().post("/api/orders").then()
                .statusCode(201);
        // test getting the order
        given()
                .when()
                .get("/api/orders/56473T45")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("id", equalTo("56473T45"))
                .body("customerInfo.customerId", equalTo(67725367))
                .body("customerInfo.name", equalTo("Maveriks"))
                .body("customerInfo.email", equalTo("ywoldemi@gmail.com"))
                .body("customerInfo.street", equalTo("Jasper Avenue"))
                .body("customerInfo.phone", equalTo("242442444"))
                .body("customerInfo.city", equalTo("Edmonton"))
                .body("customerInfo.zip", equalTo("T4T Y75"))
                .body("paymentInfo.cardNumber", equalTo(4244242424242L))
                .body("paymentInfo.cvc", equalTo(453))
                .body("paymentInfo.cardType", equalTo("Visa"))
                .body("paymentInfo.expirationDate", equalTo("12/23"));
        //cleanup
        given()
                .when()
                .delete("/api/orders/56473T45");
    }

    @Test
    public void testPlaceOrder() {
        // add the order to be fetched
        Customer customer = Customer.builder()
                .customerId(67725367)
                .name("Maveriks")
                .email("ywoldemi@gmail.com")
                .street("Jasper Avenue")
                .phone("242442444")
                .city("Edmonton")
                .zip("T4T Y75")
                .build();

        Payment payment = Payment.builder()
                .cardNumber(4244242424242L)
                .cvc(453)
                .cardType("Visa")
                .expirationDate("12/23").build();

        Order order = Order.builder()
                .id("56473T45")
                .customerInfo(customer)
                .paymentInfo(payment)
                .orderItems(Collections.emptyList())
                .build();
        given()
                .contentType("application/json")
                .body(order)
                .when().post("/api/orders").then()
                .statusCode(201);

        given()
                .when()
                .get("/api/orders/56473T45")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("id", equalTo("56473T45"))
                .body("customerInfo.customerId", equalTo(67725367))
                .body("paymentInfo.cardNumber", equalTo(4244242424242L));

    }

    @Test
    public void testUpdateOrderStatus() {
        // Create an initial order with PLACED status
        Customer customer = Customer.builder()
                .customerId(67725367)
                .name("Maveriks")
                .email("ywoldemi@gmail.com")
                .street("Jasper Avenue")
                .phone("242442444")
                .city("Edmonton")
                .zip("T4T Y75")
                .build();

        Payment payment = Payment.builder()
                .cardNumber(4244242424242L)
                .cvc(453)
                .cardType("Visa")
                .expirationDate("12/23")
                .build();

        Order initialOrder = Order.builder()
                .id("56473T45")
                .customerInfo(customer)
                .paymentInfo(payment)
                .orderItems(Collections.emptyList())
                .status(OrderStatus.PLACED)
                .build();

        // Create an updated order with DELIVERED status
        Order updatedOrder = Order.builder()
                .id("56473T45")
                .customerInfo(customer)
                .paymentInfo(payment)
                .orderItems(Collections.emptyList())
                .status(OrderStatus.DELIVERED)
                .build();

        // Add the initial order to be fetched
        given()
                .contentType("application/json")
                .body(initialOrder)
                .when().post("/api/orders").then()
                .statusCode(201);

        // Update the order status using PUT request
        given()
                .contentType("application/json")
                .body(updatedOrder)
                .when().put("/api/orders/" + updatedOrder.getId() + "?newStatus=DELIVERED").then()
                .statusCode(200);

        // Verify that the order status has been updated
        given()
                .when()
                .get("/api/orders/56473T45")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("id", equalTo("56473T45"))
                .body("status", equalTo("DELIVERED")); // Assuming your status is represented as a string in JSON

        // Cleanup
        given()
                .when()
                .delete("/api/orders/56473T45");
    }

}
