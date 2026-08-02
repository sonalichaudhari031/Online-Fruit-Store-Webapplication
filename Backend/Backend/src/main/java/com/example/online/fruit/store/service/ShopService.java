package com.example.online.fruit.store.service;

import org.springframework.stereotype.Service;
import com.example.online.fruit.store.Repository.ShopRepository;
import com.example.online.fruit.store.Entity.Shop;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    // Get all shops
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    // Get shop by ID
    public Optional<Shop> getShopById(Long id) {
        return shopRepository.findById(id);
    }

    // Get shops by admin
    public List<Shop> getShopsByAdmin(Long adminId) {
        return shopRepository. findByAdminId(adminId);
    }
   
    // Create new shop
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    // Update existing shop
    public Shop updateShop(Long id, Shop updatedShop) {
        return shopRepository.findById(id).map(shop -> {
            shop.setShopName(updatedShop.getShopName());
            shop.setStatus(updatedShop.getStatus());
            shop.setAdmin(updatedShop.getAdmin());
            return shopRepository.save(shop);
        }).orElseThrow(() -> new RuntimeException("Shop not found with id: " + id));
    }

    // Delete shop
    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}
