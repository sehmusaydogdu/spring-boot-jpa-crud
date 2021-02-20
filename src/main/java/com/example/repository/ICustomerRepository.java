package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
