package com.woniu.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Feedback;
import com.woniu.entity.FeedbackExample;
import com.woniu.entity.FeedbackExample.Criteria;
import com.woniu.entity.OrderSelect;
import com.woniu.mapper.FeedbackMapper;
import com.woniu.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
	@Resource
	private FeedbackMapper feedbackMapper;
	
	@Override
	public List findAll() {
		return feedbackMapper.selectByExample(null);
	}

	@Override
	public void save(Feedback fb) {
		feedbackMapper.insertSelective(fb);
	}

	@Override
	public void delete(Integer fid) {
		Feedback fb=new Feedback();
		fb.setFid(fid);
		fb.setIsdelete(0);
		feedbackMapper.updateByPrimaryKeySelective(fb);
	}

	@Override
	public void revoke(Integer fid) {
		Feedback fb=new Feedback();
		fb.setFid(fid);
		fb.setIsdelete(1);
		feedbackMapper.updateByPrimaryKeySelective(fb);
	}


	@Override
	public List findByCondition(OrderSelect orderSelect) {
		System.out.println("111111111");
		//定义开始和结束的时间字段
			Date btime=null;
			Date etime=null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			FeedbackExample example=new FeedbackExample();
			Criteria criteria=example.createCriteria();
			//根据开始和结束的时间查找
			if(orderSelect.getBtime()!=null&&!orderSelect.getBtime().equals("")) {
				try {
					btime=sdf.parse(orderSelect.getBtime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(orderSelect.getEtime()!=null&&!orderSelect.getEtime().equals("")) {
				try {
					etime=sdf.parse(orderSelect.getEtime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			System.out.println(orderSelect.getBtime()+"=====");
			System.out.println(orderSelect.getEtime());	
		criteria.andTimeBetween(btime, etime);
		return feedbackMapper.selectByExample(example);
	}
}
