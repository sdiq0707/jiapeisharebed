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
		
		
	}

	@Override
	public void update(Hospital hospital) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer hid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findOne(Integer hid) {
		// TODO Auto-generated method stub
		
	}

}
