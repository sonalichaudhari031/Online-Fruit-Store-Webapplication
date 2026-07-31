package com.example.online.fruit.store.controller;

import com.example.online.fruit.store.Entity.Order;
import com.example.online.fruit.store.service.OrderService;
import com.example.online.fruit.store.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    private final OrderService orderService;
    private final CartItemService cartItemService;

    // Constructor Injection
    public OrderController(OrderService orderService, CartItemService cartItemService) {
        this.orderService = orderService;
        this.cartItemService = cartItemService;
    }

    // 1. Create New Order (And Clear Database Cart)
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // Order ko database mein save karein
        Order savedOrder = orderService.createOrder(order);
        
        // Agar user login hai, toh uski purani cart database se saaf karein
        if (order.getUser() != null && order.getUser().getId() != null) {
            cartItemService.clearUserCart(order.getUser().getId());
        }
        
        return savedOrder;
    }

    // 2. Get All Orders (Admin use ke liye)
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // 3. Get Specific Order by ID
    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // 4. Get All Orders for a Specific User (Order History ke liye)
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    // 5. Update Order Status (e.g., PLACED to DELIVERED)
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }

    // 6. Delete an Order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}