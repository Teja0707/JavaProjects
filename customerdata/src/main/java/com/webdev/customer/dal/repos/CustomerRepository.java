package com.webdev.customer.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.webdev.customer.dal.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
