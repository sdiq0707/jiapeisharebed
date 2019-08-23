package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.entity.Bed;
import com.woniu.entity.Hospital;
import com.woniu.entity.OrderSelect;
import com.woniu.entity.Orders;
import com.woniu.service.IAdministrativeService;
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
	private IAdministrativeService administrativeServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map ,OrderSelect orderSelect) {
		List<Orders> list = ordersServiceImpl.findAll(orderSelect);
		map.put("list", list);		
		return "admin/orders/list";
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
	@ResponseBody
	@RequestMapping("findAllhospital")
	public String findAllhospital() throws JsonProcessingException {
		List<Hospital> list = hospitalServiceImpl.findAll();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String string = objectMapper.writeValueAsString(list);
		System.out.println(string);
		return string;
	}
}
