package com.woniu.controller;

import java.beans.PropertyEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.woniu.entity.Message;
import com.woniu.entity.PageBean;
import com.woniu.entity.Trouble;
import com.woniu.service.IBedService;
import com.woniu.service.ITroubleService;

@RestController
@RequestMapping("/admin/trouble")
public class TroubleController {
	@Resource
	private ITroubleService troubleServiceImpl;
	@Resource
	private IBedService bedServiceImpl;
	
	@RequestMapping("save")
	public Message save(Trouble trouble) {
		Message msg = new Message(true, "");
		try {
			troubleServiceImpl.save(trouble);
			msg.setMsg("添加成功！");
			return msg;
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("添加失败！");
			e.printStackTrace();
		}finally {
			return msg;
		}
	}
	
	@RequestMapping("findAll")
	public Map findAll(PageBean pageBean) {
		List troubles = troubleServiceImpl.findAll(pageBean);
		Map map = new HashMap();
		map.put("total", pageBean.getCount());
		map.put("rows", troubles);
		return map;
	}
	
	@RequestMapping("findByTid")
	public Trouble findByTid(Integer tid) {
		Trouble trouble = troubleServiceImpl.findById(tid);
		return trouble;
	}
	
	@RequestMapping("findAllBed")
	public List findAllBed() {
		List beds = bedServiceImpl.findAll();
		return beds;
	}
@InitBinder
 public void initBinder(WebDataBinder binder, WebRequest request) {
      DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
      binder.registerCustomEditor(Date.class, (PropertyEditor) new CustomDateEditor(dateFormat, true));
  }
	@RequestMapping("updateById")
	public Message update(Trouble trouble) {
		Message msg = new Message(true, "");
		try {
			troubleServiceImpl.update(trouble);
			msg.setMsg("更改成功！");
			return msg;
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("更改失败！");
			e.printStackTrace();
		}finally {
			return msg;
		}
	}
	
	@RequestMapping("deleteById")
	public Message delete(Integer tid) {
		Message msg = new Message(true, "");
		try {
			troubleServiceImpl.delete(tid);
			msg.setMsg("删除成功！");
			return msg;
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("删除失败！");
			e.printStackTrace();
		}finally {
			return msg;
		}
	}
	@RequestMapping("revokeById")
	public Message revoke(Integer tid) {
		System.out.println("revoke");
		Message msg = new Message(true, "");
		try {
			troubleServiceImpl.revoke(tid);;
			msg.setMsg("恢复成功！");
			return msg;
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("恢复失败！");
			e.printStackTrace();
		}finally {
			return msg;
		}
	}
}
