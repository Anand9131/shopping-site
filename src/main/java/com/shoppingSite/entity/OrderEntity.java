package com.shoppingSite.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "myorder")
public class OrderEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String orderDescription;
	    
	    @OneToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "customer_id", referencedColumnName = "id")
	    @Autowired
	    private CustomerEntity customerEntity;


	    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ShoppingEntity.class)
	    @JoinColumn(name = "order_id", referencedColumnName = "id")
	    private List<ShoppingEntity> cartItems;

		public OrderEntity() {
			super();
		}

	/**	public OrderEntity(int id, String orderDescription) {
			super();
			this.id = id;
			this.orderDescription = orderDescription;
		}
		**/

	/**	public OrderEntity(int id, String orderDescription, CustomerEntity customerEntity,
				List<ShoppingEntity> cartItems) {
			super();
			this.id = id;
			this.orderDescription = orderDescription;
			this.customerEntity = customerEntity;
			this.cartItems = cartItems;
		}
		**/
		
		   public OrderEntity(String orderDescription, CustomerEntity customerEntity, List<ShoppingEntity> cartItems) {
		        this.orderDescription = orderDescription;
		        this.customerEntity = customerEntity;
		        this.cartItems = cartItems;
		    }
		

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public List<ShoppingEntity> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<ShoppingEntity> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderDescription=" + orderDescription + ", customerEntity=" + customerEntity
				+ ", cartItems=" + cartItems + "]";
	}

}