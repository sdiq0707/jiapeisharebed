package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.entity.Bed;
import com.woniu.entity.Hospital;
import com.woniu.entity.OrderSelect;
import com.woniu.entity.Orders;
import com.woniu.service.IBedService;
import com.woniu.service.IHospitalService;
import com.woniu.service.IOrdersService;

@Controller
@RequestMapping("admin/orders/")
public class OrdersController {
	@Resource
	private IOrdersService ordersServiceImpl;
	@Resource
	private IHospitalService hospitalServiceImpl;
	@Resource
	private IBedService BedServiceImpl;
	
	@RequestMapping("findAll")
	public @ResponseBody Map findAll(OrderSelect orderSelect) {
		Map map = new HashMap<>();
		List<Orders> list = ordersServiceImpl.findAll(orderSelect);
		List<Hospital> hostipals = hospitalServiceImpl.findAll();
		Integer count = list.size();
		System.out.println(orderSelect.toString());
		map.put("list", list);	
		map.put("count", count);
		map.put("hostipals", hostipals);
		return map;
	}
	@RequestMapping("findById")
	public String findByOid(ModelMap map , Integer oid) {
		Orders orders = ordersServiceImpl.findById(oid);
		//租赁的总秒数
		Long totalSeconds = (orders.getReturntime().getTime()-orders.getOrdertime().getTime())/1000;
		//租赁的天数
		int days = (int) (totalSeconds/60/60/24);
		//租赁的小时数（这是除天数剩下的小时数）
		int hours = (int) ((totalSeconds%(60*60*24))/(60*60));
		//租赁的分钟数（这是除了天数和分钟数剩下的分钟数）
		int minutes = (int) (totalSeconds%(60*60)/(60));
		Bed bed = orders.getBed();
		map.put("bed", bed);
		map.put("orders", orders);
		map.put("days", days);
		map.put("hours", hours);
		map.put("minutes", minutes);
		return "admin/orders/details";
	}
	
	//查找医院回填下拉框，返回类型为josn类型
	@RequestMapping("findAllhospital")
	public @ResponseBody List findAllhospital() throws JsonProcessingException {
		List<Hospital> list = hospitalServiceImpl.findAll();
		return list;
	}
	@RequestMapping("delete")
	public @ResponseBody String deleteByID(Integer oid) {
		ordersServiceImpl.deleteByID(oid);
		return null;
	}
	@RequestMapping("revoke")
	public @ResponseBody String revokeByID(Integer oid) {
		ordersServiceImpl.revokeByID(oid);
		return null;
	}
}
