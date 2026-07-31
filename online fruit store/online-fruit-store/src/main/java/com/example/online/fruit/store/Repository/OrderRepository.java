package com.example.online.fruit.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.online.fruit.store.Entity.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}