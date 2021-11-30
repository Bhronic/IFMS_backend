package com.ifms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifms.models.Customer;
import com.ifms.models.CustomerResponse;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findTop3ByOrderByNameDesc();

	@Query("select new com.ifms.models.Customer(d.id, d.name ) from Customer d")
	List<CustomerResponse> getAll();

}
