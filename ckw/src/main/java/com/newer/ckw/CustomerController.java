package com.newer.ckw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	// 注入依赖
	@Autowired
	CustomerDao mapper;
	
	// GET
	@GetMapping("/customer")
	public List<Customer> find(Customer customer){
		return mapper.findALL(customer);
	}
	
	//post
	@PostMapping("/customer")
	public Customer post(@RequestBody Customer customer) {
		boolean aa = mapper.save(customer);
		return customer;
	}
}
