package com.example.online.fruit.store.Entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    static {
        System.out.println("✅ Cart entity loaded");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1 User = 1 Cart
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 1 Cart = Many CartItems
    @OneToMany(
        mappedBy = "cart",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.EAGER
    )
    @JsonManagedReference
    private List<CartItem> cartItems = new ArrayList<>();

    private double total;

    public Cart() {}

    public Cart(User user) {
        this.user = user;
    }

    // -----------------------------
    // BUSINESS LOGIC
    // -----------------------------
    public void calculateTotal() {
        this.total = cartItems.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

    // -----------------------------
    // GETTERS & SETTERS
    // -----------------------------
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<CartItem> getCartItems() { return cartItems; }
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        calculateTotal();
    }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    // -----------------------------
    // HELPER METHODS
    // -----------------------------
    public void addCartItem(CartItem item) {
        cartItems.add(item);
        item.setCart(this);
        calculateTotal();
    }

    public void removeCartItem(CartItem item) {
        cartItems.remove(item);
        item.setCart(null);
        calculateTotal();
    }
}
