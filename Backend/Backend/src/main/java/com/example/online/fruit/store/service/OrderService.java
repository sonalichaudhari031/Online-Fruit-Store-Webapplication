package com.example.online.fruit.store.service;

import org.springframework.stereotype.Service;
import com.example.online.fruit.store.Entity.Order;
import com.example.online.fruit.store.Entity.OrderItem; // ✅ Import this
import com.example.online.fruit.store.Repository.OrderRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // UPDATED METHOD
    public Order createOrder(Order order) {
        // 1. Order ki date set karein (Server side par safe rehta hai)
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        // 2. CRITICAL STEP: Relationship mapping
        // Har ek Item ko batana hoga ki wo kis Order se juda hai
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                item.setOrder(order); // Yeh line database mein order_id save karegi
            }
        }

        // 3. Save Order (CascadeType.ALL ki wajah se items bhi save ho jayenge)
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long id, String status) {
        return orderRepository.findById(id).map(order -> {
            order.setStatus(status);
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}