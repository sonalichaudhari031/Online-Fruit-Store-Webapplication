package com.example.online.fruit.store.controller;

import com.example.online.fruit.store.dto.CartItemDTO;
import com.example.online.fruit.store.Entity.CartItem;
import com.example.online.fruit.store.service.CartItemService;
import com.example.online.fruit.store.service.FruitService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart-items")
@CrossOrigin(origins = "http://localhost:4200")
public class CartItemController {

    private final CartItemService cartItemService;
    private final FruitService fruitService;
    private final String uploadPath = "uploads";

    public CartItemController(CartItemService cartItemService, FruitService fruitService) {
        this.cartItemService = cartItemService;
        this.fruitService = fruitService;
    }

    @PostMapping("/add/{userId}/{fruitId}")
    public ResponseEntity<CartItem> addToCart(
            @PathVariable Long userId,
            @PathVariable Long fruitId,
            @RequestParam double quantity) {
        return ResponseEntity.ok(cartItemService.addToCart(userId, fruitId, (int)quantity));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartItemDTO>> getCartItemsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(cartItemService.getCartItemsByUser(userId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CartItemDTO> updateQuantity(
            @PathVariable Long id, 
            @RequestParam int quantity) {
        return ResponseEntity.ok(cartItemService.updateQuantityDTO(id, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.ok(Map.of("message", "Item deleted successfully"));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        try {
            String originalName = file.getOriginalFilename();
            if (originalName == null || !originalName.contains(".")) {
                return ResponseEntity.badRequest().body("Invalid file format");
            }
            
            String extension = originalName.substring(originalName.lastIndexOf("."));
            String newFileName = id + extension;
            
            File directory = new File(uploadPath);
            if (!directory.exists()) directory.mkdirs();

            Path path = Paths.get(uploadPath).resolve(newFileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            
            // Is method ko Service mein zaroor add karein
            cartItemService.updateFruitImage(id, newFileName);
            
            return ResponseEntity.ok("File Uploaded: " + newFileName);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    } // Iske baad check karein ki class ka closing brace hai ya nahi
    }