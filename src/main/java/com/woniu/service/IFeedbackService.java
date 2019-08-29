package com.woniu.service;

import java.util.List;

import com.woniu.entity.Feedback;
import com.woniu.entity.OrderSelect;

public interface IFeedbackService {

	public List findAll();
	public void save(Feedback fb);
	public void delete(Integer fid);
	public void revoke(Integer fid);
	
	public List findByCondition(OrderSelect orderSelect);
}
