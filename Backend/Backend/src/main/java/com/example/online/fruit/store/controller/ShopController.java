package com.example.online.fruit.store.controller;

import org.springframework.web.bind.annotation.*;
import com.example.online.fruit.store.service.ShopService;
import com.example.online.fruit.store.Entity.Shop;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shops")
@CrossOrigin(origins = "http://localhost:4200")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // Get all shops
    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    // Get shop by ID
    @GetMapping("/{id}")
    public Optional<Shop> getShopById(@PathVariable Long id) {
        return shopService.getShopById(id);
    }

    // Get shops by admin ID
    @GetMapping("/admin/{adminId}")
    public List<Shop> getShopsByAdmin(@PathVariable Long adminId) {
        return shopService.getShopsByAdmin(adminId);
    }

    // Create new shop
    @PostMapping
    public Shop createShop(@RequestBody Shop shop) {
        return shopService.createShop(shop);
    }

    // Update shop
    @PutMapping("/{id}")
    public Shop updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        return shopService.updateShop(id, shop);
    }

    // Delete shop
    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
    }
}
