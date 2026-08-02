package com.example.online.fruit.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.online.fruit.store.Entity.Shop;
import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    // ✅ Custom method to get shops by admin ID
    List<Shop> findByAdminId(Long adminId);
}