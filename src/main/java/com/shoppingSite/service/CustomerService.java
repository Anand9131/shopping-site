package com.shoppingSite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingSite.entity.CustomerEntity;
import com.shoppingSite.repository.CustomerDao;

@Service
public class CustomerService {
	
	//@Autowired
	private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }



    public CustomerEntity saveCustomer(CustomerEntity customerEntity){
        return customerDao.save(customerEntity);
    }

    public Integer isCustomerPresent(CustomerEntity customerEntity){
    	CustomerEntity customer1 = customerDao.getCustomerByEmailAndName(customerEntity.getEmail(),customerEntity.getName());
        return customer1!=null ? customer1.getId(): null ;
    }

}
