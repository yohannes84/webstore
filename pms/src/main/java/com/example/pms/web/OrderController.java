package com.example.pms.web;

import com.example.pms.domain.Order;
import com.example.pms.domain.OrderStatus;
import com.example.pms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.getAllOrders());
    }
    @PostMapping
    public ResponseEntity< Order> placeOrder(@RequestBody Order order) {
        order.setTypeOrder(OrderStatus.PLACED);
        Order placedOrder = orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(placedOrder);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable String orderId) {
        Optional<Order> order = Optional.ofNullable(orderService.getOrderById(orderId));
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable String orderId, @RequestParam OrderStatus newStatus) {
        orderService.updateOrderStatus(orderId, newStatus);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{orderId}/{status}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable("orderId") String orderId,
                                                   @PathVariable("status") String status) {
        if (status.equals("SHIPPED")) {
            orderService.updateOrderStatus(orderId, OrderStatus.SHIPPED);
        }
        else if (status.equals("PLACED")) {
            orderService.updateOrderStatus(orderId, OrderStatus.SHIPPED);
        }
        else {
            orderService.updateOrderStatus(orderId, OrderStatus.DELIVERED);
        }
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
