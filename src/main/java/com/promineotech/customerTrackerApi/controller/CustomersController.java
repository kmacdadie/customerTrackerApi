package com.promineotech.customerTrackerApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.promineotech.customerTrackerApi.entity.Customer;
import com.promineotech.customerTrackerApi.service.CustomersService;

@RestController
public class CustomersController {
	
	private static final Logger logger = LogManager.getLogger(CustomersController.class);
	
	@Autowired
	CustomersService service;
	
	@RequestMapping(value="/customers", method=RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer) {
		return service.createCustomer(customer);
	}
	
	@RequestMapping("/customers")
	public Iterable<Customer> getCustomers() {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, this is a Warning");
		logger.error("Oops! We have an error!");
		logger.fatal("Something really went wrong!");
		try {
			throw new Exception("This is an exception");
		} catch (Exception e) {
			logger.fatal("An exception occurred." + e.getMessage());
		}
		return service.getCustomers();
	}
	
	@RequestMapping(value="/customers/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return service.getCustomer(id);
	}
	
	@RequestMapping(value="/customers/{id}", method=RequestMethod.PUT)
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		return service.updateCustomer(id, customer);
	}
	
	@RequestMapping(value="/customers/{id}", method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable Long id) {
		service.deleteCustomer(id);
	}

}
