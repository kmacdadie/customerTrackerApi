package com.promineotech.customerTrackerApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.customerTrackerApi.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
