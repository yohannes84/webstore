package com.example.pms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@Builder
@Document
public class Order {
    @Id
    private String id;
    private List<Product> orderItems;
    private Customer customerInfo;
    private Payment paymentInfo;
    private String typeOrder;

    public Order() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Product> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<Product> orderItems) {
        this.orderItems = orderItems;
    }
    public Customer getCustomerInfo() {
        return customerInfo;
    }
    public void setCustomerInfo(Customer customerInfo) {
        this.customerInfo = customerInfo;
    }
    public Payment getPaymentInfo() {
        return paymentInfo;
    }
    public void setPaymentInfo(Payment paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
    public String getTypeOrder() {
        return typeOrder;
    }

    private void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }

    public void setTypeOrder(OrderStatus status) {
        if (status == OrderStatus.PLACED) {
            setTypeOrder("PLACED");
        }
        else if (status == OrderStatus.SHIPPED) {
            setTypeOrder("SHIPPED");
        }
        else {
            setTypeOrder("DELIVERED");
        }
    }
}

