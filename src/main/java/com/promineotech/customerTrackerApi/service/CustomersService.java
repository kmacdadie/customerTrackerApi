package com.promineotech.customerTrackerApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.customerTrackerApi.entity.Customer;
import com.promineotech.customerTrackerApi.repository.CustomerRepository;

@Service
public class CustomersService {
	
	@Autowired
	CustomerRepository repo;
	
	public Customer getCustomer(Long id) {
		return repo.findOne(id);
	}
	
	public Iterable<Customer> getCustomers() {
		return repo.findAll();
	}
	
	public void deleteCustomer(Long id) {
		repo.delete(id);
	}
	
	public Customer updateCustomer(Long id, Customer customer) {
		Customer foundCustomer = repo.findOne(id);
		if(foundCustomer != null) {
			foundCustomer.setFirstName(customer.getFirstName());
			foundCustomer.setLastName(customer.getLastName());
			foundCustomer.setAddress(customer.getAddress());
			foundCustomer.setPhoneNumber(customer.getPhoneNumber());
			foundCustomer.setServiceFrequency(customer.getServiceFrequency());
			repo.save(foundCustomer);
		}
		return foundCustomer;
	}
 
	public Customer createCustomer(Customer customer) {
		return repo.save(customer);
	}
	
}
