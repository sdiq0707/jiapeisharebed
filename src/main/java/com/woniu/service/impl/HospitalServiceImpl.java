package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Hospital;
import com.woniu.mapper.HospitalMapper;
import com.woniu.service.IHospitalService;

@Service
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
	public List<Hospital> findAll() {
		List<Hospital> list = hospitalMapper.selectByExample(null);
		return list;
		
	}

	@Override
	public Hospital findOne(Integer hid) {
		Hospital hospital = hospitalMapper.selectByPrimaryKey(hid);
		return hospital;
		
	}

}
