package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Province;
import com.woniu.mapper.ProvinceMapper;
import com.woniu.service.IProvince;
@Service
public class ProvinceServiceImpl implements IProvince {

	@Resource
	private ProvinceMapper provinceMapper;
	@Override
	public List<Province> findAll() {
		// TODO Auto-generated method stub
		List<Province> list = provinceMapper.selectByExample(null);
		return list;
	}

}
