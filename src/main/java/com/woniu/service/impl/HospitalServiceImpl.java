package com.woniu.service.impl;

import javax.annotation.Resource;

import com.woniu.entity.Hospital;
import com.woniu.mapper.HospitalMapper;
import com.woniu.service.IHospitalService;

public class HospitalServiceImpl implements IHospitalService{

	@Resource
	private HospitalMapper hospitalMapper;
	@Override
	public void save(Hospital hospital) {
		hospitalMapper.insertSelective(hospital);
		
	}

	@Override
	public void update(Hospital hospital) {
		hospitalMapper.updateByPrimaryKey(hospital);
		
	}

	@Override
	public void delete(Integer hid) {
		
		hospitalMapper.deleteByPrimaryKey(hid);
	}

	@Override
	public void findAll() {
		hospitalMapper.selectByExample(null);
		
	}

	@Override
	public void findOne(Integer hid) {
		hospitalMapper.selectByPrimaryKey(hid);
		
	}

}
