package com.woniu.service;

import java.util.List;

import com.woniu.entity.Administrative;
import com.woniu.entity.PageBean;

public interface IAdministrativeService {

	public void save(Administrative administrative,Integer hid);
	public void revoke(Integer aid);
	public void delete(Integer aid);
	public void update(Administrative administrative,Integer hid);
	public Administrative findOne(Integer aid);
	public List<Administrative> findByAname(Administrative administrative,String aname);
	public List<Administrative> findAll(Administrative administrative,PageBean pagebean);

	
}
