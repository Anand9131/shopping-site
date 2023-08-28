package com.shoppingSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingSite.entity.ProductEntity;


@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Long>{ 

}
