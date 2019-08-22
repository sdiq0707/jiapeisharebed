package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.entity.OrderSelect;
import com.woniu.entity.Orders;
import com.woniu.service.IOrdersService;

@Controller
@RequestMapping("admin/orders/")
public class OrdersController {
	@Resource
	private IOrdersService ordersServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map ,OrderSelect orderSelect) {
		System.out.println(orderSelect.toString());
		List<Orders> list = ordersServiceImpl.findAll(orderSelect);
		map.put("list", list);
		
		return "admin/orders/list";
	}
	@RequestMapping("findById")
	public String findByOid(ModelMap map , Integer oid) {
		Orders orders = ordersServiceImpl.findById(oid);
		map.put("orders", orders);
		return "admin/orders/details";
	}
}
