package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Customer;
import com.woniu.entity.CustomerExample;
import com.woniu.entity.CustomerExample.Criteria;
import com.woniu.mapper.CustomerMapper;
import com.woniu.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Resource
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> findAll(Customer customer) {
		CustomerExample example = new CustomerExample();
		Criteria c = example.createCriteria();
		if(customer.getPhone()!=null && !customer.getPhone().equals("")) {
			c.andPhoneEqualTo(customer.getPhone());
		}
		if(customer.getSex()!=null && !customer.getSex().equals("")) {
			c.andSexEqualTo(customer.getSex());
		}
		if(customer.getRegtime()!=null && !customer.getRegtime().equals("")) {
			c.andRegtimeEqualTo(customer.getRegtime());
		}
		
		List<Customer> list = customerMapper.selectByExample(example);
		
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

	@Override
	public Integer findAllCount(Customer customer) {
		CustomerExample example = new CustomerExample();
		Criteria c = example.createCriteria();
		if(customer.getPhone()!=null && !customer.getPhone().equals("")) {
			c.andPhoneEqualTo(customer.getPhone());
		}
		if(customer.getSex()!=null && !customer.getSex().equals("")) {
			c.andSexEqualTo(customer.getSex());
		}
		if(customer.getRegtime()!=null && !customer.getRegtime().equals("")) {
			c.andRegtimeEqualTo(customer.getRegtime());
		}
		return customerMapper.countByExample(example);//查找用户总数
	}

}
