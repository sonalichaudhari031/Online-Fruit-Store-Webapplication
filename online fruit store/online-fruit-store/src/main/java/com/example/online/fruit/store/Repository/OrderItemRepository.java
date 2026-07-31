package com.example.online.fruit.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.online.fruit.store.Entity.OrderItem;
import java.util.List;

// Repository interface for OrderItem
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // ✅ Custom method to get all items of a specific order
    List<OrderItem> findByOrderId(Long orderId);
    
}