package com.example.online.fruit.store.Entity;

import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")   // 🔥 FIX (DB column match)
    private Long id;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Column(nullable = false)
    private String status;

    // 🔑 Shop owner (ADMIN)
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    // 🍎 Fruits of this shop
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Fruit> fruits;

    // ===== Getters & Setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getAdmin() { return admin; }
    public void setAdmin(User admin) { this.admin = admin; }

    public List<Fruit> getFruits() { return fruits; }
    public void setFruits(List<Fruit> fruits) { this.fruits = fruits; }
}
