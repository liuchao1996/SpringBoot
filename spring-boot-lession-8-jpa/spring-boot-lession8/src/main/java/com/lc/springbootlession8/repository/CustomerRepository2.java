package com.lc.springbootlession8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lc.springbootlession8.entity.Customer;

@Repository
public interface CustomerRepository2 extends JpaRepository<Customer,Long> {

	@Query(value = "select  * from customers", nativeQuery = true)
	public List<Customer> getAll();

}
