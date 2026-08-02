package com.example.online.fruit.store.Entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private double quantity;
    private boolean available;
    private String img;

    @Column(length = 500)
    private String description;

    private double minQuantity;
    private String unit; // KG / PCS

    // ✅ Relation with Shop
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id") // FK column in fruit table
    @JsonIgnoreProperties({"fruits", "admin"}) // avoid infinite loop
    private Shop shop;

    // ===== Constructors =====
    public Fruit() {}

    public Fruit(String name, double price, double quantity, String img, String description,
                 double minQuantity, String unit, Shop shop) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.img = img;
        this.description = description;
        this.minQuantity = minQuantity;
        this.unit = unit;
        this.shop = shop;
        this.available = quantity > 0;
    }

    // ===== Getters & Setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { 
        this.quantity = quantity; 
        this.available = quantity > 0; // auto-update availability
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getMinQuantity() { return minQuantity; }
    public void setMinQuantity(double minQuantity) { this.minQuantity = minQuantity; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public Shop getShop() { return shop; }
    public void setShop(Shop shop) { this.shop = shop; }

    // ===== Helper for frontend =====
    @Transient
    public String getShopName() {
        return shop != null ? shop.getShopName() : "Unknown Shop";
    }

    // ===== toString for debugging =====
    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", available=" + available +
                ", shop=" + (shop != null ? shop.getShopName() : "null") +
                '}';
    }
}