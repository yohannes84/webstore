package com.example.pms.service;

import com.example.pms.domain.Order;
import com.example.pms.domain.OrderStatus;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById (String orderId);
    Order placeOrder(Order order);
    Order updateOrderStatus(String orderId, OrderStatus newStatus);
    void deleteOrder(String id);
}
