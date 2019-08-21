package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.entity.Hospital;
import com.woniu.entity.Role;
import com.woniu.service.impl.HospitalServiceImpl;

@Controller
@RequestMapping("admin/hospital")
public class HospitalController {
	@Resource
	private HospitalServiceImpl hospitalService;
	
	@RequestMapping("save")
	public String  save(Hospital hospital) {
		hospitalService.save(hospital);
		return "redirect:findAll";
		
	}
	
	@RequestMapping("delete")
	public String delete(Integer hid) {
		hospitalService.delete(hid);
		return "redirect:findAll";
		
	}
	@RequestMapping("update")
	public String update(Hospital hospital) {
		hospitalService.update(hospital);
		return "redirect:findAll";
		
	}
	
	@RequestMapping("goUpdate")
	public String update(Integer hid,ModelMap map) {
		Hospital hospital = hospitalService.findOne(hid);
		map.put("hospital", hospital);
		return "admin/hospital/update";
		
	}
	
	@RequestMapping("findAll")
	public String  findAll(ModelMap map) {
		List<Hospital> hospitalList=hospitalService.findAll();
		map.put("hospitalList", hospitalList);
		return "admin/hospital/list";
		
	}
	
	@RequestMapping("findOne")
	public String findOne(Integer hid) {
		hospitalService.findOne(hid);
		return null;
		
	}
	@RequestMapping("goSave")
	public String goInput(ModelMap map) {
	
		return "admin/hospital/save";
	}

}
