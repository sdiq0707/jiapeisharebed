package com.woniu.service;

import java.util.List;

import com.woniu.entity.Customer;

public interface ICustomerService {
	List<Customer> findAll(Customer customer);
	void delete(Integer cid);
	void revoke(Integer cid);
	void update(Customer customer);
	Customer findById(Integer cid);
	Integer findAllCount(Customer customer);
}
