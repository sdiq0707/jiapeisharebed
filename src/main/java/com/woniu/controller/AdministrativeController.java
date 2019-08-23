package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.entity.Administrative;
import com.woniu.entity.Hospital;
import com.woniu.service.IAdministrativeService;
import com.woniu.service.IHospitalService;
import com.woniu.service.impl.HospitalServiceImpl;

@Controller
@RequestMapping("/admin/administrative")
public class AdministrativeController {

	@Resource
	private IAdministrativeService administrativeServiceImpl;
	@Resource
	private IHospitalService hospitalServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map){
		List<Administrative> list = administrativeServiceImpl.findAll();
		map.put("list", list);
		return "/admin/administrative/list";
	}
	
	@RequestMapping("findById")
	public String findById(Integer aid,ModelMap map) {
		Administrative administrative = administrativeServiceImpl.findOne(aid);
		map.put("administrative", administrative);
		return "/admin/administrative/save";
	}
	@RequestMapping("update")
	public String update(Administrative administrative,Integer[] opt) {
		administrativeServiceImpl.update(administrative,opt);
		return "redirect:findAll";
	}
	
	@RequestMapping("delete")
	public String delete(Integer aid) {
		administrativeServiceImpl.delete(aid);
		return "redirect:findAll";
	}
	@RequestMapping("revoke")
	public String revoke(Integer aid) {
		administrativeServiceImpl.revoke(aid);
		return "redirect:findAll";
	}
	
	@RequestMapping("save")
	public String save(Administrative administrative,Integer[] opt) {
		administrativeServiceImpl.save(administrative,opt);
		return "redirect:findAll";
	}
	@RequestMapping("goSave")
	public String goSave(ModelMap map) {
		List<Hospital> hospitals = hospitalServiceImpl.findAll();
		map.put("hospitals", hospitals);
		return "/admin/administrative/save";
	}
}
