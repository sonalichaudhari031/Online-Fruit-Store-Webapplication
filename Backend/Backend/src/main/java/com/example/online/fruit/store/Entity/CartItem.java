package com.example.online.fruit.store.Entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many items belong to one Cart
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    @JsonBackReference   // Prevent infinite recursion in JSON
    private Cart cart;

    // Each item corresponds to one Fruit
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fruit_id", nullable = false)
    private Fruit fruit;

    private double quantity;
    private double price;

    public CartItem() {}

    public CartItem(Cart cart, Fruit fruit, double quantity) {
        this.cart = cart;
        this.fruit = fruit;
        this.quantity = quantity;
        calculatePrice();
    }

    // -----------------------------
    // BUSINESS LOGIC
    // -----------------------------
    public void calculatePrice() {
        if (this.fruit != null) {
            this.price = this.fruit.getPrice() * this.quantity;
        } else {
            this.price = 0;
        }
    }

    // -----------------------------
    // GETTERS & SETTERS
    // -----------------------------
    public Long getId() { return id; }

    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    public Fruit getFruit() { return fruit; }
    public void setFruit(Fruit fruit) { 
        this.fruit = fruit; 
        calculatePrice();
    }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
        calculatePrice();
    }

    public double getPrice() { return price; }

    // -----------------------------
    // HELPER METHOD
    // -----------------------------
    public void increaseQuantity(double qty) {
        this.quantity += qty;
        calculatePrice();
    }
}
