package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Customer;

public interface ICustomerService {

	List<Customer> findAll();

	Optional<Customer> findById(Long id);

	Customer save(Customer customer);

	Customer update(Long id, Customer customer);

	Customer delete(Long id);
}
