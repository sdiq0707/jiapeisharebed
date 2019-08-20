package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.entity.Bed;
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
	@RequestMapping("goInput")
	public String goInput() {
		return "/admin/bed/input";
	}
	@RequestMapping("save")
	public String save(Bed bed) {
		bedServiceImpl.save(bed);
		return "redirect:findAll";
	}
	@RequestMapping("delete")
	public String delete(Integer bid) {
		bedServiceImpl.delete(bid);
		return "redirect:findAll";
	}
	@RequestMapping("revoke")
	public String revoke(Integer bid) {
		bedServiceImpl.revoke(bid);
		return "redirect:findAll";
	}
	@RequestMapping("findById")
	public String findById(Integer bid,ModelMap map) {
		Bed bed=bedServiceImpl.findById(bid);
		map.put("bed", bed);
		System.out.println(bed);
		return "/admin/bed/update";
	}
	@RequestMapping("update")
	public String update(Bed bed) {
		bedServiceImpl.update(bed);
		return "redirect:findAll";
	}
}
