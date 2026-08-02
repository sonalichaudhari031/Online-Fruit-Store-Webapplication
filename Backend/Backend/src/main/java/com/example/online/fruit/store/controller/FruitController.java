package com.example.online.fruit.store.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile; // Important import
import com.example.online.fruit.store.Entity.Fruit;
import com.example.online.fruit.store.service.FruitService;

import java.nio.file.*; // File handling ke liye
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/fruits")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    // 1. Image Upload Method
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            // Project ke root mein 'uploads' folder hona chahiye
            Path path = Paths.get("uploads/" + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok(fileName);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Upload failed: " + e.getMessage());
        }
    }

    // 2. Add New Fruit
    @PostMapping
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        return ResponseEntity.ok(fruitService.saveFruit(fruit));
    }
 // FruitController.java ke andar ye method add karein
    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable("id") Long id) {
        System.out.println("Searching for Fruit ID: " + id); // Debugging ke liye
        return ResponseEntity.ok(fruitService.getFruitById(id));
    }
    // 3. Shop ID ke hisaab se fruits load karna
    @GetMapping("/shop/{shopId}")
    public List<Fruit> getFruitsByShop(@PathVariable Long shopId) {
        return fruitService.getFruitsByShopId(shopId); 
    }
    
    
 

    // 4. Saare fruits ki list (Dashboard ke liye)
    @GetMapping
    public List<Map<String, Object>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Fruit f : fruits) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", f.getId());
            map.put("name", f.getName());
            map.put("price", f.getPrice());
            map.put("quantity", f.getQuantity());
            map.put("unit", f.getUnit());
            map.put("img", f.getImg());
            map.put("description", f.getDescription()); // Added
            map.put("available", f.isAvailable()); 
            map.put("shopId", f.getShop() != null ? f.getShop().getId() : null);
            map.put("shopName", f.getShop() != null ? f.getShop().getShopName() : "No Shop");
            result.add(map);
        }
        return result;
    }

    // 5. Update Fruit
    @PutMapping("/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable Long id, @RequestBody Fruit fruit) {
        return ResponseEntity.ok(fruitService.updateFruit(id, fruit));
    }

    // 6. Delete Fruit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable Long id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }
}