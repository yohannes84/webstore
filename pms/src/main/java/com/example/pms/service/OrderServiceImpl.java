package com.example.pms.service;

import com.example.pms.data.OrderRepository;
import com.example.pms.domain.Order;
import com.example.pms.domain.OrderStatus;
import com.example.pms.domain.Product;
import com.example.pms.web.OrderNotFoundException;
import com.example.pms.web.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Product not found with id: " + orderId));
    }

    public Order placeOrder(Order order) {
        // You can add additional validation logic if needed before saving
     return orderRepository.save(order);
    }

    public Order updateOrderStatus(String orderId, OrderStatus newStatus) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    order.setStatus(newStatus);
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
    }

    public void deleteOrder(String id) {
        Order order = getOrderOrThrow(id);
        orderRepository.delete(order);
    }

    private Order getOrderOrThrow(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
    }


}
