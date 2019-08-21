package com.woniu.service;

import java.util.List;

import com.woniu.entity.Administrative;

public interface IAdministrativeService {

	public void save(Administrative administrative);
	public void delete(Integer aid);
	public void update(Administrative administrative);
	public Administrative findOne(Integer aid);
	public List<Administrative> findAll();
}
