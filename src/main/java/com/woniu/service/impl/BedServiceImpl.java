package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Bed;
import com.woniu.entity.BedExample;
import com.woniu.entity.BedExample.Criteria;
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
	@Override
	public List findByHandA(Integer hid, Integer aid) {
		// TODO Auto-generated method stub
		return bedMapper.selectByHandA(hid, aid);
	}
	@Override
	public List searchByCondition(Integer hid, Integer aid, Integer fid, Integer uid) {
		// TODO Auto-generated method stub
		BedExample be=new BedExample();
		Criteria criteria = be.createCriteria();
		if(fid!=null&&!(fid.equals(0))) {
			criteria.andFidEqualTo(fid);
		}
		if(uid!=null&&!(uid.equals(0))) {
		criteria.andUidEqualTo(uid);
		}
		List<Bed> beds=bedMapper.selectByExample(be);
		return beds;
	}
	

}
