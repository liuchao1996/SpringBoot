package com.lc.springbootlession8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lc.springbootlession8.entity.Customer;
import com.lc.springbootlession8.repository.CustomerRepository;
import com.lc.springbootlession8.repository.CustomerRepository2;
import com.lc.springbootlession8.service.CustomerService;

/**
 * 客户控制器
 * @author qq165
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerRepository2 customerRepository2;
	
	@RequestMapping("/All")
	public List<Customer> findAll(){
		System.out.println(customerRepository.findAll());
		
		return customerRepository2.getAll();
	}
	
	@RequestMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
	    customerService.addCustomer(customer);
	    Long id = customer.getId();
	    return customerService.getCustomerById(id);
	}
}
