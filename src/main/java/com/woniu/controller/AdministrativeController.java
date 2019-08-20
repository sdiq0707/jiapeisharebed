package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.entity.Administrative;
import com.woniu.service.IAdministrativeService;

@Controller
@RequestMapping("/admin/administrative")
public class AdministrativeController {

	@Resource
	private IAdministrativeService administrativeServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map){
		List<Administrative> list = administrativeServiceImpl.findAll();
		map.put("list", list);
		return "/admin/administrative/list";
	}
	
	@RequestMapping("delete")
	public String delete(Integer aid) {
		administrativeServiceImpl.delete(aid);
		return "redirect:findAll";
	}
}
