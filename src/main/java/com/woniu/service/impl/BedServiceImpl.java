package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Bed;
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
	@Override
	public void save(Bed bed) {
		bed.setBstatus(true);
		bed.setIsdelete(0);
		bed.setIstrouble(false);
		bedMapper.insertSelective(bed);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Integer bid) {
		// TODO Auto-generated method stub
		Bed bed=bedMapper.selectByPrimaryKey(bid);
		bed.setIsdelete(1);
		bedMapper.updateByPrimaryKeySelective(bed);
	}
	@Override
	public void revoke(Integer bid) {
		// TODO Auto-generated method stub
		Bed bed=bedMapper.selectByPrimaryKey(bid);
		bed.setIsdelete(0);
		bedMapper.updateByPrimaryKeySelective(bed);
	}
	@Override
	public Bed findById(Integer bid) {
		// TODO Auto-generated method stub
		Bed bed=bedMapper.selectByPrimaryKey(bid);
		return bed;
	}
	@Override
	public void update(Bed bed) {
		// TODO Auto-generated method stub
		bedMapper.updateByPrimaryKey(bed);
	}
	

}
