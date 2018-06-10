package com.lc.springbootlession8.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lc.springbootlession8.entity.Customer;

@Service
public class CustomerService {

	/**
	 * 持久的上下文
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 添加客户
	 * @param customer
	 */
	@Transactional
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}
	
	/**
	 * 根据id进行查找
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(Long id) {
		return entityManager.find(Customer.class, id);
	}
	
}
