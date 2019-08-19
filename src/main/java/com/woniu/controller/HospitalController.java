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
import com.woniu.service.impl.HospitalServiceImpl;

@Controller
@RequestMapping("admin/hospital")
public class HospitalController {
	@Resource
	private HospitalServiceImpl hospitalService;
	
	@RequestMapping("save")
	public String  save(Hospital hospital) {
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
	public @ResponseBody Map<String,Object> findAll() {
		List<Hospital> list=hospitalService.findAll();
		Map<String,Object> map = new HashMap<String, Object>();
		System.out.println(list);
		map.put("list", list);
		return map;
		
	}
	
	@RequestMapping("findOne")
	public String findOne(Integer hid) {
		hospitalService.findOne(hid);
		return null;
		
	}

}
