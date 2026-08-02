package com.example.online.fruit.store.Repository;

import com.example.online.fruit.store.Entity.Cart;
import com.example.online.fruit.store.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
    // Spring will automatically traverse the 'user' relationship 
    // and look for the 'id' field.
    Optional<Cart> findByUserId(Long userId);
    
    Optional<Cart> findByUser(User user);
}
