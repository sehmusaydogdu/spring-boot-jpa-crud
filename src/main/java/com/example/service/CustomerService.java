package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository repository;

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	public Customer delete(Long id) {
		Customer customer = repository.findById(id).get();
		repository.deleteById(id);
		return customer;
	}

	public Customer update(Long id, Customer customer) {
		Customer db = repository.findById(id).get();
		db.setName(customer.getName());
		db.setBirthday(customer.getBirthday());
		return repository.save(db);
	}
}
