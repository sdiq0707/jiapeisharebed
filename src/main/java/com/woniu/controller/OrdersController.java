package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.entity.Orders;
import com.woniu.service.IOrdersService;

@Controller
@RequestMapping("admin/orders/")
public class OrdersController {
	@Resource
	private IOrdersService ordersServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		List<Orders> list = ordersServiceImpl.findAll();
		map.put("list", list);
		for (Orders orders : list) {
			System.out.println(orders.toString());
		}
		return "admin/orders/list";
	}

}
