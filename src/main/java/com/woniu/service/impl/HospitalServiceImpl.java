package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.entity.Hospital;
import com.woniu.entity.PageBean;
import com.woniu.entity.Province;
import com.woniu.mapper.HospitalMapper;
import com.woniu.mapper.ProvinceMapper;
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
		System.out.println(hospital);
		hospitalMapper.updateByPrimaryKeySelective(hospital);
		
	}

	@Override
	public void delete(Integer hid) {
		hospitalMapper.deleteByPrimaryKey(hid);
	}

	@Override
	public List<Hospital> findAll(PageBean pageBean) {
		List<Hospital> list = hospitalMapper.selectByExample(null,new RowBounds(pageBean.getOffset(),pageBean.getLimit()));
		int count=hospitalMapper.countByExample(null);
		pageBean.setCount(count);
		return list;
		
	}

	@Override
	public Hospital findOne(Integer hid) {
		Hospital hospital = hospitalMapper.selectByPrimaryKey(hid);
		return hospital;
		
	}

	@Override
	public List<Hospital> findAll() {
		List<Hospital> list = hospitalMapper.selectByExample(null);
		int count=hospitalMapper.countByExample(null);
		return list;
		
	}

	

}
