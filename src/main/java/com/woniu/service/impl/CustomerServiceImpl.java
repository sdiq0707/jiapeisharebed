package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Customer;
import com.woniu.mapper.CustomerMapper;
import com.woniu.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Resource
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> findAll() {
		List<Customer> list = customerMapper.selectByExample(null);
		return list;
	}

	@Override
	public void delete(Integer cid) {
		Customer customer = customerMapper.selectByPrimaryKey(cid);
		customer.setIsdelete(1);
		customerMapper.updateByPrimaryKeySelective(customer);
	}

	@Override
	public void update(Customer customer) {
		customerMapper.updateByPrimaryKeySelective(customer);
	}

	@Override
	public Customer findById(Integer cid) {
		return customerMapper.findById(cid);
	}

	@Override
	public void revoke(Integer cid) {
		Customer customer = customerMapper.selectByPrimaryKey(cid);
		customer.setIsdelete(0);
		customerMapper.updateByPrimaryKeySelective(customer);
	}

}
