package com.webdev.customer.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.webdev.customer.dal.entities.Customer;
import com.webdev.customer.dal.repos.CustomerRepository;

@SpringBootTest
class CustomerdataApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		
		customer.setName("teja");
		customer.setEmail("tejasai5780@gmail.com");
		
		customerRepository.save(customer);
	}
	
	@Test
	public void testReadCustomer() {
		
		Customer customer = customerRepository.findById(1).get();
		System.out.println(customer);
		
	}
	
	@Test
	public void testUpdateCustomer() {
		
		Customer customer = customerRepository.findById(1).get();
		customer.setEmail("saiteja.lfa7@gmail.com");
		customerRepository.save(customer);
		System.out.println(customer);
		
	}
	
	@Test
	public void testDeleteCustomer() {
		
		customerRepository.deleteById(1);
		
	}

}
