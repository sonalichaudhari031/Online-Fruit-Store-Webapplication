package com.example.online.fruit.store.dto;

public class CartItemDTO {

    private Long id;
    private String fruitName;
    private double quantity;
    private double price;
    private String img;
    public CartItemDTO() {}

    public CartItemDTO(Long id, String fruitName, double quantity, double price, String img) {
        this.id = id;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
        this.img = img;
    }

    public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	// -----------------------------
    // GETTERS & SETTERS
    // -----------------------------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFruitName() { return fruitName; }
    public void setFruitName(String fruitName) { this.fruitName = fruitName; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // -----------------------------
    // HELPER METHOD (optional)
    // -----------------------------
    public void addQuantity(double qty) {
        this.quantity += qty;
        this.price += qty * (price / quantity); // maintain price proportional
    }
}
