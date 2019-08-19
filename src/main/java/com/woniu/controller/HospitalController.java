package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.entity.Hospital;
import com.woniu.service.impl.HospitalServiceImpl;

@RestController
@RequestMapping("admin/hospital")
public class HospitalController {
	@Resource
	private HospitalServiceImpl hospitalService;
	
	@RequestMapping("save")
	public String save(Hospital hospital) {
		hospitalService.save(hospital);
		return null;
		
	}
	
	@RequestMapping("delete")
	public String delete(Integer hid) {
		hospitalService.delete(hid);
		return null;
		
	}
	@RequestMapping("update")
	public String update(Hospital hospital) {
		hospitalService.update(hospital);
		return null;
		
	}
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		List<Hospital> list=hospitalService.findAll();
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(list);
		map.put("list", list);
		return "admin/hospital/list";
		
	}
	
	@RequestMapping("findOne")
	public String findOne(Integer hid) {
		hospitalService.findOne(hid);
		return null;
		
	}

}
