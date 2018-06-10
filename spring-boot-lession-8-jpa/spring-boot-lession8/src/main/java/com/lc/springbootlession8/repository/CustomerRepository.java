package com.lc.springbootlession8.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lc.springbootlession8.entity.Customer;

@Repository
@Transactional(readOnly = false)
public class CustomerRepository extends SimpleJpaRepository<Customer, Long> {

	@Autowired
	public CustomerRepository(EntityManager em) {
		super(Customer.class, em);
	}

}
