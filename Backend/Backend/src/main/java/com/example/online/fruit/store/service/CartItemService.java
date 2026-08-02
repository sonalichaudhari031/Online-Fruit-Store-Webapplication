package com.example.online.fruit.store.service;

import com.example.online.fruit.store.Entity.Cart;
import com.example.online.fruit.store.Entity.CartItem;
import com.example.online.fruit.store.Entity.Fruit;
import com.example.online.fruit.store.Entity.User;
import com.example.online.fruit.store.Repository.CartItemRepository;
import com.example.online.fruit.store.Repository.CartRepository;
import com.example.online.fruit.store.Repository.FruitRepository;
import com.example.online.fruit.store.Repository.UserRepository;
import com.example.online.fruit.store.dto.CartItemDTO;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final FruitRepository fruitRepository;
    
    // Upload folder define karein
    private final String uploadPath = "uploads";

    public CartItemService(CartRepository cartRepository,
                           UserRepository userRepository,
                           CartItemRepository cartItemRepository,
                           FruitRepository fruitRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public CartItem addToCart(Long userId, Long fruitId, int quantity) {
        Cart cart = getOrCreateCart(userId);
        Fruit fruit = fruitRepository.findById(fruitId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fruit not found"));

        CartItem cartItem = cartItemRepository.findByCartIdAndFruitId(cart.getId(), fruitId)
                .orElseGet(() -> new CartItem(cart, fruit, 0));

        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartItem = cartItemRepository.save(cartItem);

        updateCartTotal(cart);
        return cartItem;
    }

    @Transactional
    public CartItemDTO updateQuantityDTO(Long id, int quantity) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CartItem not found"));
        
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);

        updateCartTotal(cartItem.getCart());
        return convertToDTO(cartItem);
    }

    public List<CartItemDTO> getCartItemsByUser(Long userId) {
        Cart cart = getOrCreateCart(userId);
        return cartItemRepository.findByCartId(cart.getId())
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteCartItem(Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
        Cart cart = cartItem.getCart();
        cartItemRepository.delete(cartItem);
        updateCartTotal(cart);
    }

    private Cart getOrCreateCart(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    User user = userRepository.findById(userId)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });
    }

    private void updateCartTotal(Cart cart) {
        if (cart != null) {
            cart.calculateTotal();
            cartRepository.save(cart);
        }
    }

    // ✅ FIXED: Isme 'img' add kiya gaya hai
    private CartItemDTO convertToDTO(CartItem item) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(item.getId());
        dto.setFruitName(item.getFruit().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getFruit().getPrice() * item.getQuantity()); 
        
        // Database se image ka naam set karein (Jaise: 6.png)
        dto.setImg(item.getFruit().getImg()); 
        
        return dto;
    }

    // ✅ FIXED: Upload logic with directory check
    public String saveImage(MultipartFile file, Long fruitId) throws IOException {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) return null;

        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = fruitId + extension;

        Path path = Paths.get(uploadPath).resolve(fileName);
        
        // Check if directory exists
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        return fileName; 
    }
    
    
    
    
    
    @Transactional
    public void clearUserCart(Long userId) {
        // Pehle user ki cart dhundo
        Cart cart = cartRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Cart ke saare items delete karo
        cartItemRepository.deleteByCartId(cart.getId());

        // Cart ka total zero karo
        cart.setTotal(0.0);
        cartRepository.save(cart);
    }
    @Transactional
    public void updateFruitImage(Long fruitId, String fileName) {
        Fruit fruit = fruitRepository.findById(fruitId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fruit not found"));
        
        // Aapki Entity mein field ka naam 'img' hai
        fruit.setImg(fileName); 
        fruitRepository.save(fruit);
    }
    
}