package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Shareholder;
import com.woniu.mapper.ShareholderMapper;
import com.woniu.service.IShareholderService;
@Service
public class ShareholderServiceImpl implements IShareholderService {
	
	@Resource
	private ShareholderMapper shareholderMapper;
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		List<Shareholder> shareholders=shareholderMapper.selectByExample(null);
		return shareholders;
	}
	@Override
	public Shareholder findById(Integer uid) {
		// TODO Auto-generated method stub
		Shareholder shareholder=shareholderMapper.selectByPrimaryKey(uid);
		return shareholder;
	}

}
