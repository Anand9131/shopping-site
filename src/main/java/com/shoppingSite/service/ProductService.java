package com.shoppingSite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingSite.entity.ProductEntity;
import com.shoppingSite.repository.ProductDao;

@Service
public class ProductService {
	
	//@Autowired
	private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<ProductEntity> getAllProducts() {
        return this.productDao.findAll();
    }

}
