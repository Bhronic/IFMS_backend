package com.ifms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifms.models.Customer;
import com.ifms.models.CustomerResponse;
import com.ifms.repository.CustomerRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/placeOrder")
	@PreAuthorize("hasRole('USER')")
	public Customer placeOrder(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@GetMapping("/getOrder")
	public List<Customer> getOrder() {
		return customerRepository.findTop3ByOrderByNameDesc();
	}
	
	 	@GetMapping("/getProduct")
	    public List<Customer> getAllEmployees(
	                        @RequestParam(defaultValue = "0") Integer pageNo, 
	                        @RequestParam(defaultValue = "3") Integer pageSize,
	                        @RequestParam(defaultValue = "id") String sortBy) 
	    {
	 		 Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 	 
	 	        Page<Customer> pagedResult = customerRepository.findAll(paging);
	 	         
	 	       return pagedResult.getContent();
	 
	      
	    }
	 	
	 	@GetMapping("/getOrderAll")
		public List<CustomerResponse> getOrderAll() {
		    return customerRepository.getAll();
		}
}
