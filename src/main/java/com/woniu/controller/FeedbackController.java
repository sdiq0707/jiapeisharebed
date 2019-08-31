package com.woniu.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.woniu.entity.Feedback;
import com.woniu.entity.OrderSelect;
import com.woniu.service.IFeedbackService;

@Controller
@RequestMapping("/admin/feedback/")
public class FeedbackController {
	@Resource
	private IFeedbackService feedbackServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		List list = feedbackServiceImpl.findAll();
		map.put("list", list);
		return "/admin/feedback/list";
	}
	
	@RequestMapping("save")
	public String save(String time1,@RequestParam("file") MultipartFile file,Feedback fb,HttpServletRequest req) throws Exception{
//文件上传api:
//		1.request.getSession().getServletContext().getRealPath(String s)：获取本项目下指定目录的绝对路径。 
//		2.MultipartFile.getOriginalFilename()：获取被MultipartFile绑定的上传参数的原始名称 
//		3.System.currentTimeMillis()：获取自1970年1月1日0时起到现在时间的毫秒数。 
//		4.MultipartFile.transferTo()： 在指定的磁盘路径下生成一个新的文件。
	
        //获取后缀
		String oldName = file.getOriginalFilename();
		int lastDot = oldName.lastIndexOf(".");
		String hz=oldName.substring(lastDot);
		//2.文件名
		String newName = UUID.randomUUID().toString().replaceAll("-", "");
		newName+=hz;
		//3.上传后的地址，注意("/upload")是表示文件上传后的目标文件夹
        String realPath = req.getSession().getServletContext().getRealPath("/upload");
        System.out.println("打印文件上传的路径"+realPath);
		//4.存盘
        File dir=new File(realPath,newName);
        if (!dir.exists()){//如果dir代表的文件不存在，则创建它，
            dir.mkdirs();//
        }
        file.transferTo(dir);//将上传的实体文件复制到指定目录upload下
		//5.将图片写入对象中
		fb.setPhoto(newName);//将文件名赋值给实体类，然后一并存到数据库
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(time1);
		fb.setTime(date);
		feedbackServiceImpl.save(fb);//调用后台方法，将对象存进数据库
		System.out.println("ok");
		return "redirect:findAll";//执行完毕，返回一个逻辑视图
	} 
	
	@RequestMapping("delete")
	public String delete(Integer fid) {
		feedbackServiceImpl.delete(fid);
		return "redirect:findAll";
	}  
	@RequestMapping("revoke")
	public String revoke(Integer fid) {
		feedbackServiceImpl.revoke(fid);
		return "redirect:findAll";
	}
	
	@RequestMapping("searchByTime")
	public String searchByTime(OrderSelect orderSelect,ModelMap map) {
		List list = feedbackServiceImpl.findByCondition(orderSelect);
		map.put("list", list);
		return "/admin/feedback/list";
	}
}
