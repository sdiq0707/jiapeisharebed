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
import com.woniu.entity.Message;
import com.woniu.entity.PageBean;
import com.woniu.entity.Province;
import com.woniu.entity.Role;
import com.woniu.service.impl.HospitalServiceImpl;
import com.woniu.service.impl.ProvinceServiceImpl;

@Controller
@RequestMapping("admin/hospital/")
public class HospitalController {
	@Resource
	private HospitalServiceImpl hospitalService;
	@Resource
	private ProvinceServiceImpl provinceService;

	/*
	 * @RequestMapping("save") public String save(Hospital hospital) {
	 * hospitalService.save(hospital); return "redirect:findAll";
	 * 
	 * }
	 */
	
	@RequestMapping("save")
	public @ResponseBody Message save(Hospital hospital) {
		Message msg=null;
		try {
			hospitalService.save(hospital);
			msg=new Message(true,"医院添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = new Message(false, "医院添加失败"+e.getMessage());
		}
		return msg;

	}
	
	 

	@RequestMapping("delete")
	public @ResponseBody Message delete(Integer hid) {
		Message msg=null;
		try {
			Hospital hospital = hospitalService.findOne(hid);
			hospital.setIsdelete(1);
			hospitalService.update(hospital);
			msg=new Message(true,"医院移除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = new Message(false, "医院移除失败"+e.getMessage());
		}
		return msg;

	}

	@RequestMapping("revoke")
	public @ResponseBody Message revoke(Integer hid) {
		Message msg=null;
		try {
			Hospital hospital = hospitalService.findOne(hid);
			hospital.setIsdelete(0);
			hospitalService.update(hospital);
			msg=new Message(true,"医院恢复成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = new Message(false, "医院恢复失败"+e.getMessage());
		}
		return msg;

	}

	@RequestMapping("update")
	public String update(Hospital hospital) {
		hospitalService.update(hospital);
		return "redirect:findAll";

	}

	@RequestMapping("goUpdate")
	public String update(Integer hid, ModelMap map) {
		Hospital hospital = hospitalService.findOne(hid);
		map.put("hospital", hospital);
		return "admin/hospital/update";

	}

	@RequestMapping("findAll")
	public @ResponseBody Map findAll(PageBean pageBean) {
		List hospitalList = hospitalService.findAll(pageBean);
		Map map = new HashMap();
		map.put("total", pageBean.getCount());
		map.put("rows", hospitalList);
		return map;

	}

	@RequestMapping("findOne")
	public @ResponseBody Hospital findOne(Integer hid) {
		Hospital hospital = hospitalService.findOne(hid);
		return hospital;

	}

	@RequestMapping("goSave")
	public String goInput(ModelMap map) {

		return "admin/hospital/save2";
	}

	@RequestMapping("findProvince")
	public @ResponseBody List findProvince() throws Exception {
		List<Province> list = provinceService.findAll();
		return list;
	}
}
