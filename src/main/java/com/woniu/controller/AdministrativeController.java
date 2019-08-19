package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.entity.Administrative;
import com.woniu.service.IAdministrativeService;

@RestController
@RequestMapping("/admin/administrative")
public class AdministrativeController {

	@Resource
	private IAdministrativeService administrativeServiceImpl;
	
	@RequestMapping("findAll")
	public List<Administrative> findAll(ModelMap map){
		List<Administrative> list = administrativeServiceImpl.findAll();
		return list;
	}
}
