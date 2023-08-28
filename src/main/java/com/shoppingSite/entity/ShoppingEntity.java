package com.shoppingSite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class ShoppingEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int productId;
    private String productName;

    private int quantity;
   // @NotNull
    private long amount;
	public ShoppingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingEntity(int id, int productId, String productName, int quantity, long amount) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long singleCartAmount) {
		this.amount = singleCartAmount;
	}
	@Override
	public String toString() {
		return "ShoppingEntity [id=" + id + ", productId=" + productId + ", productName=" + productName + ", quantity="
				+ quantity + ", amount=" + amount + "]";
	}

    
}
