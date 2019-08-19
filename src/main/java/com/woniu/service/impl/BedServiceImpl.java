package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.mapper.BedMapper;
import com.woniu.service.IBedService;
@Service
public class BedServiceImpl implements IBedService {
	@Resource
	private BedMapper bedMapper;
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return bedMapper.selectByExample(null);
	}

}
