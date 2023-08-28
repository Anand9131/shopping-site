package com.shoppingSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingSite.entity.ShoppingEntity;

@Repository
public interface ShoppingDao extends JpaRepository<ShoppingEntity,Integer>{

}
