package com.woniu.service;

import java.util.List;

import com.woniu.entity.Administrative;

public interface IAdministrativeService {

	public void save(Administrative administrative,Integer[] opt);
	public void revoke(Integer aid);
	public void delete(Integer aid);
	public void update(Administrative administrative,Integer[] opt);
	public Administrative findOne(Integer aid);
	public List<Administrative> findAll();
}
