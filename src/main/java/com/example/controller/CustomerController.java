package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Customer;
import com.example.service.ICustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/getAll")
	public List<Customer> getAll() {
		try {
			return service.findAll();
		} catch (Exception e) {
			String msg = "An error occurred while trying to getAll customer data.";
			log.error(msg, e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
		}
	}

	@GetMapping("/get/{id}")
	public Optional<Customer> get(@PathVariable("id") Long id) {
		try {
			return service.findById(id);
		} catch (Exception e) {
			String msg = "An error occurred while trying to get customer data.";
			log.error(msg, e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
		}
	}

	@PostMapping("/post")
	public Customer save(@RequestBody Customer customer) {
		try {
			return service.save(customer);
		} catch (Exception e) {
			String msg = "An error occurred while trying to save customer data.";
			log.error(msg, e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
		}
	}

	@DeleteMapping("/delete/{id}")
	public Customer delete(@PathVariable("id") Long id) {
		try {
			return service.delete(id);
		} catch (Exception e) {
			String msg = "An error occurred while trying to delete customer data.";
			log.error(msg, e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
		}
	}

	@PutMapping("/update/{id}")
	public Customer update(@PathVariable("id") Long id, @RequestBody Customer customer) {
		try {
			return service.update(id, customer);
		} catch (Exception e) {
			String msg = "An error occurred while trying to update customer data.";
			log.error(msg, e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
		}
	}
}