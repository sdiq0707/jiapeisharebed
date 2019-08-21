package com.woniu.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.entity.Userinfo;
import com.woniu.service.ITreeService;
import com.woniu.service.IUserinfoService;

@Controller
public class LoginController {
	@Resource
	private IUserinfoService userinfoService;
	@Resource
	private ITreeService treeService;
	@RequestMapping("/login")
	public String login(Userinfo info,HttpSession session) throws JsonProcessingException {
		info = userinfoService.login(info);
		if(info == null) {
			return "index";
		}else {
			ObjectMapper mapper =  new ObjectMapper();
			String json = mapper.writeValueAsString(info.getTrees());
			session.setAttribute("info", info);
			session.setAttribute("json", json);
		System.out.println(json);
			return "redirect:/admin/index.jsp";
		}
	}
}
