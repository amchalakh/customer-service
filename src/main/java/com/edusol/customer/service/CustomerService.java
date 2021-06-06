package com.edusol.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusol.customer.model.Customer;
import com.edusol.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	List<Customer> customerList = new ArrayList<>();
	
	@Autowired
	CustomerRepository customerRepository;

	
	public Object getCustomers() {
		
		customerList = (List<Customer>) customerRepository.findAll();
		

		return customerList;
	}

	public Object addCustomer(Customer customer) {
		
		 customerRepository.save(customer);
		 return "Customer added successfully";
	}

	public Object getCustomer(String city) {
		
		if (customerList.isEmpty()) {
			return "No customer found";
		}
		
		
		//List<Customer> customers = new ArrayList<>();
		

		/*for(Customer cust:customerList){
			if(cust.getCutsomerCity().equalsIgnoreCase(city)){
				customers.add(cust);
			}
		}*/
		
		List<Customer> customers = customerList.stream()
				.filter(c->c.getCutsomerCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
		
		if(customers.isEmpty()){
			return "No customer found";
		}
		
		return customers;
	}

	public Object updateCustomer(Customer customer) {
		
		boolean flag = false;
		
		if (customerList.isEmpty()) {
			return "No customer found";
		}
		
		for(Customer cust:customerList){
			if(cust.getCustomerId() == customer.getCustomerId()){
				customerList.remove(cust);
				customerList.add(customer);
				flag = true;
				break;
			}
		}
		
		if(flag == false){
			return "Customer data is not avaible";
		}
		
		return "Customer updated successfully";
	}

	public Object deleteCustomer(int customerId) {
		
		boolean flag = false;
		
		if (customerList.isEmpty()) {
			return "No customer found";
		}
		
		for(Customer cust:customerList){
			if(cust.getCustomerId() == customerId){
				customerList.remove(cust);
				flag = true;
				break;
			}
		}
		
		if(flag == false){
			return "Customer data is not avaible";
		}
		
		return "Customer deleted successfully";
	}

}
