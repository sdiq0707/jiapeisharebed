package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.entity.Bed;
import com.woniu.entity.Customer;
import com.woniu.service.ICustomerService;

@Controller
@RequestMapping("/admin/customer")
public class CustomerController {
	@Resource
	private ICustomerService customerServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		List<Customer> list = customerServiceImpl.findAll();
		map.put("list", list);
		map.put("log", null);
		return "admin/customer/list";
	}
	@RequestMapping("delete")
	public String delete(Integer cid) {
		customerServiceImpl.delete(cid);
		return "redirect:findAll";
	}
	@RequestMapping("findByIdDetail")
	public String findByIdDetail(Integer cid,ModelMap map) {
		Customer customer=customerServiceImpl.findById(cid);
		map.put("customer", customer);
		return "/admin/customer/detail";
	}
	@RequestMapping("findById")
	public String findById(Integer cid,ModelMap map) {
		Customer customer=customerServiceImpl.findById(cid);
		map.put("customer", customer);
		return "/admin/customer/update";
	}
	@RequestMapping("update")
	public String update(Customer customer) {
		customerServiceImpl.update(customer);
		return "redirect:findByIdDetail";
	}

}
