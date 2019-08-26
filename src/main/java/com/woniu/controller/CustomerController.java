package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.entity.Customer;
import com.woniu.service.ICustomerService;

@Controller
@RequestMapping("/admin/customer")
public class CustomerController {
	@Resource
	private ICustomerService customerServiceImpl;
	
//	@RequestMapping("findAll")
//	public String findAll(ModelMap map) {
//		List<Customer> list = customerServiceImpl.findAll();
//		Integer count = customerServiceImpl.findAllCount();
//		map.put("list", list);
//		map.put("count", count);
//		return "admin/customer/list";
//	}
	@RequestMapping("findAll")
	public String findAll(Customer customer,ModelMap map) {
		List<Customer> list = customerServiceImpl.findAll(customer);
		Integer count = customerServiceImpl.findAllCount(customer);
		map.put("list", list);
		map.put("count", count);
		map.put("customer", customer);
		return "admin/customer/list";
	}
	@RequestMapping("delete")
	public String delete(Integer cid) {
		customerServiceImpl.delete(cid);
		return "redirect:findAll";
	}
	@RequestMapping("revoke")
	public String revoke(Integer cid) {
		customerServiceImpl.revoke(cid);
		return "redirect:findAll";
	}
	@RequestMapping("findByIdDetail")
	public String findByIdDetail(Integer cid,ModelMap map) {
		Customer customer=customerServiceImpl.findById(cid);
	System.out.println(customer);
		map.put("customer", customer);
		return "admin/customer/detail";
	}
	@RequestMapping("findById")
	public String findById(Integer cid,ModelMap map) {
		Customer customer=customerServiceImpl.findById(cid);
		map.put("customer", customer);
		return "admin/customer/update";
	}
	@RequestMapping("update")
	public String update(Customer customer) {
		customerServiceImpl.update(customer);
		return "forward:findByIdDetail";
	}

}
