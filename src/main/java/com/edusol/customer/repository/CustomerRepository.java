package com.edusol.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.edusol.customer.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
