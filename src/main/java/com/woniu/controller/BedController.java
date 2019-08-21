package com.woniu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.entity.Bed;
import com.woniu.entity.Factory;
import com.woniu.entity.Hospital;
import com.woniu.entity.Shareholder;
import com.woniu.entity.Userinfo;
import com.woniu.service.IBedService;
import com.woniu.service.IFactoryService;
import com.woniu.service.IHospitalService;
import com.woniu.service.IShareholderService;
import com.woniu.service.impl.BedServiceImpl;

@Controller
@RequestMapping("/admin/bed/")
public class BedController {
	
	@Resource
	private IBedService bedServiceImpl;
	@Resource
	private IShareholderService shareholderServiceImpl;
	@Resource
	private IFactoryService factoryServiceImpl;
	@Resource
	private IHospitalService hospitalServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		List beds=bedServiceImpl.findAll();
		map.put("beds", beds);
		return "/admin/bed/list";
	}
	@RequestMapping("goInput")
	public String goInput(ModelMap map) {
		List<Shareholder> shareholders=shareholderServiceImpl.findAll();
		map.put("shareholders", shareholders);
		List<Factory> factorys=factoryServiceImpl.findAll();
		map.put("factorys", factorys);
		List<Hospital> hospitals=hospitalServiceImpl.findAll();
		map.put("hospitals", hospitals);
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
