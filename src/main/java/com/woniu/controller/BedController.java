package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.service.IBedService;
import com.woniu.service.impl.BedServiceImpl;

@Controller
@RequestMapping("/admin/bed/")
public class BedController {
	
	@Resource
	private IBedService bedServiceImpl;
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		List beds=bedServiceImpl.findAll();
		map.put("beds", beds);
		return "/admin/bed/list";
	}
}