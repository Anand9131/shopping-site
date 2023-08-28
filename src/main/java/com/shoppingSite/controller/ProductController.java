package com.shoppingSite.controller;

import java.util.List;
import java.util.Random;

//import org.hibernate.sql.results.ResultsLogger_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingSite.Dto.OrderDto;
import com.shoppingSite.Dto.ResponseDto;
import com.shoppingSite.entity.OrderEntity;
import com.shoppingSite.entity.ProductEntity;
import com.shoppingSite.entity.CustomerEntity;
import com.shoppingSite.service.CustomerService;
import com.shoppingSite.service.OrderService;
import com.shoppingSite.service.ProductService;
import com.shoppingSite.util.DateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class ProductController {
	

	private OrderService orderService;

    private ProductService productService;

    private CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger(ProductController.class);
	

	public ProductController(OrderService orderService, ProductService productService,
			CustomerService customerService) {
		super();
		this.orderService = orderService;
		this.productService = productService;
		this.customerService = customerService;
	}

	@GetMapping(value = "/getAllProducts")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {

        List<ProductEntity> productList = productService.getAllProducts();

        return ResponseEntity.ok(productList);
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<OrderEntity> getOrderDetails(@PathVariable int orderId) {

        OrderEntity order = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }
    
    
    @PostMapping(value = "/placeOrder")
    public ResponseEntity<ResponseDto> placeOrder(@RequestBody OrderDto orderDto) {
       logger.info("Request Payload " + orderDto.toString());

        ResponseDto responseDtO = new ResponseDto();


        float amount = orderService.getCartAmount(orderDto.getCartItems());

        CustomerEntity customerEntity = new CustomerEntity(orderDto.getCustomerName(), orderDto.getCustomerEmail());
        Integer customerIdFromDb = customerService.isCustomerPresent(customerEntity);
        if (customerIdFromDb != null) {
        	customerEntity.setId(customerIdFromDb);
           logger.info("Customer already present in db with id : " + customerIdFromDb);
        }else{
        	customerEntity = customerService.saveCustomer(customerEntity);
            logger.info("Customer saved.. with id : " + customerEntity.getId());
        }
        OrderEntity order = new OrderEntity(orderDto.getOrderDescription(), customerEntity, orderDto.getCartItems());
        order = orderService.saveOrder(order);
       logger.info("Order processed successfully..");

       responseDtO.setAmount(amount);
       responseDtO.setDate(DateUtil.getCurrentDateTime());
       responseDtO.setInvoiceNumber(new Random().nextInt(1000));
       responseDtO.setOrderId(order.getId());
       responseDtO.setOrderDescription(orderDto.getOrderDescription());

        logger.info("test push..");

        return ResponseEntity.ok(responseDtO);
        
    }
}
