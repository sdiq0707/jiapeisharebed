package com.woniu.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Feedback;
import com.woniu.entity.FeedbackExample;
import com.woniu.mapper.FeedbackMapper;
import com.woniu.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
	@Resource
	private FeedbackMapper feedbackMapper;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
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
}
