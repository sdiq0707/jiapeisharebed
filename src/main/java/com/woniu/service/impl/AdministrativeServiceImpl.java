package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Administrative;
import com.woniu.entity.HospitaladministrativeExample;
import com.woniu.entity.HospitaladministrativeKey;
import com.woniu.mapper.AdministrativeMapper;
import com.woniu.mapper.HospitaladministrativeMapper;
import com.woniu.service.IAdministrativeService;

@Service
public class AdministrativeServiceImpl implements IAdministrativeService {

	@Resource
	private AdministrativeMapper administrativeMapper; 
	@Resource
	private HospitaladministrativeMapper hospitaladministrativeMapper;
	
	@Override
	public void save(Administrative administrative,Integer[] opt) {
		// TODO Auto-generated method stub
		//增加administrative
		administrativeMapper.insert(administrative);
		//增加Hospitaladministrative
		if(opt!=null) {
			for (Integer hid : opt) {
				HospitaladministrativeKey key=new HospitaladministrativeKey();
				key.setAid(administrative.getAid());
				key.setHid(hid);
				hospitaladministrativeMapper.insertSelective(key);
			}
		}
	}

	@Override
	public void revoke(Integer aid) {
		// TODO Auto-generated method stub
		Administrative administrative=new Administrative();
		administrative.setAid(aid);
		administrative.setIsdelete(1);
		administrativeMapper.updateByPrimaryKeySelective(administrative);
 	}
	
	@Override
	public void delete(Integer aid) {
		// TODO Auto-generated method stub
		Administrative administrative=new Administrative();
		administrative.setAid(aid);
		administrative.setIsdelete(0);
		administrativeMapper.updateByPrimaryKeySelective(administrative);
	}

	@Override
	public void update(Administrative administrative,Integer[] opt) {
		// TODO Auto-generated method stub
		//修改administrative
		administrativeMapper.updateByPrimaryKey(administrative);
		//删除对应科室的医院信息
		HospitaladministrativeExample example=new HospitaladministrativeExample();
		example.createCriteria().andAidEqualTo(administrative.getAid());
		hospitaladministrativeMapper.deleteByExample(example);
		//增加Hospitaladministrative
		if(opt!=null) {
			for (Integer hid : opt) {
				HospitaladministrativeKey key=new HospitaladministrativeKey();
				key.setAid(administrative.getAid());
				key.setHid(hid);
				hospitaladministrativeMapper.insertSelective(key);
			}
		}
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
