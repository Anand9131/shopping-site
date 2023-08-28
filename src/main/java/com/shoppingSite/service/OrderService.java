package com.shoppingSite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingSite.entity.OrderEntity;
import com.shoppingSite.entity.ProductEntity;
import com.shoppingSite.entity.ShoppingEntity;
import com.shoppingSite.repository.OrderDao;
import com.shoppingSite.repository.ProductDao;

@Service
public class OrderService {
	
	private OrderDao orderDao;
	
    private ProductDao productDao;

    public OrderService(OrderDao orderDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
    }

    public OrderEntity getOrderDetail(int orderId) {
        Optional<OrderEntity> order = this.orderDao.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }

    public float getCartAmount(List<ShoppingEntity> shoppingCartList) {

        float totalCartAmount = 0f;
        long singleCartAmount = 0;
        int availableQuantity = 0;

        for (ShoppingEntity cart : shoppingCartList) {

            long productId = cart.getProductId();
            Optional<ProductEntity> product = productDao.findById(productId);
            if (product.isPresent()) {
                ProductEntity product1 = product.get();
                if (product1.getAvailableQuantity() < cart.getQuantity()) {
                    singleCartAmount = product1.getPrice() * product1.getAvailableQuantity();
                    cart.setQuantity(product1.getAvailableQuantity());
                } else {
                    singleCartAmount = cart.getQuantity() * product1.getPrice();
                    availableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
                }
                totalCartAmount = totalCartAmount + singleCartAmount;
                product1.setAvailableQuantity(availableQuantity);
                availableQuantity=0;
                cart.setProductName(product1.getName());
                cart.setAmount(singleCartAmount);
                productDao.save(product1);
            }
        }
        return totalCartAmount;
    }

    public OrderEntity saveOrder(OrderEntity order) {
        return orderDao.save(order);
    }

}
