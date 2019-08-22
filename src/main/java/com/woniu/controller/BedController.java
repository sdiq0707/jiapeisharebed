package com.woniu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.entity.Administrative;
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
	public String oInput(ModelMap map) throws JsonProcessingException {
		List<Shareholder> shareholders=shareholderServiceImpl.findAll();
		map.put("shareholders", shareholders);
		List<Factory> factorys=factoryServiceImpl.findAll();
		map.put("factorys", factorys);
//		ObjectMapper objectMapper=new ObjectMapper();
//		List<Hospital> list=hospitalServiceImpl.findAll();
//		String hospitals=objectMapper.writeValueAsString(list);
//		map.put("hospitals", hospitals);
		return "/admin/bed/input";
	}
	@RequestMapping("save")
	public String save(Bed bed,Hospital hospital,Administrative administrative) {
		String hos=hospital.getHid().toString();
		String adm=administrative.getAid().toString();
		bed.setFkid(hos+"X"+adm);
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
		String hosAdm=bed.getFkid();
		String [] hosAdmArr=hosAdm.split("X");
		map.put("hos", Integer.parseInt(hosAdmArr[0]));//医院ID
		map.put("adm", Integer.parseInt(hosAdmArr[1]));//科室ID
		List<Factory> factorys=factoryServiceImpl.findAll();
		map.put("factorys", factorys);
		List<Shareholder> shareholders=shareholderServiceImpl.findAll();
		map.put("shareholders", shareholders);
		return "/admin/bed/update";
	}
	@RequestMapping("update")
	public String update(Bed bed) {
		bedServiceImpl.update(bed);
		return "redirect:findAll";
	}
	@RequestMapping("findHospital")
	public @ResponseBody List findHospital() {
		List list=hospitalServiceImpl.findAll();
		return list;
	}
}
