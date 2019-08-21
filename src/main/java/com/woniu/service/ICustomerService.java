package com.woniu.service;

import java.util.List;

import com.woniu.entity.Customer;

public interface ICustomerService {
	List<Customer> findAll();
	void delete(Integer cid);
	void update(Customer customer);
	Customer findById(Integer cid);
}
