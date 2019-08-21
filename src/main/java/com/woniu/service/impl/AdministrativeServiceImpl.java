package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Administrative;
import com.woniu.mapper.AdministrativeMapper;
import com.woniu.service.IAdministrativeService;

@Service
public class AdministrativeServiceImpl implements IAdministrativeService {

	@Resource
	private AdministrativeMapper administrativeMapper; 
	
	@Override
	public void save(Administrative administrative) {
		// TODO Auto-generated method stub
		administrativeMapper.insert(administrative);
	}

	@Override
	public void delete(Integer aid) {
		// TODO Auto-generated method stub
		administrativeMapper.deleteByPrimaryKey(aid);
	}

	@Override
	public void update(Administrative administrative) {
		// TODO Auto-generated method stub
		administrativeMapper.updateByPrimaryKey(administrative);
	}

	@Override
	public Administrative findOne(Integer aid) {
		// TODO Auto-generated method stub
		return administrativeMapper.selectByPrimaryKey(aid);
	}

	@Override
	public List<Administrative> findAll() {
		// TODO Auto-generated method stub
		return administrativeMapper.selectByExample(null);
	}

}
