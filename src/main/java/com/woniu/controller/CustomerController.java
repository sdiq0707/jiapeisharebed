package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.entity.Customer;
import com.woniu.service.ICustomerService;

@Controller
@RequestMapping("admin/customer")
public class CustomerController {
	@Resource
	private ICustomerService customerServiceImpl;
	
	@RequestMapping("findAll")
	public @ResponseBody Map<String,Object> findAll() {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Customer> list = customerServiceImpl.findAll();
		map.put("list", list);
		return map;
	}

}
