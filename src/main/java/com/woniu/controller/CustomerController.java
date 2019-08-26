package com.woniu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.entity.Customer;
import com.woniu.entity.Orders;
import com.woniu.service.ICustomerService;
import com.woniu.util.timedif.TimeDifference;

@Controller
@RequestMapping("/admin/customer")
public class CustomerController {
	@Resource
	private ICustomerService customerServiceImpl;
	@Resource
	private TimeDifference timeDifference;
//	@RequestMapping("findAll")
//	public String findAll(ModelMap map) {
//		List<Customer> list = customerServiceImpl.findAll();
//		Integer count = customerServiceImpl.findAllCount();
//		map.put("list", list);
//		map.put("count", count);
//		return "admin/customer/list";
//	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); //true:允许为空, false:不允许为空
	}
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
		this.findOne(cid, map);
		return "admin/customer/detail";
	}
	@RequestMapping("findById")
	public String findById(Integer cid,ModelMap map) {
		this.findOne(cid, map);
		return "admin/customer/update";
	}
	private void findOne(Integer cid,ModelMap map) {
		Customer customer=customerServiceImpl.findById(cid);
		List<String> times = new ArrayList<String>();
		List<Orders> orders = customer.getOrders();
		if(orders!=null) {
			for (Orders ord : orders) {
				if(ord.getOrdertime()!=null && ord.getReturntime()!=null) {
					String time = timeDifference.getTimeDifference(ord.getReturntime(), ord.getOrdertime());
					times.add(time);
				}
			}
		}
		map.put("times", times);
		map.put("customer", customer);
	}
	@RequestMapping("update")
	public String update(Customer customer) {
		customerServiceImpl.update(customer);
		return "forward:findByIdDetail";
	}

}
