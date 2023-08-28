package com.shoppingSite.Dto;

import java.util.List;

import com.shoppingSite.entity.ShoppingEntity;

public class OrderDto {
	
    private String orderDescription;
    private List<ShoppingEntity> cartItems;
    private String customerEmail;
    private String customerName;
    
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDto(String orderDescription, List<ShoppingEntity> cartItems, String customerEmail,
			String customerName) {
		super();
		this.orderDescription = orderDescription;
		this.cartItems = cartItems;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
	}
	
	
	
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public List<ShoppingEntity> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<ShoppingEntity> cartItems) {
		this.cartItems = cartItems;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "OrderDto [orderDescription=" + orderDescription + ", cartItems=" + cartItems + ", customerEmail="
				+ customerEmail + ", customerName=" + customerName + "]";
	}
    
    

}
