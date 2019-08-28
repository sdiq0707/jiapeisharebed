package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.entity.Administrative;
import com.woniu.entity.Hospital;
import com.woniu.entity.Hospitaladministrative;
import com.woniu.entity.PageBean;
import com.woniu.service.IAdministrativeService;
import com.woniu.service.IHospitalService;

@Controller
@RequestMapping("/admin/administrative/")
public class AdministrativeController {

	@Resource
	private IAdministrativeService administrativeServiceImpl;
	@Resource
	private IHospitalService hospitalServiceImpl;
	
	@RequestMapping("findJSON")
	public @ResponseBody Map findJSON(Administrative administrative,PageBean pageBean){
		Map map=new HashMap();
		List<Administrative> list = administrativeServiceImpl.findAll(administrative,pageBean);
		map.put("list", list);
		map.put("page", pageBean);
		map.put("administrative", administrative);
		return map;
	}
	
	@RequestMapping("findByIdDetail")
	public String findByIdDetail(Integer aid,ModelMap map,Integer hid) {
		Administrative administrative = administrativeServiceImpl.findOne(aid);
		map.put("administrative", administrative);
		Hospital hospital = hospitalServiceImpl.findOne(hid);
		map.put("hospital", hospital);
		return "/admin/administrative/detail";
	}
	
	@RequestMapping("searchByAid")
	public String searchByAid(Integer aid,ModelMap map) {
		Administrative administrative=administrativeServiceImpl.findOne(aid);
		map.put("administrative", administrative);
		return "/admin/administrative/list";
	}
	
//	@RequestMapping("searchByAname")
//	public String searchByAname(Administrative administrative,String aname,ModelMap map) {
//		List<Administrative> list = administrativeServiceImpl.findByAname(administrative,aname);
//		map.put("list", list);
//		return "/admin/administrative/list2";
//	}
	
	@RequestMapping("findById")
	public @ResponseBody Map findById(Integer aid) {
		Map map=new HashMap();
		Administrative administrative=administrativeServiceImpl.findOne(aid);
		map.put("administrative", administrative);
		List<Hospital> hospitals = hospitalServiceImpl.findAll();
		map.put("hospitals", hospitals);
		return map;
	}
	@RequestMapping("update")
	public String update(Administrative administrative,Integer hid) {
		administrativeServiceImpl.update(administrative,hid);
		return "/admin/administrative/list2";
	}
	
	@RequestMapping("delete")
	public String delete(Integer aid) {
		administrativeServiceImpl.delete(aid);
		return "/admin/administrative/list2";
	}
	@RequestMapping("revoke")
	public String revoke(Integer aid) {
		administrativeServiceImpl.revoke(aid);
		return "/admin/administrative/list2";
	}
	
	@RequestMapping("save")
	public String save(Administrative administrative,Integer hid) {
		administrativeServiceImpl.save(administrative,hid);
		return "/admin/administrative/list2";
	}
	@RequestMapping("goSave")
	public String goSave(ModelMap map) {
		List<Hospital> hospitals = hospitalServiceImpl.findAll();
		map.put("hospitals", hospitals);
		return "/admin/administrative/save";
	}
} 
