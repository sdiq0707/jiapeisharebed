package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.entity.Administrative;
import com.woniu.entity.AdministrativeExample;
import com.woniu.entity.AdministrativeExample.Criteria;
import com.woniu.entity.Hospitaladministrative;
import com.woniu.entity.HospitaladministrativeExample;
import com.woniu.entity.PageBean;
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
	public void save(Administrative administrative,Integer hid) {
		//增加administrative
		administrativeMapper.insert(administrative);
		//增加Hospitaladministrative
			Hospitaladministrative key=new Hospitaladministrative();
			key.setAid(administrative.getAid());
			key.setHid(hid);
			key.setFkId(administrative.getAid()+"X"+hid);
			hospitaladministrativeMapper.insertSelective(key);
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
	public void update(Administrative administrative,Integer hid) {
		// TODO Auto-generated method stub
		//修改administrative
		administrativeMapper.updateByPrimaryKey(administrative);
		//删除对应科室的医院信息
		HospitaladministrativeExample example=new HospitaladministrativeExample();
		example.createCriteria().andAidEqualTo(administrative.getAid());
		hospitaladministrativeMapper.deleteByExample(example);
		//增加Hospitaladministrative
		Hospitaladministrative key=new Hospitaladministrative();
		key.setAid(administrative.getAid());
		key.setHid(hid);
		System.out.println(hid+"======================!");
		key.setFkId(administrative.getAid()+"X"+hid);
		hospitaladministrativeMapper.insertSelective(key);
	}

	@Override
	public Administrative findOne(Integer aid) {
		Administrative administrative = administrativeMapper.selectByPrimaryKey(aid);
		return administrative;
	}

	@Override
	public List<Administrative> findAll(Administrative administrative,PageBean pageBean) {
		AdministrativeExample example=new AdministrativeExample();
		 Criteria c = example.createCriteria();
		if(administrative.getAid()!=null&&!administrative.getAname().equals(""))
			c.andAidEqualTo(administrative.getAid());
		
		List list = administrativeMapper.selectByExample(example,new RowBounds(pageBean.getOffset(),pageBean.getLimit()));
		int count = administrativeMapper.countByExample(example);
		pageBean.setCount(count);
		return list;
	}

	@Override
	public List<Administrative> findByAname(Administrative administrative,String aname) {
		AdministrativeExample example=new AdministrativeExample();
		 Criteria c = example.createCriteria();
		 if(administrative.getAid()!=null&&!administrative.getAname().equals(""))
			 c.andAnameEqualTo(administrative.getAname());
		 List<Administrative> list = administrativeMapper.selectByExample(example, null);
		return list;
	}

}
