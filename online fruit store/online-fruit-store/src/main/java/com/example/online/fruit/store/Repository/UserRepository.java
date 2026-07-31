package com.example.online.fruit.store.Repository;

import com.example.online.fruit.store.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Login ke liye
    Optional<User> findByEmail(String email);
}
