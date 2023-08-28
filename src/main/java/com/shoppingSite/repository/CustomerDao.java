package com.shoppingSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingSite.entity.CustomerEntity;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,Integer>{
	
	 public CustomerEntity getCustomerByEmailAndName(String email,String name);

}
