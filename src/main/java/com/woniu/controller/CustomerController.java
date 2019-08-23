package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.entity.Customer;
import com.woniu.entity.Orders;
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
		map.put("mes", null);
		return "admin/customer/list";
	}
	@RequestMapping("delete")
	public String delete(Integer cid) {
		System.out.println("...................a00000000");
		customerServiceImpl.delete(cid);
	System.out.println("...................b00000000");
		return "redirect:findAll";
	}
	@RequestMapping("revoke")
	public String revoke(Integer cid) {
		customerServiceImpl.revoke(cid);
	System.out.println("...................11111111");
		return "redirect:findAll";
	}
	@RequestMapping("findByIdDetail")
	public String findByIdDetail(Integer cid,ModelMap map) {
	System.out.println(cid+"++++++++++++");
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
